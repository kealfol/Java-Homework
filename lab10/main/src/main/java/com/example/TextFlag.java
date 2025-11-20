package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFlag extends Application {
    private ToggleGroup group1 = new ToggleGroup();
    private ToggleGroup group2 = new ToggleGroup();
    private ToggleGroup group3 = new ToggleGroup();

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        Label titleLabel = new Label("Выберите цвета для флага (по одному на полосу):");
        root.getChildren().add(titleLabel);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(8);

        String[] colors = {"Красный", "Синий", "Зелёный", "Жёлтый", "Белый"};

        grid.add(new Label("Полоса 1:"), 0, 0);
        addRadioButtonsToGrid(grid, group1, colors, 1, 0);

        grid.add(new Label("Полоса 2:"), 0, 1);
        addRadioButtonsToGrid(grid, group2, colors, 1, 1);

        grid.add(new Label("Полоса 3:"), 0, 2);
        addRadioButtonsToGrid(grid, group3, colors, 1, 2);

        root.getChildren().add(grid);

        Button drawButton = new Button("Нарисовать");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setPrefRowCount(3);

        drawButton.setOnAction(e -> {
            String c1 = getSelected(group1);
            String c2 = getSelected(group2);
            String c3 = getSelected(group3);

            if (c1 == null || c2 == null || c3 == null) {
                resultArea.setText("Ошибка: Выберите цвет для каждой полосы.");
            } else {
                resultArea.setText(c1 + ", " + c2 + ", " + c3);
            }
        });

        root.getChildren().addAll(drawButton, resultArea);

        Scene scene = new Scene(root, 450, 300);
        primaryStage.setTitle("Текстовый флаг");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addRadioButtonsToGrid(GridPane grid, ToggleGroup group, String[] colors, int startCol, int row) {
        for (int i = 0; i < colors.length; i++) {
            RadioButton rb = new RadioButton(colors[i]);
            rb.setToggleGroup(group);
            grid.add(rb, startCol + i, row);
        }
    }

    private String getSelected(ToggleGroup group) {
        Toggle selected = group.getSelectedToggle();
        return selected != null ? ((RadioButton) selected).getText() : null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}