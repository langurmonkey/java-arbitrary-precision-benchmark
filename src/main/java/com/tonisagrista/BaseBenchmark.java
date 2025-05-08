package com.tonisagrista;

import org.openjdk.jmh.annotations.*;

import org.apfloat.Apfloat;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 3, time = 5)
public abstract class BaseBenchmark {

  @State(Scope.Thread)
  public static class BenchmarkState {
    MathContext mc;
    BigDecimal aBD, bBD;
    Apfloat aAF, bAF;

    @Param({ "25", "50", "500", "1000" }) // Add different precision levels here
    int precision;

    @Setup(Level.Trial)
    public void setUp() {
      mc = new MathContext(precision);
      aBD = new BigDecimal("12345.678901234567890123456789012345678934343434343434343434343434343434", mc);
      bBD = new BigDecimal("98765.432109876543210987654321098765432134343434343434343434343434343434", mc);
      aAF = new Apfloat("12345.678901234567890123456789012345678934343434343434343434343434343434", precision);
      bAF = new Apfloat("98765.432109876543210987654321098765432134343434343434343434343434343434", precision);
    }
  }
}

