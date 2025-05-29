package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sandwich Setup
        System.out.println("🥪 Welcome to BreadWinner 🥪");
        System.out.print("Choose sandwich size (4, 8, 12): ");
        String size = scanner.nextLine();

        System.out.print("Choose bread (White, Wheat, Rye): ");
        String bread = scanner.nextLine();

        System.out.print("Toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        // Toppings
        System.out.println("Add toppings (type 'done' to finish):");
        while (true) {
            System.out.print("Enter topping (e.g., Turkey, Lettuce, Mayo): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;

            if (input.equalsIgnoreCase("Turkey") || input.equalsIgnoreCase("Ham")) {
                sandwich.addTopping(new Meat(input));
            } else if (input.equalsIgnoreCase("Cheddar") || input.equalsIgnoreCase("Swiss")) {
                sandwich.addTopping(new Cheese(input));
            } else if (input.equalsIgnoreCase("Lettuce") || input.equalsIgnoreCase("Tomato")) {
                sandwich.addTopping(new RegularTopping(input));
            } else {
                sandwich.addTopping(new Sauce(input));
            }
        }

        // Drink
        System.out.print("Drink size (small, medium, large): ");
        String drinkSize = scanner.nextLine();

        System.out.print("Drink flavor (Cola, Lemonade, etc.): ");
        String drinkFlavor = scanner.nextLine();
        Drink drink = new Drink(drinkSize, drinkFlavor);

        // Chips
        System.out.print("Chips type (e.g., BBQ, Salt & Vinegar): ");
        String chipType = scanner.nextLine();
        Chips chips = new Chips(chipType);

        // Final Order
        Order order = new Order(sandwich, drink, chips);
        order.printReceipt();

        scanner.close();
    }
}
