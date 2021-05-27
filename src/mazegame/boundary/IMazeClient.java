package mazegame.boundary;

public interface IMazeClient {
	public String getReply (String question);
	public void playerMessage (String message);
	
	//Adding a method to get the commands from the player. 
	public String getCommand();
}
