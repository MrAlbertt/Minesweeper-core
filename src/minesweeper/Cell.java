package minesweeper;

public class Cell {
    private int row = 0;
    private int col = 0;
    private boolean hasMine = false;
    private int minesAround = 0;
    private boolean flagged = false;
    private boolean revealed = false;
    private boolean exploded = false;
    
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
    
    public int getMinesAround(){
        return minesAround;
    }
    
    public void setMinesAround(int minesAround){
        this.minesAround = minesAround;
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
    
    public void reveal(boolean revealed){
        this.revealed = revealed;
    }
    
    public boolean iExploded(){
        return exploded;
    }
    
    public void setExploted( boolean exploded){
        this.exploded = exploded;
    }
}
