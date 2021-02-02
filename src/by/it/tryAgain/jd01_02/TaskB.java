package by.it.tryAgain.jd01_02;

import java.util.Scanner;

public class TaskB {

    static void step1() {
        for (int i = 1; i < 26; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }

    static void step2(int month) {
        String monthString = null;
        switch (month) {
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "June";
                break;
            case 7:
                monthString = "July";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "October";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "December";
                break;
            default:
                break;
        }
        System.out.println(monthString);
    }

    static void step3(double a, double b, double c) {
        double discriminant = (b * b) - (4 * a * c);
        if (discriminant == 0) {
            double x1 = -b / (2 * a);
            System.out.println(x1);
        } else if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(x1);
            System.out.println(x2);
        } else System.out.println("No roots");

    }

    public static void main(String[] args) {

        step1();
        Scanner scanner = new Scanner(System.in);
        int numberMonth = scanner.nextInt();
        step2(numberMonth);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        step3(a, b, c);

    }
}
