package by.it.doNotTouch.anackij.jd01_09;


class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    public Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    Scalar(Scalar other) {
        this(other.value);
    }

    Scalar(double value) {
        this.value = value;
    }

    @Override
    public Var add(Var other){
        if (other instanceof Scalar){
            double result= this.value+((Scalar)other).value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double result= this.value-((Scalar)other).value;
            return new Scalar(result);
        }else {
            Var minus = new Scalar(-1);
            return other.add(this).mul(minus);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double result= this.value*((Scalar)other).value;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double result= this.value/((Scalar)other).value;
            return new Scalar(result);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
