package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WordShifter extends Application {
    private boolean isForward = true;
    private TextField inputField;
    private TextField outputField;
    private Button shiftButton;

    @Override
    public void start(Stage primaryStage) {
        inputField = new TextField();
        outputField = new TextField();
        shiftButton = new Button("->");

        shiftButton.setOnAction(e -> {
            if (isForward) {
                outputField.setText(inputField.getText());
                inputField.clear();
                shiftButton.setText("<-");
            } else {
                inputField.setText(outputField.getText());
                outputField.clear();
                shiftButton.setText("->");
            }
            isForward = !isForward;
        });

        HBox root = new HBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(inputField, shiftButton, outputField);

        Scene scene = new Scene(root, 400, 100);
        primaryStage.setTitle("Перекидыватель слов");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

