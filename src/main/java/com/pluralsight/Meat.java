package com.pluralsight;

public class Meat extends Topping {
    private boolean isExtra;

    public Meat(String toppingName) {
        this(toppingName, false);
    }

    public Meat(String toppingName, boolean isExtra) {
        super(toppingName.toLowerCase());
        this.isExtra = isExtra;
    }

    @Override
    public double getPrice(String sandwichSize) {
        switch (sandwichSize) {
            case "4":
                return isExtra ? 0.50 : 1.00;
            case "8":
                return isExtra ? 1.00 : 2.00;
            case "12":
                return isExtra ? 1.50 : 3.00;
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
