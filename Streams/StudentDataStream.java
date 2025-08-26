package Streams;
import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String filename = "students.dat";
        // Write data
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(8.5);
            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(7.9);
            System.out.println("Student data written.");
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }
        // Read data
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            while (true) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }
}
