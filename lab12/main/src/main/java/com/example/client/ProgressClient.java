package com.example.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;

public class ProgressClient extends Application {
    private DataOutputStream out;
    private ProgressBar pb = new ProgressBar(0);

    @Override
    public void stop() throws Exception {
        if (out != null) out.writeUTF("STOP");
        System.out.println("Client stopping...");
        super.stop();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Socket s = new Socket("localhost", 12346);
        out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream());

        Button b1 = new Button("Start"); b1.setOnAction(e -> send("START"));
        Button b2 = new Button("Pause"); b2.setOnAction(e -> send("PAUSE"));
        Button b3 = new Button("Stop"); b3.setOnAction(e -> send("STOP"));

        new Thread(() -> {
            try {
                while (true) {
                    double p = in.readDouble();
                    Platform.runLater(() -> pb.setProgress(p));
                    Thread.sleep(100);
                }
            } catch (Exception e) {}
        }).start();

        stage.setScene(new Scene(new HBox(10, pb, b1, b2, b3), 400, 100));
        stage.setTitle("ProgressBar Client");
        stage.show();
    }
    private void send(String msg) { try { out.writeUTF(msg); } catch (IOException e) {} }
    public static void main(String[] args) { launch(); }
}