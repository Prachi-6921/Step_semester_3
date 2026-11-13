package dsa_fundamentals.class_problems;

import java.util.Scanner;

class vowelandconsonantcounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        int vowels = 0, consonants = 0;

        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u') {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
