package four;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumberGenerator implements NumberGenerator {

    int numOfEl;

    public FibonacciNumberGenerator(int numOfEl) {
        this.numOfEl = numOfEl;
    }

    @Override
    public List<Integer> generate() {
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= numOfEl; i++) {
            l.add(fibonacci(i));
        }
        return l;
    }

    int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
