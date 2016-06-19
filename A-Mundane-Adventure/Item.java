/**
 * TODO add methods as needed
 * @author Adam
 *
 */
public class Item 
{

	//***********************************************************************************************************
	//**class fields
	public boolean key;         //is the item a key, not sure of the purpose of this yet, to be made private
	public boolean weapon;      //is the item a weapon, to be made private
	private Place[] canUnlock;   //what places can the item unlock
	private int canUnlockCount = 0;
	private int baseDMG;         //what is the weapon's base damage (to inflict on enemies)
	private Item[] cannotDamage; //what Items can the item not damage TODO add npcs
	private Place location;      //in what place is the item located 
	private String status;       //what is the item's current status
	private int maxUses;
	private int currentUses = 0;
	private String label;
	private String desc;
	private int cannotDamageCount = 0;
	
	//************************************************************************************************************
	//**constructors
	
	/**
	 * generic constructor using label and description
	 * @param label 
	 * @param desc
	 */
	public Item(String label, String desc) 
	{
		this.label = label;
		this.desc  = desc;
	}
	
	
	
	
	/**
	 * constructor that sets label, description, and location
	 * @param label
	 * @param desc
	 * @param location
	 */
	public Item(String label, String desc, Place location)
	{
		this.label = label;
		this.desc = desc;
		this.location = location;
	}
	
	
	
	
	//**********************************************************************************
	//**accessor methods
	
	
	/**
	 * sets type of Item
	 * @param type the type to be set
	 * @throws IllegalArgumentException invalid type
	 */
	public void setType(String type) throws IllegalArgumentException
	{
		if (type.equals("key"))
		{
			this.key = true;
			this.weapon = false;
		}
		else if (type.equals("weapon"))
		{
			this.weapon = true;
			this.key = false;
		}
		else
			throw new IllegalArgumentException("Type: " + type + " is not a valid type.");
	}
	
	
	
	
	/**
	 * removes given type
	 * @param type
	 * @throws IllegalArgumentException invalid type
	 */
	public void removeType(String type) throws IllegalArgumentException
	{
		if (type.contains("key"))
			this.key = false;
		if (type.contains("weapon"))
			this.weapon = false;
		else 
			throw new IllegalArgumentException("Type: " + type + " is not a valid type.");
	}
	
	
	
	
	/**
	 * gives the type of Item
	 * @return String detailing what type of Item it is
	 */
	public String getType()
	{
		String type = null;
		if (this.key)
			type += "key ";
		if (this.weapon)
			type += "weapon ";
		return type;
	}
	
	
	
	
	public void setLabel(String label)
	{
		this.label = label;
	}
	
	
	
	
	public String getLabel()
	{
		return this.label;
	}
	
	
	
	
	public String getDescription()
	{
		return this.desc;
	}
	
	
	
	
	public void setDescription(String desc)
	{
		this.desc = desc;
	}
	
	
	
	
	/**
	 * 
	 * @param place
	 * @throws IllegalArgumentException invalid Place
	 */
	public void givesAccessTo(Place place) throws IllegalArgumentException
	{
		if (null == place)
			throw new IllegalArgumentException("Given Place object has not been initialized");
		
		this.canUnlock[canUnlockCount++] = place;
	}
	
	
	
	
	/**
	 * makes it so an item cannot damage another particular item
	 * @param item the item that cannot be damaged
	 * @throws IllegalArgumentException invalid Item
	 * TODO: override this method with one that accepts an npc as a parameter
	 */
	public void addToCannotDamage(Item item)
	{
		if (null == item)
			throw new IllegalArgumentException("The given Item object does not exist");
		
		this.cannotDamage[cannotDamageCount++] = item;
	}
	
	
	
	//****************************************************************************************************************************
	//**other methods
	
	
	/**
	 * checks if an Item is in a game's inventory
	 * @param game the game to check
	 * @return true if is in inventory, false otherwise
	 * TODO refactor so inventory is a property of a Player / NPC object so the game doesn't need to be passed as a parameter
	 */
	public boolean isInInventory(Game game)
	{
		for (Item item : game.getInventory())
			if (item == this)
				return true;
		return false;
	}
	
	
	
	
	/**
	 * checks if this Item can damage another item
	 * @param item the target
	 * @return true if can damage, false otherwise
	 * TODO add canDamage(NPC npc)
	 */
	public boolean canDamage(Item item)
	{
		for (Item check : this.cannotDamage)
			if (check == item)
				return false;
		return true;
	}
}
