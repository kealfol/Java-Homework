package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WidgetToggler extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label1 = new Label("Виджет 1");
        Label label2 = new Label("Виджет 2");
        Label label3 = new Label("Виджет 3");

        CheckBox checkBox1 = new CheckBox("Показать Виджет 1");
        CheckBox checkBox2 = new CheckBox("Показать Виджет 2");
        CheckBox checkBox3 = new CheckBox("Показать Виджет 3");

        checkBox1.setOnAction(e -> label1.setVisible(checkBox1.isSelected()));
        checkBox2.setOnAction(e -> label2.setVisible(checkBox2.isSelected()));
        checkBox3.setOnAction(e -> label3.setVisible(checkBox3.isSelected()));

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
            label1, checkBox1,
            label2, checkBox2,
            label3, checkBox3
        );

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Управление виджетами");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}