import java.util.ArrayList;
import java.util.Scanner;

/**
 * Game in the text game
 *
 * @author  Clif Kussmaul
 * @version 2012-10
 * 
 * TODO: add itemList[]
 * TODO: add inventory[]
 */
public class Game {

    public static final int ACTION_COUNT_MAX    = 40;
    public static final int PLACE_COUNT_MAX     = 10;
    public static final int INVENTORY_MAX       = 20;

    //************************************************************
    //*** instance fields

    private String      label, description;
    private ArrayList<Action>   actionList  = new ArrayList<Action>();
    private ArrayList<Place>    placeList   = new ArrayList<Place>();
    private ArrayList<Item>     inventory   = new ArrayList<Item>();

    //************************************************************
    //*** constructors

    /**
     * Create new Game with given label and description.
     * @param label         must not be null or blank
     * @param description   must not be null, may be blank
     */
    public Game(String label, String description) 
    {
        setLabel(label);
        setDescription(description);
    }

    //************************************************************
    //*** accessor methods

    /**
     * Gets Game description
     * @return          Game description
     */
    public  String   getDescription() 
    {
    	return this.description; 
    }
    
    public static void main(String[] args)
    {
    	aMundaneAdventure();
    }
    
    
    /**
     * Sets Game description
     * @param newDescription
     * @return  true if successful, false otherwise
     */
    public  void  setDescription(String newDescription) throws IllegalArgumentException
    {
        if (null == newDescription)
        	throw new IllegalArgumentException();
        
        newDescription = newDescription.trim();
        this.description = newDescription;
    }

    
    
    
    /**
     * Gets Game label
     * @return          Game label
     */
    public  String   getLabel() 
    {
    	return this.label; 
    }
    
    
    
    
    /**
     * Sets Game label
     * @param newLabel
     * @return  true if successful, false otherwise
     */
    public  void  setLabel(String newLabel) throws IllegalArgumentException
    {
        if (null == newLabel)       
        	throw new IllegalArgumentException();
        
        newLabel = newLabel.trim();
        
        if (0 == newLabel.length()) 
        	throw new IllegalArgumentException(); 
        
        this.label = newLabel;
    }

    
    
    
    /**
     * 
     * @return inventory for this object
     */
	public ArrayList<Item> getInventory()
    {
    	return this.inventory;
    }
    
    
    
    
    
    
    
    
    
    /**
     * Adds given Action to current Game.
     * @param newAction     must not be null
     * @return              true if successful, false otherwise
     */
    public void addAction(Action newAction) throws IllegalArgumentException
    {
        if (null == newAction) 
        	throw new IllegalArgumentException();
        
        this.actionList.add(newAction);
    }

    
    
    
    /**
     * makes a new action with given params
     * @return a new Action
     */
    public Action makeAction(String label, String desc, Place prevPlace, Place nextPlace) 
    { 
    	return new Action(label, desc, prevPlace, nextPlace);
    }
    
    
    
    
    /**
     * makes a new action with given params
     *
     * @return a new Action
     */
    public Action makeAction(String label, String desc, String prevLabel, String nextLabel) 
    {
    	return new Action(label, desc, prevLabel, nextLabel);
    }

    /**
     * Gets Action at given index.
     * @param index         0 <= index < actionCount
     * @return              requested Action, null on error
     */
    public Action getAction(int index) 
    {
        if (index < 0 || index >= this.actionList.size()) 
        	return null; 
        
        return this.actionList.get(index);
    }

    
    
    
    /**
     * Gets Action with given label & previous Place.
     * @param label         must not be null or blank
     * @return              requested Action, null on error
     */
    public Action getAction(String label, Place place) 
    {
        if (null == label || null == place) 
        	return null; 
        
        label = label.trim();
        
        for (int i = 0; i < actionList.size(); i++) 
        {
            Action action = this.actionList.get(i);
            if (label.equals(action.getLabel()) && place == (action.getPrev()))
                return action;
        }
        return null;
    }

    
    
    
    /**
     * Gets Action with given label & previous Place label.
     * @param label         must not be null or blank
     * @return              requested Action, null on error
     */
    public Action getAction(String label, String place) 
    {
        if (null == label || null == place) 
        	return null;
        
        label = label.trim(); place = place.trim();
        for (int i = 0; i < actionList.size(); i++) 
        {
            Action action = this.actionList.get(i);
            if ( label.equals(action.getLabel()) && place.equals(action.getPrev().getLabel()))
                return action;
        }
        return null;
    }

    
    
    
    /**
     * Gets count of Actions in Game.
     * @return      count of actions
     */
    public int getActionCount() 
    {
    	return this.actionList.size(); 
    }

    
    
    
    /**
     * Adds given Place to current Game.
     * @param newPlace     must not be null
     * @return              true if successful, false otherwise
     */
    public void addPlace(Place newPlace) throws IllegalArgumentException
    {
        if (null == newPlace) 
        	throw new IllegalArgumentException();
        
        this.placeList.add(newPlace);
    }

    
    
    /**
     * creates a new Place
     * @param label
     * @param desc
     * @return the new Place
     * not sure why this is necessary when the constructor is easier
     */
    public Place makePlace(String label, String desc) 
    { 
    	return new Place(label, desc);
    }

    /**
     * Gets Place at given index.
     * @param index         0 <= index < placeCount
     * @return              requested Place, null on error
     */
    public Place getPlace(int i) 
    {
        if (i < 0 || i >= this.placeList.size()) 
        	return null; 
        return this.placeList.get(i);
    }

    
    
    
    /**
     * Gets Place with given label.
     * @param label         must not be null or blank
     * @return              requested Place, null on error
     */
    public Place getPlace(String label) 
    {
        if (null == label) 
        	return null; 
        
        label = label.trim();
        for (int i = 0; i < placeList.size(); i++) 
        {
            if (label.equals(this.placeList.get(i).getLabel())) 
                return this.placeList.get(i);
        }
        return null;
    }

    
    
    
    /**
     * Gets count of Places in Game.
     * @return      count of places
     */
    public int getPlaceCount() 
    { 
    	return this.placeList.size(); 
    }

    //************************************************************
    //*** other methods

    /**
     * adds an item to inventory
     * @param newItem the item to add
     * @return true if successful, false otherwise
     */
    public void addToInventory(Item newItem) throws IllegalArgumentException
    {
    	if (null == newItem)
    		throw new IllegalArgumentException();
    	
    	this.inventory.add(newItem);
    }
    
    
    
    
    /**
     * removes an item from inventory
     * @param item the item to be removed
     * @return true if successful, false otherwise
     * TODO add removeAllFromInventory(Item item)
     */
    public void removeFromInventory(Item item) throws IllegalArgumentException
    {
    	if (null == item)
    		throw new IllegalArgumentException();
    	
    	for (int i = 0; i < this.inventory.size(); i++)             // loops through inventory
    		if (this.inventory.get(i) == item)                          // if item is in inventory
    			this.inventory.remove(i);
    	
    	if (item.isInInventory(this))
    		throw new IllegalArgumentException();
    }
    
    
    
    
    /**
     * HW06: Added functionality to pick up items. Still not very user-friendly, but works!
     */
    public void play() 
    {
        Action  action;
        Place   place   = getPlace(0);
        Scanner scanner = new Scanner(System.in);
        String  text;

        System.out.println(getDescription());
        while (null != place) 
        {
            System.out.println(place.getDescription());
            text    = scanner.nextLine();
            
            
            for (int i = 0; i < 40; i++)             //this whole for-loop implements item functionality in the game
            {
            	Item item = place.getItemList().get(i);
            	if (text.contains(item.getLabel())); //if the user typed in the name of an item in this place
            	{
            		addToInventory(item);
            		place.removeItem(item);
            		System.out.println(item.getLabel() + " added to your inventory.");
            	}
            	item = this.getInventory().get(i);
            	if (text.contains(item.getLabel())) //if the user typed in the name of an item in their inventory
            	{
            		removeFromInventory(item);
            		place.addItem(item);
            		System.out.println("dropped " + item.getLabel() + ".");
            	}
            }//end for-loop
            
            action  = getAction(text, place);
           
            if (null != action) 
            {
                System.out.println(action.getDescription());
                place   = action.getNext();
            }
        }//end while-loop
        scanner.close();
    }

    
    
    
    public static void demoA() 
    {
        Game    game    = new Game("Trumbower", "This is the Trumbower Demo Game.");
        // create & add Places
        Place   outside = new Place("outside",
            "You are outside. There is a door to the north.");
        Place   foyer   = new Place("foyer",
            "You are in the foyer. There are stairs up and down, and a door south.");
        Place   hall0   = new Place("hall0",
            "You are in a hallway leading east and west, and there are stairs up.");
        Place   rm48    = new Place("rm48",
            "You are in a room full of computers and tables. There is a door to the south.");
        game.addPlace(outside);
        game.addPlace(foyer);
        game.addPlace(hall0);
        game.addPlace(rm48);
        // create and add Actions
        game.addAction(new Action("north",  "You enter the building.",  outside,    foyer   ));
        game.addAction(new Action("south",  "You leave the building.",  foyer,      outside ));
        game.addAction(new Action("down",   "You descend the stairs.",  foyer,      hall0   ));
        game.addAction(new Action("up",     "You ascend the stairs.",   hall0,      foyer   ));
        game.addAction(new Action("east",   "You walk down the hall.",  hall0,      rm48    ));
        game.addAction(new Action("south",  "You leave the room.",      rm48,       hall0   ));
        game.play();
    }
    
    
    
    
    /**
     * my game
     */
    public static void aMundaneAdventure()
    {
    	Game game = new Game("A Mundane Adventure", "The next new immersive AAA title");
    	
    	//places
    	Place dorm = new Place("dorm", "You are in your dorm. There is a door to the south, and your bed to the west");
    	Place hall = new Place("hall", "You are in the hall. You can go back to your room or go outside");
    	Place outside = new Place("outside", "You are outside. You can go back inside or go to Seegers");
    	Place seegers = new Place("seegers", "You are in Seegers. You see your friend Pete. You could go to GQ.");
    	Place saidHi = new Place("said si", "Pete stabbed you in the face. Now seems like a good time to go back to bed.");
    	Place gq = new Place("GQ", "You are in GQ. You are not hungry. You should leave.");
    	Place stabbedPete = new Place("stabbed pete", "He had it coming. You knew he was a lizard person. You should probably run.");
    	Place diningHall = new Place("dining hall", "Suddenly you're hungry. You should go to the kitchen.");
    	Place kitchen = new Place("kitchen", "You are in the kitchen. You see some cereal and a flask.");
    	Place ca = new Place("CA", "Eating the alien cereal teleported you to the CA. It's been a long day. You should probably go to bed");
    	game.addPlace(dorm);
    	game.addPlace(hall);
    	game.addPlace(outside);
    	game.addPlace(seegers);
    	game.addPlace(saidHi);
    	game.addPlace(gq);
    	game.addPlace(stabbedPete);
    	game.addPlace(diningHall);
    	game.addPlace(kitchen);
    	game.addPlace(ca);
    	
    	//actions
    	game.addAction(new Action("south", "You go through the door.", dorm, hall));
    	game.addAction(new Action("west", "You go back to bed. Then you wake up.", dorm, dorm));
    	game.addAction(new Action("room", "You go back to your room.", hall, dorm));
    	game.addAction(new Action("outside", "You go outside.", hall, outside));
    	game.addAction(new Action("inside", "You go back inside.", outside, hall));
    	game.addAction(new Action("seegers", "You go into Seegers.", outside, seegers));
    	game.addAction(new Action("hi", "You say hi to Pete.", seegers, saidHi));
    	game.addAction(new Action("bed", "You go back to bed", saidHi, dorm));
    	game.addAction(new Action("gq", "You go to GQ.", seegers, gq));
    	game.addAction(new Action("leave", "You go back to Seegers.", gq, seegers));
    	game.addAction(new Action("stab", "You stabbed Pete in the face.", seegers, stabbedPete));
    	game.addAction(new Action("run", "You ran to the dining hall.", stabbedPete, diningHall));
    	game.addAction(new Action("kitchen", "You went to the kitchen.", diningHall, kitchen));
    	game.addAction(new Action("flask", "You can't get ye flask!", kitchen, kitchen));
    	game.addAction(new Action("eat", "You eat the cereal.", kitchen, ca));
    	game.addAction(new Action("", "You go back to bed.", ca, dorm));
    	
    	//items
    	Item cerealBowl = new Item("cereal", "a bowl of cereal");
    	kitchen.addItem(cerealBowl);
    	Item flask = new Item("flask", "a flask");
    	kitchen.addItem(flask);
    	Item roomKey = new Item("room key", "a key to your room");
    	dorm.addItem(roomKey);
    	Item knife = new Item("knife", "a knife to stab Pete");
    	seegers.addItem(knife);
    	Item runningShoes = new Item("running shoes", "shoes in for which to run have do are");
    	dorm.addItem(runningShoes);   	
    	
    	game.play();
    }//end awful game

} // end class
