package edu.gatech.seclass;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SentenceTest {

    private Sentence sentence;

    @Before
    public void setUp() throws Exception {
        sentence = new Sentence();
    }

    @After
    public void tearDown() throws Exception {
        sentence = null;
    }

    @Test
    public void testGetWord1() throws IllegalArgumentException,
            PositionOutOfBoundsException {
        sentence.setSentence("This is a short sentence");
        String word = sentence.getWord(2);
        assertEquals("is", word);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWord2() throws IllegalArgumentException,
            PositionOutOfBoundsException {
    	sentence.setSentence("This is another short sentence");
        sentence.getWord(0);
    }

    @Test
    public void testGetWords1() throws IllegalArgumentException,
            PositionOutOfBoundsException {
    	sentence.setSentence("Short sentence testing for GetWords method");
    	
    	String[] result = sentence.getWords(2, 6);
    	
    	String[] expectedOutput = {"sentence", "testing", "for", "GetWords", "method"};
    	
    	assertArrayEquals(expectedOutput, result);
    }

    @Test(expected = PositionOutOfBoundsException.class)
    public void testGetWords2() throws IllegalArgumentException,
            PositionOutOfBoundsException {
        sentence.setSentence("Another short sentence");
        sentence.getWords(3, 4);
    }

    @Test
    public void testGetLength1() {
    	sentence.setSentence("Test number of words in this sentence");
    	
    	int expected = 7;
    	
    	assertEquals(expected, sentence.length());
    }

    @Test
    public void testGetLength2() {
    	sentence.setSentence(null);
    	
    	int expected = 0;

    	assertEquals(expected, sentence.length());
    }

    @Test
    public void testIndexOf1() {
        sentence.setSentence("This is a short sentence");
        assertEquals(5, sentence.indexOf("sentence"));
    }

    @Test
    public void testIndexOf2() {
    	sentence.setSentence("This is another short sentence");
        assertEquals(-1, sentence.indexOf("SENTENCE"));
    }

    @Test
    public void testReverse1() {
        sentence.setSentence("This is a short sentence");
        sentence.reverse();
        assertEquals("sentence short a is This", sentence.getSentence());
    }
    
    @Test
    public void testReverse2() {
        sentence.setSentence("sentence long this for TESTING reverse Another");
        sentence.reverse();
        assertEquals("Another reverse TESTING for this long sentence", sentence.getSentence());
    }
}
