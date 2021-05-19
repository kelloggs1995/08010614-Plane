package com.cow;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LKSQLConnection {

    private static LKSQLConnection instance = new LKSQLConnection();
    public static final String URl = "jdbc:mysql://comp-server.uhi.ac.uk/pe08010614";
    public static final String USER = "pe08010614";
    public final String PASSWORD = "liamkellock";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    private LKSQLConnection()
    {
        try{
            Class.forName(DRIVER_CLASS);
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private Connection createConnection()
    {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URl, USER, PASSWORD);
        }catch (SQLException e){
            System.out.println("ERROR: cant connect to database");
        }
        return connection;
    }

    public static Connection getConnection()
    {
        return instance.createConnection();
    }
}
