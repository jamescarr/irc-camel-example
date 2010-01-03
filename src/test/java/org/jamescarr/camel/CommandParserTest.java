package org.jamescarr.camel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CommandParserTest {
	private CommandParser commandParser;

	@Before
	public void beforeEach(){
		this.commandParser = new CommandParser();
	}
	
	@Test
	public void shouldParseTheTargetLanguage(){
		String input = "?py 2+2";
		
		ScriptCommand command = commandParser.parse(input);
		
		assertEquals("py", command.getTargetLanguage());
	}
	
	@Test
	public void shouldGetTheExpressionFromInput(){
		String input = "?rb 2 + 2 % 3";
		
		ScriptCommand command = commandParser.parse(input);
		
		assertEquals("2 + 2 % 3", command.getExpression());
	}

}
