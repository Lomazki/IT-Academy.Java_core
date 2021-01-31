package by.it.doNotTouch.degtyaryov.jd02_02;

import java.io.PrintWriter;
import java.util.Arrays;

class Reporter {

    private static final String TITLE_FORMAT = "|%20s|%20s|%20s|%20s|%20s|%20s|%20s|%n";
    private static final String BODY_FORMAT = "|%-20s|%-20s|%-20s|%-20s|%-20s|%20s|%20s|%n";
    private static final String TOTAL_FORMAT = "|%20s|%20s|%20s|%20s|%20s|%20s|%20.2f|%n";

    private static PrintWriter printWriter = new PrintWriter(System.out);
    private static String[] columns;

    public static synchronized void printReport(int cashierNumber, Basket basket) {
        String sb = getTitle() +
                getBody(cashierNumber, basket) +
                getTotal(cashierNumber, basket.getSum());
        printWriter.printf(sb).flush();
    }

    private static void initializeValues(int cashierNumber, String line) {
        columns = new String[CashierManager.MAX_CASHIER];
        Arrays.fill(columns, "");
        columns[cashierNumber] = line;
    }

    private static String getTitle() {
        return String.format(TITLE_FORMAT, "Cashier №0", "Cashier №1", "Cashier №2", "Cashier №3", "Cashier №4", "In queue", "Market's income");
    }

    private static String getBody(int cashierNumber, Basket basket) {
        StringBuilder string = new StringBuilder();
        for (Good good : basket.getGoods()) {
            String goodFormat = String.format("%s +%.2f", good.getName(),  good.getPrice());
            initializeValues(cashierNumber, goodFormat);
            String line = String.format(BODY_FORMAT, columns[0], columns[1], columns[2], columns[3], columns[4], "", "");
            string.append(line);
        }
        return string.toString();
    }

    private static String getTotal(int cashierNumber, double sum) {
        String sumLineFormat = String.format("TOTAL: %.2f", sum);
        initializeValues(cashierNumber, sumLineFormat);
        return String.format(TOTAL_FORMAT, columns[0], columns[1], columns[2], columns[3], columns[4], Queue.size(), CashierManager.getTotalIncome());
    }
}
