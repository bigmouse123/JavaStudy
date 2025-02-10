package com.situ.day16.download;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/10 21:08
 */
public class Client_ {
    public static void main(String[] args) throws Exception {
        //1.接受用户输入，指定下载文件名
        System.out.println("请输入下载文件名:");
        Scanner scanner = new Scanner(System.in);
        String downLoadFileName = scanner.nextLine();
        //2.客户端连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //3.获取和socket关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downLoadFileName.getBytes());
        socket.shutdownOutput();
        //4.读取服务端返回的字节数据
        BufferedInputStream bufferedInputStream
                = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        //5.得到输出流将bytes上传到磁盘
        String resqFileName = "F:\\" + downLoadFileName + ".mp3";
        BufferedOutputStream bufferedOutputStream
                = new BufferedOutputStream(new FileOutputStream(resqFileName));
        bufferedOutputStream.write(bytes);
//        socket.shutdownOutput();
        //6.关闭相关资源
        outputStream.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
