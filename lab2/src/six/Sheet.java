package six;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sheet {
    private Cell[][] cells;

    public Sheet(int row, int col) {
        this.cells = new Cell[row][col];
    }

    private Cell cell(String ref) {
        Point p = deref(ref);
        return cells[p.x][p.y];
    }

    public void set(String ref, String content) {
        Point p = deref(ref);
        Cell c = cell(ref);
        if (c != null) {
            for (Cell oldListener : getRefs(c)) {
                oldListener.removeObserver(c);
            }
        } else {
            c = new Cell(this, ref);
        }
        cells[p.x][p.y] = c;
        List<Cell> refs = getRefs(content);
        checkCircular(c, refs);
        for (Cell r : refs) {
            r.addObserver(c);
        }
        c.setExp(content);
    }

    int evaluate(Cell cell) {
        if (isInteger(cell.getExp())) {
            return Integer.valueOf(cell.getExp());
        }
        String[] parts = cell.getExp().split("\\+");
        if (parts.length == 1) {
            return evaluate(cell(parts[0]));
        }
        if (isInteger(parts[0]) && !isInteger(parts[1])) {
            return Integer.valueOf(parts[0]) + evaluate(cell(parts[1]));
        } else if (isInteger(parts[1]) && !isInteger(parts[0])) {
            return Integer.valueOf(parts[1]) + evaluate(cell(parts[0]));
        }
        return evaluate(cell(parts[0])) + evaluate(cell(parts[1]));
    }

    private void checkCircular(Cell c, List<Cell> refs) {
        for (Cell r : refs) {
            if (r.equals(c)) {
                throw new UnsupportedOperationException("Circular dependency!");
            } else {
                checkCircular(c, getRefs(r));
            }
        }
    }


    private List<Cell> getRefs(String exp) {
        List<Cell> refs = new ArrayList<>();
        if (!isInteger(exp)) {
            String[] parts = exp.split("\\+");
            if (!isInteger(parts[0])) {
                refs.add(cell(parts[0]));
            }
            if (parts.length > 1) {
                if (!isInteger(parts[1])) {
                    refs.add(cell(parts[1]));
                }
            }
        }
        return refs;
    }

    private List<Cell> getRefs(Cell cell) {
        return getRefs(cell.getExp());
    }

    private Point deref(String ref) {
        int col = (int) ref.toCharArray()[0];
        col -= (int) ('A');
        int row = (int) ref.toCharArray()[1] - 48;
        return new Point(row, col);
    }

    private boolean isInteger(String x) {
        try {
            Integer.valueOf(x);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
