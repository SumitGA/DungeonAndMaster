package mazegame.control;

import mazegame.entity.Blacksmith;
import mazegame.entity.Player;

public class CommerceState extends CommandState {
	public CommerceState() {
		this.getAvailableCommands().put("go", new MoveCommand());
		this.getAvailableCommands().put("buy", new BuyCommand());
		this.getAvailableCommands().put("move", new MoveCommand());
		this.getAvailableCommands().put("sell", new SellCommand());
		this.getAvailableCommands().put("list", new ListItemCommand());
		this.getAvailableCommands().put("quit", new QuitCommand());
		this.getAvailableCommands().put("get", new GetItemCommand());
		this.getAvailableCommands().put("drop", new DropItemCommand());
		this.getAvailableCommands().put("status", new GetStatusCommand());
		this.getAvailableCommands().put("equip", new EquipCommand());
		this.getAvailableCommands().put("unequip", new UnEquipCommand());
		this.getAvailableCommands().put("help", new HelpCommand());
	}
	
	@Override
	public CommandState update(Player thePlayer) {
		if (thePlayer.getCurrentLocation() instanceof Blacksmith)
			return this;
		return new MovementState();
	}
}
