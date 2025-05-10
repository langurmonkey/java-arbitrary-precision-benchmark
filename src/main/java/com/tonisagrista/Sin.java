package com.tonisagrista;

import org.apfloat.ApfloatMath;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import ch.obermuhlner.math.big.*;

public class Sin extends BaseBenchmark {

  @Benchmark
  public void SinBigDecimal(BenchmarkState state, Blackhole bh) {
    var result = BigDecimalMath.sin(state.aBD, state.mc);
    bh.consume(result);
  }

  @Benchmark
  public void SinApfloat(BenchmarkState state, Blackhole bh) {
    var result = ApfloatMath.sin(state.aAF);
    bh.consume(result);
  }
}
