package OOPSWithJava.Constructors;

class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
}

class EBook extends Book {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }
    public void showDetails() {
        System.out.println("ISBN (public): " + ISBN);
        System.out.println("Title (protected): " + title);
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        Book b = new Book("12345", "Java Basics", "John Doe");
        b.setAuthor("Jane Smith");
        System.out.println("Author: " + b.getAuthor());
        EBook eb = new EBook("54321", "Advanced Java", "Alice");
        eb.showDetails();
    }
}
