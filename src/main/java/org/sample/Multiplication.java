package org.sample;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.TimeUnit;
import ch.obermuhlner.math.big.*;

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
