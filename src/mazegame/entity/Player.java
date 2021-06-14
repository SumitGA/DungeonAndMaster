package mazegame.entity;

public class Player extends Character {
	
	private Location currentLocation;
	private FiniteInventory myInventory;
	

    public Player()
    {
    }

    public Player(String name)
	{
	    super (name);
		myInventory = new FiniteInventory(super.getStrength());
	}
    
    
    public Location getCurrentLocation() {
    	return currentLocation;
    }
    
    public void setCurrentLocation(Location currentLocation) {
    	this.currentLocation = currentLocation;
    }
    
	public FiniteInventory getInventory() {
		return this.myInventory;
	}
	
	public String getCurrentPlayerStat(Player player) {
		StringBuilder message = new StringBuilder();
		message.append("Hello " + player.getName().toUpperCase() + ",\n");
		message.append("Your current Status is: "+player.getCurrentLocation()+"\n");
		message.append("You have agility: " + player.getAgility() + "\n");
		message.append("You have lifepoint: " + player.getLifePoints() + "\n");
		message.append("You have strength: " + player.getStrength() + "\n");
		message.append("Your weight Limit is: " + player.getInventory().getWeightLimit() + "\n");
		message.append("Total amount of coins you have: "+player.getInventory().printMoney() + "\n");
		message.append("Your total item weight is: " + player.getInventory().getWeight() + "\n");
		
		return message.toString();
	}
	public String getCurrentPlayerItems(Player player) {
		StringBuilder message = new StringBuilder();
		if (!player.getInventory().getItemList().isEmpty()) {
			message.append(player.getInventory().printItemList() + "\n");
		} else {
			message.append("You currently have no items");
		}
		return message.toString();
	}
}
