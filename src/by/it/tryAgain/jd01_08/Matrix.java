package by.it.tryAgain.jd01_08;

class Matrix extends Var implements Operation{

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.substring(1, strMatrix.length() - 2);
        String[] row = strMatrix.split("},");
        for (int i = 0; i <row.length ; i++) {
            row[i] = row[i].substring(1);
        }
        String [] cols = row[0].split(",");
        double [][] mas = new double[row.length][cols.length];
        for (int i = 0; i < row.length ; i++) {
            String [] col = row[i].split(",");
            for (int j = 0; j < col.length ; j++) {
                mas[i][j] = Double.parseDouble(col[j]);
            }
        }
        value = mas;
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

