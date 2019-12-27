import javax.print.attribute.standard.RequestingUserName;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class SimpleHttpServer {
    private static class Task implements  Runnable{
        private final  Socket socket;
        Task(Socket socket){
            this.socket=socket;
        }
        @Override
        public void run(){
            try{
                InputStream is=socket.getInputStream();
                OutputStream os=socket.getOutputStream();
                //请求解析
                Request request= Request.parse(is);
                System.out.println(request);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //建立Socket
        ServerSocket serverSocket=new ServerSocket(80);
        ExecutorService pool= Executors.newFixedThreadPool(10);
        while(true){
            Socket socket=serverSocket.accept();
            pool.execute(new Task(socket));
        }
    }
}
