package by.it.doNotTouch.kondratev.jd01_07;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String StrScalar) {
        value = Double.parseDouble(StrScalar);
    }

    Scalar(Scalar scalar) {
        value = scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);

    }


}
