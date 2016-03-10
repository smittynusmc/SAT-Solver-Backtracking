package umair_sat_solver;


import java.io.File;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

/**
 * The main driver class that reads a formula specification from an input file, passed
 * as command line parameter, and computes the satisfiability of the formula.
 * 
 * @author
 */
public class BruteForceSATSolver {

	static Random rand = new Random();

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

	// Convert a boolean string (e.g 110) to variable assignment hash table as below
	// table[1] = true
	// table[2] = true
	// table[3] = false
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

	// Display the assignment to console screen in the following format
	// (x1,x2,x3,...xn) = (true,false,truth,...false)
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

	public static void main(String[] args){
		// check whether input filename was passed as command line argument to the program
		if(args.length < 1){
			System.out.println("Usage: java BruteForceSATSolver <INPUT-FILE>");
			System.out.println("where INPUT-FILE is the file containing formula specs.\n");
			System.exit(0);
		}

		// load the formula from the input file
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a file directory \n"
				+ "Copy the file path/address and paste it in the command line");
		
		//The rest of the code propmpts the user for a the directory to a folder
		//and processes each file in the folder
		String directory = sc.nextLine();
		sc.close();

		Formula f = null;
		File folder = new File(directory);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile())
				System.out.println(file.toString());
				f = Formula.readFromFile(file.toString());


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
}
