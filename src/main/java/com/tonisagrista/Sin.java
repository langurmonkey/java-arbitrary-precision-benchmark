package com.tonisagrista;

import org.apfloat.ApfloatMath;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import ch.obermuhlner.math.big.*;

public class Sin extends BaseBenchmark {

  @Benchmark
  public void testBigDecimalSin(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = BigDecimalMath.sin(state.aBD, state.mc);
      bh.consume(result);
    }
  }

  @Benchmark
  public void testApfloatSin(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = ApfloatMath.sin(state.aAF);
      bh.consume(result);
    }
  }
}
