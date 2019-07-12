package five.listeners;

import five.NumberListener;

import java.util.List;

public class SumListener implements NumberListener {

    @Override
    public void update(List<Integer> collection) {
        int sum = 0;
        for (int a : collection) {
            sum += a;
        }
        System.out.println("Sum is: " + sum);
    }
}
