package com.pluralsight;

public class Meat extends Topping {
    public Meat(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(String sandwichSize) {
        switch (sandwichSize) {
            case "4": return 1.00;
            case "8": return 2.00;
            case "12": return 3.00;
            default: return 0.00;
        }
    }
}
