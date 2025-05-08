package com.tonisagrista;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

public class Addition extends BaseBenchmark {

  @Benchmark
  public void BigDecimalAddition(BenchmarkState state, Blackhole bh) {
    var result = state.aBD.add(state.bBD);
    bh.consume(result);
  }

  @Benchmark
  public void ApfloatAddition(BenchmarkState state, Blackhole bh) {
    var result = state.aAF.add(state.bAF);
    bh.consume(result);
  }

}
