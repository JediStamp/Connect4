package game;

//import java.util.Arrays;

/**
 * This class simulates a NibbleNabble game board.
 * 
 * @author Jenne Stamplecoskie
 * CST8110 - Introduction to Computer Programming
 * Section: 800
 * Semester: 20F
 * Professor: Jangam Piyush
 * Student ID: 040919025
 * Student Email: stam0134@algonquinlive.com
 * Practical Assessment 2
 */
public class Board {
	
	/** Number of rows on the board */
	private final static int NUM_ROWS = 6;
	
	/** Number of columns on the board */
	private final static int NUM_COLS = 7;
	
	/** Array of Column objects, which contain token values */
	private Column[] board = new Column[NUM_COLS];
	
	/**
	 * Loop through the board array, to instantiate and initialize each element as a new Column.
	 */
	public Board() {
		for (int i = 0; i < NUM_COLS; i ++) {
		    board[i] = new Column();
		}
	}
	
	/**
	 * Validate the column number, output an error message and return false if it's invalid.
	 * Try to put the token in the specified column of the board. Output an error message and 
	 * return false if it does not work.
	 * 
	 * @param column The column in which to place the token, valid values are 1 - 7.
	 * @param token Token character to place on the board, an X or an O.
	 * @return True if putting the token on the column is successful, else false.
	 */
	public boolean makeMove(int column, char token) {
		if (column > NUM_COLS || column < 0) {
		    System.out.printf("Invalid column number.%n");
		    return false;
		}
		
	    if (!board[column - 1].put(token)) {    
	        return false;
	    }
		return true;
	}
	
	/**
	 * Checks for computer's or user's victory by looking for complete vertical and horizontal 
	 * nibbles. Also checks for diagonal nibbles.
	 * 
	 * @param Char token - the token for the user whose victory is being checked.
	 * @return True if any nibbles are found on the board for the player being checked, otherwise 
	 * false.
	 */
	public boolean checkVictory(char token) {
	    // Loop through each column to check for a vertical nibble.
	    for (int col = 0; col < NUM_COLS; col++) {
	        if (board[col].checkVictory(token)) {
	            return true;
	        }
	    }

	    // Loop through each row to look for horizontal nibbles.
	    int nibbleCount = 0;
	    for (int row = 0; row < NUM_ROWS; row++) {
	        // Loop through each column in the row to check the value of the column and row.
	        // Use a counter to track the number of X's or O's found.
	        for (int col = 0; col < NUM_COLS; col++) {
	            if (board[col].get(row) == token) {
	                nibbleCount++;
	            }
	            else {
	                nibbleCount = 0;
	            }
	            if (nibbleCount == 4) {
	                return true;
	            }
	        }
	        nibbleCount = 0;		
	    }

	    //check diagonals - Note: Not part of the assignment
	    //Part 1 - check left low -> right high
	    for (int row = 0; row < NUM_ROWS - 3; row++) {
	        for (int col = 0; col < NUM_COLS - 3; col++) {
	            int nibRow = row;
	            int nibCol = col;
	            int nibCount = 0;
	            while (board[nibCol++].get(nibRow++) == token && nibCol < NUM_COLS && nibRow < NUM_ROWS) {                
	                nibCount++;
	                if (nibCount == 4) {
	                    return true;
	                }
	            }
	        }
	    }

	    //Part 2 - check left high -> right low
	    for (int row = NUM_ROWS - 1; row >= NUM_ROWS - 3; row--) {
	        for (int col = 0; col < NUM_COLS - 3; col++) {
	            int nibRow = row;
	            int nibCol = col;
	            int nibCount = 0;
	            while (board[nibCol++].get(nibRow--) == token && nibCol < NUM_COLS && nibRow >= 0) { 
	                nibCount++;
	                if (nibCount == 4) {
	                    return true;
	                }
	            }
	        }  
	    }
	    //if all conditions are false, return false.
	    return false;
	}
	
	/**
	 * Checks each column to see if there is room for another token.
	 * 
	 * @return True if there are no more safe moves, else false.
	 */
	   public boolean isFull() {
	        for (int col = 0; col < NUM_COLS; col++) {
	            if (board[col].getHeight() < NUM_ROWS - 1) {
	                return false;
	            }
	        }
	        return true;
	    }
	
	/**
	 * Displays each column number, divided by spaces.
	 * Displays, in a grid, the contained in each column of each row.
	 * Displays the column numbers again at the bottom.
	 * Example:
	 *
	 *  1 2 3 4 5 6 7 
	 * ---------------
	 * | | | | | | | |
	 * | | | | | | | |
	 * | | | | | | | |
	 * | | | | | | | |
	 * | |X| | | |O| |
	 * |O|O|X| |X|O| |	 
	 * ---------------
	 *  1 2 3 4 5 6 7 
	 *
	 */
	public void display() {
	    String numberHead = "   1   2   3   4   5   6   7 ";
	    String boardEdge = "-------------------------------";
  	    
	    System.out.printf("%n%n%s%n%s%n", numberHead, boardEdge);
	    
	    for (int row = NUM_ROWS - 1; row >= 0 ; row --) {
	        String boardRow = " | ";
	        for ( int col = 0; col < NUM_COLS; col++) {
	            boardRow = boardRow + (board[col].get(row)) + " | ";
	        }
	        System.out.printf("%s%n",  boardRow);
	    }
	    System.out.printf("%s%n%s%n%n", boardEdge, numberHead);
	}
	
	/**
	 * Resets the board when called. Removes all tokens from each column.
	 */
	public void reset() {
	    for (int i = 0; i < board.length; i ++) {
            board[i] = new Column();
        }
	}
	
}
