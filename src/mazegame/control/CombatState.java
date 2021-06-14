package mazegame.control;

import mazegame.entity.Blacksmith;
import mazegame.entity.Dragon;
import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;

public class CombatState extends CommandState {
	public CombatState() {
		this.getAvailableCommands().put("go", new MoveCommand());
		this.getAvailableCommands().put("attack", new BuyCommand());
		this.getAvailableCommands().put("move", new MoveCommand());
		this.getAvailableCommands().put("look", new LookCommand());
		this.getAvailableCommands().put("talk", new SellCommand());
		this.getAvailableCommands().put("flee", new FleeCommand());
	}

	@Override
	public CommandState update(Player thePlayer) {
		if(thePlayer.getCurrentLocation() instanceof Blacksmith)
			return new CommerceState();
		return new MovementState();
	}

}
