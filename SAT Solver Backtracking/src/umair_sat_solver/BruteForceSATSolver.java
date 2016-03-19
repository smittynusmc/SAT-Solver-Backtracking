package umair_sat_solver;

import java.util.Hashtable;

/**
 * The main driver class that reads a formula specification from an input file, passed
 * as command line parameter, and computes the satisfiability of the formula.
 * 
 * @author Dennis Klauder
 * @author Adam Tucker
 * @author Umair Chaudhry
 */
public class BruteForceSATSolver 
{
    
    
    /**
     * This method takes in a formula as an argument and computes its satisfiability
     * @param f a formula
     * @return void
     */
	public static void bruteForceSAT(Formula f){
        // get the number of variables in the formula f
        int numVariables = f.getNumVariables();
        
        // number of total brute force assignments to check
        double numPossibleAssignments = Math.pow(2,numVariables);
        
        // flag to indicate whether formula was satisfied or not
        boolean satisfied = false;
        
        long iteration = 0;
        while(iteration < numPossibleAssignments){            
            
            String boolString = Long.toBinaryString(iteration);
            
            while(boolString.length() < numVariables)
                boolString = "0" + boolString;
            
            if(f.evaluate(boolString)){
                //System.out.println("Formula = " + f.toString());
                System.out.println("Satisfiable = YES");
                Hashtable<Integer, Boolean> assignment = boolStringToVarAssignment(boolString);
                printAssignment(assignment);
                satisfied = true;
                break;
            }
            iteration++;
        }
        
        if(!satisfied){
            System.out.println("Satisfiable = NO");
        }
    }
    
   
	
	/**
	 * This method converts a boolean string (e.g 110) to variable assignment hash table as below 
	 * table[1] = true
	 * table[2] = true
	 * table[3] = false
	 * @param boolString a boolean String
	 * @return 
	 */
    private static Hashtable<Integer, Boolean> boolStringToVarAssignment(String boolString){
        
        Hashtable<Integer, Boolean> assignment = new Hashtable<Integer, Boolean>();
        
        for(int i=0; i < boolString.length(); i++){
            int varNumber = i+1;
            if(boolString.charAt(i) == '1'){
                assignment.put(new Integer(varNumber), Boolean.TRUE);
            }
            else{
                assignment.put(new Integer(varNumber), Boolean.FALSE);
            }
        }
        return assignment;
    }
    
    
     
    
    /**
     * This method displays the assignment to console screen in the following format:
     * (x1,x2,x3,...xn) = (true,false,truth,...false)
     * @param assignment
     */
    private static void printAssignment(Hashtable<Integer, Boolean> assignment){
        int numVars = assignment.size();
        System.out.print("(x1");
        for(int i=1; i < numVars; i++){
            System.out.print(",x"+(i+1) );
        }
        System.out.print(") = (" + assignment.get(1));
        for(int i=2; i <= numVars; i++){
            System.out.print("," + assignment.get(i) );
        }
        System.out.println(")");
    }
    
    /**
     * This method starts the execution of the program
     * @param args a String array
     */
    public static void main(String[] args)
    {
        // check whether input filename was passed as command line argument to the program
        if(args.length < 1)
        {
          System.out.println("Input filename was not passed as command line argument to the program");
            
          System.exit(0);
        }
        
        // load the formula from the input file
        Formula f = Formula.readFromFile(args[0]);
        
        // mark start time of algorithm
        long startTime = System.currentTimeMillis();
        
        // run brute force SAT algorithm
        bruteForceSAT(f);
        
        // mark end time of algorithm
        long endTime = System.currentTimeMillis();
        
        // display time taken to run the algorithm
        System.out.println("Running Time: " + (endTime - startTime) + " millisecs");
    }
}
