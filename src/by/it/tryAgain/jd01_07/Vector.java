package by.it.tryAgain.jd01_07;

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


}
