package com.example.server;

import java.io.*;
import java.net.*;

public class ProgressServer {
    private static double progress = 0;
    private static String state = "STOP";

    public static void main(String[] args) {
        System.out.println("Progress Server starting on port 12346...");
        
        new Thread(() -> {
            while (true) {
                if (state.equals("START") && progress < 1.0) progress += 0.01;
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        }).start();

        try (ServerSocket ss = new ServerSocket(12346)) {
            ss.setReuseAddress(true);
            while (true) {
                Socket s = ss.accept();
                new Thread(() -> handleClient(s)).start();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static void handleClient(Socket s) {
        try (s; 
             DataInputStream in = new DataInputStream(s.getInputStream());
             DataOutputStream out = new DataOutputStream(s.getOutputStream())) {
            while (true) {
                if (in.available() > 0) {
                    state = in.readUTF();
                    if (state.equals("STOP")) progress = 0;
                }
                out.writeDouble(progress);
                Thread.sleep(100);
            }
        } catch (Exception e) { /* Client disconnected */ }
    }
}