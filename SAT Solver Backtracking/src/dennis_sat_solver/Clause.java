package src_Tucker.sat_solver2;

import java.util.*;
/**
 * Write a description of class Clause here.
 * 
 * @author (Dennis Klauder) 
 * @version (2-13-16)
 */
public class Clause
{
    ArrayList <Literal> values;
    /**
     * Constructor for objects of class State
     */
    public Clause()
    {  
        values = new ArrayList<Literal>(30);

    }

    public Literal get(int name)
    {
        if(name >= values.size())
            return null;
        return values.get(name-1);
    }

    public boolean getValue(int name)
    {
        return values.get(name-1).get();
    }

    public List  getAll()
    {
        return values;
    }

    public void add (Literal input)
    {
        values.add(input);
    }

    public void addList(List<Literal> list)
    {
        values.clear();
        values.addAll(list);
    }

    /**
     * This will evaluate the Clause against the state contained in the State class used as a parameter
     * 
     * @param    a State class 
     * @return   boolean response if the state will satisfy the clause
     */
    public boolean evaluate(State state)
    {
        boolean sucess = false;
        int i=0;
        while(i<values.size()&&(!sucess))
        {	
            sucess=state.checkValue(values.get(i));
            i++;
        }
        return sucess;
    }

    /**
     * This will evaluate the Clause against the state contained in the list used as a parameter
     * 
     * @param    a list 
     * @return   boolean response if the state will satisfy the clause
     */
    public boolean evaluate(List state)
    {
        boolean sucess = false;
        int i=0;
        while(i<values.size()&&(!sucess))
        {
        	System.out.println(i);
            Literal test = values.get(i);
            sucess = state.get((Integer.parseInt(test.getName()))-1).equals(test);
            i++;
        }
        return sucess;
    }

    /**
     * toString
     * 
     * @return     the contents of the List in a String format
     */
    public String toString()
    {
        String result = "{ ";
        for (int i=0;i<values.size()-1;i++)
        {
            result += values.get(i) + " or ";
        }
        result += values.get(values.size()-1)+" }";
        return result;
    }
}
