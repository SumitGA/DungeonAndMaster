package mazegame.control;

import mazegame.entity.Blacksmith;
import mazegame.entity.Item;
import mazegame.entity.Player;

public class SellCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		StringBuilder message = new StringBuilder();
		if (thePlayer.getCurrentLocation() instanceof Blacksmith) {
			if (userInput.getArguments().size() == 0) {
				return new CommandResponse("If you want to sell an item, you need to tell what you want to sell.");
			}
		} else {
			return new CommandResponse("There is no informer in this room, you cannot sell an items here.");
		}
		String itemName = userInput.getArguments().get(0).toString();

		if (thePlayer.getInventory().getItemList().containsKey(itemName)) {
			// Finding and getting the item requested
			Item item = thePlayer.getInventory().findItem(userInput.getArguments().get(0).toString());

			// Now Can successfully sell so adding and removing item
			thePlayer.getCurrentLocation().getInventory().addItem(item);
			thePlayer.getInventory().removeItem(itemName);

			// adding and removing money with 10% cut from original price
			thePlayer.getInventory().addMoney((int) (item.getValue() * 0.8));
			thePlayer.getCurrentLocation().getInventory().removeMoney((int) (item.getValue() * 0.8));
			item.setValue((int) (item.getValue() * 0.8));// The price of item is now degraded by 10%

			// Now printing the status after the player has selling the item
			message.append("You have successfully sold the " + itemName + "\n");
			message.append(thePlayer.getCurrentPlayerStat(thePlayer));

		} else {
			message.append("There is no such items in your bag, Please sell items in your bag.\n");
			message.append(thePlayer.getInventory().printItemList());

		}

		return new CommandResponse(message.toString());
	}

}
