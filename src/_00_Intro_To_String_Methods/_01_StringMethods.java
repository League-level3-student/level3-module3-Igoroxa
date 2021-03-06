package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
    	int amount = s1.length();
    	int amount2 = s2.length();
    	if (amount > amount2) {
    		return s1;
    	}
    	
        return s2;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	if (s.contains("underscores")) {
    		String replacedStr = s.replace(' ', '_');
    		s = replacedStr;
    	}
        return s;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    	
		
    	int index = s1.trim().indexOf(' ');
    	String strings = s1.substring(index);
    	//System.out.println(strings);
    	
    	int index2 = s2.trim().indexOf(' ');
    	String	strings2 = s2.substring(index2);
    	//System.out.println(strings2);
    	
    	int index3 = s3.trim().indexOf(' ');
    	String strings3 = s3.substring(index3);
    	//System.out.println(strings3);
    	
    	//System.out.println(strings.compareTo(strings2));
    	
    	if(strings.compareTo(strings2)< 0) {
    	
    		if (strings.compareTo(strings3)<  0) {
    			return s1;
    		}
    	}
    	else if(strings.compareTo(strings2)> 0){
    		if(strings2.compareTo(strings3)< 0);
    		return s2;
    	}
    	
    		return s3;
    	
    	
        
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	int sum = 0;
    
    	for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				//System.out.println("work");
				String temp = s.charAt(i)+ "";
				//System.out.println(temp);
				int unit = Integer.parseInt(temp);
				sum = sum + unit;
			}
		}
        return sum;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
    	
    	int occurs = 0;
    	int index = s.indexOf(substring);
    	while( index != -1) {
    		occurs++;
            index = s.indexOf(substring, index + substring.length());
    	}
        return occurs;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    	
    	byte[] newbyte = s.getBytes();
        return Utilities.encrypt(newbyte, (byte)key);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
    	
        return Utilities.decrypt(s, (byte)key);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	String[] words = s.split(" ");
    	int occurs = 0;
    	int index = s.indexOf(substring);
    	for (int i = 0; i < words.length; i++) {
	if (words[i].endsWith(substring)) {
		occurs++;
	}
    	//System.out.println(index);
    	
    	}
    	return occurs;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
    	int distance = 0;
    	int index1 = s.indexOf(substring);
    	int index2 = s.lastIndexOf(substring);
    	distance = (index2-index1)-substring.length();
    	
    	        return distance;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
    String[] punctuation = {".", "?", "!", ",", " ", "-", ":"};
    for (int i = 0; i < punctuation.length; i++) {
    s = s.replace(punctuation[i], "");
   s = s.toLowerCase();
    }
   
    System.out.println("yes");
System.out.println(s.length());

    	for (int i = 0; i < s.length(); i++) {
			if (s.codePointAt(i) != (s.codePointAt((s.length()-i)-1))) {
				return false;
				
				
			}
			
		}
    	return true;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
