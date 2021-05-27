package mazegame;

import mazegame.boundary.IMazeData;
import mazegame.entity.Exit;
import mazegame.entity.Location;
import mazegame.entity.utility.*;

public class HardCodedData implements IMazeData {
	private Location startUp;

	public HardCodedData() {
		createLocations();
	}

	public Location getStartingLocation() {
		return startUp;
	}

	public String getWelcomeMessage() {
		return "Welcome to the Mount Helanous";
	}

	private void createLocations() {
		// creating location accepts @param Description and Title
		startUp = new Location("an entry gate to the maze located by the riverside", "Maze Gate");

		// Create location
		Location riverHill = new Location("a wonderful connection with water and hill", "River Hill");
		Location lake = new Location("a place where you can heal your pain", "Lake Montana");
		Location valley = new Location("a place where people live", "Arun Valley");
		Location weaponary = new Location("a place where you can buy and exchange your weapons", "weaponary");
		Location mountains = new Location("a palce where there is a gaint peaks and snow capped montains",
				"Tall Mountains");
		Location westros = new Location("where king resides", "New Kingdom");
		Location citadale = new Location("house of terror", "Citadale");
		Location arsenal = new Location("a factory for buying and selling weapons", "Arsenal");

		// Connect Locations
		// Add exits to the startup location
		startUp.getExitCollection().addExit("south", new Exit("you see an open space to the south", riverHill));
		startUp.getExitCollection().addExit("southwest",
				new Exit("you are welcomed by the people in the valley", valley));

		// Add exits to riverhill
		riverHill.getExitCollection().addExit("west", new Exit("you see a wonderful blue water lake", lake));
		riverHill.getExitCollection().addExit("east", new Exit("you see a valley full of people", valley));
		riverHill.getExitCollection().addExit("south", new Exit("you see the only available weapon shop", weaponary));
		riverHill.getExitCollection().addExit("north", new Exit("you are now back to the starting point", startUp));

		// Add exits to valley
		valley.getExitCollection().addExit("east", new Exit("you are now at riverhill", riverHill));
		valley.getExitCollection().addExit("southeast",
				new Exit("you are now at the weaponary(weapon shop)", weaponary));

		// Add exits to lake
		lake.getExitCollection().addExit("west", new Exit("you see yourself at riverhill", riverHill));
		lake.getExitCollection().addExit("south", new Exit("you see yourself looking at Gaint Mountains", mountains));
		lake.getExitCollection().addExit("east", new Exit("you see yourself at the weapon arsenal", arsenal));

		// Add exits to weaponary
		weaponary.getExitCollection().addExit("north", new Exit("you are now at riverhill", riverHill));
		weaponary.getExitCollection().addExit("south", new Exit("you are now at a new kingdom Westoros", westros));
		weaponary.getExitCollection().addExit("northwest", new Exit("you are now with peoples in the valley", valley));

		// Add exits to Mountains
		mountains.getExitCollection().addExit("north", new Exit("you see yourself at blue water lake", lake));
		mountains.getExitCollection().addExit("south", new Exit("you see Citadale a house of terror", citadale));
		mountains.getExitCollection().addExit("northeast", new Exit("you see yourself at the weapon arsenal", arsenal));

		// Add exits to westros
		westros.getExitCollection().addExit("north",
				new Exit("you see a weapon shop where you can buy and exchange weapons", weaponary));
		westros.getExitCollection().addExit("east",
				new Exit("you see yourself at house of terror at Citadale", citadale));

		// Add exits to citadale
		citadale.getExitCollection().addExit("west", new Exit("you are now at a kingdom of Westros", westros));
		citadale.getExitCollection().addExit("north", new Exit("you are looking at the Gaint Mountains", mountains));

		// Add exit to arsenal
		arsenal.getExitCollection().addExit("west", new Exit("you see yourself at the blue water lake", lake));
		arsenal.getExitCollection().addExit("southwest",
				new Exit("you see yourself infront of a gaint mountains", mountains));

	}

	private void populateStrengthTable() {
		StrengthTable strengthModifiers = StrengthTable.getInstance();
		strengthModifiers.setModifier(1, -5);
		strengthModifiers.setModifier(2, -4);
		strengthModifiers.setModifier(3, -4);
		strengthModifiers.setModifier(4, -3);
		strengthModifiers.setModifier(5, -3);
		strengthModifiers.setModifier(6, -2);
		strengthModifiers.setModifier(7, -2);
		strengthModifiers.setModifier(8, -1);
		strengthModifiers.setModifier(9, -1);
		strengthModifiers.setModifier(10, 0);
		strengthModifiers.setModifier(11, 0);
		strengthModifiers.setModifier(12, 1);
		strengthModifiers.setModifier(13, 1);
		strengthModifiers.setModifier(14, 2);
		strengthModifiers.setModifier(15, 2);
		strengthModifiers.setModifier(16, 3);
		strengthModifiers.setModifier(17, 3);
		strengthModifiers.setModifier(18, 4);
		strengthModifiers.setModifier(19, 4);
		strengthModifiers.setModifier(20, 5);
		strengthModifiers.setModifier(21, 5);
		strengthModifiers.setModifier(22, 5);
		strengthModifiers.setModifier(23, 5);
		strengthModifiers.setModifier(24, 5);
		strengthModifiers.setModifier(25, 5);
		strengthModifiers.setModifier(26, 8);
		strengthModifiers.setModifier(27, 8);
		strengthModifiers.setModifier(28, 8);
		strengthModifiers.setModifier(29, 8);
		strengthModifiers.setModifier(30, 10);
		strengthModifiers.setModifier(31, 10);
		strengthModifiers.setModifier(32, 10);
		strengthModifiers.setModifier(33, 10);
		strengthModifiers.setModifier(34, 10);
		strengthModifiers.setModifier(35, 10);
		strengthModifiers.setModifier(36, 12);
		strengthModifiers.setModifier(37, 12);
		strengthModifiers.setModifier(38, 12);
		strengthModifiers.setModifier(39, 12);
		strengthModifiers.setModifier(40, 12);
		strengthModifiers.setModifier(41, 15);
		strengthModifiers.setModifier(42, 15);
		strengthModifiers.setModifier(43, 15);
		strengthModifiers.setModifier(44, 17);
		strengthModifiers.setModifier(45, 17);
		strengthModifiers.setModifier(46, 18);
	}

	private void populateAgilityTable() {
		AgilityTable agilityModifiers = AgilityTable.getInstance();
		agilityModifiers.setModifier(1, -5);
		agilityModifiers.setModifier(2, -5);
		agilityModifiers.setModifier(3, -5);
		agilityModifiers.setModifier(4, -3);
		agilityModifiers.setModifier(5, -3);
		agilityModifiers.setModifier(6, -2);
		agilityModifiers.setModifier(7, -2);
		agilityModifiers.setModifier(8, -1);
		agilityModifiers.setModifier(9, -1);
		agilityModifiers.setModifier(10, 0);
		agilityModifiers.setModifier(11, 0);
		agilityModifiers.setModifier(12, 1);
		agilityModifiers.setModifier(13, 1);
		agilityModifiers.setModifier(14, 2);
		agilityModifiers.setModifier(15, 2);
		agilityModifiers.setModifier(16, 3);
		agilityModifiers.setModifier(17, 3);
		agilityModifiers.setModifier(18, 4);
		agilityModifiers.setModifier(19, 4);
		agilityModifiers.setModifier(20, 6);
		agilityModifiers.setModifier(21, 6);
		agilityModifiers.setModifier(22, 6);
		agilityModifiers.setModifier(23, 6);
		agilityModifiers.setModifier(24, 6);
		agilityModifiers.setModifier(25, 6);
		agilityModifiers.setModifier(26, 8);
		agilityModifiers.setModifier(27, 8);
		agilityModifiers.setModifier(28, 8);
		agilityModifiers.setModifier(29, 8);
		agilityModifiers.setModifier(30, 8);
		agilityModifiers.setModifier(31, 8);
		agilityModifiers.setModifier(32, 11);
		agilityModifiers.setModifier(33, 11);
		agilityModifiers.setModifier(34, 11);
		agilityModifiers.setModifier(35, 11);
		agilityModifiers.setModifier(36, 11);
		agilityModifiers.setModifier(37, 11);
		agilityModifiers.setModifier(38, 13);
		agilityModifiers.setModifier(39, 13);
		agilityModifiers.setModifier(40, 13);
		agilityModifiers.setModifier(41, 13);
		agilityModifiers.setModifier(42, 13);
		agilityModifiers.setModifier(43, 13);
		agilityModifiers.setModifier(44, 15);
		agilityModifiers.setModifier(45, 15);
		agilityModifiers.setModifier(46, 15);
	}

	private void populateWeightLimitTable() {
		WeightLimit weightModifier = WeightLimit.getInstance();
		weightModifier.setModifier(1, 6);
		weightModifier.setModifier(2, 13);
		weightModifier.setModifier(3, 20);
		weightModifier.setModifier(4, 26);
		weightModifier.setModifier(5, 33);
		weightModifier.setModifier(6, 40);
		weightModifier.setModifier(7, 46);
		weightModifier.setModifier(8, 53);
		weightModifier.setModifier(9, 60);
		weightModifier.setModifier(10, 66);
		weightModifier.setModifier(11, 76);
		weightModifier.setModifier(12, 86);
		weightModifier.setModifier(13, 100);
		weightModifier.setModifier(14, 116);
		weightModifier.setModifier(15, 133);
		weightModifier.setModifier(16, 153);
		weightModifier.setModifier(17, 173);
		weightModifier.setModifier(18, 200);
		weightModifier.setModifier(19, 233);
		weightModifier.setModifier(20, 266);
		weightModifier.setModifier(21, 306);
		weightModifier.setModifier(22, 346);
		weightModifier.setModifier(23, 400);
		weightModifier.setModifier(24, 466);
		weightModifier.setModifier(25, 533);
		weightModifier.setModifier(26, 613);
		weightModifier.setModifier(27, 693);
		weightModifier.setModifier(28, 800);
		weightModifier.setModifier(29, 933);
		weightModifier.setModifier(30, 1013);
		weightModifier.setModifier(31, 1093);
		weightModifier.setModifier(32, 1300);
		weightModifier.setModifier(33, 1433);
		weightModifier.setModifier(34, 1513);
		weightModifier.setModifier(35, 1593);
		weightModifier.setModifier(36, 1700);
		weightModifier.setModifier(37, 1833);
		weightModifier.setModifier(38, 1913);
		weightModifier.setModifier(39, 1993);
		weightModifier.setModifier(40, 2100);
		weightModifier.setModifier(41, 2233);
		weightModifier.setModifier(42, 2313);
		weightModifier.setModifier(43, 2393);
		weightModifier.setModifier(44, 2500);
		weightModifier.setModifier(45, 2633);
		weightModifier.setModifier(46, 2713);
	}
}
