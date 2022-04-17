# HotelReservation
Þróun hugbúnaðar bókunarkerfi



# Notes


location í streng ?
landsfjórðungur + bær







### before running test

```
export CLASSPATH=$CLASSPATH:/Users/benedikt/Documents/Github/HotelReservation/lib/hamcrest-core-1.3.jar

export CLASSPATH=$CLASSPATH:/Users/benedikt/Documents/Github/HotelReservation/lib/junit-4.13.2.jar
```

## compile project:
First, we need to get the path of every files ending with java in the root of the project directory:
```
find -name "*.java" > paths.txt # for Linux
dir /s /B *.java > paths.txt # for Windows
```
Afterward, we can compile it in bin/:
```
javac -d "bin" @paths.txt
```
And that's about it! The same hierarchy as src/ will be kept in bin/ but if you have some libraries (.jar files) that should be compiled with the rest of the project, then it should look like this:
```
javac -d "bin" -cp lib/somelib.jar:lib/someotherlib.jar @paths.txt
```
NOTE: On Windows, use ; instead of :.

Also, if you get an error while compiling about an import in the main class from a subpackage, try compiling by using the following command (assuming that the .java files are in a folder called src/):
```
javac -d "bin" @paths.txt -cp "src/"
```