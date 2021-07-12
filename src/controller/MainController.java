/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.MembershipStatus;
import model.Person;
import model.UserType;

/**
 *
 * @author Benedict
 */
public class MainController {

    static DatabaseHandler conn = new DatabaseHandler();

    public String getActivePersonUsername() {
        String activeUsername = "";
        conn.connect();
        String query = "SELECT * FROM person WHERE idPerson='" + SingletonActiveId.getInstance().getActiveId() + "'";

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

    public int getActivePersonBalance() {
        int activePersonBalance = 0;
        conn.connect();
        String query = "SELECT * FROM person WHERE idPerson='" + SingletonActiveId.getInstance().getActiveId() + "'";

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                activePersonBalance = rs.getInt("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return activePersonBalance;
    }

    public Person getPersonDataById() {
        conn.connect();
        String query = "SELECT * FROM person WHERE idPerson='" + SingletonActiveId.getInstance().getActiveId() + "'";
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
                } else if (rs.getString("userType").equals("SELLER")) {
                    activePerson.setUserType(UserType.SELLER);
                } else {
                    activePerson.setUserType(UserType.ADMIN);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return activePerson;
    }

    public String getMembershipStatus() {
        setMembershipStatus(); //set dahulu, hitung dari total payment
        conn.connect();
        String query = "SELECT * FROM buyer WHERE idPerson='" + SingletonActiveId.getInstance().getActiveId() + "'";
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

    public void setMembershipStatus() {
        conn.connect();
        String query = "SELECT * FROM transaction WHERE idBuyer='" + SingletonActiveId.getInstance().getActiveId() + "'";
        int total = 0;

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                total += rs.getInt("payAmount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //update
        String query2 = "";

        if (total >= 10_000_000) {
            query2 = "UPDATE buyer SET membershipStatus='" + String.valueOf(MembershipStatus.GOLD) + "' "
                    + "WHERE idPerson='" + SingletonActiveId.getInstance().getActiveId() + "'";
        } else if (total >= 5_000_000) {
            query2 = "UPDATE buyer SET membershipStatus='" + String.valueOf(MembershipStatus.SILVER) + "' "
                    + "WHERE idPerson='" + SingletonActiveId.getInstance().getActiveId() + "'";
        } else { //dibawah 5jta
            query2 = "UPDATE buyer SET membershipStatus='" + String.valueOf(MembershipStatus.BRONZE) + "' "
                    + "WHERE idPerson='" + SingletonActiveId.getInstance().getActiveId() + "'";
        }

        try {
            Statement stmt2 = conn.con.createStatement();
            stmt2.executeUpdate(query2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getSellerNameById(int id) {
        conn.connect();
        String query = "SELECT * FROM person WHERE idPerson='" + id + "'";
        String sellerName = "";

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                sellerName = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sellerName;
    }
}
