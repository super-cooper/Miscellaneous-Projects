import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest 
{
	Item test;
	Game game;
	
	@Before public void setUp() throws Exception
	{
		game = new Game("Test label", "Test desc");
		test = new Item("Test label", "Test desc");
	}
	
	@After public void tearDown() throws Exception
	{
		game = null;
		test = null;
	}
	
	
	
	
	/**
	 * doesn't really efficiently test setType() because functionality isn't worked out yet
	 */
	@Test public void checkSetsAndGets()
	{
		test.setType("key");
		assertTrue(test.key);
		test.setType("weapon");
		assertTrue(test.weapon);
		test.setDescription("foo");
		assertEquals("foo", test.getDescription());
		test.setLabel("fooey");
		assertEquals("fooey", test.getLabel());	
	}
	
	
	
	
	//didn't bother to test methods that don't have proper functionality within game yet
	//they'll probably need to be changed around a bit anyway
}
