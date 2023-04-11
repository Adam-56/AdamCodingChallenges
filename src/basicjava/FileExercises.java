package basicjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileExercises {

	public static int counting(String word) throws IOException {
		// TODO Auto-generated method stub
		int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String currentWord : words) {
                    if (currentWord.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

	public void toUpper(String CodingChallenge, String CODING_CHALLENGE) throws IOException {
		// TODO Auto-generated method stub
		try (BufferedReader reader = new BufferedReader(new FileReader(CodingChallenge));
	             BufferedWriter writer = new BufferedWriter(new FileWriter(CODING_CHALLENGE))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                writer.write(line.toUpperCase());
	                writer.newLine();
	            }
	        }
	    }

	    public static void main(String[] args) {
	        // You can use this main method for testing your implementation
	    }
	

}
