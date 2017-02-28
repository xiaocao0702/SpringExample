package com.tutorialspoint;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Resource 注释：
 * 你可以在字段中或者 setter 方法中使用 @Resource 注释，它和在 Java EE 5 中的运作是一样的。
 * @Resource 注释使用一个 ‘name’ 属性，该属性以一个 bean 名称的形式被注入。
 * 你可以说，它遵循 by-name 自动连接语义
 * 
 * 如果没有明确地指定一个 ‘name’，默认名称源于字段名或者 setter 方法。
 * 在字段的情况下，它使用的是字段名；在一个 setter 方法情况下，它使用的是 bean 属性名称。
 * @author caopl
 *
 */
public class TextEditor4 {
	private SpellChecker spellChecker;
	
	@Resource(name="spellChecker")
	public void setSpellChecker(SpellChecker spellChecker) {
    System.out.println("Inside TextEditor4 setter." );
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
