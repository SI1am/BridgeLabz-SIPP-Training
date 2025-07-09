package LinkedList;
import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head = null;

    public void addUser(int userId, String name, int age) {
        if (findUser(userId) != null) {
            System.out.println("User with this ID already exists.");
            return;
        }
        User newUser = new User(userId, name, age);
        if (head == null) head = newUser;
        else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
        System.out.println("User added successfully.");
    }

    public User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int uid1, int uid2) {
        User user1 = findUser(uid1);
        User user2 = findUser(uid2);
        if (user1 == null || user2 == null || uid1 == uid2) {
            System.out.println("Invalid users.");
            return;
        }
        if (!user1.friendIds.contains(uid2)) user1.friendIds.add(uid2);
        if (!user2.friendIds.contains(uid1)) user2.friendIds.add(uid1);
        System.out.println("Friend connection added.");
    }

    public void removeFriend(int uid1, int uid2) {
        User user1 = findUser(uid1);
        User user2 = findUser(uid2);
        if (user1 == null || user2 == null) {
            System.out.println("Invalid users.");
            return;
        }
        user1.friendIds.remove((Integer) uid2);
        user2.friendIds.remove((Integer) uid1);
        System.out.println("Friend connection removed.");
    }

    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + user.name + ":");
        for (int fid : user.friendIds) {
            User f = findUser(fid);
            if (f != null)
                System.out.println("- " + f.name + " (ID: " + f.userId + ")");
        }
    }

    public void findMutualFriends(int uid1, int uid2) {
        User user1 = findUser(uid1);
        User user2 = findUser(uid2);
        if (user1 == null || user2 == null) {
            System.out.println("Invalid users.");
            return;
        }

        List<Integer> mutual = new ArrayList<>();
        for (int fid : user1.friendIds) {
            if (user2.friendIds.contains(fid)) {
                mutual.add(fid);
            }
        }

        if (mutual.isEmpty()) System.out.println("No mutual friends.");
        else {
            System.out.println("Mutual friends:");
            for (int id : mutual) {
                User f = findUser(id);
                if (f != null)
                    System.out.println("- " + f.name + " (ID: " + f.userId + ")");
            }
        }
    }

    public void searchUserByName(String name) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: ID=" + temp.userId + ", Age=" + temp.age);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("User not found.");
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }
}

public class Social {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Social Media Friend Manager =====");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display Friends of a User");
            System.out.println("5. Find Mutual Friends");
            System.out.println("6. Search User by Name");
            System.out.println("7. Count Friends of All Users");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sm.addUser(uid, name, age);
                    break;
                case 2:
                    System.out.print("Enter User ID 1: ");
                    int uid1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int uid2 = sc.nextInt();
                    sm.addFriend(uid1, uid2);
                    break;
                case 3:
                    System.out.print("Enter User ID 1: ");
                    int ruid1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int ruid2 = sc.nextInt();
                    sm.removeFriend(ruid1, ruid2);
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    int fuid = sc.nextInt();
                    sm.displayFriends(fuid);
                    break;
                case 5:
                    System.out.print("Enter User ID 1: ");
                    int m1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int m2 = sc.nextInt();
                    sm.findMutualFriends(m1, m2);
                    break;
                case 6:
                    sc.nextLine();
                    System.out.print("Enter Name to Search: ");
                    String sname = sc.nextLine();
                    sm.searchUserByName(sname);
                    break;
                case 7:
                    sm.countFriends();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
