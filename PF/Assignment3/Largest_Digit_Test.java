import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Largest_Digit_Test {

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
	public void test1() {
		Largest_Digit LD=new Largest_Digit();
		int result=LD.largestDigit(2);
		assertEquals("",2,result);
		//fail("Not yet implemented");
	}
	@Test
	public void test2() {
		Largest_Digit LD=new Largest_Digit();
		int result=LD.largestDigit(1257369);
		assertEquals("",9,result);
		//fail("Not yet implemented");
	}
	@Test
	public void test3() {
		Largest_Digit LD=new Largest_Digit();
		int result=LD.largestDigit(444);
		assertEquals("",4,result);
		//fail("Not yet implemented");
	}

}
