package mazegame.control;

import java.io.IOException;
import java.util.ArrayList;

import mazegame.SimpleConsoleClient;
import mazegame.boundary.IMazeClient;
import mazegame.boundary.IMazeData;
import mazegame.entity.Exit;
import mazegame.entity.Player;

public class DungeonMaster {
	private IMazeClient gameClient;
	private IMazeData gameData;
	private Player thePlayer;
	private CommandHandler playerTurnHandler;

	public DungeonMaster(IMazeData gameData, IMazeClient gameClient) {
		this.gameData = gameData;
		this.gameClient = gameClient;
		playerTurnHandler = new CommandHandler();
	}

	public void printWelcome() {
		gameClient.playerMessage(gameData.getWelcomeMessage());
	}

	public void setupPlayer() {
		String playerName = gameClient.getReply("What name do you choose to be known by?");
		thePlayer = new Player(playerName);
		thePlayer.setCurrentLocation(gameData.getStartingLocation());
		gameClient.playerMessage("Welcome " + playerName + "\n\n");
		gameClient.playerMessage("You find yourself looking at ");
		gameClient.playerMessage(gameData.getStartingLocation().getDescription());
	}

	public void runGame() {
		printWelcome();
		setupPlayer();
		while (handlePlayerTurn()) {
			//We will add non player characters actions later.
			
		}
		gameClient.getReply("\n\n<<Hit enter to exit>>");
	}

	/*
	 * This will ideally return the command from the users and checks if the quit
	 * command is invoked. If quit command is issued the game will exit or else
	 * player will keep on invoking other commands
	 */
	private boolean handlePlayerTurn() {
		CommandResponse playerResponse = playerTurnHandler.processTurn(gameClient.getCommand(), thePlayer);
		gameClient.playerMessage(playerResponse.getMessage());
		return !playerResponse.isFinishedGame();

	}
}
