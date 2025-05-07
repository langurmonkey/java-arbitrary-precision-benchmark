package org.sample;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.TimeUnit;
import ch.obermuhlner.math.big.*;

public class Subtraction extends BaseBenchmark {

  @Benchmark
  public void testBigDecimalSubtraction(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = state.aBD.subtract(state.bBD);
      bh.consume(result);
    }
  }

  @Benchmark
  public void testApFloatSubtraction(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var result = state.aAF.subtract(state.bAF);
      bh.consume(result);
    }
  }

}
