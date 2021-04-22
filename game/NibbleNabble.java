package game;
import java.util.Scanner;
import java.util.Random;

/**
 * This class implements a simple version of Connect Four, called NibbleNabble.
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
public class NibbleNabble {

	private Player currentPlayer;
	private Player computer;
	private Player user;
	private Board board;
	private Scanner input;
	
	/** Outputs a welcome message. Prompts the user for their name, and instantiates 
	 * a new Player with the name.
	 *  Initializes the Scanner, Board, user and computer variables.
	 */
	public NibbleNabble() {
		input = new Scanner(System.in);
		String welcome = "\n\tWelcome to Jenne's Connect 4.\n\nThe goal is to get 4 tokens in a row, "
		                 + "before your opponent.\nYou can win by getting four tokens in a row "
		                 + "either:\n\n\t\t\t\tv\t\td\n\t\t\t\te\t\t i\n"
		                 + "\t\t\t\tr\t\t  a\n\t\t\t\tt\t\t   g\nh o r i z o n t a l l y\t\ti\tor \t"
		                 + "    o\n\t\t\t\tc\t\t     n\n\t\t\t\ta\t\t      a\n\t\t\t\tl\t\t       "
		                 + "l\n\t\t\t\tl\t\t        l\n\t\t\t\ty\t\t         y\n\n"
		                 + "Please enter your name: ";
		
		System.out.printf("%s", welcome);
		user = new Player(input.next());
		computer = new Player();
		board = new Board();
		
		System.out.printf("%n%s on your turn, please enter the number of the column you would like to "
		                    + "place your token in.%nYour token will be an X%n%n", user.getName());
	}
	
	/**
	 * Play the game. Each user has a chance to pick a column to put a token in, and then the user 
	 * is switched. After each token is placed, check for victory.
	 * @return
	 */
	public boolean playGame() {
		
		while (true) {
			board.display();
			int column = 0;
			currentPlayer = togglePlayer();
			
			System.out.print(currentPlayer.getName() + " > ");
			
			while (column == 0) {
				
				if (currentPlayer == computer) {
					column = new Random().nextInt(7)+ 1;
//					System.out.println(column);
				} else {
					String move = input.next();
					if (move.toUpperCase().charAt(0) == 'Q')
						return false;
					// Check that it is an int
					try {
					    column = Integer.parseInt(move);
					}
					catch(Exception e) {
					    System.out.print(e);
					    System.out.printf("%nPlease use an integer.%n");
					    System.out.print(currentPlayer.getName() + " > ");
					   // restart the while loop
					    continue;
					}
				}
				
				if (!board.makeMove(column, currentPlayer.getToken())) {
					column = 0;
					if (currentPlayer == user) {
    					System.out.printf("That column is full%n");
    					System.out.print(currentPlayer.getName() + " > ");
					}
				}
				// Changed so that it only outputs the column chosen by the computer if it is successful
				else if (currentPlayer == computer) {
				    System.out.println(column);
				}
				
			}
			
			if (currentPlayer == computer && board.checkVictory(computer.getToken())) {
				System.out.printf("%n%nOh no! The computer won!%n%n");	
				board.display();
				break;
			} else if (currentPlayer == user && board.checkVictory(user.getToken())) {
				System.out.printf("%n%nYou are victorious!!!%n%n");
				board.display();
				break;
			} else if (board.isFull()) {
			    System.out.printf("%n%nThis game was a draw!!%n%n");
			    board.display();
			    break;
			}
		}	
		
		return true;
	}
	
	/**
	 * Re-initializes the board variable with a new Board object.
	 * Outputs prompt to user: Enter Q to quit, or any key to keep playing:
	 * If the user enters any variation of Q, q, Quit, quit, quits the game.
	 * @return True if the user wants to quit, false otherwise.
	 */
	public boolean quit() {
	    String prompt = "Enter Q to quit, or press any key to keep playing: ";
	    System.out.printf("%s%n", prompt);
	    switch (input.next()) {
	        case "Q":
	        case "q":
	        case "Quit":
	        case "quit":
	        case "quits":
	            System.out.println("Thank you for playing.");
	            return true;
	        default:
	            board = new Board();
//	            board.reset();
	            return false;
	    }
	}

	/**
	 * If the currentPlayer is the user, returns computer. Otherwise, returns the user.
	 *
	 * @return computer if currentPlayer is user, otherwise user.
	 */
	private Player togglePlayer() {
		if (currentPlayer == user) {
		    return computer;
		}
		else {
		    return user;
		}
	}
}
