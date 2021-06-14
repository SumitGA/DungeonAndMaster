package mazegame.control;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;


class ParsedInputTest {


	@Test
	void test() {
		String command = "move";
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("south");
		ParsedInput userInput = new ParsedInput(command, arguments);
		Assert.assertEquals(userInput.getCommand(), "move");
		Assert.assertEquals(userInput.getArguments().get(0), "south");
	}

}
