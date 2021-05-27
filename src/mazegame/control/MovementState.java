package mazegame.control;

import mazegame.entity.Blacksmith;
import mazegame.entity.Player;

public class MovementState extends CommandState {

	public MovementState() {
		this.getAvailableCommands().put("go", new MoveCommand());
		this.getAvailableCommands().put("quit", new QuitCommand());
		this.getAvailableCommands().put("move", new MoveCommand());
		this.getAvailableCommands().put("look", new LookCommand());
		this.getAvailableCommands().put("unlock", new UnlockCommand());
		this.getAvailableCommands().put("attack", new AttackCommand());
	}

	@Override
	public CommandState update(Player thePlayer) {
		// TODO Auto-generated method stub
		if (thePlayer.getCurrentLocation() instanceof Blacksmith)
			return new CommerceState();
		return this;

	}

}
