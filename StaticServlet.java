import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class StaticServlet extends HttpServlet2020 {
    @Override
    public void doGet(Request03 request, Response03 reponse) {
        int index=request.url.lastIndexOf('.');
        String suffix=request.url.substring(index+1);
        if(suffix.equals("css")){
         reponse.headers.put("Content-Type","text/css;charset=UTF-8");
        }
        String filename="docBase"+request.url;
        try{
            InputStream is=new FileInputStream(filename);
            Scanner scanner=new Scanner(is,"UTF-8");
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                reponse.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
