package edu.bsu.cs222;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WikipediaApplication extends Application {

    //Basic setup for the GUI
    Text sceneTitle = new Text("Let's check the revisions of a Wikipedia page! ");
    Text noTitleEnteredError = new Text();
    Text networkError = new Text();
    Text noPageFoundError = new Text();
    TextField textField = new TextField();
    Button startButton = new Button("Search Revisions");
    Text revisionsText = new Text();
    Executor executor = Executors.newSingleThreadExecutor();


    @Override
    public void start(Stage primaryStage) {
        //All the grid alignment to make it look pretty
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(sceneTitle, 0, 0, 2, 1);
        grid.add(textField, 1, 1);
        grid.add(startButton, 1, 4);
        grid.add(revisionsText, 1, 1);
        grid.add(noTitleEnteredError, 1, 1);
        grid.add(networkError, 1, 2);
        grid.add(noPageFoundError, 1, 3);

        //Button to activate the program
        startButton.setOnAction(event -> createUI());
        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//Main code to run the program as Main does
    private Parent createUI() {
            sceneTitle.setText("");
            startButton.setDisable(true);
            textField.setDisable(true);
            executor.execute(()->{

                String usersTitle = textField.getText();
                int numberOfRevisions = 30;
                //Try to begin program, catch the 'No Title Entered' error
                try {
                    if (usersTitle.isBlank()) {
                        throw new CustomException("No Title Entered ");
                    }
                } catch (CustomException e) {
                    noTitleEnteredError.setText(e.toString());
                }

                //Tries the basic program, will catch errors
                try {
                    Revision[] revisionList = GetRevisions.getLastRevisions(usersTitle, numberOfRevisions);
                    String formattedRevisions = RevisionFormatter.formatter(revisionList, numberOfRevisions);
                    revisionsText.setText(formattedRevisions);
                //Catch Network Error
                } catch (IOException ioException) {
                    networkError.setText("Network Error " + ioException.getMessage());
                //Catch No Page Found Error
                } catch (CustomException e) {
                    noPageFoundError.setText(e.toString());
                }

                Platform.runLater(()->{
                    startButton.setDisable(false);
                    textField.setDisable(false);
                });
            });


        VBox vbox = new VBox();
        vbox.getChildren().addAll(textField, startButton);
        return vbox;
    }
}

