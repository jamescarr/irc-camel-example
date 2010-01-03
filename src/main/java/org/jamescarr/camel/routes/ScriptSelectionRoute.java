package org.jamescarr.camel.routes;

import static org.jamescarr.camel.predicates.Predicates.languageIs;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;
@Service("script-selection-route")
public class ScriptSelectionRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("irc:lang-bot@irc.freenode.net/#botwar")
			.pipeline()
				.to("bean:validator?method=validate")
				.to("bean:parser?method=parse")
				.to("seda:processRequest");
		
		from("seda:processRequest")
			.choice()
				.when(languageIs("js"))
					.to("bean:js?method=evaluate")
					.to("seda:display")
				.when(languageIs("rb"))
					.to("bean:rb?method=evaluate")
					.to("seda:display")
				.otherwise()
					.to("bean:default-eval")
					.to("seda:display");
		
		from("seda:display")
			.to("irc:lang-bot@irc.freenode.net/#botwar");
	}
}
