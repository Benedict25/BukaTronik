/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Person;
import model.UserType;

/**
 *
 * @author Benedict
 */
public class ControllerRegister {

    static DatabaseHandler conn = new DatabaseHandler();

    public boolean insertNewPerson(Person person) {

        conn.connect();
        String query = "INSERT INTO person VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1,0);
            stmt.setString(2, person.getUsername());
            stmt.setString(3, person.getPassword());
            stmt.setString(4, person.getName());
            stmt.setString(5, person.getAddress());
            stmt.setString(6, person.getCity());
            stmt.setString(7, person.getPhoneNumber());
            stmt.setString(8, person.getEmail());
            stmt.setInt(9, 0);
            if (person.getUserType().equals(UserType.BUYER)) {
                stmt.setString(10, "BUYER");
            } else if (person.getUserType().equals(UserType.SELLER)) {
                stmt.setString(10, "SELLER");
            }
            stmt.executeUpdate();
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }

    }

}