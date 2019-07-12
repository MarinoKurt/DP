package five.listeners;

import five.NumberListener;

import java.util.List;

public class MedListener implements NumberListener {

    @Override
    public void update(List<Integer> collection) {
        double median = 0;
        int n = collection.size();

        if (n % 2 == 0) {
            median = (collection.get((n / 2) - 1) + collection.get(n / 2)) / 2;
        } else {
            median = collection.get(n / 2);
        }
        System.out.printf("Median is: %.0f\n", median);
    }
}
