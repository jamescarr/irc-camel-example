package org.jamescarr.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.jamescarr.camel.ScriptCommand;
import org.springframework.stereotype.Service;

@Service("script-selection-route")
public class ScriptSelectionRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("irc:js-bot@irc.freenode.net/#botwar")
			.pipeline()
				.to("bean:validator?method=validate")
				.to("bean:parser?method=parse")
				.to("seda:a");
		
		from("seda:a")
			.choice()
				.when(languageIs("js"))
					.to("bean:js?method=evaluate")
					.to("seda:b")
				.when(languageIs("rb"))
					.to("bean:rb?method=evaluate")
					.to("seda:b")
				.otherwise()
					.to("bean:default-eval")
					.to("seda:b");
		
		from("seda:b")
			.to("irc:js-bot@irc.freenode.net/#botwar");
	}

	private Predicate languageIs(final String lang) {
		return new Predicate(){
			public boolean matches(Exchange exchange) {
				return lang.equals(exchange.getIn().getBody(ScriptCommand.class).getTargetLanguage());
			}};
	}

}
