package mazegame.control;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import mazegame.entity.Player;

class FleeCommandTest {

	/**
	 * Testing that flee command is executed while the  user provides 'flee command'
	 */
	@Test
	void test() {
		String command = "flee";
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("south");
		ParsedInput userInput = new ParsedInput(command, arguments);
		Player player = new Player("sumit");
		FleeCommand flee = new FleeCommand();
	}
}
