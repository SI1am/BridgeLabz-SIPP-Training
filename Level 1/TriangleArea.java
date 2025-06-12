import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base in inches: ");
        double base = sc.nextDouble();
        System.out.print("Enter height in inches: ");
        double height = sc.nextDouble();

        double areaInches = 0.5 * base * height;
        double areaCm = areaInches * 6.4516; // 1 square inch = 6.4516 square cm

        System.out.println("The area of the triangle is " + areaInches + " square inches and " + areaCm + " square centimeters");
        sc.close();
    }
}
