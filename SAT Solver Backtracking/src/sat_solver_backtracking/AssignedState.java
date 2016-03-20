package sat_solver_backtracking;
/**
 * This class stores a list of Literals which are to be used to determine
 * the current values of those literals
 * 
 * @author Adam Tucker
 * @version (03/19/2016)
 */
public class AssignedState implements State
{
	boolean currState;
	
	/**
	 * Constructor for objects of class State
	 */
	public AssignedState(boolean state)
	{  
		this.currState = state;
	}
	
	public boolean isCurrState() {
		return currState;
	}

	public void setCurrState(boolean currState) {
		this.currState = currState;
	}

	public EmptyState reset()
	{
		return new EmptyState();
	}

	@Override
	public boolean empty() {
		return false;
	}
}
