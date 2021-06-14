package mazegame.control;

import mazegame.entity.Player;

public class UsePotionCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		StringBuilder message = new StringBuilder();

		if (thePlayer.getInventory().getItemList().isEmpty()) {
			return new CommandResponse("You don't have any item on your bag to use them.");
		}
		if (userInput.getArguments().size() == 0) {
			return new CommandResponse("If you want to use an item you need to tell us.");
		}

		String itemName = userInput.getArguments().get(0).toString();
		if (thePlayer.getInventory().getItemList().containsKey(itemName)) {
			thePlayer.setLifePoints(1000);
			thePlayer.getInventory().removeItem(itemName);
			message.append("You have successfully use potion and revived your life" + "\n");
			message.append(thePlayer.getCurrentPlayerStat(thePlayer));
		} else {
			message.append(
					"There is no such items in your bag, \nPlease tell the name of item from your bag if you want to use.\n");
			message.append(thePlayer.getInventory().printItemList());
		}
		return new CommandResponse(message.toString());
	}

}
