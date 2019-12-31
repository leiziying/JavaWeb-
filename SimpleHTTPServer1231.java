import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHTTPServer1231 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(80);
        ExecutorService pool=Executors.newFixedThreadPool(10);
        while(true){
            Socket socket=serverSocket.accept();
            pool.execute(new Task1231(socket));
        }
    }
}
