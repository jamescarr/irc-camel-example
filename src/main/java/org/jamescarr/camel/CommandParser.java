package org.jamescarr.camel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {

	public ScriptCommand parse(String input) {
		Matcher m = Pattern.compile("^\\?(.*)\\s(.*)$").matcher(input);
		m.find();
		
		ScriptCommand command = new ScriptCommand();
		command.setTargetLanguage(m.group(1));
		return command;
	}

}
