/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Flashsale;

/**
 *
 * @author Matthew
 */
public class ControllerAddFlashsale {

static DatabaseHandler conn = new DatabaseHandler();
    
    public void insertFlashsale(Flashsale newFlashsale){
       conn.connect();
        String query = "INSERT INTO flashsale VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1,0);
            stmt.setInt(2, newFlashsale.getIdItem());
            stmt.setInt(3, newFlashsale.getDiscountedPrice());
            stmt.setInt(4, newFlashsale.getFlashsaleStock());
            stmt.setString(5, newFlashsale.getEndDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
