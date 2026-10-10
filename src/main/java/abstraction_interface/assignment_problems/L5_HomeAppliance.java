package abstraction_interface.assignment_problems;

import java.util.Scanner;

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    boolean supportsSaver() {
        return false;
    }

    double getUnits(boolean saver) {
        double units = getPower() * hours / 1000;

        if (saver && supportsSaver()) {
            units *= 0.75;
        }

        return units;
    }

    double getCost(double units) {
        return units * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AirConditioner extends Appliance {
    AirConditioner(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    boolean supportsSaver() {
        return true;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    boolean supportsSaver() {
        return true;
    }
}

public class L5_HomeAppliance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            double hours = Double.parseDouble(input[1]);
            boolean saver = input.length > 2
                    && input[2].equals("SAVER");

            Appliance a;

            if (type.equals("FRIDGE")) {
                a = new Fridge(hours);
            } else if (type.equals("AC")) {
                a = new AirConditioner(hours);
            } else if (type.equals("TV")) {
                a = new Television(hours);
            } else {
                a = new Washer(hours);
            }

            if (saver && !a.supportsSaver()) {
                System.out.println(
                        type + ": saver mode not supported."
                );
            } else {
                double units = a.getUnits(saver);
                double cost = a.getCost(units);
                total += cost;

                System.out.printf(
                        "%s: Units=%.2f Cost=%.2f%n",
                        type, units, cost
                );
            }
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}