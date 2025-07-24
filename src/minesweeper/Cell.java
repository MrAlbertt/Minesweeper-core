package minesweeper;

public class Cell {
    private int row;
    private int col;
    private boolean hasMine;
    private int minesAdjacents;
    private boolean flagged;
    private boolean revealed;
    private boolean exploded;
    
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return col;
    }
    
    public boolean hasMine(){
        return hasMine;
    }
    
    public void setMine(boolean hasMine){
        this.hasMine = hasMine;
    }
    
    public int getMinesAdjacents(){
        return minesAdjacents;
    }
    
    public void incrementMinesAdjacents(){
        minesAdjacents++;
    }
    
    public boolean isFlagged(){
        return flagged;
    }
    
    public void toogleFlag(){
        flagged = !flagged;
    }
    
    public boolean isRevealed(){
        return revealed;
    }
    
    public void setReveal(boolean revealed){
        this.revealed = revealed;
    }
    
    public boolean isExploded(){
        return exploded;
    }
    
    public void setExploded( boolean exploded){
        this.exploded = exploded;
    }
}
