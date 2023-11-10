package pwo.seq;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FibonacciGenerator extends Generator {

    private List<BigDecimal> fibonacciSequence;

    public FibonacciGenerator() {
        fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(new BigDecimal(0));
        fibonacciSequence.add(new BigDecimal(1));
    }

    @Override
    public void reset() {
        super.reset();
        fibonacciSequence.clear();
        fibonacciSequence.add(new BigDecimal(0));
        fibonacciSequence.add(new BigDecimal(1));
    }

    @Override
    public BigDecimal nextTerm() {
        if (lastIndex < fibonacciSequence.size()) {
            current = fibonacciSequence.get(lastIndex);
        } else {
            current = fibonacciSequence.get(lastIndex - 1).add(fibonacciSequence.get(lastIndex - 2));
            fibonacciSequence.add(current);
        }

        lastIndex++;
        return current;
    }

    public BigDecimal previousTerm() {
        if (lastIndex > 1) {
            return fibonacciSequence.get(lastIndex - 2);
        } else {
            return new BigDecimal(0);
        }
    }
}
