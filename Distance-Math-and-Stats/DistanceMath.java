/**
*
*@author Adam Cooper
*@version 
*
* Estimated Completion Time: 2 hours 30 minutes
* Actual Completion Time: 3 hours
*
*Notes: 
*/

/**
 * Math operations involving distances.
 * Supported units include: "cm", "in", "ft", "m"
 */
public class DistanceMath 
{
	 
    /**
     * Adds dist1 (with units unit1) and dist2 (with units unit2), and returns the sum (in units unit1).
     * If any input is invalid, returns Double.NaN (not a number).
     */
    public static double addDistance(double dist1, String unit1, double dist2, String unit2 ) 
   { 
	   if (invalidUnits(unit1, unit2))
		   return Double.NaN;
	   
	   return dist1 + convertToUnit(dist2, unit2, unit1);
   }
 
    
    
    
  /** 
   * Multiplies dist1 (with units unit1) and dist2 (with units unit2), and returns the product (in units unit1).
   * If any input is invalid, returns Double.NaN (not a number).
   */
   public static double multDistance(double dist1, String unit1, double dist2, String unit2 ) 
   { 
	   if (invalidUnits(unit1, unit2))
		   return Double.NaN;
	   
	   return dist1 * convertToUnit(dist2, unit2, unit1);	   
   }//end method
   
   
   
   
   /**
    * converts a distance value from one unit to another
    * @param dist        given distance
    * @param unit        current unit of the distance
    * @param desiredUnit the desired unit
    * @return the converted value
    * 
    * Note: I'm sure there's a better way to do this.
    */
   public static double convertToUnit(double dist, String unit, String desiredUnit)
   { 
	   if (unit.equals(desiredUnit))
		   return dist;
	   else if (unit.equals("cm") && desiredUnit.equals("in"))
		   return dist * .3937;
	   else if (unit.equals("cm") && desiredUnit.equals("ft"))
		   return (dist * .3937) / 12;
	   else if (unit.equals("cm") && desiredUnit.equals("m"))
		   return dist / 100;
	   else if (unit.equals("in") && desiredUnit.equals("cm"))
		   return dist * 2.54;
	   else if (unit.equals("in") && desiredUnit.equals("ft"))
		   return dist / 12;
	   else if (unit.equals("in") && desiredUnit.equals("m"))
		   return (dist * 2.54) / 100;
	   else if (unit.equals("ft") && desiredUnit.equals("cm"))
		   return (dist * 12) * 2.54;
	   else if (unit.equals("ft") && desiredUnit.equals("in"))
		   return dist * 12;
	   else if (unit.equals("ft") && desiredUnit.equals("m"))
		   return dist * .3048;
	   else if (unit.equals("m") && desiredUnit.equals("cm"))
		   return dist * 100;
	   else if (unit.equals("m") && desiredUnit.equals("in"))
		   return (dist * 100) * .3937;
	   else if (unit.equals("m") && desiredUnit.equals("ft"))
		   return ((dist * 100) * .3937) / 12;
	   else
		   return Double.NaN;
   }

   
   
   
   /**
    * checks to see if there are any invalid units being passed
    * @param unit1 unit to be checked
    * @param unit2 unit to be checked
    * @return false if both units are valid, true otherwise
    */
   private static boolean invalidUnits(String unit1, String unit2)
   {
	   String[] units = {"cm", "in", "ft", "m"};
	   
	   for (String unit : units)
	   {
		   if (unit.equals(unit1))
		   {
			   for (String uunit : units)
			   {
				   if (uunit.equals(unit2))
					   return false;
			   }
		   }
	   }
	   return true;
   }//end method
		   
}//end class