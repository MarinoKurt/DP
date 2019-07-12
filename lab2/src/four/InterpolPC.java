package four;

import java.util.List;

public class InterpolPC implements PercentileCalculator {

    @Override
    public int calculate(List<Integer> list, int percetile) {
        int N = list.size();

        if (percetile < 100 * 0.5 / N) {
            return list.get(0);
        }
        for (int i = 1; i < list.size(); i++) {
            double p1 = 100 * (i - 0.5) / N;
            double p2 = 100 * (i + 0.5) / N;
            if (percetile >= p1 && percetile <= p2) {
                return (int) (list.get(i - 1) + N * (percetile - p1) * (list.get(i) - list.get(i - 1)) / 100);
            }
        }
        return list.get(N - 1);

    }
}
