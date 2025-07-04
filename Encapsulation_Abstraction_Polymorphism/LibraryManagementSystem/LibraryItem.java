package Encapsulation_Abstraction_Polymorphism.LibraryManagementSystem;

public abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrower;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrower = null;
    }

    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBorrower() {
        return borrower;
    }

    public abstract int getLoanDuration(); // in days
}
