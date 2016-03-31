package sat_solver_backtracking;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Adam Tucker
 * @author Dennis Kluader
 * @author Umair Chaudry
 * @version 03/30/2016
 *
 */

public class LiteralTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLiteralIntBoolean() 
	{
		Literal test1=new Literal(3,true);
		Literal test2=new Literal(-5,false);
		assertEquals(test1.getName(),3);
		assertEquals(test1.get(),true);
		assertEquals(test2.getName(),5);
		assertEquals(test2.get(),false);

	}

	@Test
	public void testLiteralInt() 
	{
		Literal test3 =new Literal(-1);
		Literal test4 =new Literal(514);
		Literal test5 =new Literal(1);
		assertEquals(test3.getName(),1);
		assertEquals(test4.getName(),514);
		assertEquals(test5.getName(),1);
		assertEquals(test3.get(),false);
		assertEquals(test4.get(),true);
		assertEquals(test5.get(),true);
	}

	@Test
	public void testGet() 
	{
		Literal test6 =new Literal(-231,true);
		Literal test7 =new Literal(-5);
		Literal test8 =new Literal(-589,false);
		Literal test9 =new Literal(9184);
		assertEquals(test6.get(),true);
		assertEquals(test7.get(),false);
		assertEquals(test8.get(),false);
		assertEquals(test9.get(),true);
	}

	@Test
	public void testGetName() {
		Literal test6 =new Literal(-231,true);
		Literal test7 =new Literal(-5);
		Literal test8 =new Literal(-589,false);
		Literal test9 =new Literal(9184);
		assertEquals(test6.getName(),231);
		assertEquals(test7.getName(),5);
		assertEquals(test8.getName(),589);
		assertEquals(test9.getName(),9184);
	}

	@Test
	public void testSet() {
		Literal test6 =new Literal(-231,true);
		Literal test7 =new Literal(-5);
		assertEquals(test6.get(),true);
		assertEquals(test7.get(),false);
		
		test6.set(false);
		assertEquals(test6.get(),false);
		test6.set(true);
		assertEquals(test6.get(),true);
		test6.set(false);
		assertEquals(test6.get(),false);
		test7.set(true);
		assertEquals(test7.get(),true);
		test7.set(false);
		assertEquals(test7.get(),false);
		test7.set(true);
		assertEquals(test7.get(),true);
		
	}

	@Test
	public void testChangeValue() {
		Literal test6 =new Literal(-231,true);
		Literal returnLit = test6.changeValue();
		assertEquals(test6.get(),true);
		assertEquals(test6.getName(),231);
		assertEquals(returnLit.get(),false);
		assertEquals(returnLit.getName(),231);
	}

	@Test
	public void testToString() {
		Literal test6 =new Literal(-231,true);
		Literal test7 =new Literal(-5);
		Literal test8 =new Literal(-589,false);
		Literal test9 =new Literal(9184);
		assertEquals(test6.toString(),"231 true");
		assertEquals(test7.toString(),"5 false");
		assertEquals(test8.toString(),"589 false");
		assertEquals(test9.toString(),"9184 true");
	}

	@Test
	public void testEqualsObject() {
		assertEquals(new Literal(-231),new Literal(231,false));
		assertEquals(new Literal(9682),new Literal(9682,true));
		assertEquals(new Literal(8574,false),new Literal(-8574));
		assertEquals(new Literal(-851,true),new Literal(851));
		
	}

	

}
