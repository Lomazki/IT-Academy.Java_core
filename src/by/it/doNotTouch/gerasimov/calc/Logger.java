package by.it.doNotTouch.gerasimov.calc;

import by.it.doNotTouch.gerasimov.calc.translate.Globalization;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;

class Logger {

    private static final int MAX_COUNT = 50;
    private static volatile Logger instance;
    private static Deque<String> logs = new LinkedList<>();

    private Logger() {
    }

    public static Logger getInstance() {
        Logger localInstance = instance;
        if (localInstance == null) {
            synchronized (Logger.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Logger();
                }
            }
        }
        return localInstance;
    }

    private void readLog() {
        try (BufferedReader br = new BufferedReader(new FileReader(Settings.pathToLog))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                logs.addFirst(line);
                count++;
                if (count == MAX_COUNT) {
                    logs.removeLast();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeLog(String str) {
        readLog();
        try (PrintWriter pw = new PrintWriter(Settings.pathToLog)) {
            for (int i = 0; i < MAX_COUNT - 1; i++) {
                if (logs.isEmpty()) {
                    break;
                }
                pw.println(logs.pollLast());
            }
            pw.println(toLogFormat(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String toLogFormat(String str) {
        return Globalization.getCurrentDate() + " " + str;
    }
}
