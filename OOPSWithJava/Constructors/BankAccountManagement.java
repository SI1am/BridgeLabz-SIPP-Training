package OOPSWithJava.Constructors;

class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(int number, String holder, double balance) {
        this.accountNumber = number;
        this.accountHolder = holder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(int number, String holder, double balance) {
        super(number, holder, balance);
    }

    void printAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
    }
}

class BankTest {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(1001, "Ravi", 10000);
        sa.printAccountDetails();
        sa.deposit(500);
        System.out.println("Updated Balance: " + sa.getBalance());
    }
}