
/**
 * This class serves as a utility class containing only static methods about ordinal numbers.
 * @author Jenne Stamplecoskie
 * @version 1.0
 * @since 1.8
 *
 */
public class Ordinal {

	/**
	 * Returns the ordinal value of the specified integer value.
	 * 
	 * @param integer A cardinal integer value.
	 * @return The ordinal value of the cardinal integer value.
	 */
	public static String getOrdinal(int integer) {
	    String ordinal = "";
		// hint: use modulus division and a switch statement
	    switch(integer % 10){
	    case 1:
	        ordinal =  "first";
	        break;
	    case 2:
	        ordinal =  "second";
	        break;
	    case 3:
	        ordinal =  "third";
	        break;
	    case 4:
	        ordinal =  "fourth";
	        break;
       case 5:
            ordinal =  "fifth";
            break;
       case 6:
            ordinal =  "sixth";
            break;
	    }
	    return ordinal;
	}
	
}
