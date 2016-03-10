package umair_sat_solver;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * This class defines a clause in a formula which is a disjunction of 
 * literals.
 * 
 * @author
 */
public class Clause {
    // list of variables that makes up the disjunction 
    private List<Literal> literals;
    
    public Clause(){
        literals = new ArrayList<Literal>();
    }
    
    // Add a literal to this clause
    public void addLiteral(Literal x){
        literals.add(x);
    }
    
    public boolean evaluate(String boolAssignment){
        for(Literal x: literals){
            int index = x.getNumber()-1;
            
            boolean value = ((boolAssignment.charAt(index) == '1')?true:false);
            if(x.evaluate(value))
                return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        String s ="("+literals.get(0).toString();
        for(int i=1; i < literals.size(); i++){
            s += " or " + literals.get(i).toString();
        }
        s += ")";
        return s;
    }
}
