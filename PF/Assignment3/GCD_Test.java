import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GCD_Test {

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
		GCD G=new GCD();
		int result=G.gcd(2, 1);
		assertEquals("",1,result);
		//fail("Not yet implemented");
	}
	@Test
	public void test2() {
		GCD G=new GCD();
		int result=G.gcd(12, 18);
		assertEquals("",6,result);
		//fail("Not yet implemented");
	}
	@Test
	public void test3() {
		GCD G=new GCD();
		int result=G.gcd(100, 3);
		assertEquals("",1,result);
		//fail("Not yet implemented");
	}

}
