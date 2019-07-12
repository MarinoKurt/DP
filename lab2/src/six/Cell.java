package six;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cell implements CellObserver, CellSubject {
    private Sheet sheet;
    private String exp;
    private int value;
    private List<CellObserver> observers;
    private String location;

    public Cell(Sheet sheet, String location) {
        this.sheet = sheet;
        this.location = location;
        this.observers = new ArrayList<>();
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
        this.update();
    }

    @Override
    public void update() {
        this.value = sheet.evaluate(this);
        fire();
    }

    @Override
    public void fire() {
        observers.forEach(o -> o.update());
    }

    @Override
    public void addObserver(CellObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(CellObserver o) {
        observers.remove(o);
    }

    @Override
    public void clearObservers() {
        observers.clear();
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(location, cell.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
