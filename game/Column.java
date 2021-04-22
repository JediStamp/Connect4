package game;
/**
 * This class is a single Column on the board, containing vertically stacked X and O tokens.
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
public class Column {

	private static final int MAX_HEIGHT = 6;
	private int height = 0;
	private char[] column;
	
	/**
	 * Default constructor - initialize the column array and each element of the column array
	 *  to contain a blank space.
	 */
	public Column() {
		column = new char[MAX_HEIGHT];
	}
	
	/**
	 * Return the value in the specified row of a column.
	 * 
	 * @param row The specified row. Valid values are 0 - 5. 
	 * @return The character in the specified row, or blank if an invalid row was requested.
	 */
	public char get(int row) {
		return column[row];
	}
	
	/** Put the specified token character at the top of the column, increments the height, and 
	 * returns true. Return false if cannot put a token in the column.
	 * 
	 * @param token Token character to place on the board, an X or an O.
	 * @return True if there is room in the column for the token, else false.
	 */
	public boolean put(char token) {
		if (height < MAX_HEIGHT) {
		    column[height++] = token;
		    return true;
		}
		else {
		    return false;
		}
	}
	
	/**
	 * Check if the column contains a Nibble.
	 * 
	 * @param Char token - the token for the user whose victory is being checked.
	 * @return True if the column contains 4 or more consecutive 'O' tokens, else false.
	 */
	public boolean checkVictory(char token) {
		int nibbleCount = 0;
		for (int i = 0; i < height; i ++) {
		    if (column[i] == token) {
		        nibbleCount++;
		    }
		    else {
		        nibbleCount = 0;
		    }
		    if (nibbleCount == 4) {
		        return true;
		    }   
		}
		return false;
	}
	
	/**
	 * Returns the current height of the Column.
	 * 
	 * @return the height of the column
	 */
	public int getHeight() {
		return this.height;
	}
}
