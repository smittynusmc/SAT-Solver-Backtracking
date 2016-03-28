package sat_solver_backtracking;

import java.io.File;

/**
 * 
 * This material is based upon work supported by 
 * the National Science Foundation under Grant No. 1140753.
 * 
 * This class is for a backtracking SAT solver
 * 
 * @author Dr. Andrea Lobo
 * @author Dr. Ganesh R. Baliga
 * @author Adam Tucker
 * @author Dennis Klauder
 * @author Umair Chaundry 
 * 
 *
 */


public class dpsolver {

	Formula formula;
	// Read the provided input formula
	void readFormula ( String fileName ) {
		formula = Formula.readFromFile(fileName);
	}
/*
	// Returns true if the formula has an empty clause, false otherwise
	//this is included in the Formula Class
	boolean hasEmptyClause ( Formula f ) {
		return f.hasEmptyClause;
	}

	// Returns true if the formula has no clauses left, false otherwise
	//this is included in the Formula Class
	boolean isEmpty ( Formula f ) {
		return f.isEmpty();
	}
	*/

	// Return branch variable.
	int selectBranchVar ( Formula f ) {
		return f.lastIndex;
	}

	// Set given variable to given true/false value
	// Variable value may be positive or negative
	void setVar (int var, Formula f, boolean tf) {
		// If tf is true the new literal will be true and positive
		// Else the new literal will be false and negative
		if (tf) {
			f.getSuccessState().add(var, new Literal (var));
			//f.removeLiteral(f, var);
		}
		else {
			f.getSuccessState().add(var, new Literal (-var));
			//f.removeLiteral(f, -var);
		}

	}

	// Set given variable to "unassigned" in the given formula
	void unset ( int var, Formula f) {
		// Stub

	}

	// Formula is satisfiable
	void success (Formula f) {
		// Stub		
		System.out.println ( "Formula is satisfiable");

		// Print satisfying assignment
		System.out.println(f.getSuccessState());
	}

	// Formula is unsatisfiable
	void failure (Formula f) {
		// Stub		
		System.out.println ("Formula is unsatisfiable");

	}

	public void solve ( String fileName ) {

		formula = Formula.readFromFile(fileName);

		if (formula.runSolver())
			success ( formula );
		else
			failure ( formula );

	}

	// Recursive backtracking solution
	boolean dp ( Formula formula ) {

		Formula child = formula;
		if (child.isEmpty()) // First base case: solution found
			return true;
		else if (child.hasEmptyClause) // Second base case: dead end found
			return false;
		else {

			// Pick a branch variable
			int var = selectBranchVar (child); 

			// Try to set var = true in the formula

			setVar (var, child, true);

			if (dp(child)) 
				return true;
			else {

				// Unset var in the formula 
				unset (var, formula);

				// Setting var to true did not work. 
				// Now try var = false

				setVar ( var, formula, false );

				if (dp (formula))
					return true;
				else {
					// Neither true nor false worked, so unset the branch 
					// variable and head back
					unset ( var, formula );
					return false;			
				}
			}
		}	
	}


	public static void main(String[] args) {
		
		/**
		if (args.length < 1) {
			System.err.println ("Usage: java dpsolver_skeleton cnf-formula");
			System.exit(0);
		}
		*/

		// Insert timing code here...
		File file = new File ("C:/TEMP/formula.txt");
		// Insert timing code here...
		new dpsolver().solve (file.toString());

	}

}