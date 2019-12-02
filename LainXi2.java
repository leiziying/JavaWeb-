import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class LainXi2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/stucontrol?useSSL=false","root","123456");
try     (Statement statement=connection.createStatement()){
    statement.executeUpdate("INSERT INTO classes(anme)values ('xiangrikui_class')");
}
int classid;
try(Statement statement=connection.createStatement()){
    try(ResultSet resultSet=statement.executeQuery("SELECT id FROM classes WHERE name='xiangrikui_class')"){
        resultSet.next();
        classid=resultSet.getInt(1);
    }
}
try(Statement statement=connection.createStatement()){
    System.out.println();
}

    }
}
