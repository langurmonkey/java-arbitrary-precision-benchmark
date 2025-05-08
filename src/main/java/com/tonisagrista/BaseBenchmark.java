package com.tonisagrista;

import org.openjdk.jmh.annotations.*;

import org.apfloat.Apfloat;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Warmup(iterations = 2, time = 2)
@Measurement(iterations = 2, time = 2)
public abstract class BaseBenchmark {

  protected static final int ITERATIONS = 200;

  @State(Scope.Thread)
  public static class BenchmarkState {
    MathContext mc;
    BigDecimal aBD, bBD;
    Apfloat aAF, bAF;

    @Param({ "25", "1000" }) // Add different precision levels here
    int precision;

    @Setup(Level.Trial)
    public void setUp() {
      mc = new MathContext(precision);
      aBD = new BigDecimal("12345.6789012345678901234567890123456789", mc);
      bBD = new BigDecimal("98765.4321098765432109876543210987654321", mc);
      aAF = new Apfloat("12345.6789012345678901234567890123456789", precision);
      bAF = new Apfloat("98765.4321098765432109876543210987654321", precision);
    }
  }
}

