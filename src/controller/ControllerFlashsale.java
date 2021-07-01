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

    public void insertFlashsale(Flashsale newFlashsale) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void EditFlashsale(Flashsale updateFlashsale) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
