/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Person;
import model.UserType;

/**
 *
 * @author Benedict
 */
public class MainController {

    static DatabaseHandler conn = new DatabaseHandler();
    public static int activeID = -1;

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

    public Person getPersonDataById() {
        conn.connect();
        String query = "SELECT * FROM person WHERE idPerson='" + MainController.activeID + "'";
        Person activePerson = new Person();

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                activePerson.setUsername(rs.getString("username"));
                activePerson.setPassword(rs.getString("password"));
                activePerson.setName(rs.getString("name"));
                activePerson.setAddress(rs.getString("address"));
                activePerson.setCity(rs.getString("city"));
                activePerson.setPhoneNumber(rs.getString("phoneNumber"));
                activePerson.setEmail(rs.getString("email"));
                activePerson.setBalance(Integer.parseInt(rs.getString("balance")));
                
                if (rs.getString("userType").equals("BUYER")) {
                    activePerson.setUserType(UserType.BUYER);
                }else if(rs.getString("userType").equals("SELLER")){
                    activePerson.setUserType(UserType.SELLER);
                }else {
                    activePerson.setUserType(UserType.ADMIN);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return activePerson;
    }

    public String getMembershipStatus() {
        conn.connect();
        String query = "SELECT * FROM buyer WHERE idPerson='" + MainController.activeID + "'";
        String membershipStatus = "";

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                membershipStatus = rs.getString("membershipStatus");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return membershipStatus;
    }
}
