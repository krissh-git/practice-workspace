package com.krishna.design.patterns.behavioral.strategy_1;

public class Strategy1Client {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        Item item = new Item("a", 10);
        shoppingCart.addItem(item);

        Item item2 = new Item("b", 20);
        shoppingCart.addItem(item2);

        Item item3 = new Item("c", 20);
        shoppingCart.addItem(item3);

        shoppingCart.pay(new CCPaymentStrategy("test","123","111"));


        shoppingCart.pay(new PayPalPaymentStrategy("test@gmail.com"));
    }
}
