package com.tonisagrista;

import ch.obermuhlner.math.big.BigDecimalMath;
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
public class ThreeWay {

    @State(Scope.Thread)
    public static class BenchmarkState {
        MathContext mc;
        BigDecimal aBD, bBD;
        Apfloat aAF, bAF;
        Quadruple aQ, bQ;

        @Param({"32"}) // Add different precision levels here
        int precision;

        @Setup(Level.Trial)
        public void setUp() {
            mc = new MathContext(precision);
            aBD = new BigDecimal("12345.6789012345678901234567890123", mc);
            bBD = new BigDecimal("98765.4321098765432109876543210987", mc);
            aAF = new Apfloat("12345.6789012345678901234567890123", precision);
            bAF = new Apfloat("98765.4321098765432109876543210987", precision);
            aQ = new Quadruple("12345.6789012345678901234567890123");
            bQ = new Quadruple("98765.4321098765432109876543210987");
        }
    }

    @Benchmark
    public void TWAdditionBigDecimal(BenchmarkState state, Blackhole bh) {
        var result = state.aBD.add(state.bBD);
        bh.consume(result);
    }

    @Benchmark
    public void TWAdditionApfloat(BenchmarkState state, Blackhole bh) {
        var result = state.aAF.add(state.bAF);
        bh.consume(result);
    }

    @Benchmark
    public void TWAdditionQuadruple(BenchmarkState state, Blackhole bh) {
        var result = state.aQ.add(state.bQ);
        bh.consume(result);
    }
    @Benchmark
    public void TWSubtractionBigDecimal(BenchmarkState state, Blackhole bh) {
        var result = state.aBD.subtract(state.bBD);
        bh.consume(result);
    }

    @Benchmark
    public void TWSubtractionApfloat(BenchmarkState state, Blackhole bh) {
        var result = state.aAF.subtract(state.bAF);
        bh.consume(result);
    }

    @Benchmark
    public void TWSubtractionQuadruple(BenchmarkState state, Blackhole bh) {
        var result = state.aQ.subtract(state.bQ);
        bh.consume(result);
    }
    @Benchmark
    public void TWMultiplicationBigDecimal(BenchmarkState state, Blackhole bh) {
        var result = state.aBD.multiply(state.bBD);
        bh.consume(result);
    }

    @Benchmark
    public void TWMultiplicationApfloat(BenchmarkState state, Blackhole bh) {
        var result = state.aAF.multiply(state.bAF);
        bh.consume(result);
    }

    @Benchmark
    public void TWMultiplicationQuadruple(BenchmarkState state, Blackhole bh) {
        var result = state.aQ.multiply(state.bQ);
        bh.consume(result);
    }
    @Benchmark
    public void TWDivisionBigDecimal(BenchmarkState state, Blackhole bh) {
        var result = state.aBD.divide(state.bBD, state.mc);
        bh.consume(result);
    }

    @Benchmark
    public void TWDivisionApfloat(BenchmarkState state, Blackhole bh) {
        var result = state.aAF.divide(state.bAF);
        bh.consume(result);
    }

    @Benchmark
    public void TWDivisionQuadruple(BenchmarkState state, Blackhole bh) {
        var result = state.aQ.divide(state.bQ);
        bh.consume(result);
    }

    @Benchmark
    public void TWSqrtBigDecimal(BenchmarkState state, Blackhole bh) {
        var result = BigDecimalMath.sqrt(state.aBD, state.mc);
        bh.consume(result);
    }

    @Benchmark
    public void TWSqrtApfloat(BenchmarkState state, Blackhole bh) {
        var result = ApfloatMath.sqrt(state.aAF);
        bh.consume(result);
    }

    @Benchmark
    public void TWSqrtQuadruple(BenchmarkState state, Blackhole bh) {
        var result = state.aQ.sqrt();
        bh.consume(result);
    }

    @Benchmark
    public void TWAllocationBigDecimal(BenchmarkState state, Blackhole bh) {
        var aBD = new BigDecimal("12345.6789012345678901234567890123", state.mc);
        var bBD = new BigDecimal("98765.4321098765432109876543210987", state.mc);
        bh.consume(aBD);
        bh.consume(bBD);
    }

    @Benchmark
    public void TWAllocationApfloat(BenchmarkState state, Blackhole bh) {
        var aAF = new Apfloat("12345.6789012345678901234567890123", state.precision);
        var bAF = new Apfloat("98765.4321098765432109876543210987", state.precision);
        bh.consume(aAF);
        bh.consume(bAF);
    }

    @Benchmark
    public void TWAllocationQuadruple(BenchmarkState state, Blackhole bh) {
        var aQ = new Quadruple("12345.6789012345678901234567890123");
        var bQ = new Quadruple("98765.4321098765432109876543210987");
        bh.consume(aQ);
        bh.consume(bQ);
    }

    @Benchmark
    public void TWAllocationDoubleBigDecimal(BenchmarkState state, Blackhole bh) {
        var aBD = new BigDecimal(12345.67890123456789012, state.mc);
        var bBD = new BigDecimal(98765.43210987654321098, state.mc);
        bh.consume(aBD);
        bh.consume(bBD);
    }

    @Benchmark
    public void TWAllocationDoubleApfloat(BenchmarkState state, Blackhole bh) {
        var aAF = new Apfloat(12345.67890123456789012, state.precision);
        var bAF = new Apfloat(98765.43210987654321098, state.precision);
        bh.consume(aAF);
        bh.consume(bAF);
    }

    @Benchmark
    public void TWAllocationDoubleQuadruple(BenchmarkState state, Blackhole bh) {
        var aQ = new Quadruple(12345.67890123456789012);
        var bQ = new Quadruple(98765.43210987654321098);
        bh.consume(aQ);
        bh.consume(bQ);
    }
}
