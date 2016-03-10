package src_Tucker.sat_solver2;

import java.util.*;
/**
 * This contains a list that holds and evaluates Clauses.
 * 
 * This will also manage the state.
 * 
 * @author (Dennis Klauder) 
 * @version (2/13/16)
 */
public class Formula
{
	ArrayList <Clause> values;
	State tester;

	/**
	 * Constructor for objects of class Formula
	 */
	public Formula(int size)
	{  
		values = new ArrayList<Clause>(size);
		for(int i=0;i<size;i++)
		{
			values.add(new Clause ());
		}

	}

	public Formula(int numClauses, int numLiterals) {
		tester = new State (numLiterals);

		values = new ArrayList<Clause>(numClauses);
		for(int i=0; i<numClauses; i++)
		{
			values.add(new Clause ());
		}
	}

	public void add(Literal value, int index)
	{
		values.get(index).add(value);
	}

	public void add(List <Literal> list, int index)
	{
		values.get(index).addList(list);
	}

	public Clause get(int name)
	{
		return values.get(name-1);
	}

	public boolean evaluate(State state)
	{
		boolean success = true;
		int j=1;
		do {
			int i = 0;
			success = true;
			while(i<values.size()&&success)
			{
				//System.out.println("Number clause" + i);
				//System.out.println(this.get(i+1));
				success= this.get(i+1).evaluate(state);
				i++;
				
			}
			if (success) {
				return success;
			}
			state.next();
			j++;
		}
		while(j<Math.pow(2, state.values.size()));

		return success;
	}
	//     public List getAll()
	//     {
	//         return values;
	//     }

	public void begin()
	{
		int i = 1;
		tester.reset();
		boolean solution=false;
		do
		{
			solution=this.evaluate(tester);
			//System.out.println(tester);
			i++;
		}
		while(!(solution)&&i<=tester.values.size());
		if(solution)
		{
			//System.out.println(tester);
			System.out.println("Satisfiable");
		}
		else
		{
			System.out.println("Unsatisfiable");
		}
	}


	/**
	 * toString
	 * 
	 * @return     the contents of the List in a String format
	 */
	public String toString()
	{
		String result = "{ " + values.get(0);
		for (int i=1;i<=values.size()-1;i++)
		{
			result += " and \n" + values.get(i) ;
		}
		result += " }";
		return result;
	}
}
