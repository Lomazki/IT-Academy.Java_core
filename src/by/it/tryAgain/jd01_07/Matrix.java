package by.it.tryAgain.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        // {{3,6},{6,7}}
        String[] rowMat = strMatrix.replace(" ", "").split("},");
        double[][] value = new double[2][2];
        for (int i = 0; i < rowMat.length; i++) {
            rowMat[i].replace("{", "").replace("}", "");
            String[] colMat = rowMat[i].split(",");
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(colMat[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter1 = "";
        for (double[] doubles : this.value) {
            out.append(delimiter1).append("{ ");
            String delimiter2 = "";
            for (int j = 0; j < this.value[0].length; j++) {
                out.append(delimiter2).append(doubles[j]);
                delimiter2 = ", ";
            }
            out.append(" }");
            delimiter1 = ", ";
        }
        out.append('}');
        return out.toString();
    }
}

