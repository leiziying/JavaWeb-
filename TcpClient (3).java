package tcp;

import java.io.*;
import java.net.*;
import java.util.Scanner;
/*
* tcp的客户端使用步骤：
1. 建立tcp的客户端服务。
2. 获取到对应的流对象。 指的事字节流
3.写出或读取数据
4. 关闭资源。*/
public class TcpClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        //建立tcp客户端服务
        Socket tcpClientSocket=new Socket();
        byte[] ipv4={127,0,0,1};
        InetAddress serverAddress=InetAddress.getByAddress(ipv4);
        SocketAddress serverSocketAddress=new InetSocketAddress(serverAddress,8080);
        tcpClientSocket.connect(serverSocketAddress);
        while(true){
            System.out.println("请输出>:");
            String request=scanner.nextLine();
            //通过字节流直接写入请求
            OutputStream os=tcpClientSocket.getOutputStream();
            PrintStream out=new PrintStream(os,true,"UTF-8");
            out.println(request);
            //通过字节 流，直接读取数据
            InputStream is=tcpClientSocket.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String response=reader.readLine();
            System.out.println(response);
        }
    }
}
