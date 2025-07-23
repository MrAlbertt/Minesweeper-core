package minesweeper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int rows;
    private int cols;
    private int mines;    
    private Cell[][] cells;
    
    public Board(int rows, int cols, int mines){
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        cells = new Cell[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                cells[r][c] = new Cell(r,c);
            }
        }
        
        createMines();
        calculateAdjacentMines();
    }
    
    private void createMines(){
        int numMines = 0;
        while(true){
            int randNum1 = RandNum(rows);
            int randNum2 = RandNum(cols);
            
            if(!cells[randNum1][randNum2].hasMine()){
                cells[randNum1][randNum2].setMine(true);
                numMines++;
            }
            
            if(numMines == mines){
                return;
            }
        }
    }
    
    private int RandNum(int x){
        return ThreadLocalRandom.current().nextInt(0, x );
    }
    
    public void calculateAdjacentMines(){
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(cells[r][c].hasMine()){
                    for(int dr = -1; dr <= 1; dr++){
                        for(int dc = -1; dc <= 1; dc++){
                            if(isValid(r+dr,c+dc)){
                                if(!cells[r+dr][c+dc].hasMine()){
                                    cells[r+dr][c+dc].incrementMinesAdjacents();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public List<int[]> floodReveal(int row, int col){
        List<int[]> changes = new ArrayList<>();
        reveal(row, col, changes); 
        return changes;        
    }
    
    private void reveal(int row, int col, List<int[]> changes){
        
        if (cells[row][col].isRevealed()) return;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
        
            if (cells[r][c].isRevealed()) continue;
            
            cells[r][c].setReveal(true);
            changes.add(new int[]{r, c});
            
            if(cells[r][c].hasMine()){
                cells[r][c].setExploded(true);            
                continue;
            } 
       
            if(cells[r][c].getMinesAdjacents() != 0) continue;
            
            for(int dr = -1; dr <= 1; dr++){
                for(int dc = -1; dc <= 1; dc++){
                    int nr = r + dr;
                    int nc = c + dc;
                    if (isValid(nr, nc) && !cells[nr][nc].isRevealed()) {
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }
    
    private boolean isValid(int r, int c){
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
