package by.it.doNotTouch.anackij.jd01_01;

public class Args {

    private String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public void printArgs() {
        int i = 1;
        for (String arg : args) {
            i = i + 1;
            System.out.println("Аргумент " + i + "-" + arg);
        }
    }

}
