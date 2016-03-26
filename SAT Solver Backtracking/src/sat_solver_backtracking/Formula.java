package sat_solver_backtracking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


/*
//constructor
formulaList = new ArrayList<Clause>(500);
successState = new ArrayList <Literal> (500);
numVariables = 0; //not sure how to use
//automatic minClauseSize=Integer.MAX_VALUE;
//automatic	minClauseIndex=-1;

//variables
private List<Clause> formulaList;  //yes
private List <Literal> successState;  //yes
***** int lastIndex; //i think so, use to set literals for processing
int numVariables; //I think this is currently unused
int numClauses; //I think method is set to use formula size.
boolean hasEmptyClause = false; //auto changed while adding clauses
private int minClauseSize;  //auto changed while adding clauses
private int minClauseIndex;  //auto changed while adding clauses
 */

public class Formula {

	// list of clauses in CNF 
	private List<Clause> formulaList;

	// The current partial or completed state for this formula
	private List <Literal> successState;

	//index for backtracking
	int lastIndex;

	// number of variables in the formula
	int numVariables;

	// number of clauses in the formula
	int numClauses;

	//True if any clause is empty
	boolean hasEmptyClause = false;

	//keeps track of the smallest sized clause in the list 
	private int minClauseSize;

	//keeps track of the index the first smallest clause
	private int minClauseIndex;


	/**
	 * This constructor takes no arguments
	 */
	public Formula()
	{
		formulaList = new ArrayList<Clause>(500);
		successState = new ArrayList <Literal> (500);
		numVariables = 0;
		minClauseSize=Integer.MAX_VALUE;
		minClauseIndex=-1;
	}

	/**
	 * This method adds a clause to this formula
	 * @param c a Clause
	 * @return void
	 */
	public void addClause(Clause c)
	{
		formulaList.add(c);
		if(c.size()<minClauseSize)
		{
			minClauseSize = c.size();
			minClauseIndex = formulaList.size()+1;
			if(minClauseSize==0)
			{
				hasEmptyClause=true;
			}
		}

	}

	public boolean isEmpty () {
		return formulaList.isEmpty();
	}

	/**
	 * This method returns the number of variables in the formula
	 * @return the number of variables
	 */
	public int getNumVariables() 
	{
		return numVariables;
		//use for keeping track of index?
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
		return formulaList.size();
	}

	/**
	 * This method sets the number of clauses in the formula
	 * @param numClauses number of clauses
	 * @return void
	 */
	//public void setNumClauses(int numClauses) 
	//{
	//	this.numClauses = numClauses;
	//}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}


	public List<Literal> getSuccessState() {
		return successState;
	}

	public void removeLiteral (Formula f, int var) {
		Literal temp = new Literal (var);
		for (Clause myClauses: formulaList) {
			myClauses.evaluateClause(temp);
		}
	}

	public boolean runSolver()
	{
		if(this.isEmpty())
		{
			return true;			
		}
		if(this.hasEmptyClause)
		{
		return false;
		}
		Formula testTrue = createChild(true);
		if(testTrue.runSolver())
		{
			successState.addAll(testTrue.getSuccessState());
			successState.add(new Literal(lastIndex+1,true));
			return true;
		}
		Formula testFalse = createChild(false);
		if(testTrue.runSolver())
		{
			successState.addAll(testFalse.getSuccessState());
			successState.add(new Literal(lastIndex+1,false));
			return true;
		}
		return false;
	}
	
	public Formula createChild(boolean givenBoolean)
	{
		//new formula with modified formula
		Formula child= new Formula();
		//Creating Literal based on index# and value given. Using lastIndex until 
		//another option becomes available.
		Literal testLiteral = new Literal(lastIndex+1,givenBoolean);
		//iterator to evaluate each clause in Formula
		Iterator <Clause> itty = formulaList.iterator();
		//current working Clause
		Clause testClause; 
		//modified clause for child
		Clause resultClause;

		//loop to evaluate each Clause
		while(itty.hasNext())
		{
			testClause=itty.next();
			resultClause=testClause.evaluateClause(testLiteral);
			if(resultClause!=null)
			{
				child.addClause(resultClause);
			}

		}
		return child;
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
					//f.setNumClauses(numClauses);
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

}
