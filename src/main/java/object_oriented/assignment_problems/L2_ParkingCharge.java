package object_oriented.assignment_problems;

import java.util.Scanner;

interface Vehicle {
    double calculateCharge(int hours);
}

class Bike implements Vehicle {
    public double calculateCharge(int hours) {
        return hours * 10.0;
    }
}

class Car implements Vehicle {
    public double calculateCharge(int hours) {
        return 30 + (hours - 1) * 20.0;
    }
}

class Truck implements Vehicle {
    public double calculateCharge(int hours) {
        return Math.max(100, hours * 50.0);
    }
}

public class L2_ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle v;

            switch (type) {
                case "BIKE":
                    v = new Bike();
                    break;
                case "CAR":
                    v = new Car();
                    break;
                default:
                    v = new Truck();
            }

            double charge = v.calculateCharge(hours);
            total += charge;

            System.out.printf("%s: %.2f%n", type, charge);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
