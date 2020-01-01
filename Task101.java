import java.io.IOException;
import java.io.Reader;
import java.net.Socket;

public class Task101 implements Runnable {
    private Socket socket;
    public Task101(Socket socket) {
    this.socket=socket;
    }

    @Override
    public void run() {
        try{
            //读取并解析请求->处理业务->组装并发送响应
            //1.读取并解析请求
            Request101 request=Request101.parse(socket.getInputStream());
            System.out.println(request);
            Response101 response=new Response101();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
