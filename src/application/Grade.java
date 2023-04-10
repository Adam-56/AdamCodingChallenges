package application;

public class Grade {
    private double value;
    private int maxValue;
    private double weight;
	
	/**
	 * Constructs a Grade object with the given grade value, maximum possible value, and weight towards the course grade.
	 *
	 * @param gradeValue The value of the grade.
	 * @param maxPossibleValue The maximum possible value of the grade.
	 * @param weightTowardsCourseGrade The weight of the grade towards the course grade.
	 */
	
    public Grade(double value, int maxValue, double weight) {
        this.value = value;
        this.maxValue = maxValue;
        this.weight = weight;
    }

    public Grade(String value, int maxValue, double weight) throws InvalidGradeException {
        try {
            this.value = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new InvalidGradeException("Invalid grade value: " + value, e);
        }
        if (this.value > maxValue || this.value > maxValue) {
            throw new InvalidGradeException("Grade Should be Between 0 and " + maxValue);
        }
        this.maxValue = maxValue;
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public double getWeight() {
        return weight;
    }

    public double getWeightedPercentageGrade() {
        if (weight == 1.0) {
            return value;
        } else {
            return value / maxValue * weight * 100;
        }
    }


	/**
	 * Computes and returns the weighted percentage value of the grade.
	 *
	 * @return The weighted percentage value of the grade.
	 */
	
	double getWeightedPercentageValue() {
		return value * 100 * weight / maxValue;
	}
	
	/**
	 * Sets the value of the grade based on the string entered by the user.
	 *
	 * @param valueAsString The string entered by the user.
	 * @return An error message, if applicable. Otherwise, an empty string.
	 */
	
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
    	
    	// Check if the number entered by the user is a valid percentage grade
    	// If valid, include it in grade computation
    	if (value < 0 || value > maxValue) {
    		errorMessage = String.format("Grade Should be Between 0 and %d.", maxValue);
    		value = 0;
    	}
    	
    	return errorMessage;
    }


	

}
