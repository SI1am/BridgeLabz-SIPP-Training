import java.util.Scanner;

public class StringToCharArray {
    
    public static char[] toCharArrayManual(String s) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        return arr;
    }

    
    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();
        char[] manual = toCharArrayManual(text);
        char[] builtin = text.toCharArray();
        boolean same = compareCharArrays(manual, builtin);
        System.out.print("Manual char array: ");
        System.out.println(manual);
        System.out.print("Built-in char array: ");
        System.out.println(builtin);
        System.out.println("Arrays are the same: " + same);
    }
}
