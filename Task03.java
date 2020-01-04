import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Task03 implements Runnable {
    private Socket socket;
    private Map<String,HttpServlet2020>  urlMap=new HashMap<>();
    private HttpServlet2020  notFoundServlet=new NotFoundServlet();
    private HttpServlet2020  staticServlet=new StaticServlet();
    public Task03(Socket socket) {
        this.socket=socket;
        urlMap.put("/login",new LoginServlet());
    }

    @Override
    public void run() {
        try{
            Request03 request03=Request03.parse(socket.getInputStream());
            System.out.println(request03);
            Response03 response03=new Response03();
            HttpServlet2020 servlet2020=urlMap.get(request03.url);
            if(servlet2020==null){
                String filename="docBase"+request03.url;
                File file=new File(filename);
                if(!file.exists()){
                    servlet2020=notFoundServlet;
                }else{
                    servlet2020=staticServlet;
                }
            }
            servlet2020.doGet(request03,response03);
            response03.writeAndFlush(socket.getOutputStream());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
