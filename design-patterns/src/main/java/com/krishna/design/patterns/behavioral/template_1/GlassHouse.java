package com.krishna.design.patterns.behavioral.template_1;

public class GlassHouse extends HouseTemplate {
    protected void buildWindows() {
        System.out.println("Building Glass windows");
    }

    protected void buildWalls() {
        System.out.println("Building Glass walls");
    }

    protected void buildPillars() {
        System.out.println("Building Glass pillars");
    }


}
