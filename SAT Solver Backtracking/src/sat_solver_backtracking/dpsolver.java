package sat_solver_backtracking;

import java.io.File;

/**
 * 
 * This class is for a backtracking SAT solver
 * 
 * @author Adam Tucker
 * @author Dennis Klauder
 * @author Umair Chaundry 
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

		/**
		if (args.length < 1) {
			System.err.println ("Usage: java dpsolver_skeleton cnf-formula");
			System.exit(0);
		}
		 */
		long start,end;

		// Insert timing code here...
		start = System.currentTimeMillis();
		File file = new File ("C:/Users/Dennis/Dropbox/School_folders/DAA/recent project code/src/umair_sat_solver/s20.cnf");
		//File file = new File ("C:/TEMP/formula.txt");
		// Insert timing code here...
		new dpsolver().solve (file.toString());
		end = System.currentTimeMillis();
		System.out.println("s20 took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File file1 = new File ("C:/Users/Dennis/Dropbox/School_folders/DAA/recent project code/src/umair_sat_solver/s28.cnf");
		new dpsolver().solve (file1.toString());
		end = System.currentTimeMillis();
		System.out.println("s28 took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File file2 = new File ("C:/Users/Dennis/Dropbox/School_folders/DAA/recent project code/src/umair_sat_solver/u15.cnf");
		new dpsolver().solve (file2.toString());
		end = System.currentTimeMillis();
		System.out.println("u15 took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File file3 = new File ("C:/Users/Dennis/Dropbox/School_folders/DAA/recent project code/src/umair_sat_solver/u27.cnf");
		new dpsolver().solve (file3.toString());		
		end = System.currentTimeMillis();
		System.out.println("u27 took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File file4 = new File ("C:/Users/Dennis/Dropbox/School_folders/DAA/recent project code/src/umair_sat_solver/u29.cnf");
		new dpsolver().solve (file4.toString());		
		end = System.currentTimeMillis();
		System.out.println("u29 took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File file5 = new File ("C:/Users/Dennis/Dropbox/School_folders/DAA/recent project code/src/umair_sat_solver/u30.cnf");
		new dpsolver().solve (file5.toString());		
		end = System.currentTimeMillis();
		System.out.println("u30 took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File file6 = new File ("C:/Users/Dennis/Dropbox/School_folders/DAA/recent project code/src/umair_sat_solver/u32.cnf");
		new dpsolver().solve (file6.toString());		
		end = System.currentTimeMillis();
		System.out.println("u32 took "+ (end-start) + "Milliseconds to process\n");

		//-----
		start = System.currentTimeMillis();
		File newfile1 = new File ("C:/Users/Dennis/workspace/ais8.cnf");
		new dpsolver().solve (newfile1.toString());		
		end = System.currentTimeMillis();
		System.out.println("ais8 took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File newfile2 = new File ("C:/Users/Dennis/workspace/coloring.cnf");
		new dpsolver().solve (newfile2.toString());		
		end = System.currentTimeMillis();
		System.out.println("coloring took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File newfile3 = new File ("C:/Users/Dennis/workspace/gs36.cnf");
		new dpsolver().solve (newfile3.toString());		
		end = System.currentTimeMillis();
		System.out.println("gs36 took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File newfile4 = new File ("C:/Users/Dennis/workspace/h50.cnf");
		new dpsolver().solve (newfile4.toString());		
		end = System.currentTimeMillis();
		System.out.println("h50 took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File newfile5 = new File ("C:/Users/Dennis/workspace/hole7.cnf");
		new dpsolver().solve (newfile5.toString());		
		end = System.currentTimeMillis();
		System.out.println("hole7 took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File newfile6 = new File ("C:/Users/Dennis/workspace/hole8.cnf");
		new dpsolver().solve (newfile6.toString());		
		end = System.currentTimeMillis();
		System.out.println("hole8 took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File newfile7 = new File ("C:/Users/Dennis/workspace/ii8a1.cnf");
		new dpsolver().solve (newfile7.toString());		
		end = System.currentTimeMillis();
		System.out.println("ii8a1 took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File newfile8 = new File ("C:/Users/Dennis/workspace/s28.cnf");
		new dpsolver().solve (newfile8.toString());		
		end = System.currentTimeMillis();
		System.out.println("s28 took "+ (end-start) + "Milliseconds to process\n");

		start = System.currentTimeMillis();
		File newfile9 = new File ("C:/Users/Dennis/workspace/u32.cnf");
		new dpsolver().solve (newfile9.toString());		
		end = System.currentTimeMillis();
		System.out.println("u32 took "+ (end-start) + "Milliseconds to process\n");
	}

}