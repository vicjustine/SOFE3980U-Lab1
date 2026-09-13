# BinaryCalculator — SOFE 3980U Lab 1

Apache Maven lab project for SOFE 3980U (Software Design Methods and Tools),
Ontario Tech University.

The `Binary` class stores an unsigned binary number as a string and supports
addition, bitwise OR, bitwise AND, and multiplication.

## Requirements

- JDK 17 or later
- Apache Maven 3.9+

## Build

```
mvn clean package site assembly:single
```

This compiles the sources, runs the tests, generates the project site with
Javadoc and the Surefire report, and produces two jars in `target/`.

## Run

```
java -jar target/BinaryCalculator-1.0.0-jar-with-dependencies.jar 10001000 111000
```

Operands may be passed as arguments; with none supplied the program prompts
for them interactively.

Use the `jar-with-dependencies` jar. The plain `BinaryCalculator-1.0.0.jar`
does not bundle Joda-Time and will fail at runtime with a
`NoClassDefFoundError` — this is expected, and is why the assembly plugin is
configured.

## Tests

```
mvn test
```

24 tests: 11 supplied with the lab covering the constructor and `add`, 12
added for `or`, `and`, and `multiply` (four each), plus the default `AppTest`.

## Design section

Three operations were added to the `Binary` class:

| Method | Description |
|---|---|
| `or(Binary, Binary)` | Bitwise OR; the shorter operand is treated as zero-padded |
| `and(Binary, Binary)` | Bitwise AND; the shorter operand is treated as zero-padded |
| `multiply(Binary, Binary)` | Shift-and-add multiplication, reusing `add` |

Because operands are strings rather than fixed-width integers, results are not
limited by the width of a Java primitive and cannot overflow.

## Generated documentation

After a build, open:

- `target/site/index.html` — project site
- `target/site/apidocs/index.html` — Javadoc
- `target/site/surefire-report.html` — test results

## Note on versions

The lab handout targets Java 1.7 and pins older plugin versions. JDK 25
rejects source/target 7 outright, so the language level is set to 17 and the
plugins, JUnit, and Joda-Time were updated to current releases.
