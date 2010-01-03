package org.jamescarr.camel;

import static org.apache.commons.lang.StringUtils.substringAfter;
import static org.apache.commons.lang.StringUtils.substringBefore;
public class CommandParser {

	public ScriptCommand parse(String input) {
		ScriptCommand command = new ScriptCommand();
		command.setTargetLanguage(substringBefore(input, " ").replaceAll("^\\?", ""));
		command.setExpression(substringAfter(input, " "));
		return command;
	}

}
