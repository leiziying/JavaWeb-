package echo.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket  udpClientSocket=new DatagramSocket();
        Scanner scanner=new Scanner(System.in);
       while(true) {
           String message=scanner.nextLine();
           //构建一个发送缓冲区
           byte[] sendBuffer = message.getBytes("UTF-8");//保证发送和接收端的编码格式一致
           byte[] serverIP = new byte[4];
           //本机IP127.0.0.1
           serverIP[0] = (byte) 192;
           serverIP[1] = (byte) 168;
           serverIP[2] = (byte) 43;
           serverIP[3] = (byte) 246;
           InetAddress serverAddress = InetAddress.getByAddress(serverIP);//得到服务器的IP地址
           DatagramPacket sendPacket = new DatagramPacket(
                   sendBuffer,
                   sendBuffer.length,
                   serverAddress,
                   9898);
           udpClientSocket.send(sendPacket);
           //接收对方回应的消息
           byte[] receiveBuffer = new byte[1024];
           //构造一个准备接收的数据报文
           DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
           udpClientSocket.receive(receivePacket);
           String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
           System.out.println(responseMessage);
       }
       // udpClientSocket.close();
    }
}
