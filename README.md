JMH `ApFloat` vs `BigDecimal`
=============================

This repository contains a JMH benchmark to test the performance of the arbitrary-precision floating-point libraries [ApFloat](http://www.apfloat.org) and [BigDecimal](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/math/BigDecimal.html).

Build the project:

```bash
mvn clean verify
```

Run it:

```bash
java -jar target/benchmarks.jar PrecisionBenchmark
```
