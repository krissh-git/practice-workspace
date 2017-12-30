package com.krishna.design.patterns.behavioral.cor_1;

public class Rupees10Dispenser extends Dispenser {

    Rupees10Dispenser(Dispenser dispenser) {
        super(dispenser);
    }

    protected int getAmount() {
        return 10;
    }
}
