package encapsulation.class_problems;

class PiggyBank {
    private int savings;
    private final String bankId;

    public PiggyBank(String bankId) {
        this.bankId = bankId;
        savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0)
            savings += amount;
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= savings)
            savings -= amount;
    }

    public int getSavings() {
        return savings;
    }

    public String getBankId() {
        return bankId;
    }
}

public class L1_PiggyBank {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println(pb.getSavings());
        pb.withdraw(30);
        System.out.println(pb.getSavings());
        pb.withdraw(500);
        System.out.println(pb.getSavings());
    }
}