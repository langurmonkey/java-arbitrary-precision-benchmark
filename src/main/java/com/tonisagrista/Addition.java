package com.tonisagrista;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.TimeUnit;
import ch.obermuhlner.math.big.*;

public class Addition extends BaseBenchmark {

  @Benchmark
  public void testBigDecimalAddition(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = state.aBD.add(state.bBD);
      bh.consume(result);
    }
  }

  @Benchmark
  public void testApFloatAddition(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = state.aAF.add(state.bAF);
      bh.consume(result);
    }
  }

}
