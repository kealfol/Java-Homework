package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {
    private TextField display;
    private double firstOperand = 0.0;
    private String currentOperation = "";
    private boolean startNewInput = true;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        display = new TextField();
        display.setEditable(false);
        display.setPrefHeight(50);
        display.setStyle("-fx-font-size: 24px; -fx-alignment: center-right;");
        root.getChildren().add(display);

        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(5);
        buttonGrid.setVgap(5);

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        int row = 0, col = 0;
        for (String btnText : buttons) {
            Button button = new Button(btnText);
            button.setPrefSize(60, 60);
            button.setStyle("-fx-font-size: 18px;");

            button.setOnAction(e -> handleButtonClick(btnText));

            buttonGrid.add(button, col, row);
            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }

        root.getChildren().add(buttonGrid);

        Scene scene = new Scene(root, 280, 350);
        primaryStage.setTitle("Калькулятор");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(String text) {
        switch (text) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                if (startNewInput) {
                    display.setText(text);
                    startNewInput = false;
                } else {
                    display.setText(display.getText() + text);
                }
                break;

            case ".":
                if (startNewInput) {
                    display.setText("0.");
                    startNewInput = false;
                } else if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                }
                break;

            case "+": case "-": case "*": case "/":
                try {
                    double currentValue = Double.parseDouble(display.getText());
                    if (!currentOperation.isEmpty()) {
                        performCalculation(currentValue);
                    } else {
                        firstOperand = currentValue;
                    }
                    currentOperation = text;
                    startNewInput = true;
                } catch (NumberFormatException e) {
                    display.setText("Ошибка");
                }
                break;

            case "=":
                try {
                    double secondOperand = Double.parseDouble(display.getText());
                    if (currentOperation.equals("/") && secondOperand == 0.0) {
                        display.setText("Ошибка: деление на 0");
                        resetCalculator();
                        return;
                    }
                    performCalculation(secondOperand);
                    currentOperation = "";
                    startNewInput = true;
                } catch (NumberFormatException e) {
                    display.setText("Ошибка");
                }
                break;
        }
    }

    private void performCalculation(double secondOperand) {
        double result = 0.0;
        switch (currentOperation) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                result = firstOperand / secondOperand;
                break;
        }
        display.setText(String.valueOf(result));
        firstOperand = result;
    }

    private void resetCalculator() {
        firstOperand = 0.0;
        currentOperation = "";
        startNewInput = true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}