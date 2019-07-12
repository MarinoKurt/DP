package five;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DatotecniIzvor implements Izvor {

    private Path path;
    private List<Integer> nums;
    private int currentIndex;

    public DatotecniIzvor(Path path) {
        this.path = path;
        this.nums = new ArrayList<>();
        this.currentIndex = 0;
        process();
    }

    @Override
    public boolean hasNext() {
        currentIndex++;
        return nums.size() > currentIndex;
    }

    @Override
    public int next() {
        return nums.get(currentIndex);
    }

    void process() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println("Invalid path");
            System.exit(1);
        }
        for (String l : lines) {
            try {
                nums.add(Integer.valueOf(l));
            } catch (NumberFormatException e) {
                System.err.println("NaN in the file");
                System.exit(1);
            }
        }
    }
}
