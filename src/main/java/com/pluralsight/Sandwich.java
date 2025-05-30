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

    public String getFormattedDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sandwich: %s\" %s", sandwichSize, breadType));
        if (isToasted) sb.append(" (toasted)");
        sb.append(String.format(" - Base: $%.2f%n", getBasePrice()));

        List<String> meats = new ArrayList<>();
        List<String> cheeses = new ArrayList<>();
        List<String> regulars = new ArrayList<>();
        List<String> sauces = new ArrayList<>();

        for (Topping topping : toppings) {
            String line = String.format("  - %-22s $%.2f", topping.getToppingName(), topping.getPrice(sandwichSize));
            if (topping instanceof Meat) {
                meats.add(line);
            } else if (topping instanceof Cheese) {
                cheeses.add(line);
            } else if (topping instanceof RegularTopping) {
                regulars.add(line);
            } else if (topping instanceof Sauce) {
                sauces.add(line);
            }
        }

        if (!meats.isEmpty()) {
            sb.append("Meats:\n");
            for (String line : meats) sb.append(line).append("\n");
        }

        if (!cheeses.isEmpty()) {
            sb.append("Cheeses:\n");
            for (String line : cheeses) sb.append(line).append("\n");
        }

        if (!regulars.isEmpty()) {
            sb.append("Toppings:\n");
            for (String line : regulars) sb.append(line).append("\n");
        }

        if (!sauces.isEmpty()) {
            sb.append("Sauces:\n");
            for (String line : sauces) sb.append(line).append("\n");
        }

        sb.append("------------------------------------------\n");
        sb.append(String.format("Sandwich Subtotal:      $%.2f%n", getTotalPrice()));
        return sb.toString();
    }

    public String getDetails() {
        // Fallback method, kept just incase it crashes
        return getFormattedDetails();
    }
}
