package mazegame;

import mazegame.boundary.IMazeData;
import mazegame.entity.Exit;
import mazegame.entity.Location;
import mazegame.entity.utility.*;

public class HardCodedData implements IMazeData {
	private Location startUp;
	
	public HardCodedData()
	{
		createLocations();
	}
	
	public Location getStartingLocation()
	{
		return startUp;
	}
	
	public String getWelcomeMessage()
	{
		return "Welcome to the Mount Helanous";
	}
	
	private void createLocations () 
	{
		//creating location accepts @param Description and Title
		startUp = new Location ("an entry gate to the maze located by the riverside", "Maze Gate");
		
		// Create location
		Location riverHill = new Location("a wonderful connection with water and hill", "River Hill");
		Location lake = new Location("a place where you can heal your pain", "Lake Montana");
		Location valley = new Location("a place where people live", "Arun Valley");
		Location weaponary = new Location("a place where you can buy and exchange your weapons", "weaponary");
		Location mountains = new Location("a palce where there is a gaint peaks and snow capped montains", "Tall Mountains");
		Location westros = new Location("where king resides", "New Kingdom");
		Location citadale = new Location("house of terror", "Citadale");
		Location arsenal = new Location("a factory for buying and selling weapons", "Arsenal");
		
		
		// Connect Locations
		//Add exits to the startup location
		startUp.addExit("south",  new Exit ("you see an open space to the south", riverHill));
		startUp.addExit("southwest", new Exit("you are welcomed by the people in the valley", valley));

		//Add exits to riverhill
		riverHill.addExit("west", new Exit("you see a wonderful blue water lake", lake));
		riverHill.addExit("east", new Exit("you see a valley full of people", valley));
		riverHill.addExit("south", new Exit("you see the only available weapon shop", weaponary));
		riverHill.addExit("north", new Exit("you are now back to the starting point", startUp));
		
		//Add exits to valley
		valley.addExit("east", new Exit("you are now at riverhill", riverHill));
		valley.addExit("southeast", new Exit("you are now at the weaponary(weapon shop)", weaponary));
		
		//Add exits to lake
		lake.addExit("west", new Exit("you see yourself at riverhill", riverHill));
		lake.addExit("south", new Exit("you see yourself looking at Gaint Mountains", mountains));
		lake.addExit("east", new Exit("you see yourself at the weapon arsenal", arsenal));
		
		//Add exits to weaponary
		weaponary.addExit("north", new Exit("you are now at riverhill", riverHill));
		weaponary.addExit("south", new Exit("you are now at a new kingdom Westoros", westros));
		weaponary.addExit("northwest", new Exit("you are now with peoples in the valley", valley));
		
		//Add exits to Mountains
		mountains.addExit("north", new Exit("you see yourself at blue water lake", lake));
		mountains.addExit("south", new Exit("you see Citadale a house of terror", citadale));
		mountains.addExit("northeast", new Exit("you see yourself at the weapon arsenal", arsenal));
		
		//Add exits to westros
		westros.addExit("north", new Exit("you see a weapon shop where you can buy and exchange weapons", weaponary));
		westros.addExit("east", new Exit("you see yourself at house of terror at Citadale", citadale));
		
		//Add exits to citadale
		citadale.addExit("west", new Exit("you are now at a kingdom of Westros", westros));
		citadale.addExit("north", new Exit("you are looking at the Gaint Mountains", mountains));
		
		//Add exit to arsenal
		arsenal.addExit("west", new Exit("you see yourself at the blue water lake", lake));
		arsenal.addExit("southwest", new Exit("you see yourself infront of a gaint mountains", mountains));
		
			
	}
}
