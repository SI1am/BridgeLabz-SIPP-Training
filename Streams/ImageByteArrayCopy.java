package Streams;
import java.io.*;
import java.util.Arrays;

public class ImageByteArrayCopy {
    public static void main(String[] args) {
        String src = "image.jpg";
        String dest = "image_copy.jpg";
        try (FileInputStream fis = new FileInputStream(src);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            byte[] imageBytes = baos.toByteArray();
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(dest)) {
                while ((len = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
            }
            // Verify
            boolean identical = compareFiles(src, dest);
            System.out.println("Files identical: " + identical);
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
    private static boolean compareFiles(String f1, String f2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(f1);
             FileInputStream fis2 = new FileInputStream(f2)) {
            byte[] buf1 = new byte[4096];
            byte[] buf2 = new byte[4096];
            int len1, len2;
            while ((len1 = fis1.read(buf1)) != -1) {
                len2 = fis2.read(buf2);
                if (len1 != len2 || !Arrays.equals(buf1, buf2)) return false;
            }
            return fis2.read() == -1;
        }
    }
}
