package five.listeners;

import five.NumberListener;

import java.util.List;

public class AvgListener implements NumberListener {

    @Override
    public void update(List<Integer> collection) {
        int sum = 0;
        for (int a : collection) {
            sum += a;
        }
        double avg = sum/(double)collection.size();
        System.out.println("Avg is: " + avg);
    }
}
