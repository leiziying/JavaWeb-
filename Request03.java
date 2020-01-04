import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request03 {
    String method;
    String url;
    Map<String,String>  parameters=new HashMap<>();
    Map<String,String>  headers=new HashMap<>();

    @Override
    public String toString() {
        return "Request03{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", parameters=" + parameters +
                ", headers=" + headers +
                '}';
    }
    public static  Request03 parse(InputStream   is){
        Request03 request03=new Request03();
        Scanner scanner=new Scanner(is,"UTF-8");
        String line=scanner.nextLine();
        String[] group=line.split(" ");
        request03.method=group[0];
        String[] grou2=group[1].split("\\?");
        request03.url=grou2[0];
        while(!(line=scanner.nextLine()).isEmpty()){
            String[] kv=line.split(":");
            String key=kv[0].trim();
            String value=kv[1].trim();
            request03.headers.put(key,value);
        }
        return  request03;
    }
}
