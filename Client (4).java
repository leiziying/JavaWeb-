package tcp.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket tcpClientSocket=new Socket();
        byte[] ipv4={127,0,0,1};
        InetAddress serverAddress=InetAddress.getByAddress(ipv4);
        SocketAddress serverSocketAddress=new InetSocketAddress(serverAddress,8080);
        tcpClientSocket.connect(serverSocketAddress);
        //通过字节流直接写入请求

        OutputStream os=tcpClientSocket.getOutputStream();
        os.write("我是好人".getBytes("UTF-8"));
       // os.close();
        //通过字节流，直接读取数据
        InputStream is=tcpClientSocket.getInputStream();
        byte[] buffer=new byte[1024];
        int len=is.read(buffer);
        String response=new String(buffer,0,len,"UTF-8");
        System.out.println(response);
        tcpClientSocket.close();
    }
}
