package by.it.doNotTouch.kondratev.calc;

interface Patterns {

    static final String OPERATION = "(?<=[^-+*/{,])[-+*/=]";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR =  "\\{("+SCALAR+",?)+}"; //"\\{(-?[0-9]+\\.?[0-9]*,?)+}";
    static final String MATRIX = "\\{("+VECTOR+",?)+}";  //"\\{(\\{(-?[0-9]+\\.?[0-9]*,?)+},?)+}";
    static final String HOOKS = "\\(([\\w-+\\.*/{}\\,\\ ]+)\\)";
}
