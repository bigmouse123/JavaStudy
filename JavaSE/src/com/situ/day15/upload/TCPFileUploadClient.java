package com.situ.day15.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/8 20:56
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {

        //客户端连接8888端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //读取磁盘文件,存入bytes数组
        String filePath = "F:\\JavaEE\\JavaSE\\分享资料\\bg.png";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        //将bytes数组发送给服务端
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);
        socket.shutdownOutput();

        //接受服务端发来的“收到图片”并显示
        InputStream inputStream = socket.getInputStream();
        String str = StreamUtils.streamToString(inputStream);
        System.out.println(str);

        bufferedInputStream.close();
        bufferedOutputStream.close();
        inputStream.close();
        socket.close();

    }
}
