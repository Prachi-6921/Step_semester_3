package object_oriented.class_problems;

import java.util.*;

interface Delivery {
    double calculateFee(double weight, double distance);
}

class StandardDelivery implements Delivery {
    public double calculateFee(double weight, double distance) {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery implements Delivery {
    public double calculateFee(double weight, double distance) {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery implements Delivery {
    public double calculateFee(double weight, double distance) {
        return 25 + 2.00 * weight + 0.50 * distance;
    }
}

public class L3_DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            Delivery d;

            switch (type) {
                case "STANDARD":
                    d = new StandardDelivery();
                    break;
                case "EXPRESS":
                    d = new ExpressDelivery();
                    break;
                default:
                    d = new InternationalDelivery();
            }

            double fee = d.calculateFee(weight, distance);

            if (type.equals("INTERNATIONAL")) {
                double customsFee = sc.nextDouble();
                fee += customsFee;
            }

            total += fee;
            System.out.printf("%s: %.2f%n", type, fee);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
