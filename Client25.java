import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

/*
* 1，客户端：

1），实例化DatagramSocket类(带上指定端口)，创建客户端

2），准备数据，数据是以字节数组发送的

3），打包数据，使用 DatagramPacket 类 + 服务器地址+ 端口

4），发送数据

5），关闭连接*/
/*
* 2，服务端

1），实例化DatagramSocket类+指定端口

2），准备接收的字节数组，封装 DatagramPacket

3），接受数据

4），解析数据

5），关闭连接*/
public class Client25 {
    public static void main(String[] args) throws IOException {
        //创建服务器（未加端口）
        DatagramSocket udpClientSocket=new DatagramSocket();
        //准备数据
        String message="你好呀";
        byte[] sendBuffer=message.getBytes("UTF-8");
        //getBytes(String charsetName)
        //使用命名的字符集将此 String编码为字节序列，将结果存储到新的字节数组中
        //127.0.0.1
        byte[] serverIP=new byte[4];
        serverIP[0]=127;
        serverIP[1]=0;
        serverIP[2]=0;
        serverIP[3]=1;
        //getByAddress(byte[] addr)根据源ip地址来获取InetAddress对象
        InetAddress serverAddress=InetAddress.getByAddress(serverIP);
        //打包（发送的目的和端口）
        DatagramPacket sendPacket=new DatagramPacket(sendBuffer,sendBuffer.length,serverAddress,9898);
        //发送资源
        udpClientSocket.send(sendPacket);
        //接收对方回应的消息
        //准备 容器接收
        byte[] receiveBuffer=new byte[1024];
        //封装成包（byte[]   bytes,bytes.lenth）
        DatagramPacket receivePacket=new DatagramPacket(receiveBuffer,receiveBuffer.length);
        //接收，使用DatagramSocket实例的receive方法接收
        udpClientSocket.receive(receivePacket);
        //用String的构造方法进行转换成字符串
        String responseMessage=new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");
        System.out.println(responseMessage);
        //关闭资源
        udpClientSocket.close();
    }
}
