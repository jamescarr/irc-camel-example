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

	public String evaluate(String input) {
		try {
			if (input.startsWith("?eval ")) {
				return engine.eval(input.replaceAll("^\\?eval ", "")) + "";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
		throw new RuntimeException("unable to parse");
	}
}
