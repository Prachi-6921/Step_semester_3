package abstraction_interface.assignment_problems;

import java.util.Scanner;

abstract class Ticket {
    int count;
    static final double FEE = 20.0;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double amount() {
        return (getPrice() + FEE) * count;
    }
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    double getPrice() {
        return 150.0;
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    double getPrice() {
        return 250.0;
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    double getPrice() {
        return 400.0;
    }
}

public class L1_MovieTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Ticket t;

            if (type.equals("REGULAR")) {
                t = new Regular(count);
            } else if (type.equals("PREMIUM")) {
                t = new Premium(count);
            } else {
                t = new Recliner(count);
            }

            double amount = t.amount();
            total += amount;

            System.out.printf("%s: %.2f%n", type, amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
