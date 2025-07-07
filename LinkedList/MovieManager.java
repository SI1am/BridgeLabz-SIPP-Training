package LinkedList;
import java.util.Scanner;

// Node class for the Doubly Linked List
class MovieNode {
    String title;
    String director;
    int year;
    double rating;

    MovieNode next;
    MovieNode prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List class
class MovieDoublyLinkedList {
    MovieNode head, tail;

    // Add a movie at the beginning
    void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode; // first movie
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie added at beginning.");
    }

    // Add a movie at the end
    void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie added at end.");
    }

    // Add a movie at specific position
    void addAtPosition(String title, String director, int year, double rating, int pos) {
        if (pos <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        int i = 1;

        while (temp != null && i < pos - 1) {
            temp = temp.next;
            i++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            System.out.println("Movie added at position " + pos);
        }
    }

    // Remove a movie by title
    void removeByTitle(String title) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Movie '" + title + "' removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Search by director or rating
    void search(String keyword) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(keyword) || String.valueOf(temp.rating).equals(keyword)) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                        ", Year: " + temp.year + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found matching keyword: " + keyword);
        }
    }

    // Display movies from head to tail
    void displayForward() {
        MovieNode temp = head;
        if (temp == null) {
            System.out.println("No movies in list.");
            return;
        }
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display movies from tail to head
    void displayReverse() {
        MovieNode temp = tail;
        if (temp == null) {
            System.out.println("No movies in list.");
            return;
        }
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update rating by title
    void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }
}

// Main class for interaction
public class MovieManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();
        int choice;

        do {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director or Rating");
            System.out.println("6. Display Movies (Forward)");
            System.out.println("7. Display Movies (Reverse)");
            System.out.println("8. Update Rating by Title");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1, 2, 3 -> {
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Director: ");
                    String director = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    System.out.print("Rating: ");
                    double rating = sc.nextDouble();
                    if (choice == 1) {
                        list.addAtBeginning(title, director, year, rating);
                    } else if (choice == 2) {
                        list.addAtEnd(title, director, year, rating);
                    } else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        list.addAtPosition(title, director, year, rating, pos);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Movie Title to Remove: ");
                    String title = sc.nextLine();
                    list.removeByTitle(title);
                }
                case 5 -> {
                    System.out.print("Enter Director Name or Rating to Search: ");
                    String keyword = sc.nextLine();
                    list.search(keyword);
                }
                case 6 -> list.displayForward();
                case 7 -> list.displayReverse();
                case 8 -> {
                    System.out.print("Enter Movie Title to Update Rating: ");
                    String title = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    double newRating = sc.nextDouble();
                    list.updateRating(title, newRating);
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
