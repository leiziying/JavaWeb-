package tcp.http;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1226 {
    public static void main(String[] args) throws IOException {
        //监听8080端口
        ServerSocket tcpServerSocket=new ServerSocket(8080);
        while(true){
            Socket clientSocket=tcpServerSocket.accept();
           InetAddress clientAddress= clientSocket.getInetAddress();
           int clientPort=clientSocket.getPort();
            System.out.printf("有客户端连接上来 %s:%d%n",clientAddress.getHostAddress(),clientPort);
            //获取字节流
           InputStream is= clientSocket.getInputStream();
            //字节流转换为字符流
            InputStreamReader isReader=new InputStreamReader(is,"UTF-8");
            //字符流转换为缓冲字符流
            BufferedReader reader=new BufferedReader(isReader);
            //获取输出字节流
            OutputStream os=clientSocket.getOutputStream();
            PrintStream out=new PrintStream(os,true,"UTF-8");
            String line;
            while((line=reader.readLine())!=null) {
                System.out.println(line);
                out.println("我已经收到了你的消息");
            }
        }
    }
}
