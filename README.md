JMH `Apfloat` vs `BigDecimal`
=============================

This repository contains a battery of JMH benchmarks to assess the performance of the arbitrary-precision floating-point libraries [Apfloat](http://www.apfloat.org) and [BigDecimal](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/math/BigDecimal.html).

See the blog post [Benchmarking Apfloat vs BigDecimal](https://tonisagrista.com/blog/2025/apfloat-bigdecimal).

Build the project with [`just`](https://github.com/casey/just):

```bash
just build
```

And run a test (`$TEST_NAME` is one of **Addition**, **Subtraction**, **Multiplication**, **Division**, **Sin**, **Pow**, **Log**, and **AdditionAllocation**):

```bash
just run $TEST_NAME
```
