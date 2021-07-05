/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Benedict
 */
public class MainController {

    static DatabaseHandler conn = new DatabaseHandler();
    public static int activeID = 111;

    public String getActivePersonUsername() {
        String activeUsername = "";
        conn.connect();
        String query = "SELECT * FROM person WHERE idPerson='" + MainController.activeID + "'";

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                activeUsername = rs.getString("username");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return activeUsername;
    }
}
