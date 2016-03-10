package umair_sat_solver;


/**
 * Defines a literal which can be a variable or negation of a variable
 * 
 * @author
 */
public interface Literal {
    
    /**
     * Get the variable number of this literal
     * @return the number of this literal variable
     */
    public int getNumber();
    
    /**
     * Evaluate this variable based on given truth value assignment
     * @param value
     * @return true if this literal evaluates to true with given assignment, else false
     */
    public boolean evaluate(boolean value);
}
