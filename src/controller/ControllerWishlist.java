/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ControllerVoucher.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.GadgetType;
import model.Item;
import model.Wishlist;

/**
 *
 * @author Benedict
 */
public class ControllerWishlist {

    public ArrayList<Wishlist> getWishlistData() {
        conn.connect();
        String query = "SELECT * FROM wishlist WHERE idPerson='" + MainController.activeID + "'";
        ArrayList<Wishlist> arrWishlist = new ArrayList();

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Wishlist newWishlist = new Wishlist();
                newWishlist.setIdItem(rs.getInt("idItem"));
                arrWishlist.add(newWishlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrWishlist;
    }

    public ArrayList<Item> getItemDataForWishlist(ArrayList<Wishlist> arrWishlist) {
        conn.connect();
        ArrayList<Item> arrItem = new ArrayList();

        for (int i = 0; i < arrWishlist.size(); i++) {
            String query = "SELECT * FROM item WHERE idItem='" + arrWishlist.get(i).getIdItem() + "'";
            try {
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Item newItem = new Item();
                    newItem.setIdItem(rs.getInt("idItem")); //idItem untuk nanti diparsing ke function delete
                    newItem.setItemName(rs.getString("itemName"));
                    newItem.setPrice(rs.getInt("price"));
                    newItem.setStocks(rs.getInt("stock"));
                    
                    if (rs.getString("category").equals("LAPTOP")) {
                        newItem.setCategory(GadgetType.LAPTOP);
                    }else if(rs.getString("category").equals("HANDPHONE")){
                        newItem.setCategory(GadgetType.HANDPHONE);
                    }else{
                        newItem.setCategory(GadgetType.ACC);
                    }
                    
                    newItem.setItemWeight(rs.getInt("itemWeight"));
                    arrItem.add(newItem);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return arrItem;
    }
    
    public boolean removeFromWishlist(int idItemRemove) {
        conn.connect();
        String query = "DELETE FROM wishlist WHERE idPerson='" + MainController.activeID + "'&& idItem='" + idItemRemove + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }
    }
    
    public boolean addToWishlist(int idItem){
        conn.connect();
        String query = "INSERT INTO wishlist VALUES(?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, MainController.activeID);
            stmt.setInt(3, idItem);
            stmt.executeUpdate();
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }

    }
}
