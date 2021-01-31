package by.it.doNotTouch.degtyaryov.jd02_03;

import java.io.PrintWriter;
import java.util.Arrays;

class CheckPrinter {

    private static final String TITLE_FORMAT = "|%20s|%20s|%20s|%20s|%20s|%20s|%20s|%n";
    private static final String BODY_FORMAT = "|%-20s|%-20s|%-20s|%-20s|%-20s|%20s|%20s|%n";
    private static final String TOTAL_FORMAT = "|%20s|%20s|%20s|%20s|%20s|%20s|%20.2f|%n";

    private PrintWriter printWriter = new PrintWriter(System.out);
    private String[] columns;

    public synchronized void print(int cashierNumber, Basket basket, Market market) {
        String checkText = generateTitle() +
                generateBody(cashierNumber, basket) +
                generateFooter(cashierNumber, basket.getSum(), market);
        printWriter.printf(checkText).flush();
    }

    private String generateTitle() {
        return String.format(TITLE_FORMAT, "Cashier №0", "Cashier №1", "Cashier №2", "Cashier №3", "Cashier №4", "In queue", "Market's income");
    }

    private String generateBody(int cashierNumber, Basket basket) {
        StringBuilder bodyText = new StringBuilder();
        for (Good good : basket.getGoods()) {
            String goodFormat = String.format("%s +%.2f", good.getName(), good.getPrice());
            initializeValues(cashierNumber, goodFormat);
            String line = String.format(BODY_FORMAT, columns[0], columns[1], columns[2], columns[3], columns[4], "", "");
            bodyText.append(line);
        }
        return bodyText.toString();
    }

    private String generateFooter(int cashierNumber, double sum, Market market) {
        String sumLineFormat = String.format("TOTAL: %.2f", sum);
        initializeValues(cashierNumber, sumLineFormat);
        return String.format(TOTAL_FORMAT, columns[0], columns[1], columns[2], columns[3], columns[4], market.getQueue().size(), market.getTotalIncome());
    }

    private void initializeValues(int cashierNumber, String line) {
        columns = new String[CashierManager.MAX_CASHIER];
        Arrays.fill(columns, "");
        columns[cashierNumber] = line;
    }
}
