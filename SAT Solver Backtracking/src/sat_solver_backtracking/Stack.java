package sat_solver_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Stack<E> implements StackADT<E> {
	
	/** End of the List is the top of the stack */
	List <E> values;
	
	/**
	 * Default constructor
	 */
	public Stack () {
		this(true);
	}
	
	/**
	 * Parameterized Constructor for Stack class
	 * @param arrayBased True for ArrayList and false for LinkedList
	 */
	public Stack(boolean arrayBased) {
		if (arrayBased) {
			values = new ArrayList <E> ();
		}
		else {
			values = new LinkedList <E> ();
		}
	}
	
	/**
	 * Add a value to the top of the stack
	 * @param value The value to be added to the top of the stack
	 * @return The value added to the stack
	 */
	@Override
	public E push(E value) {
		values.add(value);
		return value;
	}
	
	/**
	 * Remove the top value from the stack
	 * @return The value removed
	 */
	@Override
	public E pop() {
		return values.remove(values.size()-1);
	}
	
	/**
	 * Look at the top value in the stack
	 * @return The reference the top value of the stack
	 */
	@Override
	public E peek() {
		return values.get(values.size()-1);
	}
	
	/**
	 * Checks if the list is empty
	 * @return True if empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return values.isEmpty();	
	}
	
	/** 
	 * Returns elements in a list as strings
	 * @return the elements of this List as a String, with elements separated by commas, 
	 * enclosed in square brackets: [a,b,c]
	 */
	public String toString() {
		return values.toString();
	}
	
	/** 
	 * Remove all items from this Stack 
	 */
	@Override
	public void clear() {
		values.clear();
	}
	
	/** 
	 * Check if the given value is equal to the stack
	 * @return true only if this Stack is equal to the parameter, otherwise false
	 */
	@Override
	public boolean equals(Object other) {
		return other.equals(values);
	}
}
