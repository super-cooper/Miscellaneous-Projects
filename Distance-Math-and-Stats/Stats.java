/**
*
*@author Adam Cooper
*@version 1.0
*
* Estimated Completion Time: 1 days 
* Actual Completion Time: forever
*
*Notes: 
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Stats
{
	
	//class fields
	int[] data = {0};
	private final Scanner scan = new Scanner(System.in);
	
	
	/**
	 * constructor; sets parameter data to class field data.
	 * @param data given data
	 */
	public Stats(int[] data) 
	{ 
		setValues(data);
	}//end method
	
	
	
	
	/**
	 * constructor; sets field data to array of requested size
	 * @param size requested array size
	 */
	public Stats(int size)
	{ 
		setValues(size);
	}//end method
	
	
	
	
	/**
	 * constructor; calls setValues()
	 */
	public Stats()
	{ 
		setValues();
	}//end method
	
	
	
	
	/**
	 * sets field data to parameter data. If data == null, prints error message and does not function.
	 * @param data given data
	 */
	public void setValues(int[] data)
	{ 
		if (data != null)
			this.data = data;
		else 
		{
			System.err.println("The given array reference was null and was therefore not used.");
		}
	}//end method
	
	
	
	
	/**
	 * sets data to an array of parameter size and then prompts the user to input that many values
	 * @param size the size of the array
	 */
	public void setValues(int size)
	{ 
		this.data = new int[size];
		
		System.out.println("Please input " + size + " positive integers: ");
		
		for (int i = 0; i < size; i++)
		{
			System.out.print("index " + i + " = ");
			getUserInputForIndex(i);
		}
	}//end method
	
	
	
	
	/**
	 * asks the user how big the data array should be, sets field data to input size, asks user to set values of field data
	 */
	public void setValues()
	{ 
		int size;
		System.out.print("How many values should the data array contain? ");
		size = scan.nextInt();
		
		this.data = new int[size];
		
		System.out.println("Please enter " + size + " integers.");
		for (int i = 0; i < size; i++)
		{
			System.out.print("index " + i + " = ");
			getUserInputForIndex(i);
		}
	}//end method
	
	
	
	
	/**
	 * int to give ability to use size of given array when referencing Stats as an object
	 * @return length of field data
	 */
	public int getSize()
	{ 
		return data.length;
	}//end method
	
	
	
	
	/**
	 * converts field data to a legible string of characters
	 * @return the converted String
	 */
	public String toString()
	{ 
		if (this.getSize() == 0)
			return "{}";
		
		String converted = "{";
		int i;
		
		for (i = 0; i < data.length - 1; i++) //appends all values in data array to String converted 
			converted += data[i] + ", ";
		converted += data[i];
		
		return converted + "}";
	}//end method
	
	
	
	
	/**
	 * uses a loop to get the total sum of all values in data
	 * @return sum of all values in data, -1 if this.data is empty
	 */
	public int getTotal() 
	{ 
		if (this.getSize() == 0)
			return -1;
		
		int total = 0;
		
		for (int i : data) //adds all values of data into a single int
			total += i;
		
		return total;
	}//end method
	
	
	
	
	/**
	 * gets the total sum of all values and then returns the average
	 * @return average of all values in data, -1 if this.data is empty
	 */
	public double getAverage()
	{ 
		if (this.getSize() == 0)
			return -1;
		
		return ((double) getTotal()) / data.length;
	}//end method
	
	
	
	
	/**
	 * loops through the entire data array and finds the minimum
	 * @return the minimum value of data, -1 if this.data is empty
	 */
	public int getMin()
	{ 
		if (this.getSize() == 0)
			return -1;
		
		int min = data [0];
		
		for (int i : data)
		{
			if (i < i-1)
				min = i;
		}
		return min;
	}//end method
	
	
	
	
	/**
	 * loops through the data array and finds the max value
	 * @return the maximum value in data, -1 if this.data is empty
	 */
	public int getMax()
	{ 
		if (this.getSize() == 0)
			return -1;
		
		int max = data [0];
		
		for (int i : data)
		{
			if (i > i-1)
				max = i;
		}
		
		return max;
	}//end method
	
	
	
	/**
	 * loops through array and replaces any instances of a specific value with another value
	 * @param oldVal the requested value to be replaced
	 * @param newVal the value to replace the old value
	 * @return the amount of values changed
	 */
	public int replace(int oldVal, int newVal)
	{ 
		int changes = 0;
		for (int i = 0; i < data.length; i++)
		{
			if (data[i] == oldVal)
			{
				data[i] =  newVal;
				changes++;
			}
		}
		
		return changes;
	
	}//end method
	
	
	
	
	/**
	 * calls verifyInput, sets returned value to given index in this.data
	 * @param index the method is editing
	 */
	private void getUserInputForIndex(int index)
	{ 
		data[index] = verifyInput(index);
	}
	
	
	
	
	/**
	 * verifies that the given input is the right type, as well as within the correct range. Prompts the user to try again if incorrect. 
	 * Infinite loop until a correct value is given. 
	 * @param index the index the method is checking
	 * @return the final correct value 
	 */
	private int verifyInput(int index)
	{
		int val = 0;
		do 
		{
		    try 
		    {
		        val = scan.nextInt();
		        if (val >= 0) 
		        	break;
		    } 
		    catch (InputMismatchException e) 
		    {} 
		    finally
		    {
		        scan.nextLine();
		    }
		    System.out.println("Input must be a positive integer.");
		    System.out.print  ("index " + index + " = ");
		} while (true);
		
		return val;
	}//end method
	
}//end class