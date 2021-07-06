/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Benedict
 */
public class ControllerBalance {

    DatabaseHandler conn = new DatabaseHandler();

    public void depositBalance(int addBalance) {
        conn.connect();

        int initialBalance = new MainController().getActivePersonBalance();
        int newBalance = initialBalance + addBalance;

        String query = "UPDATE person SET balance=" + newBalance + " "
                + "WHERE idPerson='" + MainController.activeID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void withdrawBalance(int withdrawBalance) {
        conn.connect();

        int initialBalance = new MainController().getActivePersonBalance();
        int newBalance = initialBalance - withdrawBalance;

        String query = "UPDATE person SET balance=" + newBalance + " "
                + "WHERE idPerson='" + MainController.activeID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
