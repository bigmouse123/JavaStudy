package com.situ.day15.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/8 20:55
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {

        //在8888端口等待连接
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器等待连接~~~");
        Socket socket = serverSocket.accept();

        //读取客户端发来的数据并存入bytes数组
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        //将bytes写入指定路径
        String destFilePath = "E:\\idea-workspace\\JavaStudy2501\\JavaSE\\src\\baoguo.png";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bufferedOutputStream.write(bytes);

        //向客户端回复“收到图片”(字符流)
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到图片");
        bufferedWriter.flush();
        socket.shutdownOutput();

        bufferedInputStream.close();
        bufferedOutputStream.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();

    }
}
