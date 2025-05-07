package org.sample;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.TimeUnit;
import ch.obermuhlner.math.big.*;

public class Log extends BaseBenchmark {

  @Benchmark
  public void testBigDecimalLog(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var aBD = new BigDecimal("12345.6789012345678901234567890123456789", state.mc);
      var result = BigDecimalMath.log(aBD, state.mc);
      bh.consume(result);
    }
  }

  @Benchmark
  public void testApfloatLog(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var aBD = new Apfloat("12345.6789012345678901234567890123456789", state.precision);
      var result = ApfloatMath.log(aBD);
      bh.consume(result);
    }
  }

}
