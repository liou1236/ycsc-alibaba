import lessonPhaseTwo.day0926Main.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo02 {
    static Connection connection = null;
    static Statement statement = null;
   static ResultSet resultSet = null;
    public static void main(String[] args) throws SQLException {
        try{
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            int i = statement.executeUpdate("update dept set   dname='李先生' ,loc='肉酱面' where deptno=60");
            if (i==0){
                throw new RuntimeException("错啦");
            }
            System.out.println("i= "+i);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.closeResource(connection,statement,resultSet);
        }
    }
}
