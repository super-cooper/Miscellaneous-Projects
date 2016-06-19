

/**
*
*@author Adam Cooper
*@version 1.0
*
* Estimated Completion Time: 1 day 
* Actual Completion Time: 1 day
*
*/

public class Translate
{
	
	//fields
	public static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	
	
	
	
	/**
	 * checks to see if given character is a consonant
	 * @param c the passed character
	 * @return true if consonant, false otherwise
	 */
	public static boolean isConsonant(char c)
	{ 
		for (char v : vowels)
			if (c == v)
				return false;
		return true;
	}
	
	
	
	
	/**
	 * checks to see if given character is a vowel
	 * @param c the passed character
	 * @return true if vowel, false otherwise
	 */
	public static boolean isVowel(char c)
	{ 
		for (char v : vowels)
			if (c == v)
				return true;
		return false;
	}
	
	
	
	
	/**
	 * translates given String into Piglatin
	 * @param word the given word
	 * @return     word translated to Piglatin
	 */
	public static String toPigLatin(String word)
	{
		if (word == null || word.replaceAll("\\W", "").isEmpty())
			return "";
		
		String append = "";
		int start = 0;
		word = word.toLowerCase();
		
		for (int i = 0; i < word.length(); i++)
		{ 
			if (isConsonant(toChar(word, i)))
			{
				append += word.substring(i, i + 1);
				start++;
			}
			else
				break;
		} //end for-loop
		
		return word.substring(start) + append + "ay";
	}
	
	
	

	/**
	 * takes a given string and translates to Opish
	 * @param word the given word to be translated
	 * @return     the word translated to Opish
	 * 
	 * This one I can't do. It either returns one too many op or one too few. I've restarted several times but I'm not sure how to go about the logic.
	 */
	public static String toOpish(String word)
	{
		if (word == null || word.replaceAll("\\W", "").isEmpty())
			return "";
		
		int currentStart = 0;
		String opped = "";
		word = word.toLowerCase();
		
		for (int i = 0; i < word.length(); i++)
		{
			if (isVowel(toChar(word, i)))
				opped += word.substring(i, i + 1);
			else if (isConsonant(toChar(word, i)) && i < word.length() - 1 && isVowel(toChar(word, i + 1)))
			{
				currentStart = i;
				opped += word.substring(currentStart, i + 1) + "op";
			}
			else
			{
				opped += word.substring(i) + "op";
			}
		}//end for-loop
		
		return opped;
	}
	
	
	
	
	/**
	 * takes a String and returns the character at index as a single char
	 * @param s     the String to be used
	 * @param index the index at which a character is needed
	 * @return      the character at the requested index in the String
	 */
	public static char toChar(String s, int index)
	{
		char[] foo = s.substring(index, index + 1).toCharArray();
		return foo[0];
	}
	
}//end class