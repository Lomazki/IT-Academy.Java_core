package by.it.doNotTouch.kondratev.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        step1();
        step2(scanner.nextInt());
        step3(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    }

    static void step1() {
        for (int i = 1; i < 26; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) System.out.println();

        }

    }



    static void step2(int month) {
switch (month) {
            case 1:                 System.out.println("январь");                 break;
            case 2:                 System.out.println("февраль");                 break;
            case 3:                 System.out.println("март");                 break;
            case 4:                 System.out.println("апрель");                 break;
            case 5:                 System.out.println("май");                 break;
            case 6:                 System.out.println("июнь");                 break;
            case 7:                 System.out.println("июль");                 break;
    case 8:                 System.out.println("август");                 break;
    case 9:                 System.out.println("сентябрь");                 break;
    case 10:                 System.out.println("октябрь");                 break;
    case 11:                 System.out.println("ноябрь");                 break;
    case 12:                 System.out.println("декабрь");                 break;
            default:                System.out.println("нет такого месяца"); }

    }

    static void step3(double a, double b, double c) {
double D=Math.sqrt(b*b-4*a*c);
if (D>0) System.out.println((-b+D)/(2*a)+"  "+(-b-D)/(2*a));
else if (D==0) System.out.println(-b/(2*a));
else System.out.println("корней нет");
    }
}
