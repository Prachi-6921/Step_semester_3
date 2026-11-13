package dsa_fundamentals.assignment_problems;

import java.util.Scanner;

class busiestbusrow {

    static void busiestRow(int[][] grid) {
        int maxTotal = -1;
        int bestRow = 0;

        for (int i = 0; i < grid.length; i++) {
            int sum = 0;

            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }

            if (sum > maxTotal) {
                maxTotal = sum;
                bestRow = i;
            }
        }

        System.out.println("Row " + (bestRow + 1) +
                ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] grid = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        busiestRow(grid);
    }
}