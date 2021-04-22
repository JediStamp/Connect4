package game;
import javax.swing.JFrame;
/**
 * This class kicks off the game NibbleNabble, and continues playing until the user quits.
 * 
 * @author Jenne Stamplecoskie
 * CST8110 - Introduction to Computer Programming
 * Section: 800
 * Semester: 20F
 * Professor: Jangam Piyush
 * Practical Assessment 2
 */
public class Main {
	/**
	 * The main method declares a new instance of the game NibbleNabble.
	 * Execute the playGame method while the quit method continues to return false.
	 * If the playGame method returns false, exit the loop.
	 * 
	 * @param args UNUSED
	 */
	public static void main(String[] args) {
	    //Frame for GUI
	    JFrame frame = new JFrame("Connect Four");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		NibbleNabble connect4 = new NibbleNabble();
		do {
		    if (!connect4.playGame()) {
		        System.out.println("Thank you for playing.");
		        return;
		    }
		} while (!connect4.quit());
	}
	
}
