package array.class_problems;

import java.util.*;

class Main1 {

    static int maxProfit(int[] prices) {

        int lowest = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < lowest) {
                lowest = prices[i];
            }

            int currentProfit = prices[i] - lowest;

            if (currentProfit > profit) {
                profit = currentProfit;
            }
        }

        return profit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int answer = maxProfit(prices);

        System.out.println("Maximum Profit: " + answer);
    }
}