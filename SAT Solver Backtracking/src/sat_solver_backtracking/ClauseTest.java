package sat_solver_backtracking;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClauseTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		Clause clause1 = new Clause();
		Clause clause2 = new Clause();
		Literal onet = new Literal(1);
		Literal onef = new Literal(-1);
		Literal twot = new Literal(2);
		Literal twof = new Literal(-2);
		Literal threet = new Literal(3);
		Literal threef = new Literal(-3);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		
	}

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void testClause() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testAddList() 
	{
		assertEquals(new Clause(new ArrayList<Literal>(onet,twot, threet)),
				)
	}

	@Test
	public void testEvaluateClause() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSize() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testToString()
	{
		fail("Not yet implemented");
	}

}
