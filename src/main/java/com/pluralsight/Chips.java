package com.pluralsight;

public class Chips {
    private String chipType;

    public Chips(String chipType) {
        this.chipType = chipType;
    }

    public double getPrice() {
        return 1.50;
    }
    public String getType() {
        return chipType;
    }

}
