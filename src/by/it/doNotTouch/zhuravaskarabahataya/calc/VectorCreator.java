package by.it.doNotTouch.zhuravaskarabahataya.calc;

class VectorCreator extends VarCreator{

    @Override
    Var createVar(String str) {
        return new Vector(str);
    }
}

