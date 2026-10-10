package object_oriented.assignment_problems;

import java.util.Scanner;

interface Room {
    double calculateBill(int units, int occupants);
}

class SingleRoom implements Room {
    public double calculateBill(int units, int occupants) {
        return units * 8.0;
    }
}

class SharedRoom implements Room {
    public double calculateBill(int units, int occupants) {
        return (units * 6.0) / occupants;
    }
}

class ACRoom implements Room {
    public double calculateBill(int units, int occupants) {
        return units * 10.0 + 200;
    }
}

public class L3_HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            int occupants = 1;

            if (type.equals("SHARED")) {
                occupants = sc.nextInt();
            }

            Room r;

            switch (type) {
                case "SINGLE":
                    r = new SingleRoom();
                    break;
                case "SHARED":
                    r = new SharedRoom();
                    break;
                default:
                    r = new ACRoom();
            }

            double bill = r.calculateBill(units, occupants);
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
