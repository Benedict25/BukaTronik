/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Person;
import model.UserType;

/**
 *
 * @author Benedict
 */
public class ControllerLogin {

    static DatabaseHandler conn = new DatabaseHandler();

    public boolean checkLoginAndSetActivePerson(String checkUsername, String checkPassword) {
        boolean successLogin = false;
        conn.connect();
        String query = "SELECT * FROM person";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("username").equals(checkUsername) && rs.getString("password").equals(checkPassword)) {
                    MainController.activeID = rs.getInt("idPerson");
                    successLogin = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return successLogin;
    }
    

}
