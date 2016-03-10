package umair_sat_solver;

/**
 * This class defines a variable of a formula
 * @author 
 */
public class Variable implements Literal{
    // the number of this literal variable
    private int varNumber;
    
    public Variable(int number){
        varNumber = number;
    }
    
    // Get the variable number of this literal
    @Override
    public int getNumber(){
        return varNumber;
    }
    
    // evalute this literal based on the given truth assignment
    @Override
    public boolean evaluate(boolean value){
        return value;
    }
    
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Variable))
            return false;
        return varNumber == ((Variable)obj).varNumber;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.varNumber;
        return hash;
    }
    
    @Override
    public String toString(){
        return "x"+varNumber;
    }
}
