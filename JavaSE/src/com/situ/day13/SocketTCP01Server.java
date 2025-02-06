package com.situ.day13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/6 21:27
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端等待连接");
        Socket socket = serverSocket.accept();
        System.out.println("服务器端返回:" + socket.getClass());

        InputStream inputStream = socket.getInputStream();
        int readLine = -1;
        byte[] bytes = new byte[1024];
        while ((readLine = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLine));
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());
        socket.shutdownOutput();

        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");
    }
}
