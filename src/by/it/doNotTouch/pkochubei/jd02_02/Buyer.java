package by.it.doNotTouch.pkochubei.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    private Backet backet;
    protected boolean pensioneer;
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
    }

    @Override
    public void chooseGoods() {
        int timeOut = Util.random(500, 2000);
        if (pensioneer) Util.sleep(timeOut * 3 / 2);
        else Util.sleep(timeOut);
    }

    @Override
    public void goToQueue() {
        QueueBuyer.add(this);
        synchronized (this){
            try{
                this.wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void takeBacket() {
        int timeOut = Util.random(500,2000);
        if(pensioneer) Util.sleep(timeOut*3/2);
        else Util.sleep(timeOut);
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
        Dispatcher.removeBuyer();
    }
    @Override
    public String toString(){
        if(pensioneer) return getName() + " pensioneer: ";
        else return getName() + ": ";
    }
}
