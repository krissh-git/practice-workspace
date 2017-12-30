package com.krishna.design.patterns.behavioral.cor_1;

public class Rupees20Dispenser extends Dispenser {

    Rupees20Dispenser(Dispenser dispenser) {
        super(dispenser);
    }

    protected int getAmount() {
        return 20;
    }
}
