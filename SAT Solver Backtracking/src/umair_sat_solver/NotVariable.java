package umair_sat_solver;

/**
 * This class defines a variable with negation and implements Literal interface
 * @author Dennis Klauder
 * @author Adam Tucker
 * @author Umair Chaudhry
 */
public class NotVariable implements Literal{
    
    private int varNumber;
    
    /**
     * This constructor has one integer as a Parameter
     * @param number Integer
     * 
     */
    public NotVariable(int number){
        varNumber = number;
    }
    
    /**
     * This method evaluates this literal based on the given truth assignment
     * @param value a boolean variable
     * @return a boolean value
     */
    public boolean evaluate(boolean value) {
        return !value;
    }
 
    /**
     * This method overrides the equals() method
     * @param Object a variable of Object type
     * @return a boolean value
     */
    public boolean equals(Object obj){
        if(!(obj instanceof Variable))
            return false;
        return varNumber == ((NotVariable)obj).varNumber;
    }

    /**
     * This method overrides the hashCode method
     * @return an integer
     */
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.varNumber;
        return hash;
    }
    
    /**
     * This method returns the String representation of the Variable Object
     * @return a String
     */
    public String toString(){
        return "not(x"+varNumber+")";
    }

    /**
     * This method gets the variable number of this literal
     * @return an integer
     */
    public int getNumber() {
        return varNumber;
    }
}
