package mazegame.control;

import mazegame.entity.Player;

public class ListItemCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if (userInput.getArguments().size() == 0) {
			if (!thePlayer.getInventory().getItemList().isEmpty()) {
				return new CommandResponse("Hello " + thePlayer.getName().toUpperCase()
						+ ",\n You have following items in your bag(list) :\n"
						+ thePlayer.getInventory().toString());

			} else {
				return new CommandResponse(
						"Hello " + thePlayer.getName().toUpperCase() + "\nYou have no items in your bag(list)");

			}

		} else {
			return new CommandResponse(
					"No Additional argument required for the command hints");
		}
	}

}
