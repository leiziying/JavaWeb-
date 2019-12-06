
import  com.mysql.jdbc.Driver;

import java.sql.*;

public class JDBC1206 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动（利用java语言中的反射）
        Class.forName("com.mysql.jdbc.Driver");
        //2.通过DriverManager获取连接
        //连接的地址
        //CMD中先建立库：CSDN
        String url = "jdbc:mysql://127.0.0.1:3306/stucontrol?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection connection = (Connection) DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        System.out.println(connection);
   ResultSet resultSet=statement.executeQuery("SELECT  id,name FROM  classes");
   while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.printf("%d|%s%n", id, name);
        }
    }
}
