package com.example.server;

import java.io.*;
import java.net.*;

public class CalculatorServer {
    public static void main(String[] args) {
        System.out.println("Calculator Server starting on port 12345...");
        // try-with-resources автоматически закроет ServerSocket при выходе
        try (ServerSocket server = new ServerSocket(12345)) {
            // Разрешаем повторное использование порта сразу после закрытия
            server.setReuseAddress(true); 
            
            System.out.println("Server is online. Press Ctrl+C to stop.");
            
            while (!Thread.currentThread().isInterrupted()) {
                try (Socket socket = server.accept();
                     DataInputStream in = new DataInputStream(socket.getInputStream());
                     DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                    
                    double a = in.readDouble();
                    String op = in.readUTF();
                    double b = in.readDouble();
                    
                    if (op.equals("/") && b == 0) {
                        out.writeUTF("Error: Division by 0");
                    } else {
                        double res = switch(op) {
                            case "+" -> a + b;
                            case "-" -> a - b;
                            case "*" -> a * b;
                            case "/" -> a / b;
                            default -> 0;
                        };
                        out.writeUTF(String.valueOf(res));
                    }
                } catch (Exception e) {
                    System.out.println("Client session ended.");
                }
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port 12345. Maybe it's busy?");
        }
    }
}