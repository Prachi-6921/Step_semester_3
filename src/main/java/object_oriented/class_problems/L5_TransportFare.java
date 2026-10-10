package object_oriented.class_problems;

import java.util.*;

interface Transport {
    double calculateFare(double distance, double factor);
}

class Bus implements Transport {
    public double calculateFare(double distance, double factor) {
        return Math.min(2 + 0.10 * distance, 10);
    }
}

class Train implements Transport {
    public double calculateFare(double distance, double factor) {
        return 3 + 0.15 * distance;
    }
}

class Metro implements Transport {
    public double calculateFare(double distance, double factor) {
        return (1.50 + 0.20 * distance) * factor;
    }
}

public class L5_TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            double factor = 1.0;

            if (type.equals("METRO")) {
                factor = sc.nextDouble();
            }

            Transport t;

            switch (type) {
                case "BUS":
                    t = new Bus();
                    break;
                case "TRAIN":
                    t = new Train();
                    break;
                default:
                    t = new Metro();
            }

            double fare = t.calculateFare(distance, factor);
            total += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}