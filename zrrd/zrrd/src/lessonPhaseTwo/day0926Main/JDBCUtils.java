package lessonPhaseTwo.day0926Main;

import java.sql.*;

public class JDBCUtils {
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8";
    private static String username="root";
    private static String password="root";
    static {
        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

    }
    //获取链接
    public static Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
    //释放资源
    public static void closeResource(Connection conn, Statement st,ResultSet rs) throws SQLException {
        if (rs !=null){
           rs.close();
        }
        if (conn !=null){
            conn.close();
        }
        if (st !=null){
            st.close();
        }
    }


}
