package com.situ.day13;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/6 21:27
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端等待连接");
        Socket socket = serverSocket.accept();
        System.out.println("服务器端返回:" + socket.getClass());

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,client 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");
    }
}
