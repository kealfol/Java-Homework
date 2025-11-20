package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class OrderForm extends Application {
    private static final List<Dish> MENU = new ArrayList<>();

    static {
        MENU.add(new Dish("Борщ", 150.0));
        MENU.add(new Dish("Пельмени", 200.0));
        MENU.add(new Dish("Салат Цезарь", 120.0));
        MENU.add(new Dish("Стейк", 1450.0));
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        Label titleLabel = new Label("Меню ресторана");
        root.getChildren().add(titleLabel);

        GridPane menuGrid = new GridPane();
        menuGrid.setHgap(10);
        menuGrid.setVgap(8);
        menuGrid.setPadding(new Insets(10, 0, 10, 0));

        List<CheckBox> checkBoxes = new ArrayList<>();
        List<TextField> quantityFields = new ArrayList<>();

        for (int i = 0; i < MENU.size(); i++) {
            Dish dish = MENU.get(i);
            CheckBox checkBox = new CheckBox(dish.getName());
            TextField quantityField = new TextField("1");
            quantityField.setPrefWidth(60);
            quantityField.setDisable(true);

            checkBox.setOnAction(e -> {
                boolean selected = checkBox.isSelected();
                quantityField.setDisable(!selected);
                if (!selected) {
                    quantityField.setText("1");
                }
            });

            menuGrid.add(checkBox, 0, i);
            menuGrid.add(quantityField, 1, i);

            checkBoxes.add(checkBox);
            quantityFields.add(quantityField);
        }

        root.getChildren().add(menuGrid);

        Button calculateButton = new Button("Рассчитать заказ");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setPrefRowCount(8);

        calculateButton.setOnAction(e -> {
            double total = 0.0;
            StringBuilder result = new StringBuilder("Чек:\n\n");

            for (int i = 0; i < MENU.size(); i++) {
                CheckBox checkBox = checkBoxes.get(i);
                TextField quantityField = quantityFields.get(i);

                if (checkBox.isSelected()) {
                    try {
                        int qty = Integer.parseInt(quantityField.getText());
                        if (qty <= 0) throw new NumberFormatException();
                        Dish dish = MENU.get(i);
                        double dishTotal = dish.getPrice() * qty;
                        total += dishTotal;
                        result.append(String.format("%s: %d порц. × %.2f = %.2f руб.\n",
                                dish.getName(), qty, dish.getPrice(), dishTotal));
                    } catch (NumberFormatException ex) {
                        resultArea.setText("Ошибка: Введите корректное количество.");
                        return;
                    }
                }
            }

            result.append(String.format("\nИтого: %.2f руб.", total));
            resultArea.setText(result.toString());
        });

        root.getChildren().addAll(calculateButton, resultArea);

        Scene scene = new Scene(root, 450, 550);
        primaryStage.setTitle("Заказ в ресторане");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class Dish {
        private final String name;
        private final double price;

        public Dish(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
    }
}