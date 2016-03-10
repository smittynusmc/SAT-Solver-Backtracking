package umair_sat_solver;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * This class defines a formula which is a conjunction of clauses.
 * 
 * @author
 */
public class Formula {
    
    // list of clauses in CNF 
    private List<Clause> clauses;
    
    // number of variables in the formula
    int numVariables;
    
    // number of clauses in the formula
    int numClauses;
    
    public Formula(){
        clauses = new ArrayList<Clause>();
        numVariables = 0;
    }

    public int getNumVariables() {
        return numVariables;
    }

    public void setNumVariables(int numVariables) {
        this.numVariables = numVariables;
    }

    public int getNumClauses() {
        return numClauses;
    }

    public void setNumClauses(int numClauses) {
        this.numClauses = numClauses;
    }
    
    
    // Load and return a formula from a file specification
    public static Formula readFromFile(String string){
        BufferedReader br = null;
        String line = null;
        int numVars, numClauses, var;
        Formula f = new Formula();
        try {
            br = new BufferedReader(new FileReader(string));
            while((line = br.readLine()) != null){          
                if(line.startsWith("c"))
                    continue;
                if(line.startsWith("p cnf")){
                    line = line.replaceAll("\\s+", " ");
                    String[] data = line.split("[ \t]");
                    numVars = Integer.parseInt(data[2]);
                    numClauses = Integer.parseInt(data[3]);
                    f.setNumVariables(numVars);
                    f.setNumClauses(numClauses);
                }
                else{
                    Scanner sc = new Scanner(line);
                    Clause c = new Clause();
                    while(sc.hasNextInt()){
                        var = sc.nextInt();
                        if(var == 0)
                            break;
                        else if(var > 0){
                            c.addLiteral(new Variable(var));
                        }  
                        else{
                            c.addLiteral(new NotVariable(-var));
                        }
                    }
                    f.addClause(c);
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file I/O error: " + ex);
        } catch (IOException ex) {
            System.out.println("file I/O error: " + ex);
        }
        return f;
    }
    
    // Add a clause to this formula
    public void addClause(Clause c){
        clauses.add(c);
    }
    
    // Evaluate this formula based on given truth value assignments of variables
    // passed as a boolean string
    public boolean evaluate(String boolAssignment){
        for(Clause c: clauses){
            if(!c.evaluate(boolAssignment))
                return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        String s ="("+clauses.get(0).toString();
        for(int i=1; i < clauses.size(); i++){
            s += " and " + clauses.get(i).toString();
        }
        s += ")";
        return s;
    }
    
    
}
