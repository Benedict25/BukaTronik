/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.sql.Statement;
import model.Person;

/**
 *
 * @author Benedict
 */
public class ControllerProfile {

    static DatabaseHandler conn = new DatabaseHandler();

    public boolean editProfile(Person person) {
        conn.connect();
        String query = "UPDATE person SET username='" + person.getUsername() + "', "
                + "password='" + person.getPassword()+ "', "
                + "name='" + person.getName()+ "', "
                + "address='" + person.getAddress()+ "', "
                + "city='" + person.getCity()+ "', "
                + "phoneNumber='" + person.getPhoneNumber()+ "', "
                + "email='" + person.getEmail()+ "' "
                + "WHERE idPerson='" + MainController.activeID + "'";
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
