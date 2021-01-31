package by.it.doNotTouch.zhilenkova.jd02.jd02_03;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    private Backet backet;
    protected boolean pensioneer;
    public long timeToQueue = 0;
    protected Map<String,Integer> choosenGoods = new HashMap<>();

    Buyer(int number) {
        super("Buyer №" + number);
        backet = new Backet();
        pensioneer = Math.random() < 0.25;
        Dispatcher.addBuyer();
    }
    @Override
    public void run(){
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodToBacket();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        try{
            Dispatcher.semaphoreBuyers.acquire();
            Dispatcher.buyersWithBacket.put(this);
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        System.out.println(this + "enter to market");
    }

    @Override
    public void chooseGoods() {
//        System.out.println(this + "started to choose goods");
        int timeOut = Util.random(500, 2000);
        if (pensioneer) Util.sleep(timeOut * 3 / 2);
        else Util.sleep(timeOut);
    }

    @Override
    public void goToQueue() {
//        System.out.println(this + " go to Cashier");
        timeToQueue = System.nanoTime();
        QueueBuyer.add(this);
        synchronized (this){
            try{
                this.wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        if(this.pensioneer) Dispatcher.pensioneerBuyerInQueueu.addAndGet(-1);

    }

    @Override
    public void takeBacket() {
        Dispatcher.semaphoreBuyers.release();
        int timeOut = Util.random(500,2000);
        if(pensioneer) Util.sleep(timeOut*3/2);
        else Util.sleep(timeOut);
//        System.out.println(this + "take a backet");
    }

    @Override
    public void putGoodToBacket() {
        int timeOut = Util.random(500,2000);
        int numOfGoods = Util.random(1,4);
        for (int i = 0; i < numOfGoods; i++) {
            if (pensioneer) Util.sleep(timeOut * 3 / 2);
            else Util.sleep(timeOut);
            choosenGoods.put(Backet.putGoods().getKey(), Backet.putGoods().getValue());
        }
    }

    @Override
    public void goOut() {
        Dispatcher.buyersWithBacket.remove(this);
        Dispatcher.removeBuyer();
//        System.out.println(this + "go out from market");
    }
    @Override
    public String toString(){
        if(pensioneer) return getName() + " pensioneer: ";
        else return getName() + ": ";
    }
}
