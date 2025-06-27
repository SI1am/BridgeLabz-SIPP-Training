import java.util.ArrayList;
import java.util.Scanner;

// Book class with title and author
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "Book{title='" + title + "', author='" + author + "'}";
    }
}

// Library class containing multiple Book objects (Aggregation)
class Library {
    String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        System.out.println("Books in " + name + ":");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class AggregationLibraryBooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create books independently
        System.out.println("Enter number of books to create:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        ArrayList<Book> allBooks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter title of book " + (i+1) + ":");
            String title = sc.nextLine();
            System.out.println("Enter author of book " + (i+1) + ":");
            String author = sc.nextLine();
            allBooks.add(new Book(title, author));
        }

        // Create libraries
        System.out.println("Enter number of libraries:");
        int libCount = sc.nextInt();
        sc.nextLine();
        ArrayList<Library> libraries = new ArrayList<>();

        for (int i = 0; i < libCount; i++) {
            System.out.println("Enter name of library " + (i+1) + ":");
            String libName = sc.nextLine();
            libraries.add(new Library(libName));
        }

        // Add books to libraries
        for (Library lib : libraries) {
            System.out.println("Adding books to " + lib.name);
            System.out.println("Enter number of books to add to this library:");
            int booksToAdd = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < booksToAdd; j++) {
                System.out.println("Enter index of book to add (1 to " + n + "):");
                int bookIndex = sc.nextInt();
                sc.nextLine();
                if (bookIndex >= 1 && bookIndex <= n) {
                    lib.addBook(allBooks.get(bookIndex - 1));
                } else {
                    System.out.println("Invalid book index.");
                }
            }
        }

        // Show books in each library
        for (Library lib : libraries) {
            lib.showBooks();
        }

        sc.close();
    }
}
