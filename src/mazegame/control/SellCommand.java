package mazegame.control;

import mazegame.entity.Player;

public class SellCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		return new CommandResponse ("You entered the sell command");
	}

}
