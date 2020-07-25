package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KnightBlack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {


    @Test
    public void moveFigureRight() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        boolean rsl = logic.move(Cell.C1, Cell.F4);
        assertThat(rsl, is(true));
    }

    @Test
    public void moveFigureWrong() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        KnightBlack knight = new KnightBlack(Cell.D2);
        logic.add(knight);
        boolean rsl = logic.move(Cell.C1, Cell.F4);
        assertThat(rsl, is(false));
    }

}


