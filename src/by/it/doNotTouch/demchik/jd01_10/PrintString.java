package by.it.doNotTouch.demchik.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> sys = String.class;
        Method[] methods = sys.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC)
                System.out.println(method.getName());
        }

    }
}
// почему находит лишние данные в выводе format?