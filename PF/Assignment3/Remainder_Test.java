import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Remainder_Test {

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
	public void test1() 
	{
		Remainder R=new Remainder();
		int result=R.rem(2, 1);
		assertEquals("",0,result);
	}
	@Test
	public void test2() 
	{
		Remainder R=new Remainder();
		int result=R.rem(2, 0);
		assertEquals("",-1,result);
	}
	@Test
	public void test3() 
	{
		Remainder R=new Remainder();
		int result=R.rem(100, 3);
		assertEquals("",1,result);
	}

}
