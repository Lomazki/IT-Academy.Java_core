package by.it.doNotTouch.bunkov.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {

        try {


            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    String nameException = e.getClass().getName();
                    String className = element.getClassName();
                    int lineNumber = element.getLineNumber();
                    System.out.printf(
                            " name: %s\n" +
                                    "class: %s\n" +
                                    " line: %d\n",
                            nameException, className, lineNumber);
                    break;
                }
            }
        }
    }
}
