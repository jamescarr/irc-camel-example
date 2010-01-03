package org.jamescarr.camel;

public class ScriptInputValidator {

	public String validate(String input) {
		if(!input.startsWith("?")){
			throw new RuntimeException();
		}
		return input;
	}

}
