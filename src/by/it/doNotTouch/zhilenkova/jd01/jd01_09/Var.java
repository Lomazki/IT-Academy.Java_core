package by.it.doNotTouch.zhilenkova.jd01.jd01_09;

abstract class Var implements Operation{

    static Var createVar(String operand){
        operand = operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALAR)){
            return new Scalar(operand);
        }else if (operand.matches(Patterns.VECTOR)){
            return new Vector(operand);
        }else if (operand.matches(Patterns.MATRIX)){
            return new Matrix(operand);
        }
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения "+this+"+"+other+" невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания "+this+"-"+other+" невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умноджения "+this+"*"+other+" невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления "+this+"/"+other+" невозможна");
        return null;
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }
}
