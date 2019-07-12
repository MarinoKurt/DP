package four;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveNumberGenerator implements NumberGenerator {

    int start;
    int end;
    int step;

    public ConsecutiveNumberGenerator(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public List<Integer> generate() {
        List<Integer> l = new ArrayList<>();
        for(int i = start; i<end ;i+=step){
            l.add(i);
        }
        return l;
    }
}
