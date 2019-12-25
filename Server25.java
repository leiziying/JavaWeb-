import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server25 {
    public static void main(String[] args) throws IOException {
        //新建一个DatagramSocket+端口
        DatagramSocket udpServerSocket=new DatagramSocket(9898);
        while(true){
            //准备接收容器
            byte[] receiveBuffer=new byte[1024];
            //封装成包 new DatagramPacket(byte[] b,int length)
            DatagramPacket receivePacket=new DatagramPacket(receiveBuffer,receiveBuffer.length);
            //等着客户来撩
            udpServerSocket.receive(receivePacket);
            InetAddress clientAddress=receivePacket.getAddress();
            System.out.printf("我从%s:%d收到了消息%n",clientAddress.getHostAddress(),receivePacket.getPort());
            System.out.printf("我一共收到了%d字节的数据%n",receivePacket.getLength());
            //转成字符串
            String message=new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");
            //服务器端打印收到的字符串
            System.out.println(message);
            //准备容器
            byte[] sendBuffer=message.getBytes("UTF-8");
            //封装成包
            DatagramPacket sendPacket=new DatagramPacket(sendBuffer,sendBuffer.length,clientAddress,receivePacket.getPort());
            udpServerSocket.send(sendPacket);
        }
    }
}
