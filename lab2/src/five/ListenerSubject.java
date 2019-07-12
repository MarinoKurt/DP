package five;

public interface ListenerSubject {
    void fire();
    void addListener(NumberListener listener);
    void removeListener(NumberListener listener);
}
