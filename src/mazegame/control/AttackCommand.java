package mazegame.control;

import javax.swing.JOptionPane;

import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;
import mazegame.entity.utility.DiceRoller;

public class AttackCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		StringBuilder message = new StringBuilder();
		if (!thePlayer.getCurrentLocation().getNpcs().isEmpty()) {
			for (Object npc : thePlayer.getCurrentLocation().getNpcs().values()) {
				if (((NonPlayerCharacter) npc).isHostile()) {
					if (userInput.getArguments().size() == 0) {
						return new CommandResponse("!!!Warning there is a dragon and seems to be powerful."
								+ "If you want to attack the dragon type 'attack dragon' or else you can 'flee' "
								+ "from this location ");
					} else {

						if (!(userInput.getArguments().get(0).toString().toLowerCase()
								.equals(((NonPlayerCharacter) npc).getName().toLowerCase()))) {
							return new CommandResponse("If you want to kill the dragon type attack dragon");
						}
						boolean playerTurn = true;
						while (((NonPlayerCharacter) npc).getLifePoints() > 0 && thePlayer.getLifePoints() > 0) {
							if (playerTurn) {
								int attackDamage = DiceRoller.GetInstance().generateAbilityScore();
								((NonPlayerCharacter) npc)
										.setLifePoints(((NonPlayerCharacter) npc).getLifePoints() - attackDamage);
								playerTurn = false;
							} else {
								int npcAttack = DiceRoller.GetInstance().generateAbilityScore();
								thePlayer.setLifePoints(thePlayer.getLifePoints() - npcAttack);
								playerTurn = true;
							}
							message.append(((NonPlayerCharacter) npc).getCurrentPlayerStat(thePlayer));
							message.append(
									((NonPlayerCharacter) npc).getCurrentPlayerStat((NonPlayerCharacter) npc) + "\n");
						}
						if (thePlayer.getLifePoints() <= 0) {
							message.append("Winner" + ((NonPlayerCharacter) npc).getName() + "\n");
							return new CommandResponse(message.toString(), true);
						} else if (((NonPlayerCharacter) npc).getLifePoints() <= 0) {
							message.append("Winner" + thePlayer.getName()+ "\n");
							int bonus = DiceRoller.GetInstance().generateAbilityScore() * 50;
							thePlayer.getInventory().addMoney(bonus);
							message.append("Congratulations!! you get " + bonus + " point for killing the Dragon \n");
							message.append(thePlayer.getCurrentPlayerStat(thePlayer));
							thePlayer.getCurrentLocation().removeNPC(((NonPlayerCharacter) npc));
							message.append("Congraz you killed the Dragon");
						}
					}
					return new CommandResponse(message.toString());
				}
			}
			message.append("No Dragon to attack");

		} else {
			message.append("No Dragon to attack");
		}

		return new CommandResponse(message.toString());

	}

}
