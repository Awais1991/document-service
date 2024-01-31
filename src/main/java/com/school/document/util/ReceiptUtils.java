package com.school.document.util;

import java.util.Random;

public class ReceiptUtils {

    public static String generateReceiptId(int length){
        Random random = new Random();
        StringBuilder randomNumberBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Generates a random digit (0-9)
            randomNumberBuilder.append(digit);
        }
        return randomNumberBuilder.toString();
    }

    public static boolean isValidCardNumber(String cardNumber) {
        // Remove spaces, hyphens, and non-numeric characters
        String cleanedCardNumber = cardNumber.replaceAll("[\\s-]+", "");
        // Check if the cleaned card number is numeric and has a valid length
        if (!cleanedCardNumber.matches("\\d{13,19}")) {
            return false;
        }
        // You can add additional checks based on the card's format or issuer prefix using regular expressions here
        return true;
    }
}
