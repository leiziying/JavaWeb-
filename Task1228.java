import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Socket;

public class Task1228 implements  Runnable{
    //socket代表的就是客人
    private Socket socket;
    public Task1228(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try{
            //获取输入流
            InputStream is=socket.getInputStream();
            //获取输出流
            OutputStream os=socket.getOutputStream();
            //按照TCP服务器的处理流程
            //1.读取客户端的输入
            //2.理解客户端的输入（http请求解析）
            //Request对象代表客人的要求
            Request1228 request= Request1228.parse(is);
            System.out.println(request);
            if(request.path.equalsIgnoreCase("/")){
                String body="<h1>成功</h1>";
                byte[] bodyBuffer=body.getBytes("UTF-8");
                StringBuilder response=new StringBuilder();
                response.append("HTTP/1.0 200 OK\r\n");
                response.append("Content-Type:     text/html;charset=UTF-8\r\n");
                response.append("\r\n");
                response.append("\r\n");
                os.write(response.toString().getBytes("UTF-8"));
                os.write(bodyBuffer);
                os.flush();
            }else{
                StringBuilder response=new StringBuilder();
                response.append("HTTP/1.0      404    Not Found\r\n");
                os.write(response.toString().getBytes("UTF-8"));
                os.flush();
            }
            //3.处理客人的要求
            //4.说让客人能理解的话
            //5.把话说出去
            //6.通知客人可以走了
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
