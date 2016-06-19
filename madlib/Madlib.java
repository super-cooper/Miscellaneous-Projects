import java.util.Scanner;


/**
*
*@author Adam Cooper
*@version 1.0
*
* Estimated Completion Time: 30 minutes
* Actual Completion Time: 30 minutes
*
*Notes: Original text "The applet framework involves two entities: the applet and the applet context. 
*An applet is an embeddable window (see the Panel class) with a few extra methods that the applet context can use to initialize, start, and stop the applet."
*
*@TODO add more MadLibs
*/

public class Madlib
{
	
	//class fields
	static String noun1, noun2, adjective1, noun3, pluralNoun1, verb1, verb2, verb3;
	
	
	public static final Scanner keyboard = new Scanner(System.in).useDelimiter("\\s");
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to MadLibs! Well, there's only one. But you get the point!");
		getWords();
		printMadlib();
	}//end main method
	
	
	
	/**
	 * sets class variables equal to user inputs.
	 */
	private static void getWords()
	{ 
		noun1 = getNoun();
		noun2 = getNoun();
		adjective1 = getAdjective();
		noun3 = getNoun();
		pluralNoun1 = getPluralNoun();
		verb1 = getVerb();
		verb2 = getVerb();
		verb3 = getVerb();
	}
	
	
	
	
	/** FOR ALL "get" methods below
	 * 
	 * Requests the user type in a word of a particular type of speech
	 * @return user input
	 */
	private static String getNoun() 
	{ 
		System.out.print("I need a noun. ");
		return keyboard.nextLine();
	}
	
	private static String getPluralNoun()
	{ 
		System.out.print("I need a plural noun. ");
		return keyboard.nextLine();
	}
	
	private static String getAdjective() 
	{ 
		System.out.print("I need an adjective. ");
		return keyboard.nextLine();
	}
	
	private static String getVerb() 
	{ 
		System.out.print("I need a verb. ");
		return keyboard.nextLine();
	}
	
	
	
	
	/**
	 * Prints the madlib
	 */
	public static void printMadlib()
	{ 
		System.out.println("The " + noun1 + " framework involves two entities: the " + noun1 + " and the " + noun2 + 
		". \nA(n) " + noun1 + " is a(n) " + adjective1 + " window (see the " + noun3 + " class) "
		+ "\nwith a few extra " + pluralNoun1 + "s that the " + noun1 + " context can use to " + verb1 + ", " + verb2 + ", and " + verb3 + " the " + noun1 + ".");
	}

}//end class