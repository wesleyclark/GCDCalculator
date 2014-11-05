
public class GCDCalculatorModel {
	
	/**
     * Calculates the greatest common divisor (i.e. the largest
     * positive integer that divides two numbers without a remainder) of the first and second argument .  
     * The implementation is the recursive version of Euclid's greatest common divisor algorithm. 
     * Arguments are assumed to be non-negative.
     */

    public static int greatestCommonDivisor(int first, int second)
        {
    		if (first == 0)
    			return second;
    		if (second == 0)
    			return first;
    		if (first > second)
    			return greatestCommonDivisor(second, first % second);
    		else
    			return greatestCommonDivisor(first, second % first);
        
        }

}
