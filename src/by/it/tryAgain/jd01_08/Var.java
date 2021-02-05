package by.it.tryAgain.jd01_08;

public abstract class Var implements Operation {
    @Override
    public Var add(Var other) {
        System.out.println("Operation addition " + this + "+" + other + " is not possible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Operation subtractions " + this + "-" + other + " is not possible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Operation multiplication " + this + "*" + other + " is not possible");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Operation division " + this + "/" + other + " is not possible");
        return null;
    }
}
