package mazegame.control;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class ParserTest {


	@Test
	void testParse() {
		String rawInput = "talk How old are you";
		ArrayList<String> validCommand = new ArrayList<String>();
		validCommand.add("move");
		validCommand.add("talk");
		validCommand.add("get");
		validCommand.add("attack");
		Parser parser = new Parser(validCommand);
		Assert.assertEquals(parser.parse(rawInput).getCommand(), "talk");
		Assert.assertEquals(parser.parse(rawInput).getArguments().get(0), "old");
	}

}
