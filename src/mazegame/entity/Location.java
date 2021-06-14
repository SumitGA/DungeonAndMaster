package mazegame.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Location {
	private HashMap<String, Exit> exits;
	private HashMap characters;
	private Inventory items;
	private ExitCollection exitCollection;
	private String description;
	private String label;
	private HashMap npcs;

	public Location() {
		exitCollection = new ExitCollection();
		items = new Inventory();
	}

	public Location(String description, String label) {
		this(); // What does this accomplish
		this.setDescription(description);
		this.setLabel(label);
		exits = new HashMap();
		items = new Inventory();
		npcs = new HashMap();
	}

	public boolean addExit(String exitLabel, Exit theExit) {
		if (exits.containsKey(exitLabel))
			return false;
		exits.put(exitLabel, theExit);
		return true;
	}

	public Exit getExit(String exitLabel) {
		return (Exit) exits.get(exitLabel);
	}

	public Inventory getInventory() {
		return items;
	}

	public ExitCollection getExitCollection() {
		return exitCollection;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean containsExit(String exitLabel) {
		return exits.containsKey(exitLabel);
	}

	public String availableExits() {
		StringBuilder returnMsg = new StringBuilder();
		for (Object label : this.exits.keySet()) {
			returnMsg.append("[" + label.toString() + "] ");
		}
		return returnMsg.toString();
	}

	public ArrayList<ExitCollection> getAvailableExits() {
		ArrayList<ExitCollection> temp = new ArrayList<ExitCollection>();
		for (Object label : this.exits.values()) {
			temp.add((ExitCollection) label);
		}
		return temp;
	}
	
	public ArrayList<Exit> getAllExits() {
		ArrayList<Exit> temp = new ArrayList<Exit>();
		for(Object label: this.exits.values()) {
			temp.add((Exit) label);
		}
		return temp;
	}

	public void addNPC(NonPlayerCharacter npc) {
		if (npc != null)
			npcs.put(npc.getName(), npc);
	}

	public HashMap getNpcs() {
		return npcs;
	}

	public void setNpcs(HashMap npcs) {
		this.npcs = npcs;
	}

	public NonPlayerCharacter getNPC(String npcName) {
		if (npcs.containsKey(npcName))
			return (NonPlayerCharacter) npcs.get(npcName);
		else
			return null;
	}

	public boolean hasBlacksmith() {
		for (Object npc : npcs.values()) {
			if (npc instanceof Blacksmith) {
				return true;
			}
		}
		return false;
	}

	public boolean hasDragon() {
		boolean result = false;
		for (Object npc : npcs.values()) {
			if (npc instanceof Dragon) {
				result = true;
				break;
			} else {
				result = false;
			}
		}
		return result;
	}

	public Blacksmith getBlacksmith() {
		if (hasBlacksmith()) {
			for (Object npc : npcs.values()) {
				if (npc instanceof Blacksmith) {
					return (Blacksmith) npc;
				}
			}
		}
		return null;
	}

	public void removeNPC(NonPlayerCharacter npc) {
		if (npcs.containsKey(npc))
			npcs.remove(npc.getName());
	}
	
	public String getNPCName() {
		if(npcs.size() > 0) {
			return(""+npcs.keySet().toString());
		}else {
			return("");
		}
	}

	public String getNPCDetails() {
		if (npcs.size() > 0) {
			return ("\nSome NPC characters are here : " + npcs.keySet().toString());
		} else {
			return "\nNo NPC charcters present here.";
		}
	}

	public void addItems(Item item) {
		items.addItem(item);
	}

	public String toString() {
		return "\n" + this.label + "\n" + "Exits found :: " + exitCollection.availableExits() + "\n**********\n" + "\n"
				+ items.toString() + ". Info: " + this.description + "\n**********\n";
	}

}
