package by.it.doNotTouch.gerasimov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class BuyerQueue {

    private static final Deque<Buyer> QUEUE = new LinkedList<>();
    private static final Deque<Buyer> PENSIONER_QUEUE = new LinkedList<>();

    static void add(Buyer buyer) {
        synchronized (QUEUE) {
            if (buyer.isPensioner()) {
                PENSIONER_QUEUE.addLast(buyer);
            } else {
                QUEUE.addLast(buyer);
            }
        }
        if (BuyerQueue.getQueueSize() > 0 &&
            BuyerQueue.getQueueSize() / 5 >= Dispatcher.getCashierCount() &&
            Dispatcher.getCashierCount() < Dispatcher.getCashiers().size()) {
            synchronized (Dispatcher.OPEN_CASHIER_MONITOR) {
                Dispatcher.OPEN_CASHIER_MONITOR.notify();
            }
        }
    }

    static Buyer extract() {
        synchronized (QUEUE) {
            if (!PENSIONER_QUEUE.isEmpty()) {
                return PENSIONER_QUEUE.pollFirst();
            } else {
                return QUEUE.pollFirst();
            }
        }
    }

    synchronized static int getQueueSize() {
        return QUEUE.size() + PENSIONER_QUEUE.size();
    }
}
