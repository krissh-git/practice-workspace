package com.krishna.design.patterns.behavioral.template_1;

public abstract class HouseTemplate {

    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
    }

    abstract void buildWindows();

    abstract void buildWalls();

    abstract void buildPillars();

    protected void buildFoundation() {
        System.out.println("Building Foundation");
    }


}
