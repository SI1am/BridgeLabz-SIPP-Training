package Encapsulation_Abstraction_Polymorphism.LibraryManagementSystem;

public class Magazine extends LibraryItem implements Reservable {
    private boolean isReserved;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days for magazines
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
