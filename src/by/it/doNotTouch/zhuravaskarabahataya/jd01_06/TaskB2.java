package by.it.doNotTouch.zhuravaskarabahataya.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    //убери Стрбилдер
    //Вывести через \n все предложения текста в порядке возрастания количества символов (!)
    // в каждом из них. В предложениях нужно сначала заменить все небуквенные символы
    // и их последовательности на один пробел и выполнить trim() для каждого предложения.
    public static void main(String[] args) {
        printSentences();
    }

    private static void printSentences() {
        String text1 = Poem.text.replaceAll("([-,\":\n\\s]+)", " ");
        String text = text1.replaceAll("[.]{3}", " ");
        StringBuilder sb = new StringBuilder(text);
        System.out.println(sb);
        int countOfSent = 0;
        Pattern pattern = Pattern.compile("[А-Яа-яёЁ\\s]*[.!]+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            System.out.println(matcher.group().trim());
            countOfSent++;
        }
        System.out.println(countOfSent);
        String[] stringArray = new String[countOfSent];
        int[] lengthArray = new int[countOfSent];
        int counter = 0;
        Pattern p1 = Pattern.compile("[А-Яа-яёЁ\\s]*[.!]+");
        Matcher m1 = p1.matcher(sb);
        while (m1.find()) {
            stringArray[counter] = m1.group().replaceAll("[.!]", " ").trim();
            lengthArray[counter] = stringArray[counter++].length();
        }
        Arrays.sort(lengthArray);
        System.out.println();

        for (int i = 0; i < countOfSent; i++) {
            for (int j = 0; j < countOfSent; j++) {
                if (lengthArray[i] == stringArray[j].length()) {
                    System.out.println(stringArray[j]);
                    stringArray[j] = "";
                }
            }

        }
    }


}
