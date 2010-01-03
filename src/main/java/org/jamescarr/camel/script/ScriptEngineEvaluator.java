package org.jamescarr.camel.script;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.jamescarr.camel.ScriptCommand;

public class ScriptEngineEvaluator implements ScriptEvaluator{
	private ScriptEngine scriptEngine;
	
	public void setScriptEngine(ScriptEngine scriptEngine) {
		this.scriptEngine = scriptEngine;
	}

	public String evaluate(ScriptCommand cmd)  {
		try{
			return scriptEngine.eval(cmd.getExpression())+"";			
		}catch (ScriptException e) {
			return "[Parse Error] " + e.getMessage();
		}
	}
	
}
