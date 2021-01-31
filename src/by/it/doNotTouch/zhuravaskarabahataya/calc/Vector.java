package by.it.doNotTouch.zhuravaskarabahataya.calc;

import by.it.doNotTouch.zhuravaskarabahataya.calc.translate.Error;
import by.it.doNotTouch.zhuravaskarabahataya.calc.translate.ResMan;

import java.util.Arrays;

class Vector extends Var implements Operation {
    private double[] values;

    public double[] getValues() {
        return values;
    }

    public Vector(double[] values) {
        this.values = new double[values.length];
        System.arraycopy(values, 0, this.values, 0, values.length);
    }

    @SuppressWarnings("unused")
    public Vector(Vector vector) {
        this(vector.values);
    }

    public Vector(String strVector) {
        StringBuilder sb = new StringBuilder(strVector);
        sb.deleteCharAt(sb.length() -1);
        sb.deleteCharAt(0);
        String[] strArray = sb.toString().split(",");
        double[] doubleArray = new double[strArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(strArray[i]);
        }
        this.values = doubleArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double d : values) {
            sb.append(delimiter).append(d);
            delimiter = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        return other.add(this);
    }

    public Var add(Scalar other) throws CalcException {
        double[] result = Arrays.copyOf(values, values.length);
        double s =  other.getValue();
        for (int i = 0; i < result.length; i++) {
            result[i] += s;
        }
        return new Vector(result);
    }

    public Var add(Vector other) throws CalcException {
        double[] result = Arrays.copyOf(values, values.length);
        if (this.values.length != other.values.length) {
            ResMan manager = ResMan.INSTANCE;
            throw new CalcException(manager.get(Error.INVALID_OPERATION));
        }
        for (int i = 0; i < result.length; i++) {
            result[i] += other.values[i];
        }
        return new Vector(result);
    }

    public Var add(Matrix other) throws CalcException {
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double[] result = Arrays.copyOf(values, values.length);
        if (other instanceof Scalar){
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] -=s;
            }
            return new Vector(result);
        }
        if (other instanceof Vector){
            if (this.values.length != ((Vector) other).values.length){
                ResMan manager = ResMan.INSTANCE;
                throw new CalcException(manager.get(Error.INVALID_OPERATION));
            }
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).values[i];
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            double[] result = Arrays.copyOf(this.values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        else if (other instanceof Vector){
            if (this.values.length != ((Vector) other).values.length){
                ResMan manager = ResMan.INSTANCE;
                throw new CalcException(manager.get(Error.INVALID_OPERATION));
            }
            int res = 0;
            for (int i = 0; i < values.length; i++) {
                res += values[i]*((Vector) other).getValues()[i];
            }
            return new Scalar(res);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar){
            if (((Scalar) other).getValue() == 0) {
                ResMan manager = ResMan.INSTANCE;
                throw new CalcException(manager.get(Error.DIV_BY_ZERO));
            }
            double[] result = Arrays.copyOf(this.values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] /= ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        return super.div(other);
    }
}
