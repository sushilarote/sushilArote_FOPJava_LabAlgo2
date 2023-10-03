package com.sushilarote.labalgorithms;

import java.util.Scanner;


public class PayMoneyTransaction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the transaction array: ");
        int n = scanner.nextInt();

        int[] transactions = new int[n];

        System.out.println("Enter the values of the array separated by spaces:");
        for (int i = 0; i < n; i++) {
            transactions[i] = scanner.nextInt();
        }

        System.out.print("Enter the total number of targets that need to be achieved: ");
        int totalTargets = scanner.nextInt();

        for (int targetCount = 1; targetCount <= totalTargets; targetCount++) {
            System.out.print("Enter the value of target " + targetCount + ": ");
            int target = scanner.nextInt();
            int cumulativeSum = 0;
            int transactionsToAchieveTarget = 0;

            for (int i = 0; i < n; i++) {
                cumulativeSum += transactions[i];
                transactionsToAchieveTarget++;

                if (cumulativeSum >= target) {
                    System.out.println("Target " + targetCount + " is achieved after " + transactionsToAchieveTarget + " transactions.");
                    break;
                }
            }

            if (cumulativeSum < target) {
                System.out.println("Target " + targetCount + " is not achievable.");
            }
        }

        scanner.close();
    }
}
