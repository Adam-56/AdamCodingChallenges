package application;

public class Grade {
	double value;
	int maxValue = 100;
	double weight;
	
	Grade(double gradeValue, int maxPossibleValue, double weightTowardsCourseGrade) {
		value = gradeValue;
		maxValue = maxPossibleValue;
		weight = weightTowardsCourseGrade;
	}
	
	double getWeightedPercentageValue() {
		return value * 100 * weight / maxValue;
	}
	
	String setValue(String valueAsString) {
		String errorMessage = "";
    	// Check that the string entered by the user is a valid decimal number   	
    	boolean validGrade = true;
    	int counter = 0;
    	for (char c : valueAsString.toCharArray()) {
    		// Check if the character is a digit
    		if (!Character.isDigit(c) && (c != '.')) {
    			validGrade = false;
    			errorMessage = String.format("Do not use %c in a grade. Make sure to enter a number.", c);
    		}
    		if (c == '.') {
    			counter += 1;
    			if (counter <= 1) {
    				validGrade = true;
    			}	
    			if (counter >= 2) {
    				validGrade = false;
    				errorMessage = "Do not use more than one decimal point.";
    			}	
    		
    			
    			
    		}
    	}

    	// Convert the string entered by the user to a double if the input is a valid number
    	// Otherwise the project grade will default to zero
    	
    	if (validGrade) {
    		value = Double.parseDouble(valueAsString);
    	}
    	
    	if (value < 0.0 || value > maxValue) {
    		errorMessage = String.format("Grade Should be Between 0% and %d.", maxValue);
    		value = 0.0;
    	}
    	
    	return errorMessage;
    }

}
