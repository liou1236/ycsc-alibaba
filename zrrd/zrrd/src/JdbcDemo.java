import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8";
        Connection connection = DriverManager.getConnection(url,"root","root");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from dept");
        while(resultSet.next()){
            //获取一行数据
//            int dname=resultSet.getString("dname");
            String cname = resultSet.getString("dname");
            System.out.println( "+" + cname);
        }
        //6.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}

