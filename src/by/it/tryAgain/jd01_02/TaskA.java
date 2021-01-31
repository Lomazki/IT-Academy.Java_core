package by.it.tryAgain.jd01_02;

import java.util.Scanner;

public class TaskA {

    static void step1(int[] mas) {
        int masMax = 0;
        int masMin = 0;
        for (int i = 0; i < mas.length; i++) {
            masMax = mas[i];
            masMin = mas[i];
            for (int j = 0; j < mas.length; j++) {
                if (masMax <= mas[j]) {
                    masMax = mas[j];
                }
                if (masMin >= mas[j]) {
                    masMin = mas[j];
                }
            }
        }
        System.out.println(masMin + " " + masMax);
    }

    static void step2(int[] mas) {
        double sum = 0;
        int counter = mas.length;
        for (int i : mas) {
            sum = sum + i;
        }
        double average = sum/counter;
        for (int i : mas) {
            if (mas[i]<average) {
                System.out.print(mas[i] + " ");
            }
        }
        System.out.println();
    }

    static void step3(int[] mas) {
        int masMin = 0;
        for (int i = 0; i < mas.length; i++) {
            masMin = mas[i];
            for (int j = 0; j < mas.length; j++) {
                if (masMin >= mas[j]) {
                    masMin = mas[j];
                }
            }
        }
        for (int i = mas.length-1; i >= 0; i--) {
            if (mas[i] == masMin) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        System.out.println();
        step1(mas);
        step2(mas);
        step3(mas);
    }
}
