package minesweeper;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Alberto Vanegas
 */
public class BoardTest {
    @Test
    public void testDefectBoardDoesNotCrash(){
        Board board = new Board();
    }
    
    @Test
    public void testCustomBoardDoesNotCrash(){
        Board board = new Board(10,10,15);
    }
    
    @Test
    public void testFloodRevealDoesNotCrash(){
        Board board = new Board();
        board.floodReveal(2,5);
    }
    
    @Test
    public void testCreationMines(){
        Board board = new Board(5, 5, 5);
        int numMines = 0;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if(board.getCell(row, col).hasMine()) numMines++;
            }
        }
        assertEquals("Número de minas incorrecto",5, numMines);
    }
    
    @Test
    public void testExplodedMine(){
        Board board = new Board(5, 5, 1);
        boolean exploded = false;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                board.floodReveal(row, col);
                if (board.getCell(row, col).isExploded()) exploded = true;
            }
        }
        assertTrue("Mina no exploto",exploded);
    }
}
