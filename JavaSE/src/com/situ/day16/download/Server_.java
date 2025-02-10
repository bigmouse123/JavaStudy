package com.situ.day16.download;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/10 21:07
 */
public class Server_ {
    public static void main(String[] args) throws Exception {
        //1.监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.等待客户端连接
        System.out.println("等待客户端连接");
        Socket socket = serverSocket.accept();
        //3.读取客户端发送的要下载的文件名
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        String downLoadFileName = "";
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            downLoadFileName += new String(buffer, 0, len);
        }
        System.out.println("客户端希望下载的文件为" + downLoadFileName);
        String resqFileName = "";
        if ("高山流水".equals(downLoadFileName)) {
            resqFileName = "F:\\JavaEE\\JavaSE\\分享资料\\高山流水.mp3";
        } else {
            resqFileName = "F:\\JavaEE\\JavaSE\\分享资料\\无名.mp3";
        }
        //4.创建输入流，读取文件
        BufferedInputStream bufferedInputStream
                = new BufferedInputStream(new FileInputStream(resqFileName));
        //5.使用工具类读取文件到字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        //6.得到socket关联的输出流
        BufferedOutputStream bufferedOutputStream
                = new BufferedOutputStream(socket.getOutputStream());
        //7.将字节数组写入到通道中，返回给客户端
        bufferedOutputStream.write(bytes);
        socket.shutdownOutput();
        //8.关闭资源
        inputStream.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");
    }
}
