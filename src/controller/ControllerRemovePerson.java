/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class ControllerRemovePerson {

    DatabaseHandler conn = new DatabaseHandler();

    public boolean removePerson(int idPerson) {
        conn.connect();

        String query = "DELETE FROM person WHERE idPerson='" + idPerson + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }

    }

    public ArrayList<Person> getPersonData() {
        ArrayList<Person> arrPerson = new ArrayList();
        conn.connect();
        
        String query = "SELECT * FROM person";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Person person = new Person();
                person.setIdPerson(rs.getInt("idPerson"));
                person.setUsername(rs.getString("username"));
                
                if (rs.getString("userType").equals("BUYER")) {
                    person.setUserType(UserType.BUYER);
                }else if(rs.getString("userType").equals("SELLER")){
                    person.setUserType(UserType.SELLER);
                }else{
                    person.setUserType(UserType.ADMIN);
                }
                
                arrPerson.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrPerson;
    }

}
