package sat_solver_backtracking;

import java.util.*;
/**
 * Write a description of class Clause here.
 * 
 * @author (Dennis Klauder) 
 * @author (Adam Tucker)
 * @versionBackTracking (03-19-16)
 */
public class Clause
{	
	// Collections of literals that are either positive or negative
	List <Literal> clauseValues;

	/**
	 * Constructor for objects of class State
	 */
	public Clause()
	{  
		clauseValues = new ArrayList<Literal>(30);
	}

	/**
	 * Adds one literal into the existing Array of Literals
	 * 
	 * @param input
	 */
	public void add (Literal input)
	{
		clauseValues.add(input);
	}

	/**
	 * Adds an entire list of Literals as a clause
	 * 
	 * @param clauseList
	 */
	public void addList(List<Literal> clauseList)
	{
		clauseValues.clear();
		clauseValues.addAll(clauseList);
	}

	/**
	 * This will evaluate the Clause against the Literal provided
	 * 
	 * @param    a Literal object 
	 * @return   a List of Literals still contained in the clause. -
	 * 			- null if clause is satisfied.
	 */
	public Clause evaluateClause(Literal workingVar)
	{
		//create a duplicate list to return with modification
		List <Literal> testList=clauseValues;
		
		//create blank clause to return
		Clause returnClause = new Clause();
		
		//check list for Literal of opposite value & remove if present
		Literal removeLit = workingVar.changeValue();
		int index = testList.indexOf(removeLit);
		if(index>0)
		{
			testList.remove(index);
		}
		//check to see if Literal will satisfy Clause
		if (testList.contains(workingVar))
		{
			return null;
		}
		//saves new modified list to returnClause
		returnClause.addList(testList);
		return returnClause;
	}

	/**
	 * Returns the size of the clause as an integer.
	 * 
	 * @return	integer.
	 */
	public int size()
	{
		return clauseValues.size();		
	}

	/**
	 * toString
	 * 
	 * @return     the contents of the List in a String format
	 */
	public String toString()
	{
		String result = "{ ";
		for (int i=0;i<clauseValues.size()-1;i++)
		{
			result += clauseValues.get(i) + " or ";
		}
		result += clauseValues.get(clauseValues.size()-1)+" }";
		return result;
	}
}
