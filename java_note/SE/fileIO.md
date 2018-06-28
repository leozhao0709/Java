# File

## 1. read file by Line

```java
//        File file = new File( System.getProperty("user.dir") + "/src/test/java/algorithms/graph/testG1.txt");
File file = new File( "./src/test/java/algorithms/graph/testG1.txt");
List<String> lines = Files.readAllLines(file.toPath());

for(String line : lines){
   // Do whatever you want
   System.out.println(line);
}
```
