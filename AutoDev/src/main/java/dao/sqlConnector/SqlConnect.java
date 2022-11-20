package dao.sqlConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnect {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "1111";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/auto_dev";
    private static final String DB_DRIVER = "org.postgresql.Driver";

    public static Connection getConnect() throws SQLException {

        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC драйвер для СУБД не знайдений!");
        }catch (SQLException e) {
            e.printStackTrace(); //  Помилки  DriverManager.getConnection
            System.out.println("Помилка SQL !");
        }
        return connection;
    }

}
