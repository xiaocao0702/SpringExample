package com.tutorialspoint;

public class TextEditor {
	private SpellChecker spellChecker;
	private String name;

	// a setter method to inject the dependency.
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	// a getter method to return spellChecker
	public SpellChecker getSpellChecker() {
		System.out.println("Inside setSpellChecker.");
		return spellChecker;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}

}
