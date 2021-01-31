package by.it.doNotTouch.kondratev.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> clazz = String.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.STATIC)!=Modifier.STATIC)
            System.out.println(method.getName());
        }

    }

}
