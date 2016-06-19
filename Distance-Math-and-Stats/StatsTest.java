import static org.junit.Assert.*;

import org.junit.*;

public class StatsTest 
{
	
	//class fields and test cases
	private Stats test;
	private Stats test2;
	private Stats test3;
	private int[] testData1 = {0, 1, 2, 3, 4};
	private int[] testData2 = {0};
	private int[] testData3 = {};
	
	@BeforeClass public static void beforeClass() {}
	@AfterClass  public static void  afterClass() {}
	@Before      public        void      before() 
	{
		this.test  = new Stats(testData1); 
		this.test2 = new Stats(testData2); 
		this.test3 = new Stats(testData3);
	}
	@After       public        void       after() 
	{
		this.test  = null; 
		this.test2 = null; 
		this.test3 = null;
	}
	
	
	/**
	 * tests to make sure the constructors and setValue methods work
	 * reliant on user to test for certain mistakes such as negative values, wrong data types
	 */
	@Test public void checkConstructors()
	{ 
		assertArrayEquals(testData1, test.data);
		test.setValues   (5);
		assertArrayEquals(testData1, test.data);
		test.setValues   (testData1);
		assertArrayEquals(testData1, test.data);
		test.setValues   (testData2);
		assertArrayEquals(testData2, test.data);
		test.setValues   (testData3);
		assertArrayEquals(testData3, test.data);
		test.setValues(null); //does nothing; make sure error message pops up
	}//end test
	
	
	
	
	/**
	 * checks to make sure getSize() is working with all three test data examples
	 */
	@Test public void checkGetSize()
	{ 
		assertEquals(5, test .getSize());
		assertEquals(1, test2.getSize());
		assertEquals(0, test3.getSize());
	}
	
	
	
	
	/**
	 * checks to make sure toString() works with all three test data examples
	 */
	@Test public void checkToString()
	{
		assertEquals("{0, 1, 2, 3, 4}", test .toString());
		assertEquals("{0}"        ,     test2.toString());
		assertEquals("{}"         ,     test3.toString());
	}
	
	
	
	
	/**
	 * checks to make sure getMax() works using all three test data examples
	 */
	@Test public void checkGetMax()
	{ 
		assertEquals(4,  test .getMax());
		assertEquals(0,  test2.getMax());
		assertEquals(-1, test3.getMax());
	}
	
	
	
	
	/**
	 * checks to make sure getMin() works using all three test data examples
	 */
	@Test public void checkGetMin()
	{ 
		assertEquals(0,  test .getMin());
		assertEquals(0,  test2.getMin());
		assertEquals(-1, test3.getMin());
	}

	
	
	
	/**
	 * checks to make sure getTotal() works using all three test data examples
	 */
	@Test public void checkGetTotal()
	{
		assertEquals(10, test .getTotal());
		assertEquals(0,  test2.getTotal());
		assertEquals(-1, test3.getTotal());
	}
	
	
	
	
	/**
	 * checks to make sure getAverage() works using all three test data examples
	 */
	@Test public void checkGetAverage()
	{ 
		assertEquals(2,  test .getAverage(), .1);
		assertEquals(0,  test2.getAverage(), .1);
		assertEquals(-1, test3.getAverage(), .1);
	}//end method
	
	
	
	
	/**
	 * checks to make sure checkReplace() works using all three test data examples
	 * also checks to make sure nothing goes wrong when nothing is replaced
	 * checks that this.data changes and remains the same when it's supposed to
	 */
	@Test public void checkReplace()
	{ 
		assertEquals(1, test. replace(0, 1));
		assertEquals("{1, 1, 2, 3, 4}", test.toString());
		assertEquals(0, test. replace(0, 1));
		assertEquals("{1, 1, 2, 3, 4}", test.toString());
		assertEquals(1, test2.replace(0, 1));
		assertEquals("{1}", test2.toString());
		assertEquals(0, test2.replace(0, 1));
		assertEquals("{1}", test2.toString());
		assertEquals(0, test3.replace(0, 1));
		assertEquals("{}", test3.toString());
	}//end method
	
}//end class
