package src_Tucker.sat_solver2;

import java.util.*;
/**
 * This class stores a list of Literals which are to be used to determine
 * the current values of those literals
 * 
 * @author (Dennis Klauder) 
 * @version (2/13/16)
 */
public class State
{
	ArrayList <Literal> values;
	/**
	 * Constructor for objects of class State
	 */
	public State(int size)
	{  
		values = new ArrayList<Literal>(size);
		for(int i=0;i<size;i++)
		{
			values.add(new Literal (i+1));
		}
	}

	public State() {
		values = new ArrayList <Literal> (30);
	}

	public void reset()
	{
		for(int i=0;i<values.size();i++)
		{
			values.get(i).set(true);
		}
	}

	public int size()
	{
		return values.size();
	}


	/**
	 * advances the list to the next state of Literals
	 */
	public void next()
	{
		int i = 0;

		boolean loop = true;        
		//mirror list with another list for changes?

		while (loop&&i<values.size())
		{
			if (values.get(i).get())
			{
				values.get(i).set(false);
				loop = false;
			}
			else
			{
				values.get(i).set(true);
			}
			i++;
		}
	}

	/**
	 * @param       int (index/name)
	 * @returns     the Literal at that arrayList location
	 */
	public Literal get(int name)
	{
		return values.get(name-1);
	}

	/**
	 * @param       int (index/name)
	 * @returns     the value of the Literal at that arrayList location
	 */
	public boolean getValue(int name)
	{
		return values.get(name-1).get();
	}

	/**
	 * @returns     a complete list of the current state of the Literals
	 */
	public List getAll()
	{
		return values;
	}

	/**
	 * toString
	 * @return     the contents of the List in a String format
	 */
	public String toString()
	{
		return values.toString();
	}

	public String printAll()
	{
		String result = "{ ";
		for(int i = 0; i<values.size();i++)
		{
			result += (values.get(i).getName() + ", "+ values.get(i).get())+": ";
		}
		result += " }";
		return result;
	}

	/**
	 * @returns     boolean if the Literal is contained within the ArrayList
	 */
	public boolean checkValue(Literal value)
	{
		//System.out.println(this.get(Integer.parseInt(value.getName())).equals(value));
		return this.get(Integer.parseInt(value.getName())).equals(value);
	}

	/**
	 * @returns     boolean if the Literal is contained within the ArrayList
	 */
	public boolean contains(Literal value)
	{
		return values.contains(value);
	}
}
