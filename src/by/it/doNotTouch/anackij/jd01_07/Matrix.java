package by.it.doNotTouch.anackij.jd01_07;

public class Matrix extends Var {
    private double[][] values = {{1, 2},
            {3, 4}};

    public Matrix() {
    }

    public Matrix(double[][] value) {
        this.values = value;
    }

    public Matrix(Matrix values) {
        this(values.values);
    }


    public Matrix(String str) {
        //{{2,3,2},{3,3,5}}
        str.replace(" ", "").trim();
        String[] strRows = str.split("},");
        for (int i = 0; i < strRows.length; i++) {
            strRows[i] = strRows[i].replace("{", "").replace("}", "");
        }
        values = new double[strRows.length][0];
        for (int i = 0; i < strRows.length; i++) {
            String[] oneRow = strRows[i].split(",");
            values[i] = new double[oneRow.length];
            for (int j = 0; j < oneRow.length; j++) {
                values[i][j] = Double.parseDouble(oneRow[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        int endRow = values.length;
        String delimiter = "";
        out.append('{');
        for (int i = 0; i < values.length; i++) {
            out.append('{');
            for (int j = 0; j < values[0].length; j++) {

                delimiter = "";
                out.append(delimiter).append(values[i][j]);
                if (j < values[0].length - 1) {
                    delimiter = ", ";
                    out.append(delimiter);
                }
            }
            out.append('}');
            out.append(delimiter);
            if (i < values.length - 1) {
                delimiter = ", ";
                out.append(delimiter);
            }
        }
        out.append('}');
        return out.toString();
    }
}
