/**
*
*@author Adam Cooper
*@version 1.0
*
* Estimated Completion Time: 20 minutes
* Actual Completion Time: 
*
*Notes: 
*/

public class Pi 
{
	
	//class fields
	int toTerm;
	
	
	
	
	/**
	 * constructor
	 * @param toTerm the term to which we're estimating
	 */
	public Pi(int toTerm)
	{
		this.toTerm = toTerm;
	}
	
	
	
	
	/**
	 * calculates approximation of pi to a specific term
	 * @param toTerm the term that specifies the precision of the estimation
	 * @return       pi estimated to a certain term
	 */
	public double calculate(int toTerm)
	{
		double approx = 0;
		double denom  = 1;
		
		for (int n = 0; n < toTerm; n++)
		{
			if (n % 2 != 0)
			{
				approx -= 1 / denom;
				denom  += 2;
			}
			else
			{
				approx += 1 / denom;
				denom  += 2;
			}
		}//end for-loop
		return approx * 4;
	}
	
	
	
	
	/**
	 * prints a message saying to which term pi was calculated
	 * @return the value of pi as a String
	 */
	public String toString()
	{
		System.out.println("pi approximated with " + toTerm + " term(s) is: " + calculate(toTerm));
		return "" + calculate(toTerm);
	}

}
