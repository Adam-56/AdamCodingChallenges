package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GradeCalculatorController {
	Stage applicationStage;
	double averageRequiredQuizGrade = 0.0;
	double averageOptionalQuizGrade = 0.0;

    @FXML
    private ChoiceBox<Integer> requiredCodingChallengesChoicebox;

    @FXML
    private ChoiceBox<Integer> optionalCodingChallengesChoicebox;

    @FXML
    private ChoiceBox<Integer> requiredQuizzesChoiceBox;
    
    @FXML
    private ChoiceBox<Integer> optionalQuizzesChoiceBox;

    @FXML
    private Label requiredQuizAve;
    
    @FXML
    private Label optionalQuizAve;
    
    @FXML
    private TextField projectGradeTextfield;
    
    @FXML
    private Label courseGradeLabel;
    
    @FXML
    private Label projectErrorLabel;
    
    
    Label requiredQuizErrorLabel = new Label();
    
    void calculateRequiredQuizGrade(Scene mainScene, ArrayList<TextField> requiredQuizGradeTextfields) {
    	requiredQuizErrorLabel.setText("");
    	
    	double weightPerRequiredQuiz = 5.0/50.0; 
    	
    	averageRequiredQuizGrade = 0.0;
    	boolean errorInRequiredQuizGrade = false;
    	
    	for (TextField requiredQuizGradeTextfield: requiredQuizGradeTextfields) {
    		Grade requiredQuizGrade = new Grade(0, 10, weightPerRequiredQuiz);
    		String errorMessage = requiredQuizGrade.setValue(requiredQuizGradeTextfield.getText());
    		if (!errorMessage.equals("")) {
    			errorInRequiredQuizGrade = true;
    			requiredQuizErrorLabel.setText(errorMessage);
    		}
    		averageRequiredQuizGrade += requiredQuizGrade.getWeightedPercentageValue();	
        	
    	}
    	if (!errorInRequiredQuizGrade) {
    		applicationStage.setScene(mainScene);
        	averageRequiredQuizGrade = (averageRequiredQuizGrade / 15);
        	requiredQuizAve.setText(String.format("Average For Required Quizzes: %.2f / 10", averageRequiredQuizGrade));
    	}
        	
    	
    	
    }
    
    @FXML
    void getrequiredQuizGrades(ActionEvent enterrequiredQuizGradesEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	int numberOfRequiredQuizzes = requiredQuizzesChoiceBox.getValue();
    	int rowCounter = 0;
    	VBox allRows = new VBox(); 
    	requiredQuizErrorLabel = new Label();
    	allRows.getChildren().add(requiredQuizErrorLabel);
    	ArrayList<TextField> quizTextFields = new ArrayList<TextField>();
    	while (rowCounter < numberOfRequiredQuizzes) {
    		rowCounter++;
        	HBox quizRow = new HBox();
        	Label quizLabel = new Label("Quiz " + rowCounter + " grade");
        	TextField quizGradeTextfield = new TextField();
        	quizTextFields.add(quizGradeTextfield);
        	
        	quizRow.getChildren().addAll(quizLabel,quizGradeTextfield);
    
        	allRows.getChildren().add(quizRow);
    	}
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateRequiredQuizGrade(mainScene, quizTextFields));
    	allRows.getChildren().add(doneButton);
    	
    	Scene quizScene = new Scene(allRows);
    	applicationStage.setScene(quizScene);
    	

    }
    //
    void calculateOptionalQuizGrade(Scene mainScene, ArrayList<TextField> optionalQuizGradeTextfields) {
    	averageOptionalQuizGrade = 0.0;
    	for (TextField textfield : optionalQuizGradeTextfields) {
        	averageOptionalQuizGrade += Double.parseDouble(textfield.getText());
    	}   	
    	applicationStage.setScene(mainScene);
    	averageOptionalQuizGrade = (averageOptionalQuizGrade / 5);
    	optionalQuizAve.setText(String.format("Average For Optional Quizzes: %.2f / 10", averageOptionalQuizGrade));
    }
    
    @FXML
    void getoptionalQuizGrades(ActionEvent enteroptionalQuizGradesEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	int numberOfOptionalQuizzes = optionalQuizzesChoiceBox.getValue();
    	int rowCounter = 0;
    	VBox allRows = new VBox(); 
    	ArrayList<TextField> quizTextFields = new ArrayList<TextField>();
    	while (rowCounter < numberOfOptionalQuizzes) {
    		rowCounter++;
        	HBox quizRow = new HBox();
        	Label quizLabel = new Label("Quiz " + rowCounter + " grade");
        	TextField quizGradeTextfield = new TextField();
        	quizTextFields.add(quizGradeTextfield);
        	
        	quizRow.getChildren().addAll(quizLabel,quizGradeTextfield);
    
        	allRows.getChildren().add(quizRow);
    	}
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateOptionalQuizGrade(mainScene, quizTextFields));
    	allRows.getChildren().add(doneButton);
    	
    	Scene quizScene = new Scene(allRows);
    	applicationStage.setScene(quizScene);
    	
    }
    
    
    @FXML
    void calculateGrade(ActionEvent event) {
    	//Clear all error messages
    	projectErrorLabel.setText("");
    	
    	Grade projectGrade = new Grade(0, 100, .5);
    	projectErrorLabel.setText(projectGrade.setValue(projectGradeTextfield.getText()));
    	Grade requiredQuizGrade = new Grade(averageRequiredQuizGrade, 100, .1875);   	
    	Grade optionalQuizGrade = new Grade(averageOptionalQuizGrade, 100, .0625);   	
    	Grade requiredCodingChallengesGrade = new Grade(requiredCodingChallengesChoicebox.getValue(), 15, .1875);   	
    	Grade optionalCodingChallengesGrade = new Grade(optionalCodingChallengesChoicebox.getValue(), 5, .0625);
    	
    	double courseGrade = projectGrade.getWeightedPercentageValue() + requiredQuizGrade.getWeightedPercentageValue() + optionalQuizGrade.getWeightedPercentageValue() +
    						requiredCodingChallengesGrade.getWeightedPercentageValue() + optionalCodingChallengesGrade.getWeightedPercentageValue();
    			
    	
      	// Display result of calculation to the user in the window
    	// Display result to two digits after decimal
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade));
    }

}