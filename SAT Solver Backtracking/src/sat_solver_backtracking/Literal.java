package sat_solver_backtracking;
/**
 * Write a description of class Literal here.
 * 
 * This will store a boolean value and a name for uses of comparison
 * 
 * @author (Dennis Klauder) 
 * @version (2/12/16)
 */
public class Literal
{
    // instance variables - replace the example below with your own
    private boolean value;
    private int name;

    /**
     *Default Constructor for objects of class Literal
     */
    //     public Literal(String nameGiven)
    //     {
    //         value = true;
    //         name = nameGiven;
    //     }

    public Literal(int nameGiven, boolean valueGiven)
    {
        value = valueGiven;
        name = nameGiven;
    }

    public Literal (int input)
    {
        if (input <0)
        {
            value = false;
            input *= -1;
        }
        else
            value = true;
        name = input;
    }

    /**
     * @return     the boolean value of the Literal
     */
    public boolean get()
    {
        return value;
    }
	/**
	 *	@return		the name String assigned to the Literal
	 */
    public int getName()
    {
        return name;
    }
	
	/**
	 *	@parameter		allows the value of the Literal to be changed.
	 */
    public void set(boolean newValue)
    {
        value = newValue;
    }

	/**
	 *	@return		the value of the Literal as a String
	 */
    public String toString()
    {
        String result=name+" ";
        if (value)
            result += "true";
        else 
            result += "false";
        return result;
    }

    /** @return true only if this List is equal to the 
     * parameter, other 
     */
    public boolean equals (Object other)
    {
        if(!(other instanceof Literal))
        {
            return false;
        }
        Literal test = (Literal)other;
        if(!(value==test.get()&&name == (test.getName())))
        {
            return false;
        }
        return true;
    }
}
