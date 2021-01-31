package by.it.doNotTouch.gerasimov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher m = p.matcher(Poem.text);
        while (m.find()) {
            text.setCharAt(m.start() + 3, '#');
            if (m.end() - m.start() > 6) {
                text.setCharAt(m.start() + 6, '#');
            }
        }
        System.out.println(text);
    }
}
