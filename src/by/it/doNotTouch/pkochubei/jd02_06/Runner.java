package by.it.doNotTouch.pkochubei.jd02_06;

public class Runner {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("hello");

        for (int i = 0; i < 100; i++) {
            new Thread(()-> Logger.getInstance().log("Hello2\n")).start();
        }
    }
}
