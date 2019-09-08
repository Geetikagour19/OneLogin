## Building and Running Project
### To build project

```
    mvn clean install
```

### To generate test report

```
    mvn clean test
```
* Report is generated under ${PROJECT_ROOT}/src/target/site/jacoco

### The project can be run with the following command

```
    mvn exec:java -Dexec.mainClass="MainClass" -Dexec.args="1/2 * 3_3/4"
    mvn exec:java -Dexec.mainClass="MainClass" -Dexec.args="2_3/8 + 9/8"
```

## Assumptions :-

1. For simplicity, the API works in 4 byte Integer range.
1. If the number is whole, it is printed such. For e.g. 3 is printed as 3 , not 3_0/1.
1. If a fraction can be simplified as a whole number, it is printed as whole number. For e.g 6/2 is printed as 3, not 3/1 or 2_1/1 .
1. If denominator is entered as 0, it is assumed to be 1. For e.g. 6/0 = 6 .