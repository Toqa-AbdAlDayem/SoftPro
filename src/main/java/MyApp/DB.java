package MyApp;

import java.sql.*;

public class DB {
    public static Connection con;
    public static void initialize() throws SQLException {
        con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:orcl", "car_db", "car12345");

}}