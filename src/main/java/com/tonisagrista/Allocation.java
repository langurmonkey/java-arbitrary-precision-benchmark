package com.tonisagrista;

import org.apfloat.Apfloat;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigDecimal;

public class Allocation extends BaseBenchmark {

  @Benchmark
  public void BigDecimalAllocation(BenchmarkState state, Blackhole bh) {
    var aBD = new BigDecimal("12345.6789012345678901234567890123456789", state.mc);
    var bBD = new BigDecimal("98765.4321098765432109876543210987654321", state.mc);
    bh.consume(aBD);
    bh.consume(bBD);
  }

  @Benchmark
  public void ApfloatAllocation(BenchmarkState state, Blackhole bh) {
    var aAF = new Apfloat("12345.6789012345678901234567890123456789", state.precision);
    var bAF = new Apfloat("98765.4321098765432109876543210987654321", state.precision);
    bh.consume(aAF);
    bh.consume(bAF);
  }

}
