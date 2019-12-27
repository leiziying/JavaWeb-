import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer1227 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);
        while(true){
            //等待客户端建立连接
            Socket socket=serverSocket.accept();//阻塞，沧海桑田
            //有客户端建立了连接
            InputStream is=socket.getInputStream();// 在java中InputStream是字节输入流，用来将文件中的数据读取到java程序中
            OutputStream os=socket.getOutputStream();
            Reader reader=new InputStreamReader(is,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(reader);
            Writer writer=new OutputStreamWriter(os,"UTF-8");
            PrintWriter printWriter=new PrintWriter(writer,false);
            String message;
            while((message=bufferedReader.readLine())!=null){
                System.out.println("我收到一条消息："+message);
                printWriter.println(message);
                printWriter.flush();
            }
            socket.close();
        }
    }
}
