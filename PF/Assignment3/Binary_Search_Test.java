import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Binary_Search_Test {

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
	public void test() {
		Binary_Search BS=new Binary_Search();
		int input[]={2,5,8,9,10, 55, 77};
		int result=BS.binarySearch(input, 88, 0, 6, 3);
		assertEquals(-1,result);
	}
	@Test
	public void test1() {
		Binary_Search BS=new Binary_Search();
		int input[]={2,5,8,9,10, 55, 77};
		int result=BS.binarySearch(input, 77, 0, 6, 3);
		assertEquals(7,result);
	}
	
	

}
