import java.util.ArrayList;
import java.util.Scanner;

// Account class
class Account {
    private String accountNumber;
    private double balance;
    private Bank bank;

    public Account(String accountNumber, Bank bank) {
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " to account " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from account " + accountNumber);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance");
        }
    }

    public Bank getBank() {
        return bank;
    }
}

// Customer class
class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalances() {
        System.out.println("Balances for customer " + name + ":");
        for(Account acc : accounts) {
            System.out.println("Account " + acc.getAccountNumber() + ": " + acc.getBalance());
        }
    }

    public String getName() {
        return name;
    }
}

// Bank class
class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void openAccount(Customer customer, String accountNumber) {
        Account account = new Account(accountNumber, this);
        customer.addAccount(account);
        if(!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account " + accountNumber + " opened for customer " + customer.getName() + " at bank " + name);
    }

    public String getName() {
        return name;
    }
}

public class AssociationBankCustomers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter bank name:");
        String bankName = sc.nextLine();
        Bank bank = new Bank(bankName);

        System.out.println("Enter number of customers:");
        int custCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Customer> customers = new ArrayList<>();

        for(int i=0; i<custCount; i++) {
            System.out.println("Enter name of customer " + (i+1) + ":");
            String custName = sc.nextLine();
            Customer customer = new Customer(custName);
            customers.add(customer);
            bank.addCustomer(customer);

            System.out.println("Enter number of accounts for " + custName + ":");
            int accCount = sc.nextInt();
            sc.nextLine();

            for(int j=0; j<accCount; j++) {
                System.out.println("Enter account number " + (j+1) + ":");
                String accNum = sc.nextLine();
                bank.openAccount(customer, accNum);
            }
        }

        // View balances for each customer
        for(Customer cust : customers) {
            cust.viewBalances();
        }

        sc.close();
    }
}
