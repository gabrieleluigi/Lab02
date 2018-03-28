package it.polito.tdp.alien;

import java.util.*;
import java.util.regex.Pattern;

public class AlienDictionary {
	
	private List<Word> wordList = new LinkedList<Word>();
	
	public void addWord(String alienWord, String translation) {
		Word w = new Word(alienWord);
		boolean find1 = false;
		boolean find2 = false;
		for(Word c: wordList) {
			if(c.getAlienWord().compareTo(alienWord)==0) { //cambio con equals
				find1 = true;
				for (String s : c.getListTranslation()) {
					if(s.compareTo(translation)==0) {
						find2 = true;
					}
				}
				if(find2 == false)	
					c.addListTranslation(translation);
				System.out.println("Find2: "+find2);
			}
		}
		if(find1 == false) {
			wordList.add(w);
			w.addListTranslation(translation);
		}
		System.out.println("Find1: "+find1);
	}
	
	public String translateWord(String alienWord) {
		int index = alienWord.indexOf('?'); //trovo la posizione di '?'
		if(index >= 0) {
			String reg = "[a-z]"; // definisco la regex da sostituire a '?'
			String regex = alienWord.substring(0, index) + reg + alienWord.substring(index+1); // costruisco la regex
			//ES: al?en ---> al[a-z]en
			System.out.println("REgEx: "+regex);
			String listString = new String();
			for(Word c: wordList)
				if(Pattern.matches(regex, c.getAlienWord())) {
					for (String s: c.getListTranslation()) {
						System.out.println("Elemento: "+s);
						listString += s+"\n";}
					}
			return listString;
		}
		else {
			for(Word c: wordList)
				if(c.getAlienWord().compareTo(alienWord)==0) {
					String listString = new String();
					for (String s: c.getListTranslation()) {
						System.out.println("Elemento: "+s);
						listString += s+"\n";}
					return listString;
				}
		}
		return null;
	}
	
	public void reset() {
		wordList.clear();
	}

}
