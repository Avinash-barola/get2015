import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Quick_Sort_Test {

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
		Quick_Sort QS=new Quick_Sort();
		int input[]={2,5,8,9,10, 77, 55, 11};
		int result[]=QS.quickSort(input,0,7);
		int output[]={2,5,8,9,10,11,55,77};
		assertArrayEquals("",output,result);
	}
	@Test
	public void test1() {
		Quick_Sort QS=new Quick_Sort();
		int input[]={};
		int result[]=QS.quickSort(input,0,7);
		int output[]={-1};
		assertArrayEquals("",output,result);
	}

}
