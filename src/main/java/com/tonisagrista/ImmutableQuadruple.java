package com.tonisagrista;

import ch.obermuhlner.math.big.BigDecimalMath;
import com.tonisagrista.math.Float128;
import com.tonisagrista.math.Quadruple;
import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 5, time = 5)
public class ImmutableQuadruple {

    @State(Scope.Thread)
    public static class BenchmarkState {
        MathContext mc;
        Quadruple aQ, bQ;
        Float128 aF, bF;

        @Param({"32"}) // Add different precision levels here
        int precision;

        @Setup(Level.Trial)
        public void setUp() {
            mc = new MathContext(precision);
            aQ = new Quadruple(25435345.345354353);
            bQ = new Quadruple(-23235996868.47857549);
            aF = Float128.from(25435345.345354353);
            bF = Float128.from(-23235996868.47857549);
        }
    }

    @Benchmark
    public void ImmAdditionQuadruple(BenchmarkState state, Blackhole bh) {
        var result = state.aQ.add(state.bQ);
        bh.consume(result);
    }

    @Benchmark
    public void ImmAdditionFloat128(BenchmarkState state, Blackhole bh) {
        var result = state.aF.add(state.bF);
        bh.consume(result);
    }

    @Benchmark
    public void ImmSubtractionQuadruple(BenchmarkState state, Blackhole bh) {
        var result = state.aQ.subtract(state.bQ);
        bh.consume(result);
    }

    @Benchmark
    public void ImmSubtractionFloat128(BenchmarkState state, Blackhole bh) {
        var result = state.aF.subtract(state.bF);
        bh.consume(result);
    }

    @Benchmark
    public void ImmMultiplicationQuadruple(BenchmarkState state, Blackhole bh) {
        var result = state.aQ.multiply(state.bQ);
        bh.consume(result);
    }

    @Benchmark
    public void ImmMultiplicationFloat128(BenchmarkState state, Blackhole bh) {
        var result = state.aF.multiply(state.bF);
        bh.consume(result);
    }

    @Benchmark
    public void ImmDivisionQuadruple(BenchmarkState state, Blackhole bh) {
        var result = state.aQ.divide(state.bQ);
        bh.consume(result);
    }

    @Benchmark
    public void ImmDivisionFloat128(BenchmarkState state, Blackhole bh) {
        var result = state.aF.divide(state.bF);
        bh.consume(result);
    }
}
