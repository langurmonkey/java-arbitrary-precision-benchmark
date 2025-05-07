package org.sample;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.TimeUnit;
import ch.obermuhlner.math.big.*;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 1, time = 3)
public class PrecisionBenchmark {

  private static final int ITERATIONS = 100;

  @State(Scope.Thread)
  public static class BenchmarkState {
    BigDecimal aBD;
    BigDecimal bBD;
    Apfloat aAF;
    Apfloat bAF;
    MathContext mc;

    @Param({ "25", "1000" }) // Add different precision levels here
    int precision;

    @Setup(Level.Trial)
    public void setUp() {
      mc = new MathContext(precision);
    }
  }

  @Benchmark
  public void testBigDecimalAddition(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var aBD = new BigDecimal("12345.6789012345678901234567890123456789", state.mc);
      var bBD = new BigDecimal("98765.4321098765432109876543210987654321", state.mc);
      var result = aBD.add(bBD);
      bh.consume(result);
    }
  }

  @Benchmark
  public void testApFloatAddition(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var aAF = new Apfloat("12345.6789012345678901234567890123456789", state.precision);
      var bAF = new Apfloat("98765.4321098765432109876543210987654321", state.precision);
      var result = aAF.add(bAF);
      bh.consume(result);
    }
  }

  @Benchmark
  public void testBigDecimalMultiplication(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var aBD = new BigDecimal("12345.6789012345678901234567890123456789", state.mc);
      var bBD = new BigDecimal("98765.4321098765432109876543210987654321", state.mc);
      var result = aBD.multiply(bBD);
      bh.consume(result);
    }
  }

  @Benchmark
  public void testApFloatMultiplication(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var aAF = new Apfloat("12345.6789012345678901234567890123456789", state.precision);
      var bAF = new Apfloat("98765.4321098765432109876543210987654321", state.precision);
      var result = aAF.multiply(bAF);
      bh.consume(result);
    }
  }

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

  @Benchmark
  public void testBigDecimalSin(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var aBD = new BigDecimal("12345.6789012345678901234567890123456789", state.mc);
      var result = BigDecimalMath.sin(aBD, state.mc);
      bh.consume(result);
    }
  }

  @Benchmark
  public void testApfloatSin(BenchmarkState state, Blackhole bh) {
    for (int i = 0; i < ITERATIONS; i++) {
      var aBD = new Apfloat("12345.6789012345678901234567890123456789", state.precision);
      var result = ApfloatMath.sin(aBD);
      bh.consume(result);
    }
  }

}
