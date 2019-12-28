import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request1228 {
    String method;
    String path;
    String version;
    Map<String ,String > headers=new HashMap<>();
    public static Request1228 parse(InputStream is){
        Request1228 request1228=new Request1228();
        //is是字节流，不太容易读一行，用熟悉的Scanner处理
        Scanner scanner=new Scanner(is,"UTF-8");
        //遵循HTTP请求格式
        //1.解析请求行
        String requestLine=scanner.nextLine();
        String[] group=requestLine.split(" ");
        request1228.method=group[0];
        request1228.path=group[1];
        request1228.version=group[2];
        //2.解析请求头
        String line;
        while(!(line=scanner.nextLine()).isEmpty()){
            String[] kv=line.split(":");
            String key=kv[0].trim();
            String value=kv[1].trim();
            request1228.headers.put(key,value);
        }
        return  request1228;
    }

    @Override
    public String toString() {
        return "Request1228{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                '}';
    }
}
