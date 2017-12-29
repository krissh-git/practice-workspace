package com.krishna.design.patterns.behavioral.template_1;

public class WoodenHouse extends HouseTemplate {
    protected void buildWindows() {
        System.out.println("Building Wooden windows");
    }

    protected void buildWalls() {
        System.out.println("Building Wooden walls");
    }

    protected void buildPillars() {
        System.out.println("Building Wooden pillars");
    }


}
