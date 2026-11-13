package dsa.class_problems;

import java.util.Scanner;
import java.util.HashSet;

class transactionduplicatecheck {

    static boolean hasDuplicate(String[] transactions) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < transactions.length; i++) {

            if (set.contains(transactions[i])) {
                return true;
            }

            set.add(transactions[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] transactions = new String[n];

        for (int i = 0; i < n; i++) {
            transactions[i] = sc.next();
        }

        System.out.println(hasDuplicate(transactions));
    }
}
