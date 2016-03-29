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

public class Formula {


	// list of clauses in CNF 
	private List<Clause> formulaList;

	// The current partial or completed state for this formula
	private List <Literal> successState;
	
	//Keeps track of the clauses removed
	Stack <List <Clause>> lastRemoved = new Stack <List <Clause>> ();

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
		//for (int i = 0; i < 500;i++) {
			//successState.add(new Literal(0,true));
		//}
		numVariables = 0;
		minClauseSize=Integer.MAX_VALUE;
		minClauseIndex=-1;
	}

	public void setSuccessState(int numVariables) {
		int size = (int) Math.pow(numVariables,2);
		successState = new ArrayList <Literal> (size);
		for (int i = 0; i < size;i++) {
		 successState.add(new Literal(0,true));
		}
		
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
		return numClauses;
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
					f.setSuccessState(numClauses);
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

	public List<Literal> getSuccessState() {
		return successState;
	}
	
	public void setFormula (int var) {
		Literal temp = new Literal (var);
		List <Clause> removed = new ArrayList <Clause> ();
		int orignalClauseSize;
		int clauseIndex;
		Iterator <Clause> formulaItty = formulaList.iterator();
		while (formulaItty.hasNext()) {
			Clause nextClause = formulaItty.next();
			orignalClauseSize = nextClause.size();
			clauseIndex = formulaList.indexOf(nextClause);
			Clause newClause = nextClause.evaluateClause(temp);
			//If the new clause is null than the clause has been satisfied
			// HasEmptyClause gets true
			if (newClause == null) {
				removed.add(nextClause);
				formulaItty.remove();
			}
			//If the newClause equals the original then
			//nothing has changed in the clause
			//Otherwise replace the original clause with the new clause
			// and add the original clause to the stack
			else if (newClause.size()!=orignalClauseSize) {
				removed.add(nextClause);
				if (newClause.clauseValues.isEmpty()) {
					hasEmptyClause = true;
				}
				formulaList.set(clauseIndex,newClause);
			}
		}
		lastRemoved.push(removed);
	}
	
	public void unsetFormula (int var) {
		List <Clause> temp = lastRemoved.pop();
		formulaList.addAll(temp);
	}
}
