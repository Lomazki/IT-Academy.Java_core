package by.it.doNotTouch.kondratev.jd01_08;

abstract class Var implements Operation {

    @Override
    public Var add(Var other) {
        System.out.println("Операция "+this+" + "+other+" невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция "+this+" - "+other+" невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция "+this+" * "+other+" невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция "+this+" / "+other+" невозможна");
        return null;
    }

    @Override
    public String toString() {
        return "abstract Var";
    }
}
