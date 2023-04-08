package basicjava;

public class CCStringsIfAndWhile {

	public static boolean isDigit(char c) {
		// TODO Auto-generated method stub
		return c >= '0' && c <= '9';
	}

	public static int count(String string, String string2) {
		// TODO Auto-generated method stub
		int count = 0;
	    String stringLower = string.toLowerCase();
	    String charsLower = string2.toLowerCase();

	    for (int i = 0; i < stringLower.length(); i++) {
	        if (charsLower.indexOf(stringLower.charAt(i)) != -1) {
	            count++;
	        }
	    }
	    return count;
	}
	
	public static int smallestDigit(int i) {
		// TODO Auto-generated method stub
		if (i == 0) {
	        return 0;
	    }

	    i = abs(i);
	    int smallest = 9;

	    while (i > 0) {
	        int digit = i % 10;
	        if (digit < smallest) {
	            smallest = digit;
	        }
	        i /= 10;
	    }

	    return smallest;
	}

	private static int abs(int i) {
		// TODO Auto-generated method stub
		return i < 0 ? -i : i;
    }
}
