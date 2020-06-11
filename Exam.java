import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Exam {
    public static void main(String args[ ]) {
        String name = "罗自琴";
        String  id ="02182028" ;

        Connection con=null;
        try{  Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e){}
        String uri = "jdbc:mysql://localhost:3306/student?useSSL=true";
        String user ="root";
        String password =" ";
        try{
            con = DriverManager.getConnection(uri,user,password);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        // 这里添加代码


    }
}
