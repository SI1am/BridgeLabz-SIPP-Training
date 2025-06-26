package OOPSConceptAssignment;

import java.util.Scanner;

public class BankAccount {
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;

    private final int accountNumber;
    private String accountHolderName;

    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName; // this to resolve ambiguity
        this.accountNumber = accountNumber; // final variable
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        } else {
            System.out.println("Object is not an instance of BankAccount");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name for account 1: ");
        String name1 = sc.nextLine();
        System.out.print("Enter account number for account 1: ");
        int number1 = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter account holder name for account 2: ");
        String name2 = sc.nextLine();
        System.out.print("Enter account number for account 2: ");
        int number2 = sc.nextInt();

        BankAccount acc1 = new BankAccount(name1, number1);
        BankAccount acc2 = new BankAccount(name2, number2);

        acc1.displayDetails();
        System.out.println();
        acc2.displayDetails();
        System.out.println();
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());

        sc.close();
    }
}
