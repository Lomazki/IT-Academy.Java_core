package by.it.doNotTouch.degtyaryov.jd02_02;

class Good {

    private String name;
    private double price;

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s (price %.2f)", name, price);
    }
}
