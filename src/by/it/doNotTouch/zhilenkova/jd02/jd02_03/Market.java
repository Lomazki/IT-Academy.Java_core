package by.it.doNotTouch.zhilenkova.jd02.jd02_03;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static List<Cashier> cashiers = new ArrayList<>();
    public static List<Thread> threads = new ArrayList<>();
    private static Manager manager;

    public static void main(String[] args) {
        System.out.println("Market opend");
        System.out.printf("%15s  %18s  %18s  %18s  %18s  %20s %11s\n","Касса №1","Касса №2","Касса №3","Касса №4","Касса №5","очередь","выручка");
        Good.fillGoods();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Cashier cashier1 = new Cashier(1);
        Cashier cashier2 = new Cashier(2);
        cashiers.add(cashier1);
        cashiers.add(cashier2);
        executorService.execute(cashier1);
        executorService.execute(cashier2);
        executorService.shutdown();
        manager = new Manager();
        threads.add(manager);
        manager.start();
        for (int time = 0; Dispatcher.marketOpened(); time++) {
            int sec = time % 60;
            if (time == 0) {
                for (int i = 0; i < 10; i++) {
                    Buyer buyer = new Buyer(Dispatcher.getBuyerCounter());
                    threads.add(buyer);
                    buyer.start();
                }
//                print(time);
                continue;
            }
            if (sec < 31 && Dispatcher.getBuyerInShop() < 10 + sec) {
                while (Dispatcher.getBuyerInShop() < 10 + sec) {
                    int buyerCount = Util.random(0, 2);
                    for (int j = 0; j < buyerCount; j++) {
                        Buyer buyer = new Buyer(Dispatcher.getBuyerCounter());
                        threads.add(buyer);
                        buyer.start();
                    }
                }
            }
            if (sec > 30 && Dispatcher.getBuyerInShop() <= 70 - sec) {
                while (Dispatcher.getBuyerInShop() < 70 - sec) {
                    int buyerCount = Util.random(0, 2);
                    for (int i = 1; i < buyerCount; i++) {
                        Buyer buyer = new Buyer(Dispatcher.getBuyerCounter());
                        threads.add(buyer);
                        buyer.start();
                    }
                }
            }
//            print(time);
            Util.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market closed");
    }
    private static void print(int time) {
        int wc = manager.getWorkingCashiers();
        System.out.println("======================================\n" + time + " sec" + "\t"
                + QueueBuyer.buyers.size() + " buyers in queue" + "\n работает касс: "+ wc+"\n======================================\n");
    }
}
