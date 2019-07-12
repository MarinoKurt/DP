package four;

import java.util.List;

public class NearestRankPC implements PercentileCalculator {

    @Override
    public int calculate(List<Integer> list, int percentile) {
        int i = (int) (percentile * list.size() / 100 + 0.5);
        i--;
        return list.get(i);
    }
}
