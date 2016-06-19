import static org.junit.Assert.*;

import org.junit.*;

public class TranslateTest 
{
	
	@BeforeClass public static void beforeClass() {}
	@AfterClass  public static void  afterClass() {}
	@Before      public        void      before() {}
	@After       public        void       after() {}
	
	
	
	
	/**
	 * checks boolean methods within Translate
	 */
	@Test public void checkBools()
	{
		assertTrue (Translate.isVowel('a'));
		assertFalse(Translate.isVowel('b'));
		assertTrue (Translate.isConsonant('b'));
		assertFalse(Translate.isConsonant('a'));
	}
	
	
	
	
	/**
	 * checks that toPigLatin works correctly with a multitude of test cases
	 */
	@Test public void checkPigLatin()
	{
		assertEquals("uttbay",   Translate.toPigLatin("butt"));
		assertEquals("atchay",   Translate.toPigLatin("chat"));
		assertEquals("oofay",    Translate.toPigLatin("foo"));
		assertEquals("oofay",    Translate.toPigLatin("Foo"));
		assertEquals("oofay",    Translate.toPigLatin("FOO"));
		assertEquals("oofay",    Translate.toPigLatin("fOo"));
		assertEquals("orangeay", Translate.toPigLatin("orange"));
		assertEquals("",         Translate.toPigLatin(""));
		assertEquals("",         Translate.toPigLatin("   .:"));
		assertEquals("",         Translate.toPigLatin(null));
	}

	
	
	
	/**
	 * checks that toOpish works correctly with a multitude of test cases
	 */
	@Test public void checkOpish()
	{
		assertEquals("boputtop",   Translate.toOpish("butt"));
		assertEquals("topo",       Translate.toOpish("top"));
		assertEquals("atop",       Translate.toOpish("at"));
		assertEquals("fopoo",      Translate.toOpish("foo"));
		assertEquals("fopoo",      Translate.toOpish("Foo"));
		assertEquals("fopoo",      Translate.toOpish("FOO"));
		assertEquals("fopoo",      Translate.toOpish("fOo"));
		assertEquals("oropangope", Translate.toOpish("orange"));
		assertEquals("",           Translate.toOpish(""));
		assertEquals("",           Translate.toOpish("   .:"));
		assertEquals("",           Translate.toOpish(null));
	}
}
