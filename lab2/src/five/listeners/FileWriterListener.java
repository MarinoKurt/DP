package five.listeners;

import five.NumberListener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class FileWriterListener implements NumberListener {

    @Override
    public void update(List<Integer> collection) {
        try {

            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("zapis.txt"));
            for (int c : collection) {
                writer.write(String.valueOf(c));
                writer.write("\n");
            }
            Date d = new Date();
            writer.write(d.toString());
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
