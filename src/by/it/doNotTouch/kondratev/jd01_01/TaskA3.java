package by.it.doNotTouch.kondratev.jd01_01;
/*
Измените переменные и строку вывода в программе так,
чтобы она рассчитывала и печатала следующее выражение
3*3+4*4=25
 */

class TaskA3 {
    public static void main(String[] args) {
        int i = 2;
        int j = 3;
        int k = i * i * i * i + j * j;
        System.out.println(j + "*" + j + "+" + i * i + "*" + i * i + "=" + k);
    }
}
