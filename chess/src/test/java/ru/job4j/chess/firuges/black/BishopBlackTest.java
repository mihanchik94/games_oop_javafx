package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {


    @Test
    public void position() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        Cell rsl = bishop.position();
        assertThat(rsl, is(Cell.C1));

    }

    @Test
    public void way() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        Cell[] rsl = bishop.way(Cell.C1, Cell.G5);
        assertThat(rsl, is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test(expected = IllegalStateException.class)
    public void isNotDiagonal() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        Cell[] rsl = bishop.way(Cell.C1, Cell.C5);
    }

    @Test
    public void copy() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        Figure fig = bishop.copy(Cell.G5);
        Cell rsl = fig.position();
        assertThat(rsl, is(Cell.G5));
    }
}