package by.it.doNotTouch.lomazki.Example.jd01_00_02;

public class InOut {

    static double[ ] getArray(String line) {
        String [] strArray = line.split(" ");
        double [] res  = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            res [i] = Double.parseDouble(strArray[i]);
        }
        return res;
    }
}

