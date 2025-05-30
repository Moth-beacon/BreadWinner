package com.pluralsight;

public class Cheese extends Topping {
    private boolean isExtra;

    public Cheese(String toppingName) {
        this(toppingName, false);
    }

    public Cheese(String toppingName, boolean isExtra) {
        super(toppingName.toLowerCase());
        this.isExtra = isExtra;
    }

    @Override
    public double getPrice(String sandwichSize) {
        switch (sandwichSize) {
            case "4":
                return isExtra ? 0.30 : 0.75;
            case "8":
                return isExtra ? 0.60 : 1.50;
            case "12":
                return isExtra ? 0.90 : 2.25;
            default:
                return 0.00;
        }
    }

    @Override
    public String getToppingName() {
        return (isExtra ? "Extra " : "") + capitalizeFirstLetter(toppingName);
    }

    private String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
