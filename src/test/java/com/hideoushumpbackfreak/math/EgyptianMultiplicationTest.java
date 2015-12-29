package com.hideoushumpbackfreak.math;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EgyptianMultiplicationTest {
    EgyptianMultiplication _sut;

    @Before
    public void Init() {
        _sut = new EgyptianMultiplication();
    }

    @Test
    public void testMultiply0() throws Exception {
        multiplicationTests(_sut::multiply0);
    }

    @Test
    public void testMultiply1() throws Exception {
        multiplicationTests(_sut::multiply1);
    }

    @Test
    public void testMult_acc0() throws Exception {
        multiplicationTests((a, n) -> _sut.mult_acc0(0, a, n));
    }

    @Test
    public void testMult_acc2() throws Exception {
        multiplicationTests((a, n) -> _sut.mult_acc2(0, a, n));
    }

    @Test
    public void testMult_acc3() throws Exception {
        multiplicationTests((a, n) -> _sut.mult_acc3(0, a, n));
    }

    @Test
    public void testMult_acc4() throws Exception {
        multiplicationTests((a, n) -> _sut.mult_acc4(0, a, n));
    }

    @Test
    public void testMultiply2() throws Exception {
        multiplicationTests(_sut::multiply2);
    }

    @Test
    public void testMultiply3() throws Exception {
        multiplicationTests(_sut::multiply3);
    }

    @Test
    public void testMultiply4() throws Exception {
        multiplicationTests(_sut::multiply4);
    }

    private void multiplicationTests(TestCalculation calc) {
        int result = calc.calculate(5, 10);
        assertEquals(50, result);

        result = calc.calculate(6, 8);
        assertEquals(48, result);

        result = calc.calculate(3, 7);
        assertEquals(21, result);

        result = calc.calculate(1, 10);
        assertEquals(10, result);

        result = calc.calculate(10, 1);
        assertEquals(10, result);
    }
}

