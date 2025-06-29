package com.tonisagrista;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

public class Subtraction extends BaseBenchmark {

  @Benchmark
  public void SubtractionBigDecimal(BenchmarkState state, Blackhole bh) {
    var result = state.aBD.subtract(state.bBD);
    bh.consume(result);
  }

  @Benchmark
  public void SubtractionApfloat(BenchmarkState state, Blackhole bh) {
    var result = state.aAF.subtract(state.bAF);
    bh.consume(result);
  }

}
