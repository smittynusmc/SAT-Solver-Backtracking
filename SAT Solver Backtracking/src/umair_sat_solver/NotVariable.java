package umair_sat_solver;

/**
 * This class defines a variable with negation
 * @author
 */
public class NotVariable implements Literal{
    
    private int varNumber;
    
    public NotVariable(int number){
        varNumber = number;
    }
    
    @Override
    public boolean evaluate(boolean value) {
        return !value;
    }
 
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Variable))
            return false;
        return varNumber == ((NotVariable)obj).varNumber;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.varNumber;
        return hash;
    }
    
    @Override
    public String toString(){
        return "not(x"+varNumber+")";
    }

    @Override
    public int getNumber() {
        return varNumber;
    }
}
