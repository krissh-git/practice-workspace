package com.krishna.design.patterns.behavioral.cor_1;

public class Rupees50Dispenser extends Dispenser {

    Rupees50Dispenser(Dispenser dispenser) {
        super(dispenser);
    }

    protected int getAmount() {
        return 50;
    }
}
