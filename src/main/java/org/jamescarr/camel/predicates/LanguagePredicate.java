package org.jamescarr.camel.predicates;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.jamescarr.camel.ScriptCommand;

public class LanguagePredicate implements Predicate{
	private final String lang;
	public LanguagePredicate(String lang){
		this.lang = lang;
		
	}
	public boolean matches(Exchange exchange) {
		return lang.equals(exchange.getIn().getBody(ScriptCommand.class).getTargetLanguage());
	}

}
