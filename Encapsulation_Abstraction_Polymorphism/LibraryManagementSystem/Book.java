package Encapsulation_Abstraction_Polymorphism.LibraryManagementSystem;

public class Book extends LibraryItem implements Reservable {
    private boolean isReserved;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 21; // 21 days for books
    }

    @Override
    public boolean reserveItem(String borrower) {
        if (!isReserved) {
            setBorrower(borrower);
            isReserved = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}
