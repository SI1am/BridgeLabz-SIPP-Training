package OOPSWithJava.Constructors;

class Book {
    public String ISBN;
    protected String title;
    private String author;

    Book(String isbn, String title, String author) {
        this.ISBN = isbn;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends Book {
    EBook(String isbn, String title, String author) {
        super(isbn, title, author);
    }

    void showInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
    }
}

class BookTest {
    public static void main(String[] args) {
        EBook eb = new EBook("123456", "Java Basics", "John Doe");
        eb.showInfo();
        System.out.println("Author: " + eb.getAuthor());
    }
}