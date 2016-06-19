import static org.junit.Assert.*;

import org.junit.*;

public class DistanceMathTest 
{
	//class fields
	private String cm = "cm";
	private String in = "in";
	private String ft = "ft";
	private String m  = "m";
	
	
	@BeforeClass public static void beforeClass() {}
	@AfterClass  public static void afterClass () {}
	@Before      public        void before     () {}
	@After       public        void after      () {}
	
	
	/**
	 * checks to see that no errors occur in regards to units
	 * only necessary to test using one method because they both call the same methods
	 */
	@Test public void checkDistanceUnits()
	{
		assertEquals(Double.NaN, DistanceMath.addDistance(1, "floob", 1, in), .01);
		assertEquals(Double.NaN, DistanceMath.addDistance(1,  in, 1, "goob"), .01);
		assertEquals(Double.NaN, DistanceMath.addDistance(1, "floob", 1, "goob"), .01);
		assertEquals(Double.NaN, DistanceMath.addDistance(1, null, 1, cm), .01);
		assertEquals(Double.NaN, DistanceMath.addDistance(1, cm, 1, null), .01);
		assertEquals(Double.NaN, DistanceMath.addDistance(1, null, 1, null), .01);
		assertEquals(Double.NaN, DistanceMath.addDistance(1, "", 1, ""), .01);
		assertEquals(Double.NaN, DistanceMath.addDistance(1, "", 1, in), .01);
		assertEquals(Double.NaN, DistanceMath.addDistance(1, in, 1, ""), .01);
		assertEquals(2, DistanceMath.addDistance(1, cm, 1, cm), .01);
	}

	
	

	/**
	 * checks to make sure all possible forms of unit conversion are correct.
	 * only necessary to test using one method because the other one does the exact same thing but with multiplication
	 */
	@Test public void checkMath()
	{
		assertEquals(10, DistanceMath.addDistance(5, cm, 5, cm), .001);
		assertEquals(17.7, DistanceMath.addDistance(5, cm, 5, in), .001);
		assertEquals(157.4, DistanceMath.addDistance(5, cm, 5, ft), .001);
		assertEquals(505, DistanceMath.addDistance(5, cm, 5, m), .001);
		assertEquals(6.96850394, DistanceMath.addDistance(5, in, 5, cm), .001);
		assertEquals(65, DistanceMath.addDistance(5, in, 5, ft), .001);
		assertEquals(201.850394, DistanceMath.addDistance(5, in, 5, m), .001);
		assertEquals(5.16404199, DistanceMath.addDistance(5, ft, 5, cm), .001);
		assertEquals(5.41666667, DistanceMath.addDistance(5, ft, 5, in), .001);
		assertEquals(21.4041995, DistanceMath.addDistance(5, ft, 5, m), .001);
		assertEquals(5.05, DistanceMath.addDistance(5, m, 5, cm), .001);
		assertEquals(5.12700, DistanceMath.addDistance(5, m, 5, in), .001);
		assertEquals(6.52400, DistanceMath.addDistance(5, m, 5, ft), .001);
	}
	
}//end class
