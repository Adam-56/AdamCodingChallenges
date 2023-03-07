package application;

public class Grade {
	double value;
	int maxValue = 100;
	double weight;
	
	String setValue(String valueAsString) {
		String errorMessage = "";
    	// Check that the string entered by the user is a valid decimal number   	
    	boolean validProjectGrade = true;
    	int counter = 0;
    	for (char c : valueAsString.toCharArray()) {
    		// Check if the character is a digit
    		if (!Character.isDigit(c) && (c != '.')) {
    			validProjectGrade = false;
    			errorMessage = String.format("Do not use %c in a project grade. Make sure to enter a number.", c);
    		}
    		if (c == '.') {
    			counter += 1;
    			if (counter <= 1) {
    				validProjectGrade = true;
    			}	
    			if (counter >= 2) {
    				validProjectGrade = false;
    				errorMessage = "Do not use more than one decimal point.";
    			}	
    		
    			
    			
    		}
    	}

    	// Convert the string entered by the user to a double if the input is a valid number
    	// Otherwise the project grade will default to zero
    	
    	if (validProjectGrade) {
    		value = Double.parseDouble(valueAsString);
    	}
    	
    	if (value < 0.0 || value > maxValue) {
    		errorMessage = String.format("Project Grade Should be Between 0% and %d.", maxValue);
    		value = 0.0;
    	}
    	
    	return errorMessage;
    }

}
