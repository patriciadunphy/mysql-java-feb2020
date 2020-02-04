package org.program;

import org.db.DatabaseConnection;
import org.db.SQLStatements;
import org.ui.StringOutput;

import java.sql.SQLException;

public class Program {
    SQLStatements stmt = new SQLStatements();
    InputHandler inp = new InputHandler();
    StringOutput out = new StringOutput();

    public void findAnActor() throws SQLException {
        DatabaseConnection db = DatabaseConnection.getInstance();
        InputHandler inp = new InputHandler();
        StringOutput out = new StringOutput();

        out.typeFirstName();
        String firstName = inp.getStringInput();
        out.typeLastName();
        String lastName = inp.getStringInput();
        try {
            out.printResult();
            db.searchActor(stmt.selectActor(), lastName, firstName);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(db.getConnection());
        }
    }
    public void addAnActor() throws SQLException {
        DatabaseConnection db = DatabaseConnection.getInstance();
        out.typeFirstName();
        String firstName = inp.getStringInput();
        out.typeLastName();
        String lastName = inp.getStringInput();
        try {
            db.executeUpdate(stmt.insertActor(), lastName, firstName);
            out.insertActorSuccess();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(db.getConnection());
        }
    }
    public void updateActorNames() throws SQLException {
        DatabaseConnection db = DatabaseConnection.getInstance();

        out.typeOldFirstName();
        String oldFirstName = inp.getStringInput();
        out.typeOldLastName();
        String oldLastName = inp.getStringInput();
        out.typeNewFirstName();
        String newFirstName = inp.getStringInput();
        out.typeNewLastName();
        String newLastName = inp.getStringInput();

        try {
            db.updateActor(stmt.updateActor(), oldLastName, oldFirstName, newLastName, newFirstName);
            out.updateSuccess();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(db.getConnection());
        }
    }
    public void deleteAnActor() throws SQLException {
        DatabaseConnection db = DatabaseConnection.getInstance();

        InputHandler inp = new InputHandler();
        StringOutput out = new StringOutput();
        SQLStatements stmt = new SQLStatements();
        out.typeFirstName();
        String firstName = inp.getStringInput();
        out.typeLastName();
        String lastName = inp.getStringInput();
        try {
            db.executeUpdate(stmt.deleteActor(),lastName, firstName);
            out.deleteActorSucess();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(db.getConnection());
        }
    }
    public void findFilmsForActor() throws SQLException {
        DatabaseConnection db = DatabaseConnection.getInstance();
        out.typeFirstName();
        String firstName = inp.getStringInput();
        out.typeLastName();
        String lastName = inp.getStringInput();
        try {
            out.findActorinFilmsSuccess();
            db.searchActorAndFilm(stmt.selectFilmsFromActor(),lastName, firstName);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(db.getConnection());
        }
    }
}