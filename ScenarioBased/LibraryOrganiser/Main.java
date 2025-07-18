package ScenarioBased.LibraryOrganiser;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();
        Scanner sc = new Scanner(System.in);

        // Preloaded Books (for testing and demonstration)
        preloadBooks(shelf);

        System.out.println("Welcome to the BridgeLab Library System!");
        System.out.println("---------------------------------------------------");
        System.out.println("Select your role:");
        System.out.println("1. Librarian");
        System.out.println("2. Issuer");
        System.out.print("Enter your choice (1 or 2): ");

        int role = sc.nextInt();
        sc.nextLine();

        System.out.println("---------------------------------------------------");

        if (role == 1) {
            // Librarian Mode
            System.out.println("🔐 Librarian Mode Activated");

            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Add a new book");
                System.out.println("2. Search the catalog");
                System.out.println("3. Display full catalog");
                System.out.println("4. Exit Librarian Mode");
                System.out.print("Your choice: ");
                String choice = sc.nextLine().trim();

                switch (choice) {
                    case "1":
                        System.out.print("Enter Genre: ");
                        String genre = sc.nextLine();
                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        Book book = new Book(genre, title, author);
                        shelf.addBook(book);
                        break;

                    case "2":
                        System.out.print("Enter title/author/genre to search: ");
                        String query = sc.nextLine().trim();
                        shelf.search(query);
                        break;

                    case "3":
                        shelf.displayCatalog();
                        break;

                    case "4":
                        System.out.println("👋 Exiting Librarian Mode...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

        } else if (role == 2) {
            //Issuer Mode
            System.out.println(" Issuer Mode Activated");

            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Search for books");
                System.out.println("2. Issue a book");
                System.out.println("3. Exit");
                System.out.print("Your choice: ");
                String choice = sc.nextLine().trim();

                if (choice.equals("1")) {
                    System.out.print("Enter title/author/genre to search: ");
                    String query = sc.nextLine().trim();
                    shelf.search(query);

                } else if (choice.equals("2")) {
                    System.out.print("Enter the book title to issue: ");
                    String title = sc.nextLine().trim();

                    boolean issued = tryIssueBook(shelf, title);
                    if (!issued) {
                        System.out.print("This book doesn't exist. Do you want to add it to the library? (yes/no): ");
                        String response = sc.nextLine().trim().toLowerCase();
                        if (response.equals("yes")) {
                            System.out.print("Enter genre: ");
                            String genre = sc.nextLine();
                            System.out.print("Enter author: ");
                            String author = sc.nextLine();

                            Book newBook = new Book(genre, title, author);
                            shelf.addBook(newBook);
                        }
                    }

                } else if (choice.equals("3")) {
                    System.out.println("Exiting Issuer Mode...");
                    break;

                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            }

        } else {
            System.out.println("Invalid role selected. Please restart the program.");
        }

        sc.close();
        System.out.println("\nThank you for using the Library System!");
    }

    // Helper to try issuing a book
    private static boolean tryIssueBook(BookShelf shelf, String title) {
        for (LinkedList<Book> books : shelf.getCatalog().values()) {
            for (Book book : books) {
                if (book.title.equalsIgnoreCase(title)) {
                    if (book.getCopies() > 0) {
                        book.decreaseCopy();
                        System.out.println("Book issued: " + book.title + " (Remaining copies: " + book.getCopies() + ")");
                    } else {
                        System.out.println("No copies available for: " + book.title);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    // Preload books at startup
    private static void preloadBooks(BookShelf shelf) {
        shelf.addBook(new Book("Fiction", "The Alchemist", "Paulo Coelho"));
        shelf.addBook(new Book("Science", "A Brief History of Time", "Stephen Hawking"));
        shelf.addBook(new Book("Fantasy", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling"));
        shelf.addBook(new Book("Fantasy", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling"));
        shelf.addBook(new Book("Fantasy", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling"));
        shelf.addBook(new Book("Fantasy", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling"));
        shelf.addBook(new Book("Mythology", "Sita: Warrior of Mithila", "Amish Tripathi"));
        shelf.addBook(new Book("Mythology", "Sita: Warrior of Mithila", "Amish Tripathi"));
        shelf.addBook(new Book("Mythology", "Sita: Warrior of Mithila", "Amish Tripathi"));
        shelf.addBook(new Book("Mythology", "Sita: Warrior of Mithila", "Amish Tripathi"));
        shelf.addBook(new Book("Technology", "Clean Code", "Robert C. Martin"));
        shelf.addBook(new Book("Science", "The Selfish Gene", "Richard Dawkins"));
        shelf.addBook(new Book("Fiction", "To Kill a Mockingbird", "Harper Lee"));
        shelf.addBook(new Book("Fiction", "To Kill a Mockingbird", "Harper Lee"));
        shelf.addBook(new Book("Fiction", "To Kill a Mockingbird", "Harper Lee"));
        shelf.addBook(new Book("Biography", "Wings of Fire", "A.P.J. Abdul Kalam"));
        shelf.addBook(new Book("Fantasy", "The Hobbit", "J.R.R. Tolkien"));
        shelf.addBook(new Book("Fantasy", "The Hobbit", "J.R.R. Tolkien"));
        shelf.addBook(new Book("Fantasy", "The Hobbit", "J.R.R. Tolkien"));
        shelf.addBook(new Book("Philosophy", "The Republic", "Plato"));
    }
}
