/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Flashsale;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Matthew
 */
public class ControllerFlashsale {

    static DatabaseHandler conn = new DatabaseHandler();
    
    public ArrayList<Flashsale> getFlashsaleDataAdmin() {
        conn.connect();
        String query = "SELECT * FROM flashsale";
        ArrayList<Flashsale> arrFlashsale = new ArrayList();
        
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Flashsale newFlashsale = new Flashsale();
                newFlashsale.setIdFlashsale(rs.getInt("idFlashsale"));
                newFlashsale.setIdItem(rs.getInt("idItem"));
                newFlashsale.setDiscountedPrice(rs.getInt("discountedPrice"));
                newFlashsale.setFlashsaleStock(rs.getInt("flashsaleStock"));
                String date = rs.getDate("endDate").toString();
                newFlashsale.setEndDate(date);
                arrFlashsale.add(newFlashsale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrFlashsale;
    }

    public boolean insertFlashsale(Flashsale newFlashsale) {
        conn.connect();
        String query = "INSERT INTO flashsale VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, newFlashsale.getIdItem());
            stmt.setInt(3, newFlashsale.getDiscountedPrice());
            stmt.setInt(4, newFlashsale.getFlashsaleStock());
            String str = newFlashsale.getEndDate();
            Date date = Date.valueOf(str);
            stmt.setDate(5, date);
            stmt.executeUpdate();
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }
    }

    public boolean EditFlashsale(Flashsale updateFlashsale) {
        conn.connect();
        String str = updateFlashsale.getEndDate();
        Date date = Date.valueOf(str);
        
        String query = "UPDATE flashsale SET discountedPrice='" + updateFlashsale.getDiscountedPrice()+ "', "
                + "flashsaleStock='" +updateFlashsale.getFlashsaleStock()+ "', "
                + "endDate='" +date+ "' "
                + "WHERE idFlashsale='"+updateFlashsale.getIdFlashsale()+"'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }
    }
    
    public boolean DeleteFlashsale(int inputDeleteFlashsale){
        conn.connect();
        String query = "DELETE FROM flashsale WHERE idFlashsale='"+inputDeleteFlashsale+"'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }
    }
    
    public Flashsale getFlashsaleDataById(int idFlashsale){
        conn.connect();
        String query = "SELECT * FROM flashsale WHERE idFlashsale='"+idFlashsale+"'";
        Flashsale flashsale = new Flashsale();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                flashsale.setIdFlashsale(rs.getInt("idFlashsale"));
                flashsale.setIdItem(rs.getInt("idItem"));
                flashsale.setDiscountedPrice(rs.getInt("discountedPrice"));
                flashsale.setFlashsaleStock(rs.getInt("flashsaleStock"));
                String date = rs.getDate("endDate").toString();
                flashsale.setEndDate(date);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flashsale;
    }
    
    
}
