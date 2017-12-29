package com.krishna.design.patterns.behavioral.strategy_1;

public class PayPalPaymentStrategy implements PaymentStrategy {

    private String emailId;

    public PayPalPaymentStrategy(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via PayPal using email id " + emailId);
    }
}
