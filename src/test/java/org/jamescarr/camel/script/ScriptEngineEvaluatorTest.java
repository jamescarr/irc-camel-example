package org.jamescarr.camel.script;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.apache.camel.model.WhenDefinition;
import org.jamescarr.camel.ScriptCommand;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class ScriptEngineEvaluatorTest {
	private static final ScriptCommand VALID_EXPRESSION = new ScriptCommand("js", "input expression");
	private static final ScriptCommand BAD_EXPRESSION = new ScriptCommand("js", "bad expression");
	@Mock private ScriptEngine engine;
	private ScriptEngineEvaluator evaluator;
	
	@Before
	public void beforeEach(){
		evaluator = new ScriptEngineEvaluator();
		evaluator.setScriptEngine(engine);
	}
	
	@Test
	public void shouldEvaluateInputExpressionAgainstEngine() throws ScriptException{
		when(engine.eval(VALID_EXPRESSION.getExpression())).thenReturn("result");
		
		String result = evaluator.evaluate(VALID_EXPRESSION);
		
		assertEquals("result", result);
	}
	
	@Test
	public void shouldReturnExceptionMessageWhenScriptExceptionIsThrown() throws ScriptException{
		when(engine.eval(BAD_EXPRESSION.getExpression())).thenThrow(new ScriptException("YOU FAIL"));
		
		String result = evaluator.evaluate(BAD_EXPRESSION);
		
		assertEquals("[Parse Error] YOU FAIL", result);
	}
}
