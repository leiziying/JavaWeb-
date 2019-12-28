import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServer1228 {
    public static void main(String[] args) throws IOException {
        //创建一个监听80
        //80监听端口（TCP决定把数据交给谁，通过端口）
        //一个端口只属于一个进程
        ServerSocket serverSocket=new ServerSocket(80);
        //创建线程池，类比平时开公司
        //只有10个员工的公司
        ExecutorService pool= Executors.newFixedThreadPool(10);
        //不断地接待客人
        while(true){
            //没有客人来之前，不会返回的
            //返回的是一个通信socket
            Socket socket=serverSocket.accept();
            //主线程只负责前台任务
            //对接待客户全部交给工作线程处理
            //为了 效率，我们采用线程池的方式管理工作线程
            //把客人引荐给工作线程
            pool.execute(new Task1228(socket));
        }
    }
}
