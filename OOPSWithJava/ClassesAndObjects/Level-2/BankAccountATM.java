import java.util.Scanner;

public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
        else System.out.println("Insufficient balance or invalid amount.");
    }

    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String holder = sc.nextLine();
        System.out.print("Enter account number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        BankAccount acc = new BankAccount(holder, accNum, balance);
        while (true) {
            System.out.println("1. Deposit\n2. Withdraw\n3. Display Balance\n4. Exit");
            System.out.print("Choose option: ");
            int opt = sc.nextInt();
            if (opt == 1) {
                System.out.print("Enter amount to deposit: ");
                acc.deposit(sc.nextDouble());
            } else if (opt == 2) {
                System.out.print("Enter amount to withdraw: ");
                acc.withdraw(sc.nextDouble());
            } else if (opt == 3) {
                acc.displayBalance();
            } else break;
        }
    }
}
