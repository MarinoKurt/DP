package five;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class SlijedBrojeva implements ListenerSubject {

    private Izvor source;
    private List<Integer> collection;
    private List<NumberListener> listeners;

    public SlijedBrojeva(Izvor source) {
        this.source = source;
        this.collection = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    void kreni() {

        while (true) {
            if (source.hasNext()) {
                int n = source.next();
                System.out.println();
                System.out.println("Read: " + n);
                collection.add(n);
                fire();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("\nSource exhausted. Exiting...");
                break;
            }
        }
    }

    @Override
    public void fire() {
        listeners.forEach(l -> l.update(new ArrayList(collection)));
    }

    @Override
    public void addListener(NumberListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(NumberListener listener) {
        listeners.remove(listener);
    }
}
