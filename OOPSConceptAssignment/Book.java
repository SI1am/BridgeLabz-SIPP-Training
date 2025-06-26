package OOPSConceptAssignment;

import java.util.Scanner;

public class Book {
    private static String libraryName = "City Library";

    private final String isbn;
    private String title;
    private String author;

    public Book(String title, String author, String isbn) {
        this.title = title; // this to initialize
        this.author = author;
        this.isbn = isbn; // final variable
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Library: " + libraryName);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        } else {
            System.out.println("Object is not an instance of Book");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        displayLibraryName();

        System.out.print("Enter title for book 1: ");
        String title1 = sc.nextLine();
        System.out.print("Enter author for book 1: ");
        String author1 = sc.nextLine();
        System.out.print("Enter ISBN for book 1: ");
        String isbn1 = sc.nextLine();

        System.out.print("Enter title for book 2: ");
        String title2 = sc.nextLine();
        System.out.print("Enter author for book 2: ");
        String author2 = sc.nextLine();
        System.out.print("Enter ISBN for book 2: ");
        String isbn2 = sc.nextLine();

        Book book1 = new Book(title1, author1, isbn1);
        Book book2 = new Book(title2, author2, isbn2);

        System.out.println();
        book1.displayDetails();
        System.out.println();
        book2.displayDetails();

        sc.close();
    }
}
