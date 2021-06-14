package mazegame.entity;

public class Armor extends Item {
	private int bonus;	
	
	int healthpower;

	public int getProtection() {
		return healthpower;
	}

	public void setProtection(int protection) {
		this.healthpower = protection;
	}

	public Armor (String label, int value, double weight, String description, int protection) {
		super (label, value, weight, description);
		this.healthpower=protection;
	}
	
	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
