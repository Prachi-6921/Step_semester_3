package object_oriented.assignment_problems;

import java.util.Scanner;

interface Customer {
    double calculateBill(double amount);
}

class Student implements Customer {
    public double calculateBill(double amount) {
        return amount * 0.90;
    }
}

class Staff implements Customer {
    public double calculateBill(double amount) {
        return amount * 0.95;
    }
}

class Guest implements Customer {
    public double calculateBill(double amount) {
        return amount + 10;
    }
}

public class L1_CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer c;

            switch (type) {
                case "STUDENT":
                    c = new Student();
                    break;
                case "STAFF":
                    c = new Staff();
                    break;
                default:
                    c = new Guest();
            }

            double bill = c.calculateBill(amount);
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
