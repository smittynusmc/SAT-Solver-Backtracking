package sat_solver_backtracking;

import java.io.File;

/**
 * 
 * This class is the main driver for a backtracking SAT solver
 * 
 * @author Adam Tucker
 * @author Dennis Klauder
 * @author Umair Chaundhry 
 * @version 03/30/2016
 *
 */


public class dpsolver {

	Formula formula;

	/**
	 * Print out "Formula is satisfiable" and the formula success state
	 * A success state is a solution to the given formula
	 * @param f The successful formula
	 */
	void success (Formula f) {

		System.out.println ( "Formula is satisfiable");

		System.out.println(f.getSuccessState());
	}

	/**
	 * Print out "Formula is unsatisfiable"
	 * @param f The failed formula
	 */
	void failure (Formula f) {	
		System.out.println ("Formula is unsatisfiable");

	}
	
	/**
	 * Takes a files name as a string and parses the file to create
	 * the formula that will be evaluated
	 * @param fileName The file name as a string to be parsed
	 */
	public void solve ( String fileName ) {

		formula = Formula.readFromFile(fileName);

		if (formula.runSolver())
			success ( formula );
		else
			failure ( formula );

	}
	
	/**
	 * Main method for this SAT solver
	 * @param args The file to be parse
	 */
	public static void main(String[] args) {

		
		if (args.length < 1) {
			System.err.println ("Usage: java dpsolver cnf-formula");
			System.exit(0);
		}
		 

		        
        // mark start time of algorithm
        long startTime = System.currentTimeMillis();
        
        dpsolver dpsk = new dpsolver();
        
        dpsk.solve(args[0]);
        
        // mark end time of algorithm
        long endTime = System.currentTimeMillis();
        
        // display time taken to run the algorithm
        System.out.println("Running Time: " + (endTime - startTime) + " millisecs");
	}

}