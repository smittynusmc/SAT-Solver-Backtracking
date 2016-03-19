package umair_sat_solver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class defines a formula which is a conjunction of clauses.
 * 
 * @author Dennis Klauder
 * @author Adam Tucker
 * @author Umair Chaudhry
 * 
 */
public class Formula 
{
    
    // list of clauses in CNF 
    private List<Clause> clauses;
    
    // number of variables in the formula
    int numVariables;
    
    // number of clauses in the formula
    int numClauses;
    
    /**
     * This constructor takes no arguments
     */
    public Formula()
    {
        clauses = new ArrayList<Clause>();
        numVariables = 0;
    }

    /**
     * This method returns the number of variables in the formula
     * @return the number of variables
     */
    public int getNumVariables() 
    {
        return numVariables;
    }

    
    /**
     * This method sets the number of variables in the formula
     * @param numVariables number of variables
     * @return void
     */
    public void setNumVariables(int numVariables) 
    {
        this.numVariables = numVariables;
    }

    /**
     * This method returns the number of clauses in the formula
     * @return the number of clauses
     */
    public int getNumClauses() 
    {
        return numClauses;
    }

    
    /**
     * This method sets the number of clauses in the formula
     * @param numClauses number of clauses
     * @return void
     */
    public void setNumClauses(int numClauses) 
    {
        this.numClauses = numClauses;
    }
    
    
    /**
     * This method loads and returns a formula from a file specification
     * @param filename name of the file containing the formula
     * @return the Formula
     */
    public static Formula readFromFile(String filename)
    {
        BufferedReader br = null;
        String line = null;
        int numVars, numClauses, var;
        Formula f = new Formula();
        try {
            br = new BufferedReader(new FileReader(filename));
            while((line = br.readLine()) != null){          
                if(line.startsWith("c"))
                    continue;
                if(line.length() == 0)
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
                    sc.close();
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
    
    /**
     * This method adds a clause to this formula
     * @param c a Clause
     * @return void
     */
    public void addClause(Clause c)
    {
        clauses.add(c);
    }
    
    /**
     * This method evaluates this formula based on given truth value assignments of variables 
     * passed as a boolean string
     * @param boolAssignment a String
     * @return a boolean value
     */
    public boolean evaluate(String boolAssignment)
    {
        for(Clause c: clauses){
            if(!c.evaluate(boolAssignment))
                return false;
        }
        return true;
    }
    
    /**
     * This method returns the String representation of the formula
     * @return a String
     */
    public String toString()
    {
        String s ="("+clauses.get(0).toString();
        for(int i=1; i < clauses.size(); i++){
            s += " and " + clauses.get(i).toString();
        }
        s += ")";
        return s;
    }
    
    
}

