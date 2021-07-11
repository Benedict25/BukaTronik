/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.MainController.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.DetailedTransaction;
import model.GadgetType;
import model.Item;

/**
 *
 * @author Ignatius Dariel
 */
public class ControllerItem {

    public boolean insertSellerItem(Item newItem) {
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
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String strGadgetType(Item newItem) {
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

    public boolean deleteSellerItem(int idItem) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "DELETE FROM item WHERE idItem='" + idItem + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean editSellerItem(Item newItem) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "UPDATE item SET itemName='" + newItem.getItemName() + "', "
                + "price='" + newItem.getPrice() + "', "
                + "stock='" + newItem.getStocks() + "', "
                + "category='" + strGadgetType(newItem) + "', "
                + "itemWeight='" + newItem.getItemWeight() + "' "
                + "WHERE idItem='" + newItem.getIdItem() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private GadgetType enumGadgetType(String category) {
        if (category.equals("LAPTOP")) {
            return GadgetType.LAPTOP;
        } else if (category.equals("HANDPHONE")) {
            return GadgetType.HANDPHONE;
        } else if (category.equals("ACCESSORIES")) {
            return GadgetType.ACC;
        }
        return null;
    }

    public ArrayList<Item> getSellerItemsData() {
        ArrayList<Item> listItem = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM item WHERE idPerson='" + MainController.activeID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Item newItem = new Item();
                newItem.setIdItem(rs.getInt("idItem"));
                newItem.setItemName(rs.getString("itemName"));
                newItem.setPrice(rs.getInt("price"));
                newItem.setStocks(rs.getInt("stock"));
                newItem.setCategory(enumGadgetType(rs.getString("category")));
                newItem.setItemWeight(rs.getInt("itemWeight"));
                listItem.add(newItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listItem;
    }

    public ArrayList<Item> getArrItemFromDetailed(ArrayList<DetailedTransaction> listDetailed) {
        ArrayList<Item> listItem = new ArrayList<>();
        conn.connect();
        for (int i = 0; i < listDetailed.size(); i++) {
            String query = "SELECT * FROM item WHERE idItem='" + listDetailed.get(i).getIdItem() + "'";
            try {
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Item newItem = new Item();
                    newItem.setItemName(rs.getString("itemName"));
                    newItem.setPrice(rs.getInt("price"));
                    newItem.setStocks(rs.getInt("stock"));
                    newItem.setCategory(enumGadgetType(rs.getString("category")));
                    newItem.setItemWeight(rs.getInt("itemWeight"));
                    listItem.add(newItem);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listItem;
    }

    public Item getDataItemByID(int idItem) {
        Item item = new Item();

        String query = "SELECT * FROM item WHERE idItem='" + idItem + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                item.setIdItem(rs.getInt("idItem")); //idItem untuk nanti diparsing ke function delete
                item.setItemName(rs.getString("itemName"));
                item.setPrice(rs.getInt("price"));
                item.setStocks(rs.getInt("stock"));

                if (rs.getString("category").equals("LAPTOP")) {
                    item.setCategory(GadgetType.LAPTOP);
                } else if (rs.getString("category").equals("HANDPHONE")) {
                    item.setCategory(GadgetType.HANDPHONE);
                } else {
                    item.setCategory(GadgetType.ACC);
                }

                item.setItemWeight(rs.getInt("itemWeight"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    public ArrayList<Item> getBuyerItemsData() {
        ArrayList<Item> listItem = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM item ";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Item newItem = new Item();
                newItem.setIdItem(rs.getInt("idItem"));
                newItem.setItemName(rs.getString("itemName"));
                newItem.setPrice(rs.getInt("price"));
                newItem.setStocks(rs.getInt("stock"));
                newItem.setCategory(enumGadgetType(rs.getString("category")));
                newItem.setItemWeight(rs.getInt("itemWeight"));
                listItem.add(newItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listItem;
    }
}
