package by.it.doNotTouch.degtyaryov.jd02_01;

class Runner {

    private static final int WORK_TIME = 120;

    public static void main(String[] args) {
        Market market = new Market();
        System.out.println("Market is opened.");
        market.start(WORK_TIME);
        market.end();
        System.out.println("Marked is closed.");
    }
}
