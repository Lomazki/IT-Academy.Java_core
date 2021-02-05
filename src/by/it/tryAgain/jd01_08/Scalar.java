package by.it.tryAgain.jd01_08;

class Scalar extends Var implements Operation{

    private double value;

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
