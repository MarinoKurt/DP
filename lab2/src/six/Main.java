package six;

public class Main {
    public static void main(String[] args) {
        Sheet s = new Sheet(7,7);
        s.set("A1", "2");
        s.set("A2", "5");
        s.set("A3", "A1+A2");
        s.set("A4", "A1+A3");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("**************");
//        s.set("A1", "3");
//        s.set("A5", "A3+A4");
//        s.set("A6", "A4+A5");

        System.out.println("now to break it: ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s.set("A1", "A3");



//        s.set("A1", "A6+A2");

    }
}
