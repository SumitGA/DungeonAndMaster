package mazegame.control;

import mazegame.entity.Player;

public class TalkCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		StringBuilder message = new StringBuilder();
		if (thePlayer.getCurrentLocation().getNpcs().size() > 0) {
			if (userInput.getArguments().size() == 0) {
				return new CommandResponse("If you want to talk to character, type 'name', 'purpose', 'age' " );
			}

			String itemName = userInput.getArguments().get(0).toString();
			if(itemName.contentEquals("name")) {
				System.out.println("Name section");
				message.append("\nHi! I am "+thePlayer.getCurrentLocation().getNPCName());
			}else if(itemName.contentEquals("age")) {
				message.append("\nI was recently created. My age is less than a month");
			}else if(itemName.contentEquals("bye")) {
				message.append("\nBye "+thePlayer.getName()+ " Good luck and all the best for your battle. See you sometime soon. ");
			}
			return new CommandResponse(message.toString());
		} else {
			message.append("There is no any non player character to talk to.");
		}
		return new CommandResponse(message.toString());
	}

}
