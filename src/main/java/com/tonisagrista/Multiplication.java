package com.tonisagrista;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

public class Multiplication extends BaseBenchmark {

  @Benchmark
  public void MultiplicationBigDecimal(BenchmarkState state, Blackhole bh) {
    var result = state.aBD.multiply(state.bBD);
    bh.consume(result);
  }

  @Benchmark
  public void MultiplicationApfloat(BenchmarkState state, Blackhole bh) {
    var result = state.aAF.multiply(state.bAF);
    bh.consume(result);
  }
}
