import java.util.ArrayList;

/**
 * Place in the text game
 * 
 * @author  Clif Kussmaul
 * @version 2012-10
 * 
 * TODO: add itemList[] maybe not
 */
public class Place {

    //************************************************************
    // instance fields
    private String  label, description;
    boolean locked;
    private ArrayList<Item> itemList = new ArrayList<Item>();
    private int itemCount = 0;

    //************************************************************
    // constructors
    
    /**
     * Creates new Place with given label & description
     * @param label
     * @param description
     */
    public Place(String label, String description) 
    {
        setLabel(label);
        
        setDescription(description);
    }

    //************************************************************
    // accessor methods
    
    public  String  getDescription()    
    {
    	return this.description; 
    }
    
    
    
    
    public ArrayList<Item> getItemList()
    {
    	return this.itemList;
    }
    
    
    
    
    public  void setDescription(String newDescription) throws IllegalArgumentException
    {
        if (null == newDescription)     
        	throw new IllegalArgumentException();
        
        newDescription   = newDescription.trim();
        this.description = newDescription;
    }

    
    
    
    public String getLabel()      
    {
    	return this.label; 
    }
    
    
    
    
    public  void setLabel(String newLabel) throws IllegalArgumentException
    {
        if (null == newLabel)       
        	throw new IllegalArgumentException(); 
        
        newLabel = newLabel.trim();

        if (0 == newLabel.length()) 
        	throw new IllegalArgumentException();
        
        this.label = newLabel;
    }
    
    
    
    
    
    public void lock()
    {
    	this.locked = true;
    }
    
    
    
    
    public void unlock()
    {
    	this.locked = false;
    }
    
    
    
    
    /**
     * adds an item to the game's itemList
     * @param newItem the item to be added
     * @return true if success, false otherwise
     */
    public void addItem(Item newItem) throws IllegalArgumentException
    {
    	if (null == newItem)
    		throw new IllegalArgumentException();
    	
    	this.itemList.add(newItem);
    }
    
    
    
    
    /**
     * removes an item from the place's itemList
     * @param item the Item to be removed
     * @return true if success, false otherwise
     * I am aware of repeating code and I have already submitted my application to the dark side
     */
    public void removeItem(Item item) throws IllegalArgumentException
    {
    	if (null == item)
    		throw new IllegalArgumentException();
    	
    	for (int i = 0; i < this.itemList.size(); i++)             // loops through itemList
    	{
    		if (this.itemList.get(i) == item)                          // if item is in itemList
	    		this.itemList.remove(i);
    	}
    }
    
} // end class
