package com.example.server;

import java.io.*;
import java.net.*;

public class MatchServer {
    private static int count = 37;
    private static int turn = 0;
    private static DataOutputStream[] outs = new DataOutputStream[2];

    public static void main(String[] args) {
        System.out.println("Match Server starting on port 12347...");
        try (ServerSocket ss = new ServerSocket(12347)) {
            ss.setReuseAddress(true);
            
            for (int i = 0; i < 2; i++) {
                Socket s = ss.accept();
                outs[i] = new DataOutputStream(s.getOutputStream());
                outs[i].writeInt(i);
                int id = i;
                new Thread(() -> {
                    try (s; DataInputStream in = new DataInputStream(s.getInputStream())) {
                        while (count > 0) {
                            broadcast();
                            int taken = in.readInt();
                            if (turn == id) {
                                count -= taken;
                                turn = 1 - turn;
                            }
                        }
                        broadcast();
                    } catch (Exception e) { System.out.println("Player " + id + " left."); }
                }).start();
            }
            // Держим сервер открытым, пока идет игра
            while(count > 0) Thread.sleep(1000);
            
        } catch (Exception e) { e.printStackTrace(); }
    }

    private static synchronized void broadcast() throws IOException {
        for (var o : outs) {
            if (o != null) {
                o.writeInt(count);
                o.writeInt(turn);
                o.flush();
            }
        }
    }
}