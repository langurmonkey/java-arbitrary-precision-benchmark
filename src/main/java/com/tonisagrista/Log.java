package com.tonisagrista;

import org.apfloat.ApfloatMath;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import ch.obermuhlner.math.big.*;

public class Log extends BaseBenchmark {

  @Benchmark
  public void BigDecimalLog(BenchmarkState state, Blackhole bh) {
    var result = BigDecimalMath.log(state.aBD, state.mc);
    bh.consume(result);
  }

  @Benchmark
  public void ApfloatLog(BenchmarkState state, Blackhole bh) {
    var result = ApfloatMath.log(state.aAF);
    bh.consume(result);
  }
}
