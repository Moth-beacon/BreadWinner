package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String sandwichSize;
    private String breadType;
    private boolean isToasted;
    private List<Topping> toppings = new ArrayList<>();

    public Sandwich(String sandwichSize, String breadType, boolean isToasted) {
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.isToasted = isToasted;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getTotalToppingPrice() {
        double total = 0.0;
        for (Topping topping : toppings) {
            total += topping.getPrice(sandwichSize);
        }
        return total;
    }

    public double getBasePrice() {
        switch (sandwichSize) {
            case "4": return 5.00;
            case "8": return 7.00;
            case "12": return 9.00;
            default: return 0.0;
        }
    }

    public double getTotalPrice() {
        return getBasePrice() + getTotalToppingPrice();
    }

    public String getDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(sandwichSize).append("\" ").append(breadType);
        if (isToasted) sb.append(" (toasted)");
        sb.append(" with toppings:\n");
        for (Topping topping : toppings) {
            sb.append("- ").append(topping.getToppingName())
                    .append(" ($").append(topping.getPrice(sandwichSize)).append(")\n");
        }
        return sb.toString();
    }
}
