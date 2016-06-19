import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ActionTest 
{
	Place previousPlace = new Place("testLabelP", "testDescP");
	Place nextPlace = new Place("testLabelN", "testLabelN");
	Action test = new Action("testLabel", "testDesc", previousPlace, nextPlace);
	@Before public void setUp() throws Exception 
	{
		this.test = new Action("testLabel", "testDesc", previousPlace, nextPlace);
	}

	@After public void tearDown() throws Exception 
	{
		this.test = null;
	}
	

	/**
	 * checks accessor methods
	 */
	@Test public void checkAccessors()
	{
		assertEquals("testLabel", test.getLabel());
		assertEquals("testDesc", test.getDescription());
		assertEquals(previousPlace, test.getPrev());
		assertEquals(nextPlace, test.getNext());
	}

}
