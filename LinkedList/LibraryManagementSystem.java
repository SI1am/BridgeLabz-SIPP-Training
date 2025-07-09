package LinkedList;

import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    String bookId;
    boolean available;

    Book next, prev;

    Book(String title, String author, String genre, String bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head = null;
    private Book tail = null;

    public void addAtBeginning(String title, String author, String genre, String bookId, boolean available) {
        Book newBook = new Book(title, author, genre, bookId, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        System.out.println("Book added at beginning.");
    }

    public void addAtEnd(String title, String author, String genre, String bookId, boolean available) {
        Book newBook = new Book(title, author, genre, bookId, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        System.out.println("Book added at end.");
    }

    public void addAtPosition(String title, String author, String genre, String bookId, boolean available, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(title, author, genre, bookId, available);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, available);
        Book current = head;
        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }
        newBook.next = current.next;
        newBook.prev = current;
        if (current.next != null) {
            current.next.prev = newBook;
        } else {
            tail = newBook;
        }
        current.next = newBook;
        System.out.println("Book added at position " + position);
    }

    public void removeById(String bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book current = head;
        while (current != null && !current.bookId.equals(bookId)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book not found.");
            return;
        }
        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        System.out.println("Book removed.");
    }

    public void searchByTitle(String title) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                displayBook(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No book found with title: " + title);
    }

    public void searchByAuthor(String author) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                displayBook(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No book found by author: " + author);
    }

    public void updateAvailability(String bookId, boolean available) {
        Book current = head;
        while (current != null) {
            if (current.bookId.equals(bookId)) {
                current.available = available;
                System.out.println("Availability status updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book ID not found.");
    }

    public void displayAllForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book current = head;
        while (current != null) {
            displayBook(current);
            current = current.next;
        }
    }

    public void displayAllReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book current = tail;
        while (current != null) {
            displayBook(current);
            current = current.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Total number of books: " + count);
    }

    private void displayBook(Book book) {
        System.out.println("Book Title: " + book.title);
        System.out.println("Author: " + book.author);
        System.out.println("Genre: " + book.genre);
        System.out.println("Book ID: " + book.bookId);
        System.out.println("Available: " + (book.available ? "Yes" : "No"));
        System.out.println("--------------------------");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n=== Library Management Menu ===");
            System.out.println("1. Add Book (Beginning)");
            System.out.println("2. Add Book (End)");
            System.out.println("3. Add Book (At Position)");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Books (Forward)");
            System.out.println("9. Display Books (Reverse)");
            System.out.println("10. Count Books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1, 2, 3 -> {
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Book ID: ");
                    String bookId = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    boolean available = sc.nextBoolean();
                    if (choice == 1) library.addAtBeginning(title, author, genre, bookId, available);
                    else if (choice == 2) library.addAtEnd(title, author, genre, bookId, available);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        library.addAtPosition(title, author, genre, bookId, available, pos);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Book ID: ");
                    String bookId = sc.nextLine();
                    library.removeById(bookId);
                }
                case 5 -> {
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    library.searchByTitle(title);
                }
                case 6 -> {
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    library.searchByAuthor(author);
                }
                case 7 -> {
                    System.out.print("Enter Book ID: ");
                    String bookId = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    boolean available = sc.nextBoolean();
                    library.updateAvailability(bookId, available);
                }
                case 8 -> library.displayAllForward();
                case 9 -> library.displayAllReverse();
                case 10 -> library.countBooks();
                case 0 -> System.out.println("Exiting system.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
