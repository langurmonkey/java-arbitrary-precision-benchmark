JMH `ApFloat` vs `BigDecimal`
=============================

This repository contains a JMH benchmark to test the performance of the arbitrary-precision floating-point libraries [ApFloat](http://www.apfloat.org) and [BigDecimal](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/math/BigDecimal.html).

See the blog post [Benchmarking ApFloat vs BigDecimal](https://tonisagrista.com/blog/2025/apfloat-bigdecimal).

Build the project with `just` (needs to be installed):

```bash
just build
```

And run a test (`$TEST_NAME` is one of Addition, Subtraction, Multiplication, Division, Sin, Pow, Log):

```bash
just run $TEST_NAME
```
