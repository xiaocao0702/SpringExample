package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Setter 方法中的 @Autowired
 * @author caopl
 *
 */
public class TextEditor {
	private SpellChecker spellChecker;
	
	//a setter method to inject the dependency.
	@Autowired
  public void setSpellChecker(SpellChecker spellChecker) {
     System.out.println("Inside setSpellChecker." );
     this.spellChecker = spellChecker;
  }
  // a getter method to return spellChecker
  public SpellChecker getSpellChecker() {
     return spellChecker;
  }
	
	public void spellCheck() {
		spellChecker.checkSpelling();
	}
	
}
