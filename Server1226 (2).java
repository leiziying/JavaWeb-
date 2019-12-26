package udp.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server1226 {
    public static void main(String[] args) throws IOException {
        //1.新建一个DatagramSocket
        DatagramSocket udpServerSocket=new DatagramSocket(9898);
        byte[] receiveBuffer=new byte[1024];
        DatagramPacket receivePacket=new DatagramPacket(receiveBuffer,receiveBuffer.length);
        //2.等着客户端来撩
        udpServerSocket.receive(receivePacket);
       InetAddress clientAddress= receivePacket.getAddress();
        System.out.printf("我从%s:%d 收到了消息%n",clientAddress.getHostAddress(),receivePacket.getPort());
        System.out.printf("我一共收到了%d字节的数据%n",receivePacket.getLength());
        //字节转字符
        String message=new String (receivePacket.getData(),
                0,
                receivePacket.getLength(),
                "UTF-8");
        System.out.println(message);
        udpServerSocket.close();
    }
}
