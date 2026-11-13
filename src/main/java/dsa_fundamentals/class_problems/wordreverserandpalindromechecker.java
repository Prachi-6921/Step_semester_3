package dsa_fundamentals.class_problems;

import java.util.Scanner;

class wordreverserandpalindromechecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        StringBuilder sb = new StringBuilder(word);
        String reverse = sb.reverse().toString();

        System.out.println("Reverse: " + reverse);

        if (word.equalsIgnoreCase(reverse)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}