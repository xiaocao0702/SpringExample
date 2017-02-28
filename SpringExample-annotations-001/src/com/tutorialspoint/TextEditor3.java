package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 构造函数中的 @Autowired
 * @author caopl
 *
 */
public class TextEditor3 {
	private SpellChecker spellChecker;
	
	@Autowired
	public TextEditor3(SpellChecker spellChecker) {
    System.out.println("Inside TextEditor3 constructor." );
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
