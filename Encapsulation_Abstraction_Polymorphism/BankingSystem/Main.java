package Encapsulation_Abstraction_Polymorphism.BankingSystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        System.out.print("Enter number of accounts to create: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Account #" + i + " ---");
            System.out.print("Enter Account Type (savings/current): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Account Number: ");
            String accNum = sc.nextLine();

            System.out.print("Account Holder Name: ");
            String holder = sc.nextLine();

            System.out.print("Initial Balance: ");
            double balance = Double.parseDouble(sc.nextLine());

            if (type.equals("savings")) {
                System.out.print("Enter Interest Rate (%): ");
                double rate = Double.parseDouble(sc.nextLine());
                accounts.add(new SavingsAccount(accNum, holder, balance, rate));
            } else if (type.equals("current")) {
                System.out.print("Enter Overdraft Limit: ");
                double limit = Double.parseDouble(sc.nextLine());
                accounts.add(new CurrentAccount(accNum, holder, balance, limit));
            } else {
                System.out.println("Invalid account type. Try again.");
                i--; // repeat this iteration
            }
        }

        // Display account summary
        System.out.println("\n========= Account Summary =========");
        for (BankAccount acc : accounts) {
            System.out.println("Account: " + acc.getAccountNumber());
            System.out.println("Holder: " + acc.getHolderName());
            System.out.println("Balance: ₹" + acc.getBalance());
            System.out.println("Interest: ₹" + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable loanable = (Loanable) acc;
                System.out.println("Eligible Loan: ₹" + loanable.calculateLoanEligibility());

                System.out.print("Do you want to apply for a loan (yes/no)? ");
                String choice = sc.nextLine().trim().toLowerCase();
                if (choice.equals("yes")) {
                    System.out.print("Enter loan amount to apply: ₹");
                    double loanAmount = Double.parseDouble(sc.nextLine());
                    boolean approved = loanable.applyForLoan(loanAmount);
                    System.out.println("Loan Application (₹" + loanAmount + "): " + (approved ? "Approved" : "Rejected"));
                }
            }

            System.out.println("-------------");
        }

        sc.close();
    }
}
