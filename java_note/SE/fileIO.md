# File

## 1. read file by Line

```java
String path = GraphTest.class.getResource("testG1.txt").getPath(); // class loader, `GraphTest` is current class
File file = new File(path);
List<String> lines = Files.readAllLines(file.toPath());

for(String line : lines){
   // Do whatever you want
   System.out.println(line);
}
```
