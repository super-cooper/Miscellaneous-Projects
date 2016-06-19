/**
*
*@author Adam Cooper
*@version 1.0
*
* Estimated Completion Time: 1 hours 30 minutes
* Actual Completion Time: 2 hours 30 minutes
*
*Notes: Contains certain bugs beyond my knowledge of Java; unable to find answers online. 
*Bugs to do with user causing crashes through potential InputMismatchException when prompted with scanner.
*This project would most-likely be done better in Python or Javascript due to such exceptions being voided.
*/

import java.util.Scanner;


public class FileStub {
	
	//establishing universal input
	public static final Scanner keyboard = new Scanner(System.in);

	
	
	
	public static void main(String[] args) 
	{ 
		while (true) //creates loop to allow for multiple creations, sets class fields equal to inputs, asks to go again
		{  
			printClass(getClassName(), getUserName(), getEstimatedTime());
			if (!requestRepeat()) 
				break;
		}
	} //end main method
	
	
	
	
	/**
	 * Receives user input for class name
	 * @return the desired class name as a string
	 */
	private static String getClassName()
	{ 
		System.out.print("What would you like the Class name to be? "); 
		return keyboard.nextLine();
	}//end method
	
	
	
	
	/**
	 * Receives user input for user name
	 * @return the desired user name as a string
	 */
	private static String getUserName()
	{ 
		System.out.print("\nWhat is your username? ");
		return keyboard.nextLine();
	}//end method
	
	
	
	
	/** 
	 * Receives user input for estimated time
	 * @TODO: @throws any non-integers
	 * @return estimated completion time as an integer array
	 */
	private static int[] getEstimatedTime()
	{ 
		int returnTime[] = new int[3]; 
		
		System.out.println("\nHow much time do you think it will take to create this?");
		
		System.out.print("Days: ");
		returnTime[0] = keyboard.nextInt(); 
		System.out.print("Hours: ");
		returnTime[1] = keyboard.nextInt();
		System.out.print("Minutes: ");
		returnTime[2] = keyboard.nextInt();
		
		return returnTime;
	}//end method
	
	

	
	/**
	 * prints full class start
	 * @param className
	 * @param userName
	 * @param estimatedTime - estimated time of completion
	 */
	private static void printClass(String className, String userName, int[] estimatedTime)
	{ 
		printClassComment(className, userName, estimatedTime);
		printClassDeclaration(className);
	}//end method
	
	
	
	
	/**
	 * Generates and prints a class comment for a java program
	 * @param className
	 * @param userName
	 * @param estimatedTime - Estimated time of completion
	 */
	private static void printClassComment(String className, String userName, int[] estimatedTime)
	{ 
		System.out.println("\nGenerating class... \n\n");
		
		System.out.println("/**\n*\n*@author " + userName + "\n*@version \n*\n* Estimated Completion Time: " + convertedTime(estimatedTime) + 
				"\n* Actual Completion Time: \n*\n*Notes: \n*/");
	}//end method
	
	
	
	
	/**
	 * Generates and prints a class declaration for a java program
	 * @param name - the previously decided class name
	 */
	private static void printClassDeclaration(String name)
	{ 
		System.out.println("\npublic class " + name + "\n{\n	\n	public static void main(String[] args)\n	{\n		\n	}//end main method\n\n}//end class");
	}//end method
	
	
	
	
	/**
	 * Asks the user if they would like to start over
	 * @return true if the user would like to start over, false otherwise
	 */
	private static boolean requestRepeat()
	{ 
		while (true)
		{ 
			System.out.print("\n\nWould you like to make another? ");
			if (keyboard.nextLine().toUpperCase().equals("Y")) 
				return true;
			else if (keyboard.nextLine().toUpperCase().equals("N"))
				return false;
		}
	}//end method
	
	
	
	
	/**
	 * Converts estimated time into a more readable string
	 * @param time
	 * @return time in days, hours, minutes
	 */
	private static String convertedTime(int[] time) 
	{ 
		String dayString = "";
		String hourString = "";
		String minString = ""; 
		
		//putting given time values into strings
		if (time[0] > 0) 
			dayString += time[0] + " days ";
		if (time[1] > 0) 
			hourString += time[1] + " hours ";
		if (time[2] > 0) 
			minString += time[2] + " minutes";
		
		return dayString + hourString + minString;
	}//end method
	
	
	
}//end class
