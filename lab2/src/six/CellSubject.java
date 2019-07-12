package six;

public interface CellSubject {
    void fire();
    void addObserver(CellObserver o);
    void removeObserver(CellObserver o);
    void clearObservers();
}
