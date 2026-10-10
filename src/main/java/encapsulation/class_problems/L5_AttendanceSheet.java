package encapsulation.class_problems;

class AttendanceSheet {
    private final String[] students;
    private int count;

    public AttendanceSheet(int maxStudents) {
        students = new String[maxStudents];
        count = 0;
    }

    public void markPresent(String name) {
        if (count >= students.length || isPresent(name))
            return;

        students[count] = name;
        count++;
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name))
                return true;
        }
        return false;
    }
}

public class L5_AttendanceSheet {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}
