package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class GradeCalculatorController {

    @FXML
    private ChoiceBox<Integer> requiredCodingChallengesChoicebox;

    @FXML
    private ChoiceBox<Integer> optionalCodingChallengesChoicebox;

    @FXML
    private Slider quizSlider;

    @FXML
    private TextField projectGradeTextfield;
    
    @FXML
    private Label courseGradeLabel;
    
    @FXML
    private Label projectErrorLabel;
    
    /**
     * Convert the value entered to a double value. This method will verify that the value entered is indeed a number and is a valid percentage grade (between 0 and 100).
     * If the value entered is not a valid percentage grade, this method will return 0.0 as the project grade instead.
     * 
     * @param valueEntered a string that holds a value entered by the user intended to be a project grade
     * @return the project value entered by the user if it is a valid percentage grade and 0 otherwise
     */
    double getProjectGrade(String valueEntered) {

    	// Check that the string entered by the user is a valid decimal number   	
    	boolean validProjectGrade = true;
    	int counter = 0;
    	for (char c : valueEntered.toCharArray()) {
    		// Check if the character is a digit
    		if (!Character.isDigit(c) && (c != '.')) {
    			validProjectGrade = false;
    			projectErrorLabel.setText("Do not use " + c + " in a project grade. Make sure to enter a number.");
    		}
    		if (c == '.') {
    			counter += 1;
    			if (counter <= 1) {
    				validProjectGrade = true;
    			}	
    			if (counter >= 2) {
    				validProjectGrade = false;
    				projectErrorLabel.setText("Do not use more than one decimal point.");
    			}	
    		
    			
    			
    		}
    	}
    	    		

    	// Check that the string entered by the user is a valid decimal number
    	
    	boolean validProjectGrade = true;
    	for (char c : valueEntered.toCharArray()) {
    		// Check if the character is a digit
    		if (!Character.isDigit(c)) {
    			validProjectGrade = false;
    			projectErrorLabel.setText("Do not use " + c + " in a project grade. Make sure to enter a number.");    		
    			
    		} else {
    			if (!Character.isDigit('.')) {
    				validProjectGrade = true;
    			}
    		}
    	}
    	

    	// Convert the string entered by the user to a double if the input is a valid number
    	// Otherwise the project grade will default to zero
    	double projectGrade = 0.0;
    	if (validProjectGrade) {
    		projectGrade = Double.parseDouble(valueEntered);
    	}
    	
    	if (projectGrade < 0.0 || projectGrade > 100.0) {
    		projectErrorLabel.setText("Project Grade Should be Between 0% and 100%.");
    		projectGrade = 0.0;
    	}
    	
    	return projectGrade;
    }
    @FXML
    void calculateGrade(ActionEvent event) {
    	//Clear all error messages
    	projectErrorLabel.setText("");
    	double courseGrade = 0.0;
    	
    	String projectValueEntered = projectGradeTextfield.getText();
    	
    	double projectGrade = getProjectGrade(projectValueEntered);
    	
    	// Check if the number entered by the user is a valid percentage grade
    	// If valid, include it in the grade computation
    	  
    	courseGrade = courseGrade + projectGrade * 50 / 100;
    	
    	System.out.println("Project grade entered: " + projectGrade + " Course grade so far: " + courseGrade);
    	
    	double quizGrade = quizSlider.getValue();
    	courseGrade += (quizGrade * .25) * 100 / 10;
    	System.out.println("Quiz grade entered: " + quizGrade + " Course grade so far: " + courseGrade);
    	
    	int requiredCodingChallengesPassed = requiredCodingChallengesChoicebox.getValue();
    	courseGrade += (requiredCodingChallengesPassed * .1875) * 100 / 15;
    	System.out.println("Required coding challenges passed: " + requiredCodingChallengesPassed + " Course grade so far: " + courseGrade);
    	
    	int optionalCodingChallengesPassed = optionalCodingChallengesChoicebox.getValue();
    	courseGrade += (optionalCodingChallengesPassed * .0625) * 100 / 5;
    	System.out.println("Optional coding challenges passed: " + optionalCodingChallengesPassed + " Course grade so far: " + courseGrade);

    	// Display result of calculation to the user in the window
    	// Display result to two digits after decimal
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade));
    }

}