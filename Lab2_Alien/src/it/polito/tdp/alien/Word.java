package it.polito.tdp.alien;

import java.util.*;

public class Word {
	
	private String alienWord; 
	//private String translation;
	private List<String> listTranslation;
	
	public Word(String alienWord) {
		this.alienWord = alienWord;
		//this.translation = translation;
		listTranslation = new LinkedList<String>();
	}

	public String getAlienWord() {
		return alienWord;
	}

	/*public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}*/
	
	public List<String> getListTranslation() {
		return listTranslation;
	}
	
	public void addListTranslation(String translation) {
		listTranslation.add(translation);
	}

	//NON FUNZIONANETE
	public boolean equals (Object obj) {
		if (this == obj) 
	        return true;
	    if (obj == null)
	        return false;
	    if (alienWord.getClass() != obj.getClass()) {
	    		System.out.println("FALSE CLASS");
	    		return false;
	    }
	    Word person = (Word) obj;
	    return Objects.equals(alienWord, person.alienWord);
	}

}
