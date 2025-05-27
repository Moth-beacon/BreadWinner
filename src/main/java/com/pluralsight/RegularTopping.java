package com.pluralsight;

public class RegularTopping extends Topping {
    public RegularTopping(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(String sandwichSize) {
        return 0.00;
    }
}
