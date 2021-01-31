package by.it.doNotTouch.gerasimov.jd01_09;

interface Patterns {
    String OPERATORS = "[-+*/]";
    String PRIMARY_OPERATORS = "[*/]";
    String SECONDARY_OPERATORS = "[-+]";
    String[] OPERATIONS = {SECONDARY_OPERATORS, PRIMARY_OPERATORS};
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
}