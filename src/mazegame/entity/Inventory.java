package mazegame.entity;

import java.util.Formatter;
import java.util.HashMap;

public class Inventory {
	private Money gold;
	private HashMap<String, Item> itemList;

	public Inventory() {
		gold = new Money();
		itemList = new HashMap<String, Item>();
	}

	public void addMoney(int goldPieces) {
		gold.Add(goldPieces);
	}

	public boolean removeMoney(int goldPieces) {
		return gold.Subtract(goldPieces);
	}

	public boolean addItem(Item theItem) {
		itemList.put(theItem.getLabel(), theItem);
		return true;
	}

	public boolean hasCoins() {
		if (this.gold != null) {
			return true;
		} else {
			return false;

		}
	}
	

	public Item removeItem(String itemName) {
		if (itemList.containsKey(itemName)) {
			itemList.remove(itemName);
			return itemList.get(itemName);
		}
//        else return ("That item isn't here to remove");
		else
			return null;
	}

	public String printItemList() {
		if (itemList.size() == 0)
			return "No item here";
		StringBuilder returnMsg = new StringBuilder();
		Formatter formatter = new Formatter(returnMsg);
		String format = "%-37s %-65s %-9s %-9s";
		Boolean first = true;
		Boolean second = true;
		Boolean third = true;
		for (String item : itemList.keySet()) {
			if (itemList.get(item) instanceof Armor) {
				if (first) {
					returnMsg.append(
							"\n******************************************************** || Item List|| ********************************************************\n\n");
					returnMsg.append(
							"-------------------------------------------------------------------------------------------------------------------------------\n");
					formatter.format(format, "Item", "Description", "Item/price", "Item Weight\n");
					returnMsg.append(
							"-------------------------------------------------------------------------------------------------------------------------------\n");
					first = false;
				}
				formatter.format(format, itemList.get(item).getLabel(), itemList.get(item).getDescription(),
						itemList.get(item).getValue(), itemList.get(item).getWeight());

				returnMsg.append("\n");
			}
		}

		for (String item : itemList.keySet()) {
			if (itemList.get(item) instanceof Weapon) {
				if (second) {
					returnMsg.append(
							"\n\n******************************************************** || Item List || ********************************************************\n\n");
					returnMsg.append(
							"-------------------------------------------------------------------------------------------------------------------------------\n");
					formatter.format(format, "Item", "Description", "Item Price/Gold", "Weight\n");
					returnMsg.append(
							"-------------------------------------------------------------------------------------------------------------------------------\n");

					second = false;
				}
				formatter.format(format, itemList.get(item).getLabel(), itemList.get(item).getDescription(),
						itemList.get(item).getValue(), itemList.get(item).getWeight());

				returnMsg.append("\n");
			}
		}

		for (String item : itemList.keySet()) {

			if (itemList.get(item) instanceof Shield) {
				if (third) {
					returnMsg.append(
							"\n\n******************************************************** || Item List || ********************************************************\n\n");
					returnMsg.append(
							"-------------------------------------------------------------------------------------------------------------------------------\n");
					formatter.format(format, "Item", "Description", "Item Price/Gold", "Weight\n");
					returnMsg.append(
							"-------------------------------------------------------------------------------------------------------------------------------\n");
					third = false;
				}
				formatter.format(format, itemList.get(item).getLabel(), itemList.get(item).getDescription(),
						itemList.get(item).getValue(), itemList.get(item).getWeight());
				returnMsg.append("\n");
			}
		}
		returnMsg.append("\n\n");
		formatter.close();
		return returnMsg.toString();

	}

	public String toString() {
		return printItemList() + "\n" + gold.toString();
	}

	public HashMap<String, Item> getItemList() {
		return itemList;
	}

	public Item findItem(String itemLabel) {
		if (itemList.containsKey(itemLabel)) {
			return itemList.get(itemLabel);
		} else {
			return null;
		}

	}

	public int printMoney() {
		return gold.getTotal();
	}

}