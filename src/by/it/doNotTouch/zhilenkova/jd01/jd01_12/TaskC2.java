package by.it.doNotTouch.zhilenkova.jd01.jd01_12;

import java.util.*;

/*
TaskC2. Попробуйте решить заново задачу TaskA2 для любого количества
множеств на входе метода, а также для различных типов чисел в каждом из
множеств (generics).
 В main покажите работоспособность решения.
 */

public class TaskC2 {

    static <T extends  Number>  Set<T> getCross(Set<T>... a) {
        HashSet<T> result = new HashSet<>(a[0]);

        for (Set<T> value : a){
            result.retainAll(value);
        }

        return result;
    }
    static <T extends  Number>  Set<T> getUnion(Set<T>... a) {
        HashSet<T> result = new HashSet<>(a[0]);

        for (Set<T> value : a){
            result.addAll(value);
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] dataA = {1, 2, 3, 5, 6, 7, 90};
        Integer[] dataB = {1, 2, 3, 4, 5, 6, 7, 77};
        Integer[] dataC = {5, 5, 6, 2, 6, 7, 23};
        Set<Integer> a = new HashSet<>(Arrays.asList(dataA));
        Set<Integer> b = new HashSet<>(Arrays.asList(dataB));
        Set<Integer> c = new HashSet<>(Arrays.asList(dataC));
        System.out.println(getCross(a, b, c));
        System.out.println(getUnion(a, b, c));

    }
}
