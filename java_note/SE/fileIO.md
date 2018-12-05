# File

## 0. File method
```java
String resourcePath = FileStreamTest.class.getResource("./test.txt").getPath();
File file = new File(resourcePath);
```
-  `file.getName()`

-  `file.createNewFile()`
-  `file.mkdir()`
-  `file.mkdirs()`
-  `oldFile.renameTo(newFile)`
-  `file.delete()`

-  `file.exists()`
-  `file.isDirectory()`
-  `file.isFile()`
-  `file.isHidden()`

-  `file.getAbsolutePath()`
-  `file.length()` will return bytes length
-  `file.lastModified()` will return a time stamp
-  `String[] fileNameArray = file.list()` will only return the **file/directory name array**
-  `File[] fileArray = file.listFiles()` will return the **file array**
-  `File[] fileArray = file.list((dir, name) -> name.endsWith(".txt"))`.

## 1. read file by Line (not recommend, please check BufferedReader)

```java
String path = GraphTest.class.getResource("testG1.txt").getPath(); // class loader, `GraphTest` is current class
File file = new File(path);
List<String> lines = Files.readAllLines(file.toPath());

for(String line : lines){
   // Do whatever you want
   System.out.println(line);
}
```

## 2. fileInputStream

```java
String resourcePath = FileStreamTest.class.getResource("./test.txt").getPath();
try (FileInputStream fis = new FileInputStream(resourcePath);) {
   byte[] bytes = new byte[3];
   int temp;
   while ((temp = fis.read(bytes)) != -1) {
         String res = new String(bytes, 0, temp);
         System.out.println(res);
   }
} catch (IOException e) {
   e.printStackTrace();
}
```

Note:

-  you need to create a byte array and define the size. (please also check **BufferedStream**)
-  You need `temp` to recieve the **offset** of the bytes that write to byte array.
-  Remember to close the resource(before jdk7).

## 3. fileOutputStream

```java
String resourcePath = FileStreamTest.class.getResource("./test.txt").getPath();
try(FileOutputStream fos = new FileOutputStream(resourcePath, true);) {
   //如果文件不存在，则会自动创建
   //如果要想在文件中append写的话，第二个参数传true
   String msg = "monkey1024.com";
   //将msg转为byte数组
   byte[] bytes = msg.getBytes();
   //将byte数组中所有的数据全部写入
   fos.write(bytes);
   //刷新一下保证数据全部写入硬盘
   fos.flush();
} catch (FileNotFoundException e) {
   e.printStackTrace();
} catch (IOException e) {
   e.printStackTrace();
}
```

Note:

-  First get the bytes to write. (please also check **BufferedStream**)
-  `FileOutputStream` has the second parameter which defines appends or not.
-  use `fos.flush()` each time to make sure we write the things in file.
-  Use `File.separator` to get the default separator.
-  Remember to close stream (before jdk7).

## 4. BufferedStream

```java
String inputResourcePath = FileStreamTest.class.getResource("./input.txt").getPath();
String outputResourcePath = FileStreamTest.class.getResource("./output.txt").getPath();
try (
   //使用缓冲流装饰一下
   BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputResourcePath));
   BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputResourcePath));
){
   int temp;
   while((temp = bis.read()) != -1) {                
         bos.write(temp);
   }
} catch (FileNotFoundException e) {
   e.printStackTrace();
} catch (IOException e) {
   e.printStackTrace();
}
```

Note:

-  The theory for BufferedStream is almost same with stream except it automatically create a default **8192 byte** array to do the stream operations.
-  In here, temp are still offset.

## 5. autoClosable

After jdk7, you can use the new syntax to create any stream which you don't need to manullay close the resource because the stream implements the `Closeable` interface. So we can also define our own `Closeable` and use the new syntax.

```java
class CloseTest implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("auto closed...");
    }
}

class FileStreamTest {

    public static void main(String[] args) {
        try (CloseTest ct = new CloseTest() ) { // note the bracket in try statement
            // do something
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 6. BufferedReader/Writer

```java
String inputResourcePath = FileStreamTest.class.getResource("./input.txt").getPath();
String outputResourcePath = FileStreamTest.class.getResource("./output.txt").getPath();
try (BufferedReader br = new BufferedReader(new FileReader(inputResourcePath));
   BufferedWriter bw = new BufferedWriter(new FileWriter(outputResourcePath));) {
   String s;
   while ((s = br.readLine()) != null) {
         bw.write(s);
         bw.newLine();
   }
   bw.flush();
} catch (IOException e) {
   e.printStackTrace();
}
```

Note:

-  Use `new BufferedReader(new FileReader(inputResourcePath))` and `new BufferedWriter(new FileWriter(outputResourcePath));`
-  For writer, remember `flush`.

## 7. InputStreamReader/OutputStreamWriter (encoding/decoding related)

These 2 are used when you want to deal with different encoding of the file.

```java
String inputResourcePath = FileStreamTest.class.getResource("./input.txt").getPath();
String outputResourcePath = FileStreamTest.class.getResource("./output.txt").getPath();
// 使用FileInputStream读取文本内容，然后通过InputStreamReader和指定的编码将字符转换为字节
try (BufferedReader br = new BufferedReader(
               new InputStreamReader(new FileInputStream(inputResourcePath), "utf-8"));
         BufferedWriter bw = new BufferedWriter(
               new OutputStreamWriter(new FileOutputStream(outputResourcePath), "gbk"));) {
   String msg;
   while((msg = br.readLine()) != null){
         bw.write(msg);
   }
   bw.flush();
} catch (UnsupportedEncodingException | FileNotFoundException e) {
   e.printStackTrace();
} catch (IOException e1) {
   e1.printStackTrace();
}
```

Note:

-  Use Buffer to wrap the streamReader/streamWriter.
