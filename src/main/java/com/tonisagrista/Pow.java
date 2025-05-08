package com.tonisagrista;

import org.apfloat.ApfloatMath;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import ch.obermuhlner.math.big.*;

public class Pow extends BaseBenchmark {

  @Benchmark
  public void testBigDecimalPow(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = BigDecimalMath.pow(state.aBD, 4L, state.mc);
      bh.consume(result);
    }
  }

  @Benchmark
  public void testApfloatPow(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = ApfloatMath.pow(state.aAF, 4L);
      bh.consume(result);
    }
  }

}
