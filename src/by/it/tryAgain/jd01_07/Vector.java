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
        String [] strVec = strVector.trim()
                .replace("{","")
                .replace("}","")
                .replace(" ","")
                .split(",");
        value = new double[strVec.length];
        for (int i = 0; i < strVec.length; i++) {
            value[i] = Double.parseDouble(strVec[i]);
        }
    }

    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            strBuilder.append(delimiter).append(v);
            delimiter=", ";
        }
        strBuilder.append("}");
        return strBuilder.toString();
    }


}
