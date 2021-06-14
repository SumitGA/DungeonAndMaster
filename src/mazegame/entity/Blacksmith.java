package mazegame.entity;

public class Blacksmith extends Location {


	private Inventory storage;
	
	public Blacksmith() {
		
	}

	public Blacksmith(String description, String label) {
		super(description, label);
		storage = new Inventory();
	}

	public void addItem(Item item) {
		storage.addItem(item);
	}

	public Inventory getStorage() {
		return storage;
	}
}
