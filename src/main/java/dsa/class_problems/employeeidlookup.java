package dsa.class_problems;

import java.util.Scanner;
import java.util.HashMap;

class employeeidlookup {

    static HashMap<String, String> buildLookup(
            String[][] records) {

        HashMap<String, String> lookup = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            lookup.put(records[i][0], records[i][1]);
        }

        return lookup;
    }

    static String getDepartment(
            HashMap<String, String> lookup, String employeeId) {

        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[][] records = new String[n][2];

        for (int i = 0; i < n; i++) {
            records[i][0] = sc.next();
            records[i][1] = sc.next();
        }

        HashMap<String, String> lookup = buildLookup(records);

        String id1 = sc.next();
        String id2 = sc.next();

        System.out.println(getDepartment(lookup, id1));
        System.out.println(getDepartment(lookup, id2));
    }
}
