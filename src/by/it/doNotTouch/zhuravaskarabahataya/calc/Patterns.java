package by.it.doNotTouch.zhuravaskarabahataya.calc;

interface Patterns {
    String OPERATION = "(?<=[^{,=*/+-])([=*/+-])";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
    String BRACKETS = "(?<=\\()[0-9a-zA-Z-+*/.]*?(?=\\))";
}
