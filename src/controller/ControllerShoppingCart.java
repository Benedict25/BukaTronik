/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.GadgetType;
import model.Item;
import model.ItemInShoppingCart;
import model.Person;

/**
 *
 * @author Matthew
 */
public class ControllerShoppingCart {

    static DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<ItemInShoppingCart> getShoppingCartData() {
        conn.connect();
        String query = "SELECT * FROM iteminshoppingcart WHERE idPerson='" + MainController.activeID + "'";
        ArrayList<ItemInShoppingCart> arrShoppingCart = new ArrayList();

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ItemInShoppingCart newShopppingCart = new ItemInShoppingCart();
                newShopppingCart.setQuantity(rs.getInt("quantity"));
                newShopppingCart.setIdItem(rs.getInt("idItem"));
                arrShoppingCart.add(newShopppingCart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrShoppingCart;
    }

    public ArrayList<Item> getItemDataForShoppingCart(ArrayList<ItemInShoppingCart> arrShoppingCart) {
        conn.connect();
        ArrayList<Item> arrItem = new ArrayList();

        for (int i = 0; i < arrShoppingCart.size(); i++) {
            String query = "SELECT * FROM item WHERE idItem='" + arrShoppingCart.get(i).getIdItem() + "'";
            try {
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Item newItem = new Item();
                    newItem.setIdItem(rs.getInt("idItem")); //idItem untuk nanti diparsing ke function delete
                    newItem.setIdPerson(rs.getInt("idPerson"));
                    newItem.setItemName(rs.getString("itemName"));
                    newItem.setPrice(rs.getInt("price"));
                    newItem.setStocks(rs.getInt("stock"));

                    if (rs.getString("category").equals("LAPTOP")) {
                        newItem.setCategory(GadgetType.LAPTOP);
                    } else if (rs.getString("category").equals("HANDPHONE")) {
                        newItem.setCategory(GadgetType.HANDPHONE);
                    } else {
                        newItem.setCategory(GadgetType.ACC);
                    }

                    newItem.setStocks(rs.getInt("itemWeight"));
                    arrItem.add(newItem);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return arrItem;
    }

    public boolean insertShoppingCart(int inputIdItem) {
        conn.connect();
        String query = "INSERT INTO iteminShoppingCart VALUES(?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, MainController.activeID);
            stmt.setInt(2, inputIdItem);
            stmt.setInt(3, 1);
            stmt.executeUpdate();
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }
    }

    public boolean removeFromShoppingCart(int idItem) {
        conn.connect();
        String query = "DELETE FROM iteminshoppingcart WHERE idPerson='" + MainController.activeID + "'&& idItem='" + idItem + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }
    }

    public boolean changeQuantity(int quantity, int idItem) {
        conn.connect();
        String query = "UPDATE iteminshoppingcart SET quantity='" + quantity + "' WHERE idItem='" + idItem + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }
    }

    public ArrayList<Person> getSellerData(ArrayList<Item> arrItem) {
        conn.connect();

        ArrayList<Person> arrPerson = new ArrayList();

        for (int i = 0; i < arrItem.size(); i++) {
            String query = "SELECT * FROM person WHERE idPerson='" + arrItem.get(i).getIdPerson() + "'";
            try {
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Person newPerson = new Person();
                    newPerson.setName(rs.getString("name"));
                    arrPerson.add(newPerson);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return arrPerson;
    }
}
