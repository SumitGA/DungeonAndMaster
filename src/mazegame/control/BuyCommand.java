package mazegame.control;

import java.util.ArrayList;
import java.util.HashMap;
import mazegame.entity.Blacksmith;
import mazegame.entity.Item;
import mazegame.entity.Player;

public class BuyCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		StringBuilder message = new StringBuilder();
		if (thePlayer.getCurrentLocation() instanceof Blacksmith) {
			if (userInput.getArguments().size() == 0) {
				return new CommandResponse(
						"If you want to purchase an item, you need to tell what you want to purchase.");
			}
		} else {
			return new CommandResponse("You cannot purchase any items here.");
		}
		String itemName = userInput.getArguments().get(0).toString();

		if (thePlayer.getCurrentLocation().getInventory().findItem(itemName.toLowerCase()) != null) {
			double weightLimit = thePlayer.getInventory().getWeightLimit();// Total weight player can carry
			double currentWeight = thePlayer.getInventory().getWeight();// Current weight player is carrying
			int numberOfGolds = thePlayer.getInventory().printMoney();// The number of golds player has

			// Finding and getting the item requested
			Item item = thePlayer.getCurrentLocation().getInventory()
					.findItem(userInput.getArguments().get(0).toString());

			// Checking if the the player has the golds to pay for this item
			// check the weight limit of player is not exceeded if the player buys the item
			if (item.getValue() <= numberOfGolds && item.getWeight() <= (weightLimit - currentWeight)) {
				// successfully purchase so adding and removing item
				thePlayer.getCurrentLocation().getInventory().removeItem(itemName);
				thePlayer.getInventory().addItem(item);
				System.out.println("Adding Items");
				// adding and removing money
				thePlayer.getInventory().removeMoney(item.getValue());
				thePlayer.getCurrentLocation().getInventory().addMoney(item.getValue());

				// display the status after the player has purchased the item
				message.append("You have successfully purchased the " + itemName + "\n");
				message.append(thePlayer.getCurrentPlayerStat(thePlayer));

			} else {
				message.append(
						"You don't have enough space or money to buy this item. Please check your resource and try again!!\n");
				message.append(thePlayer.getCurrentPlayerStat(thePlayer));
			}

		} else {
			message.append("There is no such items in this store, Please purchase given items in list\n");
			message.append(thePlayer.getCurrentLocation().getInventory().printItemList());

		}

		return new CommandResponse(message.toString());
	}
}
