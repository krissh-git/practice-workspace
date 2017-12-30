package com.krishna.design.patterns.behavioral.cor_1;

public abstract class Dispenser {

    private Dispenser dispenser;

    Dispenser(Dispenser dispenser) {
        this.dispenser = dispenser;
    }

    protected abstract int getAmount();

    protected void dispense(Currency currency) {
            final int amount = getAmount();
            final int inputAmount = currency.getAmount();
            if (inputAmount >= amount) {
                int noOfNotes = inputAmount / amount;
                System.out.println("Dispensing " + noOfNotes + " notes of Rs." + amount);
                int balance = inputAmount % amount;
                if (balance != 0) {
                    this.dispenser.dispense(new Currency(balance));
                }
            } else {
                this.dispenser.dispense(currency);
            }

    }

}
