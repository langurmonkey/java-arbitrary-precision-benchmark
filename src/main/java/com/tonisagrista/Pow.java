package com.tonisagrista;

import org.apfloat.ApfloatMath;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import ch.obermuhlner.math.big.*;

public class Pow extends BaseBenchmark {

  @Benchmark
  public void BigDecimalPow(BenchmarkState state, Blackhole bh) {
    var result = BigDecimalMath.pow(state.aBD, 4L, state.mc);
    bh.consume(result);
  }

  @Benchmark
  public void ApfloatPow(BenchmarkState state, Blackhole bh) {
    var result = ApfloatMath.pow(state.aAF, 4L);
    bh.consume(result);
  }

}
