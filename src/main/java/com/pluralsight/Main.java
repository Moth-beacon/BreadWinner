package com.pluralsight;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== BreadWinner Menu ===");
            System.out.println("1. Start a new order");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    startOrder(scanner);
                    break;
                case "2":
                    System.out.println("Thank you for visiting BreadWinner!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter 1 or 2.");
            }
        }

        scanner.close();
    }

    private static void startOrder(Scanner scanner) {
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        System.out.print("Choose sandwich size (4, 8, 12): ");
        String size = scanner.nextLine();

        System.out.print("Choose bread (White, Wheat, Rye, or Wrap): ");
        String bread = scanner.nextLine();

        System.out.print("Toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        List<String> meats = Arrays.asList("turkey", "ham", "steak", "salami", "roast beef", "chicken", "bacon");
        List<String> cheeses = Arrays.asList("cheddar", "swiss", "american", "provolone");
        List<String> regulars = Arrays.asList("lettuce", "tomato", "peppers", "onions", "jalapeños", "cucumbers", "pickles", "guacamole", "mushrooms");
        List<String> sauces = Arrays.asList("mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette");

        System.out.println("\nAvailable Meats: " + String.join(", ", meats));
        System.out.println("Available Cheeses: " + String.join(", ", cheeses));
        System.out.println("Available Toppings: " + String.join(", ", regulars));
        System.out.println("Available Sauces: " + String.join(", ", sauces));

        System.out.println("\nAdd toppings (type one at a time, or 'done' to finish):");
        while (true) {
            System.out.print("Enter topping: ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("done")) break;

            if (meats.contains(input)) {
                System.out.print("Would you like extra " + input + "? (yes/no): ");
                boolean isExtra = scanner.nextLine().equalsIgnoreCase("yes");
                sandwich.addTopping(new Meat(input, false)); // always add regular
                if (isExtra) {
                    sandwich.addTopping(new Meat(input, true)); // add extra if requested
                }
            } else if (cheeses.contains(input)) {
                System.out.print("Would you like extra " + input + "? (yes/no): ");
                boolean isExtra = scanner.nextLine().equalsIgnoreCase("yes");
                sandwich.addTopping(new Cheese(input, false)); // always add regular
                if (isExtra) {
                    sandwich.addTopping(new Cheese(input, true)); // add extra if requested
                }
            } else if (regulars.contains(input)) {
                sandwich.addTopping(new RegularTopping(input));
            } else if (sauces.contains(input)) {
                sandwich.addTopping(new Sauce(input));
            } else {
                System.out.println("Unknown topping. Please choose from the displayed lists.");
            }
        }

        // Drink
        System.out.print("Drink size (small, medium, large): ");
        String drinkSize = scanner.nextLine();

        System.out.print("Drink flavor (Cola, Lemonade): ");
        String drinkFlavor = scanner.nextLine();
        Drink drink = new Drink(drinkSize, drinkFlavor);

        // Chips
        System.out.print("Chips type (BBQ, Salt & Vinegar): ");
        String chipType = scanner.nextLine();
        Chips chips = new Chips(chipType);

        // Finalize order
        Order order = new Order(sandwich, drink, chips);
        order.printReceipt();
        ReceiptManager.saveReceipt(order, customerName);
    }
}
