package com.situ.day16.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/10 20:22
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        System.out.println("接收端A等待输入数据");
        socket.receive(packet);
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
        data = "明天见".getBytes();
        packet = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 9998);
        socket.send(packet);
        socket.close();
        System.out.println("A端退出");
    }
}