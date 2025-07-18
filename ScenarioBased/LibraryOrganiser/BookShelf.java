package ScenarioBased.LibraryOrganiser;

import java.util.*;

public class BookShelf {
    private Map<String, LinkedList<Book>> catalog;
    private Map<String, HashSet<Book>> genreBookSet;

    public BookShelf() {
        catalog = new HashMap<>();
        genreBookSet = new HashMap<>();
    }
    public Map<String, LinkedList<Book>> getCatalog() {
    return catalog;
    }


    public void addBook(Book book) {
        catalog.putIfAbsent(book.genre, new LinkedList<>());
        genreBookSet.putIfAbsent(book.genre, new HashSet<>());

        for (Book b : genreBookSet.get(book.genre)) {
            if (b.equals(book)) {
                b.increaseCopy();
                System.out.println("Existing book found. Increased copies: " + b);
                return;
            }
        }

        catalog.get(book.genre).add(book);
        genreBookSet.get(book.genre).add(book);
        System.out.println("Book added: " + book);
    }

    public void displayCatalog() {
        System.out.println("\n📚 Library Catalog:");
        for (String genre : catalog.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book book : catalog.get(genre)) {
                System.out.println(" - " + book);
            }
        }
    }

    public void search(String query) {
        System.out.println("\n🔍 Search Results for \"" + query + "\":");
        boolean found = false;
        for (LinkedList<Book> books : catalog.values()) {
            for (Book book : books) {
                if (book.title.equalsIgnoreCase(query) ||
                    book.author.equalsIgnoreCase(query) ||
                    book.genre.equalsIgnoreCase(query)) {
                    System.out.println(" - " + book);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No books found matching your search.");
        }
    }

    public void issueBook(String title) {
        for (LinkedList<Book> books : catalog.values()) {
            for (Book book : books) {
                if (book.title.equalsIgnoreCase(title)) {
                    if (book.getCopies() > 0) {
                        book.decreaseCopy();
                        System.out.println("Book issued: " + book.title + " (Remaining copies: " + book.getCopies() + ")");
                    } else {
                        System.out.println("No copies available for: " + book.title);
                    }
                    return;
                }
            }
        }
        System.out.println("Book not found: " + title);
    }
}
