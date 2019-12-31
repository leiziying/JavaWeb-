import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Task1231  implements  Runnable{
    private final Socket socket;
    public  Task1231(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try{
            InputStream is=socket.getInputStream();
            OutputStream os=socket.getOutputStream();
            Request request=Request.parse(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
