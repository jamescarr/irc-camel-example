package org.jamescarr.camel.script;

import org.jamescarr.camel.ScriptCommand;

public interface ScriptEvaluator {
	public <T extends Throwable> String evaluate(ScriptCommand cmd) throws T;
}
