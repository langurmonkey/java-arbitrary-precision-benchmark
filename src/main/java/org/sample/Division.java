package org.sample;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.TimeUnit;
import ch.obermuhlner.math.big.*;

public class Division extends BaseBenchmark {

  @Benchmark
  public void testBigDecimalDivision(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var aBD = new BigDecimal("12345.6789012345678901234567890123456789", state.mc);
      var bBD = new BigDecimal("98765.4321098765432109876543210987654321", state.mc);
      var result = aBD.divide(bBD, state.mc);
      bh.consume(result);
    }
  }

  @Benchmark
  public void testApFloatDivision(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var aAF = new Apfloat("12345.6789012345678901234567890123456789", state.precision);
      var bAF = new Apfloat("98765.4321098765432109876543210987654321", state.precision);
      var result = aAF.divide(bAF);
      bh.consume(result);
    }
  }

}
