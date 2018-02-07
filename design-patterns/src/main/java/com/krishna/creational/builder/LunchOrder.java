package com.krishna.creational.builder;

public class LunchOrder {

    private String bread;
    private String meat;
    private String dressing;


    private LunchOrder(String bread, String meat, String dressing) {
        this.bread = bread;
        this.meat = meat;
        this.dressing = dressing;
    }

    public String getBread() {
        return bread;
    }

    public String getMeat() {
        return meat;
    }

    public String getDressing() {
        return dressing;
    }

    private void setBread(String bread) {
        this.bread = bread;
    }

    private void setMeat(String meat) {
        this.meat = meat;
    }

    private void setDressing(String dressing) {
        this.dressing = dressing;
    }

    @Override
    public String toString() {
        return "LunchOrder{" +
                "bread='" + bread + '\'' +
                ", meat='" + meat + '\'' +
                ", dressing='" + dressing + '\'' +
                '}';
    }

    public static class Builder {
        private String bread;
        private String meat;
        private String dressing;

        public Builder bread(String bread){
            this.bread = bread;
            return this;
        }


        public Builder meat(String meat){
            this.meat = meat;
            return this;
        }

        public Builder dressing(String dressing){
            this.dressing = dressing;
            return this;
        }

        public LunchOrder build(){
            return new LunchOrder(this.bread,this.meat,this.dressing);
        }
    }
}
