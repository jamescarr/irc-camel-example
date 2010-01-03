package org.jamescarr.camel;

import static org.apache.commons.lang.StringUtils.substringAfter;
import static org.apache.commons.lang.StringUtils.substringBefore;

import org.springframework.stereotype.Service;

@Service("parser")
public class CommandParser {
	public ScriptCommand parse(String input) {
		ScriptCommand command = new ScriptCommand();
		command.setTargetLanguage(substringBefore(input, " ").replaceAll("^\\?", ""));
		command.setExpression(substringAfter(input, " "));
		return command;
	}

}
