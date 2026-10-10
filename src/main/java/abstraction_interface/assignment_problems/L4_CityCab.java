package abstraction_interface.assignment_problems;

import java.util.Scanner;

abstract class Cab {
    double distance;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double getRate();

    boolean hasNightService() {
        return true;
    }

    double calculateFare(String time) {
        double fare = Math.max(distance * getRate(), 100);

        if (time.equals("NIGHT")) {
            fare *= 1.2;
        }

        return fare;
    }
}

class Mini extends Cab {
    Mini(double distance) {
        super(distance);
    }

    double getRate() {
        return 10;
    }

    boolean hasNightService() {
        return false;
    }
}

class Sedan extends Cab {
    Sedan(double distance) {
        super(distance);
    }

    double getRate() {
        return 14;
    }
}

class SUV extends Cab {
    SUV(double distance) {
        super(distance);
    }

    double getRate() {
        return 18;
    }
}

public class L4_CityCab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            String time = sc.next();

            Cab c;

            if (type.equals("MINI")) {
                c = new Mini(distance);
            } else if (type.equals("SEDAN")) {
                c = new Sedan(distance);
            } else {
                c = new SUV(distance);
            }

            if (time.equals("NIGHT") && !c.hasNightService()) {
                System.out.println("MINI: night service not available");
            } else {
                double fare = c.calculateFare(time);
                total += fare;

                System.out.printf("%s: %.2f%n", type, fare);
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
