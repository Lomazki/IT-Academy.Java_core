package by.it.doNotTouch.gerasimov.jd01_13;

import java.util.HashMap;

class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NumberFormatException | NullPointerException e) {
            printException(e);
        }
    }

    static void printException(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (element.getClassName().equals(TaskA.class.getName())) {
                String nameException = e.getClass().getName();
                String className = element.getClassName();
                int lineNumber = element.getLineNumber();
                System.out.printf(" name: %s\nclass: %s\n line: %d\n", nameException, className, lineNumber);
                break;
            }
        }
    }
}
