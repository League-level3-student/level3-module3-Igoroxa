package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
        StringBuilder builder = new StringBuilder(str);
       for (int i = 0; i < characters.length; i++) {
		builder.append(characters[i]);
	
	}
       str = builder.toString();
    	return str;
    }
    
    public static String reverse(String str) {
        return null;
    }
    
    public static String insert(String str, int index, char newChar) {
        return null;
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
        return null;
    }
}