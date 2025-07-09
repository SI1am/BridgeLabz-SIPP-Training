package LinkedList;

import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
    }
}

class TextEditor {
    private TextState head = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public void addNewState(String newText) {
        TextState newState = new TextState(newText);

        if (current == null) {
            head = newState;
            current = head;
            size = 1;
        } else {
            // Remove all forward history
            current.next = null;

            // Attach new state
            newState.prev = current;
            current.next = newState;
            current = newState;

            size++;

            // Trim history if size exceeds MAX_HISTORY
            while (size > MAX_HISTORY) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }

        System.out.println("State saved!");
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    public void showCurrentState() {
        if (current != null)
            System.out.println("Current Text: \"" + current.content + "\"");
        else
            System.out.println("Editor is empty.");
    }
}

public class EditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== TEXT EDITOR MENU ===");
            System.out.println("1. Type text / Add new state");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show current text");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (ch) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = scanner.nextLine();
                    editor.addNewState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.showCurrentState();
                    break;
                case 5:
                    System.out.println("Exiting editor.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
