package by.it.doNotTouch.bunkov.calc;



class Scalar extends Var {

    private  double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {

         this.value = value;
    }

    @Override
    public Var add(Var other)  throws CalcException{
         if(other instanceof Scalar){
             double add=this.value+((Scalar) other).value;
             return  new Scalar(add);
         }
         else
             return  other.add(this);


    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        }
        else  return  new Scalar(-1.).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar){
            double mul=this.value*((Scalar) other).value;
            return  new Scalar(mul);
        }
        else
            return  other.mul(this);


    }


    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar){
            if (((Scalar) other).value == 0)
                throw  new CalcException("Деление на ноль");
            double div=this.value/((Scalar) other).value;
            return  new Scalar(div);
        }
            return  super.div(other);

    }

    Scalar(String str){
        this.value= Double.parseDouble(str);

    }
        Scalar(Scalar scalar){
         this.value = scalar.value;

        }
    @Override
    public String toString() {
        return Double.toString(value);
    }
}
