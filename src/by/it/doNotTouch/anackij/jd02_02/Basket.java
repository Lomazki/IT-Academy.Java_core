package by.it.doNotTouch.anackij.jd02_02;

import java.util.HashMap;
import java.util.Map;

class Basket {

    int capacity;

    Map<Good, Integer> basketGoods;

    int totalPrice;

    Basket(){
        capacity = findCapacity();
        basketGoods = new HashMap<>(capacity);
    }

    int findCapacity (){
        return (int)(Math.random()*4+1);
    }

}
