import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request101 {
 String method;
 String path;
 String  version;
 public Map<String ,String> parameters=new HashMap<>();
 public Map<String,String>  headers=new HashMap<>();

    @Override
    public String toString() {
        return "Request101{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", parameters=" + parameters +
                ", headers=" + headers +
                '}';
    }
    static Request101 parse(InputStream is) throws  IOException{
        Request101 request101=new Request101();
        Scanner scanner=new Scanner(is,"UTF-8");
        parseRequsetLine(scanner,request101);
        parseRequsetHeaders(scanner,request101);
        return  request101;
    }

    private static void parseRequsetHeaders(Scanner scanner, Request101 request101) throws  IOException {
        String[] group=scanner.nextLine().split(":");
        request101.method=group[0];
        parseUrl(group[1],request101);
        request101.version=group[2];

    }

    private static void parseUrl(String s, Request101 request101) throws UnsupportedEncodingException {
        String[] group=s.split("\\?");
        request101.path= URLDecoder.decode(group[0],"UTF-8");
        if(group.length==2){
            String[]   segment=group[1].split("&");
            for (String  kvString:
                 segment) {
                String[] kv=kvString.split("=");
                String key=URLDecoder.decode(kv[0],"UTF-8");
                String value="";
                if(kv.length==2){
                    value=URLDecoder.decode(kv[1],"UTF-8");
                }
                request101.parameters.put(key,value);
            }
        }
    }

    private static void parseRequsetLine  (Scanner scanner, Request101 request101) throws IOException {
        String line;
        while(!(line=scanner.nextLine()).isEmpty()){
            String[] kv=line.split(":");
            String key=kv[0].trim();
           String value=kv[1].trim();
           request101.headers.put(key,value);
        }
    }

}
