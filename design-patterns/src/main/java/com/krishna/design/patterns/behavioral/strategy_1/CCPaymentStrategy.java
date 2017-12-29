package com.krishna.design.patterns.behavioral.strategy_1;

public class CCPaymentStrategy implements PaymentStrategy {

    private String name;
    private String creditCardNumber;
    private String creditCardCvv;


    public CCPaymentStrategy(String name, String creditCardNumber, String creditCardCvv) {
        this.name = name;
        this.creditCardNumber = creditCardNumber;
        this.creditCardCvv = creditCardCvv;
    }

    @Override
    public void pay(int amount) {
        String message = "Paid " + amount + "via CC {" +
                "name='" + name + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", creditCardCvv='" + creditCardCvv + '\'' +
                '}';
        System.out.println(message);
    }

}
