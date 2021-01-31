package by.it.tryAgain.jd01_01;

import java.util.Scanner;

public class TaskC3 {

    static double getWeight(double weightEarth) {
        double mars = 3.86;
        double earth = 9.81;
        return (double) Math.round(weightEarth / earth * mars * 100) / 100;
    } // Переделать для String (Округлять в String format)

    public static void main(String[] args) {

        System.out.println("Enter your weight");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your weight on Mars is " + getWeight(scanner.nextDouble()) + "kg");
    }
}
