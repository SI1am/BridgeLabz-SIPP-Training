package Streams;
import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        String source = "source.txt";
        String dest = "destination.txt";
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + source);
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
