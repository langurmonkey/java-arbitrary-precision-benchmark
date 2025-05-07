
package org.sample;

import org.openjdk.jmh.annotations.*;

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

    @Param({ "25", "1000" }) // Add different precision levels here
    int precision;

    @Setup(Level.Trial)
    public void setUp() {
      mc = new MathContext(precision);
    }
  }
}

