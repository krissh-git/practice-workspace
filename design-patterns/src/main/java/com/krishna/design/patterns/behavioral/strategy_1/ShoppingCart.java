package com.krishna.design.patterns.behavioral.strategy_1;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void pay(PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(calculateTotal());
    }

    private int calculateTotal() {
        return this.items.stream().mapToInt(Item::getItemPrice).sum();
    }


}
