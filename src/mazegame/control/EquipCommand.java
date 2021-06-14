package mazegame.control;

import mazegame.entity.Armor;
import mazegame.entity.Item;
import mazegame.entity.Player;
import mazegame.entity.Shield;
import mazegame.entity.Weapon;
import mazegame.entity.utility.AgilityTable;

public class EquipCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		StringBuilder message = new StringBuilder();

		if (userInput.getArguments().size() == 0) {

			message.append("If you want to wear or weild an item, you need to tell what you want to wear/wield.");
			message.append(thePlayer.getInventory().printItemList());
			return new CommandResponse(message.toString());
		}

		String itemName = userInput.getArguments().get(0).toString();

		if (thePlayer.getInventory().getItemList().containsKey(itemName)) {
			// Finding and getting the item requested
			Item item = thePlayer.getInventory().findItem(userInput.getArguments().get(0).toString());
			if (!item.isEquiped()) {
				// Now Can successfully sell so adding and removing item
				thePlayer.setAgility(
						thePlayer.getAgility() - AgilityTable.getInstance().getModifier((int) item.getWeight()));
				if (item instanceof Armor) {
					thePlayer.setLifePoints(thePlayer.getLifePoints() + ((Armor) item).getProtection());
					thePlayer.setStrength(thePlayer.getStrength() + ((Weapon) item).getCombatPower());
					message.append("The player has successfully weild the " + item.getLabel() + " Armor.\n");
				} else if (item instanceof Shield) {
					thePlayer.setLifePoints(thePlayer.getLifePoints() + ((Shield) item).getProtection());
					message.append("The player has successfully wield the " + item.getLabel()+ " shield.\n");
				}
				item.setEquiped(true);
				message.append("\n"+thePlayer.getCurrentPlayerStat(thePlayer));
			} else {
				message.append("You are already wearing/holding the " + item.getLabel() + ".\n");
				message.append("Please select another item from following list:");
				message.append(thePlayer.getInventory().printItemList());
			}

		} else {
			message.append(
					"There is no such items in your bag, \nPlease tell the name of item from your bag if you want to wear/weild it.\n");
			message.append(thePlayer.getInventory().printItemList());
		}
		return new CommandResponse(message.toString());
	}

}
