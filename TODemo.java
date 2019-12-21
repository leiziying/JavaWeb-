

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
* 输入
 */
public class TODemo {
    /*
    * 1.可以从文件中读
    * 2.可以从网络中读（网卡/TCP
    *3.可以从内存中读取
    * 4.可以从标准输入中读取
        * */
    private  static InputStream 获取一个输入流() throws IOException {
       InputStream inputStream;
       // inputStream= new FileInputStream("本地文件.txt");
        Socket socket=new Socket("www.baidu.com",80);
        OutputStream os=socket.getOutputStream();
        Writer writer=new OutputStreamWriter(os,"UTF-8");
        PrintWriter printWriter=new PrintWriter(writer,false);
        printWriter.print("GET/HTTP/1.0\r\n\r\n");
        printWriter.flush();
        inputStream=socket.getInputStream();
       // byte[] bytes="我只是内存中的一段空间\r\n第二行\r\n".getBytes("UTF-8");
        //inputStream= new ByteArrayInputStream(bytes);
        //inputStream=System.in;

        return  inputStream;
    }
    /*
    * 1.直接通过字节方式读，然后程序进行字符编码
    * 2.把String 转化为Reader,进行字符形式读取
    *       2.1直接读
    *       2.2 BufferReader   readLine
    * 3.Scanner也可以
    *
    * */
    private static String 从字节流最终或得字符数据(InputStream is) throws IOException {
       /* byte[] buffer=new byte[1024];
        int len=is.read();
        //数据放在buffer[0,len]
        String message=new String(buffer,0,len);
        return  message;*/
       /*
       StringBuilder sb=new StringBuilder();
        Reader reader=new InputStreamReader(is,"UTF-8");
        char[] buffer=new char[1024];
        int len=reader.read(buffer);
        while((len=reader.read(buffer))!=-1){
            sb.append(buffer,0,len);
        }
        String message=sb.toString();
        return  message;*/
   Reader reader=new InputStreamReader(is,"UTF-8");
   BufferedReader bufferedReader=new BufferedReader(reader);
   String line;
   StringBuilder sb=new StringBuilder();
   while((line=bufferedReader.readLine())!=null){
       sb.append(line+"\r\n");
   }
 return  sb.toString();
    }

    public static void main(String[] args) throws IOException {
         InputStream is=  获取一个输入流();
        String message=从字节流最终或得字符数据(is);
        System.out.println(message);
    }
}
