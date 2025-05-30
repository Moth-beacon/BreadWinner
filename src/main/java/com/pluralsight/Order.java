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
        System.out.println("\n========== Bread Winner Receipt ==========");
        System.out.println(sandwich.getFormattedDetails());
        System.out.printf("Drink: %-20s $%.2f%n", drink.getFlavor(), drink.getPrice());
        System.out.printf("Chips: %-20s $%.2f%n", chips.getType(), chips.getPrice());
        System.out.println("------------------------------------------");
        System.out.printf("TOTAL: %-25s $%.2f%n", "", getTotalPrice());
        System.out.println("==========================================");
        System.out.println("Thank you for choosing Bread Winner! We hope to see you again.\n");
    }

    public String getReceiptText() {
        StringBuilder sb = new StringBuilder();
        sb.append("========== Bread Winner Receipt ==========\n");
        sb.append(sandwich.getFormattedDetails());
        sb.append(String.format("Drink: %-20s $%.2f%n", drink.getFlavor(), drink.getPrice()));
        sb.append(String.format("Chips: %-20s $%.2f%n", chips.getType(), chips.getPrice()));
        sb.append("------------------------------------------\n");
        sb.append(String.format("TOTAL: %-25s $%.2f%n", "", getTotalPrice()));
        sb.append("==========================================\n");
        sb.append("Thank you for choosing Bread Winner! We hope to see you again.\n");
        return sb.toString();
    }
}
