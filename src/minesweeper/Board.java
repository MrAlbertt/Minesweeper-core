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
    
    public Board(){
        this(10,10,15);
    }
    
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
    
    public Cell getCell(int row, int col){
        return cells[row][col];
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
    
    public List<Cell> floodReveal(int row, int col){
        List<Cell> changes = new ArrayList<>();
        reveal(row, col, changes); 
        return changes;        
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
    
    private void reveal(int row, int col, List<Cell> changes){
        
        if (cells[row][col].isRevealed()) return;
        
        Queue<Cell> queue = new LinkedList<>();
        queue.add(cells[row][col]);
        
        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            int r = current.getRow();
            int c = current.getCol();
            
            
            if (current.isRevealed()) continue;
            
            current.setReveal(true);
            changes.add(current);
            
            if(current.hasMine()){
                current.setExploded(true);            
                continue;
            } 
       
            if(current.getMinesAdjacents() != 0) continue;
            
            for(int dr = -1; dr <= 1; dr++){
                for(int dc = -1; dc <= 1; dc++){
                    int nr = r + dr;
                    int nc = c + dc;
                    if (isValid(nr, nc) && !cells[nr][nc].isRevealed()) {
                        queue.add(cells[nr][nc]);
                    }
                }
            }
        }
    }
    
    private boolean isValid(int r, int c){
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}


