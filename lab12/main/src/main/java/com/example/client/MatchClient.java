package com.example.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;

public class MatchClient extends Application {
    private int myId;
    private Label info = new Label("Connecting...");
    private TextField input = new TextField("1");
    private Button btn = new Button("Take Matches");

    @Override
    public void start(Stage stage) throws Exception {
        Socket s = new Socket("localhost", 12347);
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        myId = in.readInt();

        btn.setOnAction(e -> { 
            try { 
                int val = Integer.parseInt(input.getText());
                if (val >= 1 && val <= 5) out.writeInt(val); 
            } catch (Exception ex) {} 
        });

        new Thread(() -> {
            try {
                while (true) {
                    int c = in.readInt(); 
                    int t = in.readInt();
                    Platform.runLater(() -> {
                        if (c <= 0) { 
                            info.setText(t == myId ? "YOU WIN!" : "YOU LOSE"); 
                            btn.setDisable(true); 
                        } else { 
                            info.setText("Matches left: " + c + ". Turn: " + (t == myId ? "YOURS" : "OPPONENT'S")); 
                            btn.setDisable(t != myId); 
                        }
                    });
                }
            } catch (Exception e) {}
        }).start();

        stage.setScene(new Scene(new VBox(10, info, input, btn), 250, 150));
        stage.setTitle("Player " + myId);
        stage.show();
    }
    public static void main(String[] args) { launch(); }
}