package com.tonisagrista;

import org.apfloat.ApfloatMath;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import ch.obermuhlner.math.big.*;

public class Log extends BaseBenchmark {

  @Benchmark
  public void testBigDecimalLog(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = BigDecimalMath.log(state.aBD, state.mc);
      bh.consume(result);
    }
  }

  @Benchmark
  public void testApfloatLog(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = ApfloatMath.log(state.aAF);
      bh.consume(result);
    }
  }

}
