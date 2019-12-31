import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request1231 {
    String method;
    String path;

    String version;
    Map<String ,String> parameters=new HashMap<>();
    Map<String,String> headers=new HashMap<>();

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", parameters=" + parameters +
                ", headers=" + headers +
                '}';
    }
    static Request1231 parse(InputStream is)throws IOException{
        Request1231 request=new Request1231();
        Scanner scanner=new Scanner(is,"UTF-8");
        String line;
        parseLine(request,scanner);
        while(!(line=scanner.nextLine()).isEmpty()){
            String[] kv=line.split(":");
            String key=kv[0].trim();
            String value=kv[1].trim();
            request.headers.put(key,value);
        }
        return  request;
    }

    private static void parseLine(Request1231 request, Scanner scanner) throws IOException {
        String line;
        line=scanner.nextLine();
        String[] group=line.split(" ");
        request.method=group[0];
        //解析路径部分
        //  /%c2B%2B?name=hello&age=18&sex
        // path=c++
        String[] segment=group[1].split("\\?");
        request.path=segment[0];
        if(segment.length!=1){
         String[] kv=segment[1].split("&");
            for (String kvString:kv) {
                String[] kv2=kvString.split("=");
                String key= URLDecoder.decode(kv2[0],"UTF-8");
                String value="";
                if(kv2.length==2){
                    value=URLDecoder.decode(kv2[1],"UTF-8");
                }
                request.parameters.put(key,value);
            }
        }
        request.path=URLDecoder.decode(request.path,"UTF-8");
        request.version=group[2];
    }

}
