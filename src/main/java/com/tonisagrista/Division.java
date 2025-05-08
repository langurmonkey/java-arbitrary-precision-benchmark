package com.tonisagrista;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

public class Division extends BaseBenchmark {

  @Benchmark
  public void testBigDecimalDivision(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = state.aBD.divide(state.bBD, state.mc);
      bh.consume(result);
    }
  }

  @Benchmark
  public void testApFloatDivision(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = state.aAF.divide(state.bAF);
      bh.consume(result);
    }
  }

}
