package ru.geekbrains.qa.java2.lesson6.Demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketHttpRequest {

    // Демонстрация HTTP запроса (упрощенная, без хэдеров)
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("www.nyu.edu", 80);

        InputStream response = socket.getInputStream();
        OutputStream request = socket.getOutputStream();

        byte[] bytes = ("GET /community.html HTTP/1.0\n"
            + "Host: www.nyu.edu\n\n").getBytes();

        request.write(bytes);

        int ch;
        while ((ch = response.read()) != -1) {
            System.out.print((char) ch);
        }

        socket.close();
    }
}
