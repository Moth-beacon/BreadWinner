package com.pluralsight;

public class Order {
    private Sandwich sandwich;
    private Drink drink;
    private Chips chips;

    public Order(Sandwich sandwich, Drink drink, Chips chips) {
        this.sandwich = sandwich;
        this.drink = drink;
        this.chips = chips;
    }

    public double getTotalPrice() {
        return sandwich.getTotalPrice() + drink.getPrice() + chips.getPrice();
    }

    public void printReceipt() {
        System.out.println("🧾 Receipt:");
        System.out.println(sandwich.getDetails());
        System.out.printf("Drink: %s ($%.2f)%n", drinkFlavorSafe(), drink.getPrice());
        System.out.printf("Chips: %s ($%.2f)%n", chipTypeSafe(), chips.getPrice());
        System.out.printf("TOTAL: $%.2f%n", getTotalPrice());
    }

    private String drinkFlavorSafe() {
        return (drink != null) ? drink.getPrice() > 0 ? "Drink included" : "None" : "None";
    }

    private String chipTypeSafe() {
        return (chips != null) ? chips.getPrice() > 0 ? "Chips included" : "None" : "None";
    }
    public String getReceiptText() {
        StringBuilder sb = new StringBuilder();
        sb.append(sandwich.getDetails());
        sb.append(String.format("Drink: $%.2f%n", drink.getPrice()));
        sb.append(String.format("Chips: $%.2f%n", chips.getPrice()));
        sb.append(String.format("TOTAL: $%.2f%n", getTotalPrice()));
        return sb.toString();
    }

}

