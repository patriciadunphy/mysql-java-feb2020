package org.db;

import org.program.InputHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class SqlDB {
    InputHandler in = new InputHandler();
    String dbURL = "jdbc:mysql://localhost:3306/sakila";
    String user = "student";
    String pass = "123";
    Connection myConn = null;
    PreparedStatement myStmt = null;
    ResultSet myRs = null;

    public void searchActor(String sqlStatement, String lastName, String firstName) throws SQLException {

        try {
            myConn = DriverManager.getConnection(dbURL, user, pass);

            myStmt = myConn.prepareStatement(sqlStatement);

            myStmt.setString(1, lastName + "%");
            myStmt.setString(2, firstName + "%");

            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                System.out.println(myRs.getString("first_name")+" "+ myRs.getString("last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            myConn.close();
        }

    }

    public void executeUpdate(String sqlStatement, String lastName, String firstName) throws SQLException {

        try {
            myConn = DriverManager.getConnection(dbURL, user, pass);

            myStmt = myConn.prepareStatement(sqlStatement);

            myStmt.setString(1, lastName);
            myStmt.setString(2, firstName);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            myConn.close();
        }

    }

    public void updateActor(String sqlStatement, String oldLastName, String oldFirstName, String newLastName, String newFirstName) throws SQLException {
        try {
            myConn = DriverManager.getConnection(dbURL, user, pass);

            myStmt = myConn.prepareStatement(sqlStatement);

            myStmt.setString(1, newLastName);
            myStmt.setString(2, newFirstName);
            myStmt.setString(3, oldLastName);
            myStmt.setString(4, oldFirstName);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            myConn.close();
        }
    }

    public void searchActorAndFilm(String sqlStatement, String lastName, String firstName ) throws SQLException {

        try {
            myConn = DriverManager.getConnection(dbURL, user, pass);

            myStmt = myConn.prepareStatement(sqlStatement);

            myStmt.setString(1, lastName + "%");
            myStmt.setString(2, firstName + "%");

            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(myRs.getDate("release_year"));
                System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name") + " - "
                        + myRs.getString("title") + ", " + calendar.get(Calendar.YEAR));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            myConn.close();
        }
    }
}