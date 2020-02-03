package org.db;

import java.sql.*;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/sakila";
    private String user = "student";
    private String pass = "123";

    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void searchActor(String sqlStatement, String lastName, String firstName) throws SQLException {
        //Connection myConn;
        PreparedStatement myStmt;
        ResultSet myRs;


        myStmt = getConnection().prepareStatement(sqlStatement);

        myStmt.setString(1, lastName + "%");
        myStmt.setString(2, firstName + "%");

        myRs = myStmt.executeQuery();

        while (myRs.next()) {
            System.out.println(myRs.getString("first_name") + " " + myRs.getString("last_name"));
        }

    }
}