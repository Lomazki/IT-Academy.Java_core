package by.it.doNotTouch.gerasimov.calc;

interface Patterns {

    String OPERATORS = "(?<=[^-+*/={,])[-+*/]";
    String PRIMARY_OPERATORS = "(?<=[^-+*/={,])[*/]";
    String SECONDARY_OPERATORS = "(?<=[^-+*/={,])[-+]";
    String ASSIGNMENT_OPERATORS = "=";
    String[] OPERATIONS = {SECONDARY_OPERATORS, PRIMARY_OPERATORS};
    String BRACKETS = "\\([^\\(]*?\\)";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
    String VARIABLE = "[A-z]+";
    String ASSIGNMENT = VARIABLE + ASSIGNMENT_OPERATORS + ".+";
}
