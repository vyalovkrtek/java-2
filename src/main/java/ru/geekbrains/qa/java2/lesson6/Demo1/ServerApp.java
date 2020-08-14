package ru.geekbrains.qa.java2.lesson6.Demo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.time.ZoneId;

public class ServerApp {

    // Серверная часть чата
    public static void main(String[] args) {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(6666)) {
                Socket client = serverSocket.accept();
                System.out.println("Client connected!");
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                while (true) {
                    String clientResponse = in.readUTF();
                    System.out.println("Client response:" + clientResponse);
                    out.writeUTF(clientResponse + " " +
                        Instant.now().atZone(ZoneId.of("Europe/Moscow")));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
