package object_oriented.class_problems;

import java.util.*;

abstract class Question {
    String correct;
    String student;
    int points;

    Question(String correct, String student, int points) {
        this.correct = correct;
        this.student = student;
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String correct, String student, int points) {
        super(correct, student, points);
    }

    double grade() {
        return student.equals(correct) ? points : 0;
    }
}

class TrueFalse extends Question {
    TrueFalse(String correct, String student, int points) {
        super(correct, student, points);
    }

    double grade() {
        return student.equalsIgnoreCase(correct) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String correct, String student, int points) {
        super(correct, student, points);
    }

    double grade() {
        String[] keywords = correct.split(",");
        int found = 0;

        for (String keyword : keywords) {
            if (student.toLowerCase().contains(
                    keyword.trim().toLowerCase())) {
                found++;
            }
        }

        if (found >= 2)
            return points * 0.75;
        else if (found == 1)
            return points * 0.50;
        else
            return 0;
    }
}

public class L4_QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            int firstQuote = line.indexOf('"');
            String type = line.substring(0, firstQuote).trim();

            List<String> fields = new ArrayList<>();
            int start = firstQuote;

            while (start < line.length()) {
                int end = line.indexOf('"', start + 1);

                if (end == -1)
                    break;

                fields.add(line.substring(start + 1, end));
                start = line.indexOf('"', end + 1);

                if (start == -1)
                    break;
            }

            int points = Integer.parseInt(
                    line.substring(line.lastIndexOf('"') + 1).trim());

            String correct = fields.get(1);
            String student = fields.get(2);

            Question q;

            switch (type) {
                case "MCQ":
                    q = new MCQ(correct, student, points);
                    break;
                case "TF":
                    q = new TrueFalse(correct, student, points);
                    break;
                default:
                    q = new Essay(correct, student, points);
            }

            double score = q.grade();
            total += score;

            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
