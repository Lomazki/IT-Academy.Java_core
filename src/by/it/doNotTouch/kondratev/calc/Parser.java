package by.it.doNotTouch.kondratev.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private Var oneOperation(String strLeft, String operation, String strRight)
            throws CalcException {

        Var right = Var.create(strRight);

        if (operation.equals("="))
            return Var.saveVar(strLeft,right);

        Var left = Var.create(strLeft);

        switch (operation) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
            default:
                throw new CalcException("Неизвестная операция");
        }
    }

    Var calc(String expression) throws CalcException {
        expression = expression.trim().replace(" ", "");
        if (expression.contains("("))
            expression = deleteHooks(expression);
        String[] strings = expression.split(Patterns.OPERATION);
        List<String> operands = new ArrayList<>(Arrays.asList(strings));
        if (operands.size() == 1)
            return Var.create(expression);

        List<String> operation = new ArrayList<>();
        Matcher matcherOperation = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcherOperation.find()) {
            operation.add(matcherOperation.group());
        }

        while (!operation.isEmpty()) {
            int index = getIndexOperation(operation);
            String op = operation.remove(index);
            String strLeft = operands.remove(index);
            String strRight = operands.remove(index);
            Var res = oneOperation(strLeft, op, strRight);
            operands.add(index, res.toString());
        }
        return Var.create(operands.get(0));
    }

    String deleteHooks(String string) throws CalcException {
        Matcher matcherHooks = Pattern.compile(Patterns.HOOKS).matcher(string);
        String str1, str2;
        while (matcherHooks.find(0)) {
            str1 = matcherHooks.group();
            str2 = str1;
            str2 = str2.replace("(","").replace(")","");
            str2 = calc(str2).toString();
            string = string.replace(str1,str2);
            matcherHooks = Pattern.compile(Patterns.HOOKS).matcher(string);
        }
        return string;
    }

    private static final Map<String,Integer> PR_MAP =new HashMap<>();
    static {
        PR_MAP.put("=",0);
        PR_MAP.put("+",1);
        PR_MAP.put("-",1);
        PR_MAP.put("*",2);
        PR_MAP.put("/",2);
    }

    private int getIndexOperation(List<String> operation) {
        int index=-1;
        int current=-1;
        for (int i = 0; i < operation.size(); i++) {
            String op = operation.get(i);
            if (PR_MAP.get(op)>current){
                index=i;
                current= PR_MAP.get(op);
            }
        }
        return index;
    }
}
