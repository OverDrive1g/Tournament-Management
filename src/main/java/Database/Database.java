package Database;

import java.sql.*;

public class Database {
    private static Database _instance;
    public static Database getInstance(){
        if(_instance == null)
            _instance = new Database();
        return _instance;
    }
    private Database(){}


    private String database = "eufa";
    private String password = "";
    private String user = "root";
    private int port = 3306;
    private String host = "localhost";

    public static ResultSet Select(String query) {
        return Database.getInstance()._select(query);
    }
    public static void Query(String query){
        Database.getInstance()._query(query);
    }

    private ResultSet _select(String query){
        try {
            Connection connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", host, port, database), user, password);
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void _query(String query){
        try {
            Connection connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", host, port, database), user, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
