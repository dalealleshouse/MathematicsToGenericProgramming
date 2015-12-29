package com.hideoushumpbackfreak.math;

/**
 * Egyptian number systems did not have negative numbers or a zero
 * This is an evolution of the algorithm
 */
public class EgyptianMultiplication {
    // Multiplication is simply adding a number recursively
    public int multiply0(int n, int a) {
        // 1a = a
        if (n == 1) return a;

        // (n + 1)a = na + a
        return multiply0(n - 1, a) + a;
    }

    public int multiply1(int n, int a) {
        if (n == 1) return a;

        // This is not tail recursive...
        int result = multiply1(half(n), a + a);

        if (odd(n)) result = result + a;

        return result;
    }

    // Add an accumulator to reduce recursion
    public int mult_acc0(int r, int n, int a) {
        if (n == 1) return r + a;

        if (odd(n)) r = r + a;

        // This is tail recursive b/c recursion only occurs in return value
        return mult_acc0(r, half(n), a + a);
    }

    // Reduce the number of times it has to compare with 1 b/c the number is rarely 1
    public int mult_acc2(int r, int n, int a) {
        if (odd(n)) {
            r = r + a;
            if (n == 1) return r;
        }

        return mult_acc2(r, half(n), a + a);
    }

    // Make the procedure strictly tail recursive by assigning all the variables that are
    // passed before doing the recursion
    public int mult_acc3(int r, int n, int a) {
        if (odd(n)) {
            r = r + a;
            if (n == 1) return r;
        }

        n = half(n);
        a = a + a;
        return mult_acc2(r, n, a);
    }

    // Eliminate recursion to escape overhead of function calls
    public int mult_acc4(int r, int n, int a) {
        while (true) {
            if (odd(n)) {
                r = r + a;
                if (n == 1) return r;
            }

            n = half(n);
            a = a + a;
        }
    }

    // Use this to invoke mult_acc4, pass value of a for the initial accumulator value
    // to skip one iteration of mult_acc4
    public int multiply2(int n, int a) {
        if (n == 1) return a;
        return mult_acc4(a, n - 1, a);
    }

    // If n is a power of 2, the first thing we do is subtract 1, which means mult_acc4 will be called
    // with a number who's binary representation is all 1, the worse case for the algorithm
    public int multiply3(int n, int a) {
        while (!odd(n)) {
            a = a + a;
            n = half(n);
        }

        if (n == 1) return a;
        return mult_acc4(a, n - 1, a);
    }

    // Half and double n and a to make it odd for mult_acc4
    public int multiply4(int n, int a) {
        while (!odd(n)) {
            a = a + a;
            n = half(n);
        }

        if (n == 1) return a;

        return mult_acc4(a, half(n - 1), a + a);
    }

    private boolean odd(int n) {
        return (n & 0x1) == 0x1;
    }

    private int half(int n) {
        return n >> 0x1;
    }
}