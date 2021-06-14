package mazegame.entity;

public abstract class Item {
	
	private String label;
	private int value;
	private double weight;
	private String description;
	boolean equiped;

	public Item (String label, int value, double weight, String description)
	{
		this.label = label;
		this.value = value;
		this.weight = weight;
		this.description = description;
		this.equiped = false;
	}

	public String getLabel() {

		return label;
	}
	
	public int getValue() 
	{
		return value;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public String getDescription()
	{
		return description;
	}
	

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isEquiped() {
		return equiped;
	}

	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}
}
