package solution;

import java.math.BigDecimal;
import java.math.MathContext;

public class Calculator {

    private static final MathContext MC = new MathContext(10000);

    public BigDecimal calculatePi(int iterations) {
        BigDecimal a = BigDecimal.ONE;
        BigDecimal b = BigDecimal.ONE.divide(BigDecimal.valueOf(Math.sqrt(2)), MC);
        BigDecimal t = new BigDecimal("0.25");
        BigDecimal p = BigDecimal.ONE;

        for (int i = 0; i < iterations; i++) {
            BigDecimal aNext = a.add(b).divide(new BigDecimal(2), MC);
            BigDecimal bNext = a.multiply(b).sqrt(MC);
            BigDecimal tNext = t.subtract(p.multiply(a.subtract(aNext).pow(2), MC), MC);
            BigDecimal pNext = p.multiply(new BigDecimal(2));

            a = aNext;
            b = bNext;
            t = tNext;
            p = pNext;
            System.out.println("Iteration: " + i + 1);
        }

        return a.add(b).pow(2, MC).divide(t.multiply(new BigDecimal(4)), MC);
    }
}
