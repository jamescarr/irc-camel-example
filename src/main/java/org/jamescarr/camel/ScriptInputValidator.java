package org.jamescarr.camel;

import org.springframework.stereotype.Service;

@Service("validator")
public class ScriptInputValidator {

	public String validate(String input) {
		if(!input.startsWith("?")){
			throw new RuntimeException();
		}
		return input;
	}

}
