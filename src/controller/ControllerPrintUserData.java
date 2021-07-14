/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Buyer;
import model.Person;
import model.Seller;
import controller.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.MembershipStatus;

/**
 *
 * @author Ignatius Dariel
 */
public class ControllerPrintUserData {

    DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<Person> getListUserData() {
        conn.connect();
        ArrayList<Person> arrPerson = new ArrayList<>();
        String query = "SELECT * FROM person";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("userType").equals("BUYER")) {
                    Buyer newBuyer = new Buyer();
                    newBuyer.setIdPerson(rs.getInt("idPerson"));
                    newBuyer.setName(rs.getString("name"));
                    newBuyer.setAddress(rs.getString("address"));
                    newBuyer.setCity(rs.getString("city"));
                    newBuyer.setPhoneNumber(rs.getString("phoneNumber"));
                    newBuyer.setEmail(rs.getString("email"));
                    newBuyer.setMembershipStatus(enumMembershipStatus(getMembershipStatusById(rs.getInt("idPerson"))));
                    arrPerson.add(newBuyer);
                } else if (rs.getString("userType").equals("SELLER")) {
                    Seller newSeller = new Seller();
                    newSeller.setIdPerson(rs.getInt("idPerson"));
                    newSeller.setName(rs.getString("name"));
                    newSeller.setAddress(rs.getString("address"));
                    newSeller.setCity(rs.getString("city"));
                    newSeller.setPhoneNumber(rs.getString("phoneNumber"));
                    newSeller.setEmail(rs.getString("email"));
                    arrPerson.add(newSeller);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrPerson;
    }

    public String getMembershipStatusById(int id) {
        conn.connect();
        String membershipStatus = "";
        String query = "SELECT * FROM buyer WHERE idPerson='" + id + "'";
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

    public MembershipStatus enumMembershipStatus(String status) {
        if (status.equals("BRONZE")) {
            return MembershipStatus.BRONZE;
        } else if (status.equals("SILVER")) {
            return MembershipStatus.SILVER;
        } else if (status.equals("GOLD")) {
            return MembershipStatus.GOLD;
        }
        return null;
    }

}
