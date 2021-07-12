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
public class ControllerLogin {

    static DatabaseHandler conn = new DatabaseHandler();

    public String checkLoginAndSetActivePerson(String checkUsername, String checkPassword) {
        String returnUserType = "";
        conn.connect();
        String query = "SELECT * FROM person";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("username").equals(checkUsername) && rs.getString("password").equals(checkPassword)) {
                    int activeId = rs.getInt("idPerson");
                    SingletonActiveId.getInstance().setActiveId(activeId);
                    returnUserType = rs.getString("userType");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnUserType;
    }
}
