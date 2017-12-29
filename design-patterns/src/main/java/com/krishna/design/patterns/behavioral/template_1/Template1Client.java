package com.krishna.design.patterns.behavioral.template_1;

public class Template1Client {
    public static void main(String[] args) {
        HouseTemplate houseTemplate = new GlassHouse();
        houseTemplate.buildHouse();

        System.out.println("=================");
        houseTemplate = new WoodenHouse();
        houseTemplate.buildHouse();
    }
}
