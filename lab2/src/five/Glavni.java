package five;

import five.listeners.AvgListener;
import five.listeners.FileWriterListener;
import five.listeners.MedListener;
import five.listeners.SumListener;

import java.nio.file.Paths;

public class Glavni {

    public static void main(String[] args) {
        SlijedBrojeva sb = new SlijedBrojeva(new DatotecniIzvor(Paths.get("input.txt")));
        sb.addListener(new SumListener());
        sb.addListener(new FileWriterListener());
        sb.addListener(new MedListener());
        sb.addListener(new AvgListener());
        sb.kreni();
    }
}
