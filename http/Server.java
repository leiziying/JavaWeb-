package tcp.http;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//tcp是面向连接的
public class Server {
    public static void main(String[] args) throws IOException {
        //建立一个ServerSocket
        ServerSocket tcpServerSocket=new ServerSocket(8080);
        while(true){
            Socket  clientSocket=tcpServerSocket.accept();//如果有人连接上来，accept方法就会返回，没有连接就会一直等在这里
           InetAddress clientAddress= clientSocket.getInetAddress();//获得对方客户端的地址
          int  clientPort=clientSocket.getPort();
            System.out.printf("有客户端连接上来 %s:%d%n",clientAddress.getHostAddress(),clientPort);
            //获取字节流
           InputStream is= clientSocket.getInputStream();
            //1、字节流转字符流
            InputStreamReader isReader=new InputStreamReader(is,"UTF-8");
            //字符流转化为缓冲字符流
            BufferedReader reader=new BufferedReader(isReader);//目的是为了或得对方的数据reader中就有方法readLine
            //怎么判断数据读完了？
           String line;
           StringBuilder sb=new StringBuilder();
           while((line=reader.readLine())!=null){
               sb.append(line);
           }
           String requset=sb.toString();
            System.out.println(requset);
            //获取输出字节流
            OutputStream os=clientSocket.getOutputStream();
            PrintStream out=new PrintStream(os,true,"UTF-8");
            out.println("我已经收到了你的消息，退朝吧");
            clientSocket.close();
        }

    }
}
