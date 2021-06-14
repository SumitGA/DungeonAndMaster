package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class GetItemCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		StringBuilder message = new StringBuilder();
		String itemName = userInput.getArguments().get(0).toString();

		if (thePlayer.getCurrentLocation().getInventory().hasCoins()) {
			int money = thePlayer.getCurrentLocation().getInventory().printMoney();
			thePlayer.getCurrentLocation().getInventory().removeMoney(money);
			thePlayer.getInventory().addMoney(money);
				message.append("You have successfully picked the " + itemName + "\n");
				message.append(thePlayer.getCurrentPlayerStat(thePlayer));

			} else {
				message.append(
						"There is no coins in this location.\n");
				message.append(thePlayer.getCurrentPlayerStat(thePlayer));
			}

		return new CommandResponse(message.toString());
	}

}
