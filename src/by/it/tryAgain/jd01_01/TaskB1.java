package by.it.tryAgain.jd01_01;

import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {

        int a;

        do {
            System.out.println("Введите целое число");
            Scanner sc = new Scanner(System.in);
            a = sc.nextInt();
        } while (a <= 0);

        System.out.println(a*a + " - Квадрат введенного Вами числа");
    }
}
