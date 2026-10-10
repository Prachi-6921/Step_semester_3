package object_oriented.class_problems;

import java.util.*;

interface Payment {
    double calculate(double amount);
}

class Card implements Payment {
    public double calculate(double amount) {
        return amount * 1.02;
    }
}

class Wallet implements Payment {
    public double calculate(double amount) {
        return amount * 1.01;
    }
}

class BankTransfer implements Payment {
    public double calculate(double amount) {
        return amount;
    }
}

public class L1_PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment p;

            switch (type) {
                case "CARD":
                    p = new Card();
                    break;
                case "WALLET":
                    p = new Wallet();
                    break;
                default:
                    p = new BankTransfer();
            }

            double result = p.calculate(amount);
            total += result;
            System.out.printf("%s: %.2f%n", type, result);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
