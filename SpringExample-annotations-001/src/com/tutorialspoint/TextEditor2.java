package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 属性中的 @Autowired
 * @author caopl
 *
 */
public class TextEditor2 {
	@Autowired
	private SpellChecker spellChecker;
	
	public TextEditor2() {
    System.out.println("Inside TextEditor2 constructor." );
	}
  // a getter method to return spellChecker
  public SpellChecker getSpellChecker() {
     return spellChecker;
  }
	
	public void spellCheck() {
		spellChecker.checkSpelling();
	}
	
}
