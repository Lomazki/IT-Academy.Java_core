package by.it.doNotTouch.zhilenkova.jd01.jd01_05;

import static java.lang.Math.*;

public class TaskC {

    public static void main(String[] args) {

        step1("Arr", 25);
        step2();

    }

    private static void step1(String name, int len){
        double[] mainArray = new double[len];
        int count = 0;
        int lenNewArray = 0;
        for (double x = 5.33; x <= 9 ; x = x + 0.132) {
            if(count < mainArray.length){
                mainArray[count] = cbrt((x * x) + 4.5);
                if(mainArray[count] > 3.5){
                    lenNewArray++;
                }
            } else {
                break;
            }
            count++;
        }
        printArray(mainArray, "Arr A", 5);
        double[] result = getNewArray(mainArray, lenNewArray); //getting array with values more than 3.5
        printArray(result, "Arr B", 5);
        double average = getAverage(result); //getting average value
        System.out.println("Average = " + average);
    }

    private static void printArray(double[ ] arr, String name, int columnCount){
        int col = 0;
        System.out.println("Массив " + name +"[]");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-4s[ %-2d ] = %-10f", name, i, arr[i]);
            col++;
            if(col % columnCount == 0 || col == arr.length){
                System.out.println();
            }
        }
    }

    private static double[] getNewArray(double[] arr, int len){
        double[] result = new double[len];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 3.5){
                result[j] = arr[i];
                j++;
            }
        }
        return result;
    }

    private static double getAverage(double[]arr){
        double result;
        double sum = 1;
        for (int i = 0; i < arr.length; i++) {
            sum *= arr[i];
        }
        result = pow(sum, 1.0 / arr.length);
        return result;
    }



    private static void step2(){
        char[] tableElem = initializationChar();
        double[] arrayA = new double[31];
        int lenArrayB = 0;
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = round(random()*347 + 103);
            if(arrayA[i] * 0.1 > i){
                lenArrayB++;
            }
        }
        double[] arrayB = new double[lenArrayB];
        int j = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] * 0.1 > i){
                arrayB[j] = arrayA[i];
                j++;
            }
        }
        sortArr(arrayB);

        printArrayA(arrayA, "A" , 5, tableElem);

        printArrayB(arrayB, "B", 4, tableElem);
    }

    private static void printArrayA(double[] arr, String name, int column, char[]table){
        int col = 0;
        int delta = (int)ceil(arr.length * 1.0/ column) * column;
        int index = 0;

        System.out.println("Массив " + name +"[]");
        printTopLine(table, column);
        for (int i = 0; i < delta; i++) {
            if(index < arr.length) {
//                System.out.printf(table[5] + " " + name + "[" +i +"] = " + arr[i] + "    ");
                System.out.printf("%s %s[ %-2d]=%-7.1f", table[5], name, i, arr[i]);
            } else {
                System.out.printf("%s%-15s", table[5], "");
            }
            index++;
            col++;
            if(col % column == 0){
                System.out.println(table[5]);
                if(col < arr.length){
                    printMiddleLine(table, column);
                }
            }
        }
        printBottomLine(table, column);
    }
    private static void sortArr(double[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for(int k = i + 1; k < arr.length; k++){
                if(arr[k] < arr[i]){
                    double tmp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    private static void printArrayB(double[]arr, String name, int col, char[]table){
        int delta = (int)ceil(arr.length * 1.0/ col) ;
        int count = 0;
        System.out.println("Массив " + name +"[]");
        printTopLine(table, col);
        for (int i = 0; i < delta; i++) {
            int index = i;
            for (int j = 0; j < col; j++) {
                if(index < arr.length){
                    System.out.printf("%s %s[ %-2d]=%-7.1f", table[5], name, index, arr[index]);
                } else {
                    System.out.printf("%s%-15s", table[5], "");
                }
                index += delta;
                count++;
            }
            System.out.println(table[5]);
            if(count < arr.length){
                printMiddleLine(table, col);
            }
        }
        printBottomLine(table, col);
    }
    private static char[] initializationChar(){
        char[] table = {9552, //0 - ═
                9580, //1 - ╬
                9556, //2 - ╔
                9559, //3 - ╗
                9562, //4 - ╚
                9553, //5 - ║
                9574, //6 - ╦
                9577, //7 - ╩
                9568, //8 - ╠
                9571, //9 - ╣
                9565  //10 - ╝
        };
        return table;
    }

    private static void printTopLine(char[] table, int column){

        System.out.print(table[2] + getLine(table[0]));
        for (int i = 0; i < column - 1; i++) {
            System.out.print(table[6] + getLine(table[0]));
        }
        System.out.println(table[3]);
    }

    private static void printMiddleLine(char[] table, int column){
        System.out.print(table[8] + getLine(table[0]));
        for (int i = 0; i < column - 1; i++) {
            System.out.print(table[1] + getLine(table[0]));
        }
        System.out.println(table[9]);
    }
    private static void printBottomLine(char[] table, int column){

        System.out.print(table[4] + getLine(table[0]));
        for (int i = 0; i < column - 1; i++) {
            System.out.print(table[7] + getLine(table[0]));
        }
        System.out.println(table[10]);
    }

    private static String getLine(char a){
        String line = "";
        for (int i = 0; i < 15; i++) {
            line += a;
        }
        return line;
    }

}
