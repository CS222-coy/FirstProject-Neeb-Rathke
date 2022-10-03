package edu.bsu.cs222;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
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
import java.awt.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WikipediaApplication extends Application {

    Text sceneTitle = new Text("Let's check the revisions of a Wikipedia page! ");
    TextField textField = new TextField();
    Button startButton = new Button("Search Revisions");
    Text revisionsText = new Text();
    Executor executor = Executors.newSingleThreadExecutor();


    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(sceneTitle, 0, 0, 2, 1);
        grid.add(textField, 1, 1);
        grid.add(startButton, 1, 4);
        grid.add(revisionsText, 1, 6);

        startButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                createUI();
            }
        });
        Scene scene = new Scene(grid, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private Parent createUI() {
        startButton.setOnAction((event) -> {
            startButton.setDisable(true);
            textField.setDisable(true);
            executor.execute(()->{

                String text = textField.getText();
                int value = Integer.parseInt(text);
                RevisionParser parser = new RevisionParser();

                Platform.runLater(()->{
                    startButton.setDisable(false);
                    textField.setDisable(false);
                });
            });
        });


        VBox vbox = new VBox();
        vbox.getChildren().addAll(textField, startButton);
        return vbox;
    }
}

