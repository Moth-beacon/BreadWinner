package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    // Saves the order to a receipt file using the customer's name
    public static void saveReceipt(Order order, String customerName) {
        String sanitizedName = customerName.trim().replaceAll("\\s+", "_");
        String fileName = "receipt_" + sanitizedName + "_" + getTimeStamp() + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("BreadWinner Receipt \n");
            writer.write("Customer: " + customerName + "\n\n");
            writer.write(order.getReceiptText());
            writer.write("\nThank you for ordering from BreadWinner!\n");
            System.out.println("Receipt saved as " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }

    // Generates a timestamp for file naming
    private static String getTimeStamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return LocalDateTime.now().format(formatter);
    }
}
