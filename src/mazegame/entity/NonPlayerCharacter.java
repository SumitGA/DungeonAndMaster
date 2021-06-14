package mazegame.entity;

public class NonPlayerCharacter extends Character {
	private Boolean hostile;

	public NonPlayerCharacter(String name) {
		super(35, 30, name, 35);
		setHostile(false);
	}

	public NonPlayerCharacter(String name, boolean hostile) {
		super(name);
		setHostile(hostile);
	}

	public boolean isHostile() {
		return this.hostile;
	}

	public void setHostile(boolean hostile) {
		this.hostile = hostile;
	}

	public String getCurrentPlayerStat(Character player) {
		StringBuilder message = new StringBuilder();
		message.append(player.getName().toUpperCase() + ",\n");
		message.append("You have lifepoint: " + player.getLifePoints() + "\n");
		return message.toString();
	}

}
