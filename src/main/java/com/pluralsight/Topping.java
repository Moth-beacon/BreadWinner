package com.pluralsight;

public abstract class Topping {
    protected String toppingName;

    public Topping(String toppingName) {
        this.toppingName = toppingName;
    }

    public String getToppingName() {
        return toppingName;
    }

    public abstract double getPrice(String sandwichSize);
}
