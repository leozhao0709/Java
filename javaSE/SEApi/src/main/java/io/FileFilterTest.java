package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Objects;

class FileFilterTest {

    public static void main(String[] args) {
        String path = FileFilterTest.class.getResource("./").getPath();
        File file = new File(path);

        System.out.println(Arrays.toString(Arrays.stream(Objects.requireNonNull(file.list())).filter(name -> name.endsWith(".txt")).toArray()));

        String[] fileName = file.list((dir, name) -> {
            File file1 = new File(dir, name);
            return file1.isFile() && file1.getName().endsWith(".txt");
        });

        for (String name: fileName) {
            System.out.println(name);
        }
    }
}
