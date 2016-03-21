package sat_solver_backtracking;

/**
 * hi MY NAME IS UMAIR
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Formula {
	
    
    // list of clauses in CNF 
    private List<Clause> clauses;
    
    // The current partial or completed state for this formula
    private List <State> states;
    
    //Stack of index for backtracking
    Stack <Integer> lastIndex;
    
    // number of variables in the formula
    int numVariables;
    
    // number of clauses in the formula
    int numClauses;
    
    //True if any clause is empty
    boolean hasEmptyClause = false;
    
    
    /**
     * This constructor takes no arguments
     */
    public Formula()
    {
        clauses = new ArrayList<Clause>();
        states = new ArrayList <State> ();
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
                            c.add(new Literal(var));
                        }  
                        else{
                            c.add(new Literal(var));
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
    
    public boolean isEmpty () {
    	return clauses.isEmpty();
    }
    
    public void removeLiteral (Clause c, int index) {
    	c.remove(index);
    	if (c.values.isEmpty()) {
    		hasEmptyClause = true;
    	}
    }
}
