package com.sushilarote.labalgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class CurrencyPayment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Step 1: Take input of the size of currency denominations
        System.out.print("Enter the size of currency denominations: ");
        int size = scanner.nextInt();
        
        // Step 2: Take input of currency denominations values
        int[] denominations = new int[size];
        System.out.println("Enter the currency denominations values:");
        for (int i = 0; i < size; i++) {
            denominations[i] = scanner.nextInt();
        }

        // Step 3: Sort the currency denominations in descending order
        Arrays.sort(denominations);
        int i = 0, j = denominations.length - 1;

        while (i < j) {
            int temp = denominations[i];
            denominations[i] = denominations[j];
            denominations[j] = temp;
            i++;
            j--;
        }

        // Step 4: Take input of the amount you want to pay
        System.out.print("Enter the amount you want to pay: ");
        int amountToPay = scanner.nextInt();

        // Step 5: Initialize variables
        int[] notesCount = new int[size];

        // Step 6: Loop through the sorted denominations
        for (int k = 0; k < size; k++) {
            int denomination = denominations[k];
            
            // Calculate the number of notes of this denomination needed
            int notesNeeded = amountToPay / denomination;

            // Update the notes count
            notesCount[k] = notesNeeded;

            // Update the remaining amount
            amountToPay -= (notesNeeded * denomination);
        }

        // Step 7: Print the payment approach
        System.out.println("Your payment approach in order to give the minimum number of notes will be:");
        for (int k = 0; k < size; k++) {
            if (notesCount[k] > 0) {
                System.out.println(denominations[k] + ":" + notesCount[k]);
            }
        }
    }
}

