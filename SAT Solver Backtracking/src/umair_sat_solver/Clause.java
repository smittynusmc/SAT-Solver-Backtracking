package umair_sat_solver;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines a clause in a formula which is a disjunction of 
 * literals.
 * 
 * @author Dennis Klauder
 * @author Adam Tucker
 * @author Umair Chaudhry
 * 
 * 
 */
public class Clause 
{
    // list of variables that makes up the disjunction 
    private List<Literal> literals;
    
    /**
     * This constructor takes no arguments
     * It initializes the ArrayList of Literals
     */
    public Clause()
    {
        literals = new ArrayList<Literal>();
    }
    
    /**
     * This method adds a literal to this clause
     * @param x a literal
     * 
     */
    public void addLiteral(Literal x)
    {
        literals.add(x);
    }
    
    /**
     * This method evaluates the Clause
     * @param boolAssignment a String
     * @return a boolean value
     */
    public boolean evaluate(String boolAssignment)
    {
        for(Literal x: literals)
        {
            int index = x.getNumber()-1;
            
            boolean value = ((boolAssignment.charAt(index) == '1')?true:false);
            if(x.evaluate(value))
                return true;
        }
        return false;
    }
    
    /**
     * This method returns the String representation of the Clause
     * @return a String
     */
    public String toString(){
        String s ="("+literals.get(0).toString();
        for(int i=1; i < literals.size(); i++){
            s += " or " + literals.get(i).toString();
        }
        s += ")";
        return s;
    }
}
