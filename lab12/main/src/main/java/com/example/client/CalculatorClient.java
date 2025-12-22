package com.example.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Network Calculator Client ---");
        while (true) {
            try (Socket socket = new Socket("localhost", 12345);
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                 DataInputStream in = new DataInputStream(socket.getInputStream())) {
                
                System.out.print("Number 1: "); out.writeDouble(sc.nextDouble());
                System.out.print("Operation (+,-,*,/): "); out.writeUTF(sc.next());
                System.out.print("Number 2: "); out.writeDouble(sc.nextDouble());
                
                System.out.println("Server Result: " + in.readUTF());
                System.out.println("---------------------------------");
            } catch (Exception e) { 
                System.out.println("Connection lost.");
                break; 
            }
        }
    }
}