package com.js.tictactoe.board.cell;

import com.js.tictactoe.player.Sign;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

@Test
public class CellTest {

    public void createEmptyCell() {
        Cell cell = new EmptyCell();
        assertEquals(Sign.EMPTY, cell.getValue());
    }

    public void createNonEmptyCellWithEmptyValue() {
        Cell cell = new CellWithValue(null);
        assertEquals(null, cell.getValue());
    }

    public void createCellWithCorrectValueAndCheckIfItIsEmpty() {
        Cell cell = new CellWithValue(Sign.X);
        assertFalse(cell.isCellEmpty());
    }
}
