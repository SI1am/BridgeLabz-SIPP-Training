package Encapsulation_Abstraction_Polymorphism.BankingSystem;

public interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}
