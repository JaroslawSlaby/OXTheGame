package com.js.tictactoe.board.cell;

import com.js.tictactoe.player.Sign;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CellTest {

    @Test
    public void createEmptyCell() {
        Cell cell = new EmptyCell();
        Assert.assertEquals(Sign.EMPTY, cell.getValue());
    }

    @Test
    public void createNonEmptyCellWithEmptyValue() {
        Cell cell = new CellWithValue(null);
        Assert.assertEquals(null, cell.getValue());
    }

    @Test
    public void createCellWithCorrectValueAndCheckIfItIsEmpty() {
        Cell cell = new CellWithValue(Sign.X);
        Assert.assertFalse(cell.isCellEmpty());
    }

    @Test
    public void createEmptyCellAndCheckIfItIsEmpty() {

    }
}
