package mazegame.control;

import java.util.ArrayList;
import java.util.List;

import mazegame.HardCodedData;
import mazegame.entity.Blacksmith;
import mazegame.entity.Exit;
import mazegame.entity.ExitCollection;
import mazegame.entity.Location;
import mazegame.entity.Player;

public class GetStatusCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		StringBuilder message = new StringBuilder();

		if (userInput.getArguments().size() == 0) {
			ArrayList<Location> loc = new ArrayList<Location>();
			HardCodedData data = new HardCodedData();
			int n = 0;
			int m = 0;
			for(int i = 0; i < data.getLocationList().size(); i++) {
				if(data.getLocationList().get(i) instanceof Blacksmith) {
					n ++;
				} else {
					m ++;
				}
			}
			message.append("--------------Game Status--------------\n Available exits:\n");
			for(int i = 0; i < data.getLocationList().size(); i++) {
				message.append(data.getLocationList().get(i).getLabel()+"\n");
			}
			message.append("\n"+thePlayer.getCurrentPlayerStat(thePlayer));
			return new CommandResponse(message.toString());

		} else {
			return new CommandResponse("No need of argument accepted for this command");
		}
	}

	public ArrayList<ExitCollection> getAll(ArrayList<Location> locat, Location loc) {
		ArrayList<ExitCollection> temp = new ArrayList<ExitCollection>();
		temp = loc.getAvailableExits();
			for(int i = 0 ; i < temp.size(); i++) {
				System.out.println(temp.get(i).availableExits());
			}
		return temp;
	}
}
