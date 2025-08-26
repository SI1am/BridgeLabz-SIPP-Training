package Streams;
import java.io.*;

public class UpperToLowerFileCopy {
    public static void main(String[] args) {
        String src = "input.txt";
        String dest = "output.txt";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(src), "UTF-8"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
            System.out.println("File copied with lowercase conversion.");
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
