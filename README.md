# Minesweeper Logic

A simple Java-based implementation of the core **Minesweeper** game logic.  
Focuses purely on the **game engine**, with no UI layer included.

> **Status:** Completed — all main functions of the Minesweeper logic are implemented.

## Features
- **Customizable board** size and number of mines  
- **Automatic random** mine placement  
- **Flood-fill logic** for revealing connected empty cells  
- **Flagging system** to mark suspected mines  

## Project structure
- src/minesweeper/ — Core game logic (Board, Cell)  
- test/minesweeper/ — Unit tests (JUnit 4)  

## Installation
1. Clone the repository:
```   
bash
   git clone https://github.com/MrAlbertt/Minesweeper-core.git
```
2. Open the project in NetBeans 8.2+.
3. Build the project to ensure all dependencies (JUnit 4) are correctly loaded.

## Usage
This project provides only the game engine, so you can integrate it into your own applications or use it via the included test suite.
```java
import minesweeper.Board;
import minesweeper.Cell;
import java.util.List;

// Create a new board: 9x9 with 10 mines
Board board = new Board(9, 9, 10);

// Or use the empty constructor for a default 10x10 board with 15 mines
Board defaultBoard = new Board();

// Reveal a cell at row 3, column 4 (returns a list of updated cells)
List<Cell> updatedCells = board.floodReveal(3, 4);

// Flag a suspected mine at (5, 5)
board.setFlag(5, 5);

// Access a specific cell
Cell cell = board.getCell(3, 4);
```

**To run the JUnit tests:**
1. Open the project in NetBeans.
2. Right-click the test package and select **Test**.

## Built with
- Java 8
- JUnit 4
- NetBeans 8.2

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
