package encapsulation.class_problems;

class Locker {
    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public void changeCode(String oldCode, String newCode) {
        if (code.equals(oldCode))
            code = newCode;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class L4_Locker {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}
