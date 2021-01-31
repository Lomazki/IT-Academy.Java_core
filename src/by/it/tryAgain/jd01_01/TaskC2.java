package by.it.tryAgain.jd01_01;

import java.util.Scanner;

public class TaskC2 {

    static int Entered(String massage) {
        System.out.println(massage);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        System.out.println("sum = " + Entered("Введите первое целое число") +
                Entered("Введите второе целое число"));
    }
}
