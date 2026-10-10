package object_oriented.assignment_problems;

import java.util.Scanner;
import java.time.LocalDate;

interface SubscriptionPlan {
    LocalDate getRenewalDate(LocalDate startDate);
}

class BasicPlan implements SubscriptionPlan {
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
}

class StandardPlan implements SubscriptionPlan {
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
}

class PremiumPlan implements SubscriptionPlan {
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
}

public class L5_StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split("\\s+");

            String type = data[0];
            String name = data[1];
            LocalDate startDate = LocalDate.parse(data[2]);

            SubscriptionPlan plan;

            switch (type) {
                case "BASIC":
                    plan = new BasicPlan();
                    break;
                case "STANDARD":
                    plan = new StandardPlan();
                    break;
                default:
                    plan = new PremiumPlan();
            }

            LocalDate renewalDate = plan.getRenewalDate(startDate);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}