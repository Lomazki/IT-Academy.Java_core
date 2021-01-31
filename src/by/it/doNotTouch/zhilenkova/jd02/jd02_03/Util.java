package by.it.doNotTouch.zhilenkova.jd02.jd02_03;

public class Util {
    protected static int random(int max){return random(0,max);}
    protected static int random(int min, int max){return min+(int)(Math.random()*(max-min+1));}
    static void sleep(int millis){
        try{
            Thread.sleep(millis/ Dispatcher.K_SPEED);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
