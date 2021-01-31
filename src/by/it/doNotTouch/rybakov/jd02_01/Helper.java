package by.it.doNotTouch.rybakov.jd02_01;


import java.util.Random;

class Helper {

    private static Random generator = new Random();

    static void sleep(int timeout){
        try{
            Thread.sleep(timeout/Dispatcher.K_SPEED);
        }
        catch(InterruptedException e){
            System.err.println("Crash of Thread");

        }
    }
    static int random(int min, int max){return generator.nextInt(max-min+1)+min;}
    static int random(int max){return random(0,max);}
}
