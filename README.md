Apfloat vs BigDecimal Benchmark
===============================

This repository contains a battery of JMH benchmarks to assess the performance of the arbitrary-precision floating-point libraries [Apfloat](http://www.apfloat.org) and [BigDecimal](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/math/BigDecimal.html).

See the blog post [Benchmarking Apfloat vs BigDecimal](https://tonisagrista.com/blog/2025/apfloat-bigdecimal).

Build the project with [`just`](https://github.com/casey/just):

```bash
just build
```

Run a test with: 

```bash
just run $TEST_NAME
```
`$TEST_NAME` is one of **Addition**, **Subtraction**, **Multiplication**, **Division**, **Sin**, **Pow**, **Log**, or **Allocation**.

This writes a report in JSON format in `results/jmh-result-$TEST_NAME.json`.
