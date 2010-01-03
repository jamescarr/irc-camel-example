package org.jamescarr.camel.predicates;

import org.apache.camel.Predicate;

public class Predicates {
	public static Predicate languageIs(String lang){
		return new LanguagePredicate(lang);
	}
}
