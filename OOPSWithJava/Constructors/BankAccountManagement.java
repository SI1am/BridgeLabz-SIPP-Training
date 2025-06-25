package OOPSWithJava.Constructors;

class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }
    public void showAccountInfo() {
        System.out.println("Account Number (public): " + accountNumber);
        System.out.println("Account Holder (protected): " + accountHolder);
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("123456", "Bob", 1000);
        acc.setBalance(1500);
        System.out.println("Balance: " + acc.getBalance());
        SavingsAccount sa = new SavingsAccount("654321", "Alice", 2000);
        sa.showAccountInfo();
    }
}
