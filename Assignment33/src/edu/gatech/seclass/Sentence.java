package edu.gatech.seclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentence implements SentenceInterface {

	private String sentence;
	
	private List<String> wordList;
	
	public Sentence() {
		
		initVars();
		buildWordList();
	}
	
	private void initVars() {
		
		sentence = "";
		wordList = new ArrayList<String>();
	}
	
	@Override
	public void setSentence(String sentence) {
		
		if (sentence == null)
			sentence = "";
		
		this.sentence = sentence;
		
		buildWordList();
	}

	@Override
	public String getSentence() {
		return sentence;
	}

	@Override
	public int length() {
		return wordList.size();
	}

	@Override
	public String getWord(int position) throws IllegalArgumentException,
			PositionOutOfBoundsException {
		
		if (position <= 0) {
			throw new IllegalArgumentException();
		}
		
		if (position > wordList.size()) {
			throw new PositionOutOfBoundsException();
        }
	
		return wordList.get(position - 1);
	}

	@Override
	public String[] getWords(int startPosition, int endPosition)
			throws IllegalArgumentException, PositionOutOfBoundsException {
		
		if (startPosition <= 0) {
			throw new IllegalArgumentException();
		}
		
		if (endPosition <= 0) {
			throw new IllegalArgumentException();
		}
		
		if (startPosition > endPosition) {
			throw new IllegalArgumentException();
		}
		
		if (endPosition > wordList.size()) {
			throw new PositionOutOfBoundsException();
        }
		
		final List<String> result = buildWords(startPosition, endPosition);
		
		return result.toArray(new String[result.size()]);
	}

	@Override
	public int indexOf(String word) {
		
		int result = 0;
		
		result = wordList.indexOf(word);
		
		if (result != -1)
			return result + 1;
		else
			return result;
	}

	@Override
	public void reverse() {
		this.setSentence(reverseStr(this.sentence));
	}
	
	private String reverseStr(final String sentence) {
		
		  final StringBuilder result = new StringBuilder();
		  final String[] words = sentence.split("\\s+");      
		  for (int i = words.length - 1 ; 0 <= i; i--) {
		    result.append(words[i]).append(' ');
		  }
		  
		  return result.toString().trim();
	}
	
	private void buildWordList() {

		if (sentence == null || sentence.isEmpty()){
			return;
		}

		String[] words = sentence.split("\\s+");
		wordList = Arrays.asList(words);
	}
	
	private final List<String> buildWords(int startPosition, int endPosition) {
		
	    final List<String> result = new ArrayList<String>();

	    for(int i=(startPosition-1); i < endPosition; i++) {
	    	result.add(wordList.get(i));
	    }
	    
	    return result;
	}

}
