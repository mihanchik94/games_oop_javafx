package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y);
    }


    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = (dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = Math.abs(dest.x - source.x) > 0 ? 1 : -1;
        int deltaY = Math.abs(dest.y - source.y) > 0 ? 1 : -1;
        int x = source.x;
        int y = source.y;
        for (int index = 0; index < size; index++) {
            x+= deltaX;
            y+= deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }


    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
