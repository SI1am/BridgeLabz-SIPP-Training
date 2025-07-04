package Encapsulation_Abstraction_Polymorphism.LibraryManagementSystem;

public class DVD extends LibraryItem implements Reservable {
    private boolean isReserved;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days for DVDs
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
