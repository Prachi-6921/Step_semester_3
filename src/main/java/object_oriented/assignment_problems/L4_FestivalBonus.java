package object_oriented.assignment_problems;

import java.util.Scanner;

interface Employee {
    double calculateBonus(double salary);
}

class FullTime implements Employee {
    public double calculateBonus(double salary) {
        return salary * 0.10;
    }
}

class PartTime implements Employee {
    public double calculateBonus(double salary) {
        return salary * 0.05;
    }
}

class Intern implements Employee {
    public double calculateBonus(double salary) {
        return 2000;
    }
}

public class L4_FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee e;

            switch (type) {
                case "FULLTIME":
                    e = new FullTime();
                    break;
                case "PARTTIME":
                    e = new PartTime();
                    break;
                default:
                    e = new Intern();
            }

            double bonus = e.calculateBonus(salary);
            total += bonus;

            System.out.printf("%s: %.2f%n", name, bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}
