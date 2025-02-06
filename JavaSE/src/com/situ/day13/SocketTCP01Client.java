package com.situ.day13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/6 21:27
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端返回:" + socket.getClass());

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        int readLine;
        byte[] bytes = new byte[1024];
        while ((readLine = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLine));
        }

        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
