package _02_The_Wave;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class _01_TheWave {
    /*
     * Background:
     * https://en.wikipedia.org/wiki/Wave_%28audience%29 
     * 
     * Task:
     * Your task is to create a function that turns a string into a Wave.
     * You will be passed a string and you must return that string in an
     * ArrayList where an uppercase letter is a person standing up.
     * Example:
     * wave("hello") => "Hello", "hEllo", "heLlo", "helLo", "hellO"
     * 
     * 1. The input string will always be lower case but maybe empty.
     * 2. If the character in the string is whitespace then pass over it as
     *    if it was an empty seat.
     */
    
    public static ArrayList<String> wave(String str) {
        
        ArrayList<String> words = new ArrayList<String>();
    
        for (int i = 0; i < str.length(); i++) {
        	if (str.charAt(i) != ' ') {
        	char[] chars = str.toCharArray();
        			
        	String uppercase = (chars[i] + "").toUpperCase();
        	char replaced = uppercase.charAt(0);
        	chars[i] = replaced;
        	System.out.println(i);
        	System.out.println(chars);
        	System.out.println(chars);
        	String result = new String(chars);
        	words.add(result);
        	}
		}
        return words;
    }
}
