package by.it.tryAgain.jd01_07;

import java.util.Arrays;

public class Vector extends Var {

    private double [] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector){
        this.value = vector.value;
    }

    public Vector(String strVector){

    }

    @Override
    public String toString() {
        return "Vector{" +"value=" + Arrays.toString(value) +'}';
    }
}
