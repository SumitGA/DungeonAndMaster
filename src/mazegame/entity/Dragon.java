package mazegame.entity;

public class Dragon extends NonPlayerCharacter {

	private Inventory storage;

	public Dragon(String name) {
		super(name);
		storage = new Inventory();
	}

	public void addItem(Item item) {
		storage.addItem(item);
	}

	public Inventory getStorage() {
		return storage;
	}
}
