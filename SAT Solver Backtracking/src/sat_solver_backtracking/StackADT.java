package sat_solver_backtracking;

/**
 * Last-In First-Out List
 * @author Adam Tucker
 * @version September 22 2015
 */
public interface StackADT<E> {
	
	/**
	 * Add a value to the top of the stack
	 * @param value The value to be added to the top of the stack
	 * @return The value added to the stack
	 */
	E push (E value);
	
	/**
	 * Remove the top value from the stack
	 * @return The value removed
	 */
	E pop ();
	
	/**
	 * Look at the top value in the stack
	 * @return The reference the top value of the stack
	 */
	E peek ();
	
	/**
	 * Checks if the list is empty
	 * @return True if empty, false otherwise
	 */
	boolean isEmpty();
	
	/** 
	 * Remove all items from this Stack 
	 */
	void clear();
	/** 
	 * Check if the given value is equal to the stack
	 * @return true only if this Stack is equal to the parameter, othewise false
	 */
	boolean equals(Object other);
	
	/** 
	 * Returns elements in a list as strings
	 * @return the elements of this List as a String, with elements separated by commas, 
	 * enclosed in square brackets: [a,b,c]
	 */
	String toString( );
	
	
}
