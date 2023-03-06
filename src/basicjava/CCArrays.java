package basicjava;

import java.util.Arrays;

public class CCArrays {

	public static void replace(char[] charArray, char toReplace, char replaceWith) {
		for (int index = 0; index < charArray.length; index++) {
            if (Character.toLowerCase(charArray[index]) == Character.toLowerCase(toReplace)) {
                charArray[index] = replaceWith;
            }
        }
	}


	public static void sortAlphabetic(String[] strArray) {
		Arrays.sort(strArray, String.CASE_INSENSITIVE_ORDER);
		
	}
	

}
