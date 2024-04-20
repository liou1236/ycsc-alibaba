import lessonPhaseTwo.day0926Main.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class JdbcTest {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;

    public static void main(String[] args) throws SQLException {
        connection = JDBCUtils.getConnection();
        while (true) {
            System.out.println("请选择操作:");
            System.out.println("1. 注册");
            System.out.println("2. 登录");
            System.out.println("3. 修改");
            System.out.println("4. 注销");
            System.out.println("5. 退出");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerUser(connection);
                    break;
                case 2:
                    loginUser(connection);
                    break;
                case 3:
                    updateUser(connection);
                    break;
                case 4:
                    deleteUser(connection);
                    break;
                case 5:
                    connection.close();
                    System.exit(0);
                default:
                    System.out.println("无效的选项");
            }
        }
    }
    private static void registerUser(Connection connection) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();

        String sql = "insert into users (username,password) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }

    }
    private static void loginUser(Connection connection) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();

        String sql = "select * from users where where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

    }
    private static void updateUser(Connection connection) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入新密码:");
        String newPassword = scanner.nextLine();

        String sql = "update users set password = ? where username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2, newPassword );

        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("密码更新成功");
        } else {
            System.out.println("密码更新失败");
        }
    }
    private static void deleteUser(Connection connection) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        String sql = "delete from users where username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);

        int rowsDeleted = preparedStatement.executeUpdate();
        if (rowsDeleted > 0){
            System.out.println("账号删除成功");
        }else {
            System.out.println("账号删除失败");
        }
    }
}
