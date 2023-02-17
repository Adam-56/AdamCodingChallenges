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
 
    @FXML
    void calculateGrade(ActionEvent event) {
    	//Clear all error messages
    	projectErrorLabel.setText("");
    	double courseGrade = 0.0;
    	
    	Double projectGrade = Double.parseDouble(projectGradeTextfield.getText());
    	if (projectGrade < 0 || projectGrade > 100) {
    		System.out.println("Project Grade Should be Between 0% and 100%. Invalid grade: " + projectGrade);
    		projectErrorLabel.setText("Project Grade Should be Between 0% and 100%.");
    	} else {
    		courseGrade = courseGrade + projectGrade * 50 / 100;
    	}
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
