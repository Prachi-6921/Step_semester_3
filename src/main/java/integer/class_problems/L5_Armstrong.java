package integer.class_problems;

import java.util.Scanner;

class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int origNumber = number;
        int sum = 0;
        int digits = 0;
        int temp = number;

        while (temp != 0) {
            digits++;
            temp = temp / 10;
        }

        number = origNumber;

        while (number != 0) {
            int digit = number % 10;
            sum = sum + (int)Math.pow(digit, digits);
            number = number / 10;
        }

        if (sum == origNumber)
            System.out.println("Is the number " + origNumber + " an Armstrong number? Yes");
        else
            System.out.println("Is the number " + origNumber + " an Armstrong number? No");
    }
}
