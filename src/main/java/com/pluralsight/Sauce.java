package com.pluralsight;

public class Sauce extends Topping {
    public Sauce(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(String sandwichSize) {
        return 0.00;
    }
}
