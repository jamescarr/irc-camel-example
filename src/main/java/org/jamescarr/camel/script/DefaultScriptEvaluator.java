package org.jamescarr.camel.script;

import org.jamescarr.camel.ScriptCommand;
import org.springframework.stereotype.Service;

@Service("default-eval")
public class DefaultScriptEvaluator implements ScriptEvaluator{


	public String evaluate(ScriptCommand cmd)  {
		return "Don't know how to evaluate "+cmd.getTargetLanguage();
	}

}
