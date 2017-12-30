package com.krishna.design.patterns.behavioral.cor_1;

public class Cor1Client {

    public static void main(String[] args) {


        Dispenser dispenser_10 = new Rupees10Dispenser(null);
        Dispenser dispenser_20 = new Rupees20Dispenser(dispenser_10);
        Dispenser dispenser_50 = new Rupees50Dispenser(dispenser_20);

        dispenser_50.dispense(new Currency(15));

    }
}
