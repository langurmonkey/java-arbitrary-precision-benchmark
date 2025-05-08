package com.tonisagrista;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

public class Multiplication extends BaseBenchmark {

  @Benchmark
  public void testBigDecimalMultiplication(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = state.aBD.multiply(state.bBD);
      bh.consume(result);
    }
  }

  @Benchmark
  public void testApFloatMultiplication(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = state.aAF.multiply(state.bAF);
      bh.consume(result);
    }
  }
}
