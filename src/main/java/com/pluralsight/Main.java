package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Topping> selectedToppings = new ArrayList<>();

        System.out.println("Welcome to BreadWinner!");
        System.out.print("Enter sandwich size (4, 8, 12): ");
        String sandwichSize = scanner.nextLine();

        // Demo: Adding sample toppings
        selectedToppings.add(new Meat("Turkey"));
        selectedToppings.add(new Cheese("Swiss"));
        selectedToppings.add(new RegularTopping("Lettuce"));
        selectedToppings.add(new Sauce("Mayo"));

        double totalToppingPrice = 0.0;

        System.out.println("\nYour Toppings:");
        for (Topping topping : selectedToppings) {
            double price = topping.getPrice(sandwichSize);
            System.out.printf("- %s: $%.2f%n", topping.getToppingName(), price);
            totalToppingPrice += price;
        }

        System.out.printf("Total Topping Cost: $%.2f%n", totalToppingPrice);
        System.out.println("Thank you for using BreadWinner!");

        scanner.close();
    }
}
