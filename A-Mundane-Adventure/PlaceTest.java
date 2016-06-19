import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Note that some methods in Place do not have tests because their functionality is not implemented yet
 *
 */
public class PlaceTest 
{
	Place test = new Place("testLabel", "testDesc");

	@Before public void setUp() throws Exception 
	{
		test = new Place("testLabel", "testDesc");
	}

	@After public void tearDown() throws Exception 
	{
		test = null;
	}

	
	/**
	 * checks "get" accessor methods
	 */
	@Test public void checkGets()
	{
		assertEquals("testLabel", test.getLabel());
		assertEquals("testDesc", test.getDescription());
		
	}
	
	
	
	/**
	 * checks "set" accessor methods
	 */
	@Test public void checkSets()
	{
		test.setDescription("foo");
		test.setLabel("fooey");
		assertEquals("foo", test.getDescription());
		assertEquals("fooey", test.getLabel());
	}

	
	
	
	/**
	 * checks Item-related methods
	 * ignored unlock and lock methods because not implemented in Game
	 */
	@Test public void checkItems()
	{
		Item item1 = new Item("1", "test");
		Item item2 = new Item("2", "test");
		test.addItem(item1);
		test.addItem(item2);
		assertEquals(item2, test.getItemList().get(1));
		test.removeItem(item1);
		assertEquals(item2, test.getItemList().get(0));
		assertEquals(null, test.getItemList().get(1));
		
	}
}
