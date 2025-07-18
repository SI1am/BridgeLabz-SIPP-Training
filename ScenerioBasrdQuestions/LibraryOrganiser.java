import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node 
{
    HashMap<String, HashMap<String, String>> data;
    Node next;
    Node prev;

    Node(HashMap<String, HashMap<String, String>> data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Library
{
    Node head = null;
    Node tail = null;

    public void addLast(HashMap<String, HashMap<String, String>> newHashMap) 
    {
        Node newNode = new Node(newHashMap);
        if (head == null) 
        {
            head = newNode;
            tail = newNode;
        } 
        else 
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addFirst(HashMap<String, HashMap<String, String>> newHashMap)
    {
        Node newNode = new Node(newHashMap);
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void display(Node startNode)
    {
        Node current = startNode;
        while (current != null)
        {
            for (String bookName : current.data.keySet()) {
                System.out.println(bookName); 
                HashMap<String, String> details = current.data.get(bookName);
                for (String key : details.keySet()) {
                    System.out.println(key + ": " + details.get(key)); 
                }
            }
            current = current.next;
        }
    }

    public void remove(Node removeNode)
    {
        if (removeNode == null) return;

        if (removeNode.prev != null) {
            removeNode.prev.next = removeNode.next;
        } else {
            head = removeNode.next;
        }

        if (removeNode.next != null) {
            removeNode.next.prev = removeNode.prev;
        } else {
            tail = removeNode.prev;
        }

        removeNode.next = null;
        removeNode.prev = null;
    }
}


public class LibraryOrganiser 
{
    public void Addtocart(List<String> cart, String bookName)
    {
        cart.add(bookName);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        Library library = new Library();
        List<String> cart = new ArrayList<>();
        HashMap<String, HashMap<String, String>> bookList = new HashMap<>();
        HashMap<String, String> borrowedBooks = new HashMap<>(); // bookName -> userName

        // Initial books
        HashMap<String, String> details1 = new HashMap<>();
        details1.put("Author", "Prem Chand");
        bookList.put("Do belo ki katha", details1);

        HashMap<String, String> details2 = new HashMap<>();
        details2.put("Author", "Jay");
        bookList.put("ABC", details2);

        library.addLast(bookList);

        boolean flag = true;
        String password = "12343211";
        int input;

        while(flag)
        {
            System.out.println("\nWelcome TO The Digital Library");
            System.out.println("Select you are: \n1.Reader \n2.Admin \n3.Exit");
            input = sc.nextInt();
            sc.nextLine();

            switch (input) 
            {
                case 1:
                    System.out.print("Enter your name: ");
                    String readerName = sc.nextLine();
                    boolean readerFlag = true;
                    while(readerFlag) 
                    {
                        System.out.println("\nAvailable Books:");
                        library.display(library.head);

                        System.out.print("Enter the book name you want to borrow: ");
                        String bookToBorrow = sc.nextLine();

                      
                        boolean found = false;
                        Node current = library.head;
                        while (current != null) {
                            if (current.data.containsKey(bookToBorrow)) {
                                found = true;
                                break;
                            }
                            current = current.next;
                        }

                        if (found && !borrowedBooks.containsKey(bookToBorrow)) {
                            cart.add(bookToBorrow);
                            borrowedBooks.put(bookToBorrow, readerName);
                            System.out.println("Book '" + bookToBorrow + "' added to your cart.");
                        } else if (borrowedBooks.containsKey(bookToBorrow)) {
                            System.out.println("Sorry, this book is already borrowed.");
                        } else {
                            System.out.println("Book not found.");
                        }

                        System.out.print("Do you want to borrow another book? (yes/no): ");
                        String ans = sc.nextLine();
                        if (!ans.equalsIgnoreCase("yes")) {
                            readerFlag = false;
                        }
                    }
                    break;

                case 2: // Admin
                    System.out.print("Enter admin password: ");
                    String pass = sc.nextLine();
                    if (!pass.equals(password)) {
                        System.out.println("Incorrect password!");
                        break;
                    }
                    boolean adminFlag = true;
                    while(adminFlag) {
                        System.out.println("\nAdmin Menu:");
                        System.out.println("1. Add Book\n2. Remove Book\n3. View Borrowed Books & Stats\n4. Exit Admin");
                        int adminChoice = sc.nextInt();
                        sc.nextLine();
                        switch(adminChoice) {
                            case 1: 
                                System.out.print("Enter book name: ");
                                String newBook = sc.nextLine();
                                System.out.print("Enter author name: ");
                                String newAuthor = sc.nextLine();
                                HashMap<String, String> newDetails = new HashMap<>();
                                newDetails.put("Author", newAuthor);

                                
                                bookList.put(newBook, newDetails);
                                HashMap<String, HashMap<String, String>> singleBook = new HashMap<>();
                                singleBook.put(newBook, newDetails);
                                library.addLast(singleBook);
                                System.out.println("Book added.");
                                break;
                            case 2: 
                                System.out.print("Enter book name to remove: ");
                                String removeBook = sc.nextLine();
                                
                                bookList.remove(removeBook);
                                
                                Node curr = library.head;
                                while (curr != null) {
                                    if (curr.data.containsKey(removeBook)) {
                                        library.remove(curr);
                                        System.out.println("Book removed.");
                                        break;
                                    }
                                    curr = curr.next;
                                }
                                borrowedBooks.remove(removeBook); 
                                break;
                            case 3: 
                                System.out.println("Borrowed Books:");
                                if (borrowedBooks.isEmpty()) 
                                {
                                    System.out.println("No books borrowed yet.");
                                } 
                                else 
                                {
                                    for (String b : borrowedBooks.keySet()) 
                                    {
                                        System.out.println("Book: " + b + ", Borrowed by: " + borrowedBooks.get(b));
                                    }
                                }
                                System.out.println("Total Books Borrowed: " + borrowedBooks.size());
                                System.out.println("Total Users: " + borrowedBooks.values().stream().distinct().count());
                                System.out.println("Books Borrowed: " + borrowedBooks.keySet());
                                break;
                            case 4:
                                adminFlag = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case 3:
                    flag = false;
                    System.out.println("Exiting Library System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid input.");
            }
        }
    }
}
