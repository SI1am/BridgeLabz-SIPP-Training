package Encapsulation_Abstraction_Polymorphism.LibraryManagementSystem;

public interface Reservable {
    boolean reserveItem(String borrower);
    boolean checkAvailability();
}
