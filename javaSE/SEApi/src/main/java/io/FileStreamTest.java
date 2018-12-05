package io;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;

class FileStreamTest {

    public static void main(String[] args) {
        String resourcePath = FileStreamTest.class.getResource("./test.txt").getPath();
        try (FileInputStream fis = new FileInputStream(resourcePath);
            CloseTest ct = new CloseTest()) {
            byte[] bytes = new byte[3];
            int temp;
            while ((temp = fis.read(bytes)) != -1) {
                String res = new String(bytes, 0, temp);
                System.out.println(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class CloseTest implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("auto closed...");
    }
}
