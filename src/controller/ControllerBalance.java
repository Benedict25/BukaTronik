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

    public boolean depositBalance(int addBalance) {
        conn.connect();

        int initialBalance = new ControllerPerson().getActivePersonBalance();
        int newBalance = initialBalance + addBalance;

        String query = "UPDATE person SET balance=" + newBalance + " "
                + "WHERE idPerson='" + SingletonActiveId.getInstance().getActiveId() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }

    }

    public boolean withdrawBalance(int withdrawBalance) {
        conn.connect();

        int initialBalance = new ControllerPerson().getActivePersonBalance();
        int newBalance = initialBalance - withdrawBalance;

        String query = "UPDATE person SET balance=" + newBalance + " "
                + "WHERE idPerson='" + SingletonActiveId.getInstance().getActiveId() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }
    }

}
