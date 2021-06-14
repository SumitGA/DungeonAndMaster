package mazegame.control;

import mazegame.entity.Blacksmith;
import mazegame.entity.Dragon;
import mazegame.entity.Player;

public class MovementState extends CommandState {

	public MovementState() {
		this.getAvailableCommands().put("go", new MoveCommand());
		this.getAvailableCommands().put("quit", new QuitCommand());
		this.getAvailableCommands().put("move", new MoveCommand());
		this.getAvailableCommands().put("look", new LookCommand());
		this.getAvailableCommands().put("unlock", new UnlockCommand());
		this.getAvailableCommands().put("list", new ListItemCommand());
		this.getAvailableCommands().put("get", new GetItemCommand());
		this.getAvailableCommands().put("help", new HelpCommand());
		this.getAvailableCommands().put("drop", new DropItemCommand());
		this.getAvailableCommands().put("status", new GetStatusCommand());
		this.getAvailableCommands().put("attack", new AttackCommand());
		this.getAvailableCommands().put("use", new UsePotionCommand());
		this.getAvailableCommands().put("talk", new TalkCommand());
		this.getAvailableCommands().put("equip", new EquipCommand());
		this.getAvailableCommands().put("unequip", new UnEquipCommand());
		this.getAvailableCommands().put("flee", new FleeCommand());
	}

	@Override
	public CommandState update(Player thePlayer) {
		if (thePlayer.getCurrentLocation() instanceof Blacksmith)
			return new CommerceState();
		return this;
	}

}
