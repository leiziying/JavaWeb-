package udp;


import  java.nio.charset.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
public class Server {
    public static void main(String[] args) throws IOException {
        //1.新建一个DatagramSocket
        DatagramSocket udpServerSoket=new DatagramSocket(9898);
        byte[]  reciveBuffer =new byte[1024];
        DatagramPacket recivePacket=new DatagramPacket(reciveBuffer,reciveBuffer.length);
        udpServerSoket.receive(recivePacket);
          InetAddress clientAddress= recivePacket.getAddress();
        System.out.printf("我从%s:%d  收到了消息%n",clientAddress.getHostAddress(),recivePacket.getPort());
        System.out.printf("我一共收到了%d字节的数据%n",recivePacket.getLength());
    String message=new String(recivePacket.getData(),0,recivePacket.getLength(),"UTF-8");
        System.out.println(message);
        byte[] sendBuffer=message.getBytes("UTF-8");

        udpServerSoket.close();
    }
}
