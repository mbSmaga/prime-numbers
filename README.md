# prime-numbers

### Building
```sh
mvn package
```
This will generate two jar files in target directory:
  - prime-numbers-1.0.jar
  - prime-numbers-1.0-jar-with-dependencies.jar
  
### Running

You can use either
```sh
mvn exec:java
# or with providing a fileName as first agrument to save the results
mvn exec:java -Dexec.args="fileName"

```
or
```sh
java -jar prime-numbers-1.0-jar-with-dependencies.jar
# or with providing a fileName as first agrument to save the results
java -jar prime-numbers-1.0-jar-with-dependencies.jar fileName
```
