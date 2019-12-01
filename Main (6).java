import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 注册 Driver
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 通过 DriverManager 获取数据库连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/StuControl?useSSL=false",
                "root",
                "123456"
        );
        System.out.println(connection);
        Statement statement=connection.createStatement();
        int rows=statement.executeUpdate("insert into classes (name) values ('xiangrikui_class')");
        statement.close();

      /* ResultSet resultSet= statement.executeQuery("SHOW TABLES");
       while(resultSet.next()){
           String tableName=resultSet.getString(1);
           System.out.println(tableName);
        }*/
       /* statement.close();
        statement=connection.createStatement();
        rows=statement.executeUpdate("updata classes set name='C++11班' where name ='java11班 '");
        statement.close();*/


    }
}
