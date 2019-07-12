package five;

import java.util.Scanner;

public class TipkovnickiIzvor implements Izvor {

    private Scanner sc;

    public TipkovnickiIzvor() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public boolean hasNext() {
        return sc.hasNext();
    }

    @Override
    public int next() {
        return sc.nextInt();
    }
}
