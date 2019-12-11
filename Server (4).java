package tcp.http;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Stream;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket tcpServerSocket=new ServerSocket(8080);
        while(true){
            Socket clientSocket=tcpServerSocket.accept();
            InetAddress clientAddress= clientSocket.getInetAddress();
            int clientPort=clientSocket.getPort();
            System.out.printf("有客户端连接上来 %s :%d%n",clientAddress.getHostAddress(),clientPort);
            //获取字节流
            InputStream is= clientSocket.getInputStream();
            //字节流转换为字符流
            InputStreamReader isReader=new InputStreamReader(is,"UTF-8");
            //字符流转换缓冲字符流
            BufferedReader reader=new BufferedReader(isReader);
            String line;
            StringBuilder sb=new StringBuilder();
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
            String request=sb.toString();
            System.out.println(request);
            //获取输出字节流
            OutputStream os=clientSocket.getOutputStream();
           PrintStream out=new PrintStream(os,true,"UTF-8");
           out.println("我已经收到了理你的消息，退朝吧");
           clientSocket.close();
        }
    }
}
