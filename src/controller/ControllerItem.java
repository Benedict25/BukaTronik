/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import model.GadgetType;
import model.Item;

/**
 *
 * @author Ignatius Dariel
 */
public class ControllerItem {

    public void insertSellerItem(Item newItem) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "INSERT INTO item VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, MainController.activeID);
            stmt.setString(3, newItem.getItemName());
            stmt.setInt(4, newItem.getPrice());
            stmt.setInt(5, newItem.getStocks());
            stmt.setString(6, strGadgetType(newItem));
            stmt.setInt(7, newItem.getItemWeight());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String strGadgetType(Item newItem) {
        String category = "";
        if (newItem.getCategory() == GadgetType.LAPTOP) {
            category = "LAPTOP";
        } else if (newItem.getCategory() == GadgetType.HANDPHONE) {
            category = "HANDPHONE";
        } else if (newItem.getCategory() == GadgetType.ACC) {
            category = "ACCESSORIES";
        }
        return category;
    }

    public void deleteSellerItem(int idItem) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "DELETE FROM item WHERE idItem='" + idItem + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void editSellerItem(Item newItem) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "UPDATE item SET itemName='" + newItem.getItemName() + "', "
                + "price='" + newItem.getPrice()+ "', "
                + "stock='" + newItem.getStocks() + "', "
                + "category='" + strGadgetType(newItem) + "', "
                + "itemWeight='" + newItem.getItemWeight()+ "' "
                + "WHERE idItem='" + newItem.getIdItem() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
