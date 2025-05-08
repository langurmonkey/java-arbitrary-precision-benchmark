package com.tonisagrista;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

public class Division extends BaseBenchmark {

  @Benchmark
  public void BigDecimalDivision(BenchmarkState state, Blackhole bh) {
    var result = state.aBD.divide(state.bBD, state.mc);
    bh.consume(result);
  }

  @Benchmark
  public void ApfloatDivision(BenchmarkState state, Blackhole bh) {
    var result = state.aAF.divide(state.bAF);
    bh.consume(result);
  }

}
