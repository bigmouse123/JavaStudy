package com.situ.day13;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/6 21:27
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端返回:" + socket.getClass());

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,server 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
