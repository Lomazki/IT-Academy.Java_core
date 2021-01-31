package by.it.doNotTouch.makarenko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String [] words = new String[0];
    private static int[] count = new int [0];


    public static void main(String[] args) {
        Pattern patternWords = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = patternWords.matcher(Poem.text);
        while(matcher.find()){
            String word = matcher.group();
            process(word);
        }
        for (int i = 0; i <words.length ; i++) {
            System.out.printf("%s=%s\n", words[i],count[i]);

        }
    }

    private static void process(String word) {
        for (int i = 0; i < words.length; i++) {
            if(word.equals(words[i])){
                count[i]++;
                return;
            }

        }
        words=Arrays.copyOf(words,words.length+1);
        count=Arrays.copyOf(count,count.length+1);
        words[words.length-1]=word;
        count[count.length-1]=1;
    }
}
