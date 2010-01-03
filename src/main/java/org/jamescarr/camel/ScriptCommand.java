package org.jamescarr.camel;

public class ScriptCommand {
	private String targetLanguage;
	private String expression;
	public ScriptCommand(){}
	public ScriptCommand(String targetLanguage, String expression) {
		this.targetLanguage = targetLanguage;
		this.expression = expression;
		
	}

	public String getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	

}
