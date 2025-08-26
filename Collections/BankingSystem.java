package Collections;
import java.util.*;

class Account {
    String accountNumber;
    double balance;
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    @Override
    public String toString() {
        return accountNumber + ": $" + balance;
    }
}

public class BankingSystem {
    private HashMap<String, Double> accountMap = new HashMap<>();
    private TreeMap<Double, List<String>> balanceMap = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(String acc, double bal) {
        accountMap.put(acc, bal);
        balanceMap.computeIfAbsent(bal, k -> new ArrayList<>()).add(acc);
    }

    public void requestWithdrawal(String acc) {
        withdrawalQueue.add(acc);
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String acc = withdrawalQueue.poll();
            double bal = accountMap.getOrDefault(acc, 0.0);
            if (bal >= amount) {
                accountMap.put(acc, bal - amount);
                // Update balanceMap
                balanceMap.get(bal).remove(acc);
                if (balanceMap.get(bal).isEmpty()) balanceMap.remove(bal);
                balanceMap.computeIfAbsent(bal - amount, k -> new ArrayList<>()).add(acc);
                System.out.println("Withdrawal of $" + amount + " from " + acc + " successful.");
            } else {
                System.out.println("Insufficient funds for " + acc);
            }
        }
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, List<String>> entry : balanceMap.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println(acc + ": $" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount("A001", 500.0);
        bank.addAccount("A002", 1200.0);
        bank.addAccount("A003", 800.0);
        bank.requestWithdrawal("A002");
        bank.requestWithdrawal("A001");
        bank.processWithdrawals(300.0);
        bank.displayAccountsSortedByBalance();
    }
}
