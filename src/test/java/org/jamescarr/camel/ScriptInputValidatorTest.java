package org.jamescarr.camel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ScriptInputValidatorTest {
	private ScriptInputValidator inputValidator;

	@Before
	public void before(){
		this.inputValidator = new ScriptInputValidator();
	}
	
	@Test
	public void shouldReturnTheInputStringIfItMatchesPattern(){
		final String input = "?lang expression is here";
		
		assertEquals(input, inputValidator.validate(input));
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldThrowAnExceptionWhenInputDoesNotStartWithAQuestionMark(){
		inputValidator.validate("Hello World");
	}
}
