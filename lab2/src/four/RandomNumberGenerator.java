package four;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    int mean;
    int dev;
    int numberOfEl;

    public RandomNumberGenerator(int mean, int dev, int numberOfEl) {
        this.mean = mean;
        this.dev = dev;
        this.numberOfEl = numberOfEl;
    }

    @Override
    public List<Integer> generate() {
        List<Integer> l = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < numberOfEl; i++) {
            l.add((int) (r.nextGaussian() * dev + mean));
        }
        l.sort(Comparator.comparing(Integer::intValue));
        return l;
    }
}
