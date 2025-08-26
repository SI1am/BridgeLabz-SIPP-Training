package Streams;
import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) throws IOException {
        String src = "largefile.dat";
        String destBuffered = "copy_buffered.dat";
        String destUnbuffered = "copy_unbuffered.dat";
        int bufferSize = 4096;
        // Buffered Streams
        long start = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destBuffered))) {
            byte[] buffer = new byte[bufferSize];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        }
        long end = System.nanoTime();
        System.out.println("Buffered copy time: " + (end - start) / 1_000_000 + " ms");
        // Unbuffered Streams
        start = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(destUnbuffered)) {
            byte[] buffer = new byte[bufferSize];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        }
        end = System.nanoTime();
        System.out.println("Unbuffered copy time: " + (end - start) / 1_000_000 + " ms");
    }
}
