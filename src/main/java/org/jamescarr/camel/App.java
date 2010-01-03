package org.jamescarr.camel;

import javax.script.ScriptEngine;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private ScriptEngine engine;

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext(
				"org/jamescarr/camel/irc-example.xml");
	}

	public void setEngine(ScriptEngine engine) {
		this.engine = engine;
	}

	public String evaluate(ScriptCommand command) {
		try {
			return engine.eval(command.getExpression()) + "";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
