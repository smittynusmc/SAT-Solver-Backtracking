package umair_sat_solver;

/**
 * This interface defines a literal which can be a variable or negation of a variable
 * 
 * @author Dennis Klauder
 * @author Adam Tucker
 * @author Umair Chaudhry
 */
public interface Literal 
{
    
    /**
     * This method gets the variable number of this literal
     * @return the number of this literal variable
     */
    public int getNumber();
    
    /**
     * This method evaluates this variable based on given truth value assignment
     * @param value boolean type
     * @return true if this literal evaluates to true with given assignment, else false
     */
    public boolean evaluate(boolean value);
}
