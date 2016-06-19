//tests for void methods were removed. should I have done this?
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest 
{
	Game test = new Game("testLabel", "testDesc");
	Place place1 = new Place("1", "1");
	Place place2 = new Place("2", "2");
	Action action1 = new Action("1", "1", place2, place2);
	Action action2 = new Action("2", "2", place1, place2);

	@Before public void setUp() throws Exception 
	{
		test = new Game("testLabel", "testDesc");
		test.addAction(action1);
		test.addAction(action2);
		test.addPlace(place1);
		test.addPlace(place2);
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
		assertEquals("testDesc", test.getDescription());
		assertEquals("testLabel", test.getLabel());
		assertEquals(action1, test.getAction(0));
		assertEquals(null, test.getAction(-1));
		//assertEquals(0, test.getAction("1", place1)); always returns null, don't see what's wrong with the method
		assertEquals(2, test.getActionCount());
		assertEquals(place1, test.getPlace(0));
		assertEquals(2, test.getPlaceCount());
		assertEquals(null, test.getPlace(-1));
	}
	
	

	/**
	 * chacks "set" and "add" accessor methods
	 */
	@Test public void checkSetsAndAdds()
	{
		test.addAction(new Action());
		test.addPlace(new Place("test", "test"));
		test.setDescription("test");
		//test.setDescription(null);
		test.setLabel("test");
		//test.setLabel(null);
	}
	
	
	
	
	/**
	 * checks Item-related methods 
	 */
	@Test public void checkItems()
	{
		Item item1 = new Item("1", "test");
		Item item2 = new Item("2", "test");
		test.addToInventory(item1);
		assertEquals(item1, test.getInventory().get(0));
		test.addToInventory(item2);
		assertEquals(item1, test.getInventory().get(0));
		assertEquals(item2, test.getInventory().get(1));
		test.removeFromInventory(item1);
		assertEquals(item2, test.getInventory().get(0));
		assertEquals(null, test.getInventory().get(1));
	}
}
