/**
*
*@author Adam Cooper
*@version 1.0
*
* Estimated Completion Time: 
* Actual Completion Time: 
*
*Notes: 
*TODO: add required/forbidden items
*TODO: create / destroy items
*/

public class Action
{
	//***************************************************************************
	//  class fields
	
	private String label = "",
			       prevLabel = "",
			       nextLabel = "",
				   desc  = "";
	private Place  previousPlace = new Place("",""),
			       nextPlace     = new Place("","");
		
	//***************************************************************************
	//  constructors
	
	
	/**
	 * constructor
	 */
	public Action() {}
	
	
	
	
	/**
	 * constructor
	 * @param label
	 * @param desc
	 */
	public Action(String label, String desc) 
	{
		this.label = label;
		this.desc = desc;
	}
	
	
	
	
	/**
	 * constructor
	 * @param label
	 * @param desc
	 * @param previousPlace
	 * @param nextPlace
	 */
	public Action(String label, String desc, Place previousPlace, Place nextPlace) 
	{
		this.label = label;
		this.desc = desc;
		this.previousPlace = previousPlace;
		this.nextPlace = nextPlace;
	}




	/**
	 * constructor
	 * @param label
	 * @param desc
	 * @param prevLabel
	 * @param nextLabel
	 */
	public Action(String label, String desc, String prevLabel, String nextLabel) 
	{
		this.label = label;
		this.desc = desc;
		this.prevLabel = prevLabel;
		this.nextLabel = nextLabel;
	}
	
	
	
	
	/**
	 * constructor, adds or removes an item if necessary
	 * @param label
	 * @param desc
	 * @param prevLabel
	 * @param nextLabel
	 * @param item
	 * @param adding
	 * @param game
	 */
	public Action(String label, String desc, Item item, boolean adding, Game game)
	{
		this.label = label;
		this.desc = desc;
		
		if (adding)
			game.addToInventory(item);
		else
			game.removeFromInventory(item);
	}


	//**********************************************************************************
	//  accessor methods




	/**
	 * 
	 * @return field label
	 */
	public String getLabel()
	{
		return this.label;
	}
	
	
	
	
	/**
	 * 
	 * @return field previousPlace
	 */
	public Place getPrev()
	{
		return this.previousPlace;
	}




	/**
	 * 
	 * @return field desc
	 */
	public String getDescription() 
	{
		return this.desc;
	}




	/**
	 * 
	 * @return field nextPlace
	 */
	public Place getNext() 
	{
		return this.nextPlace;
	}




	
}//end class