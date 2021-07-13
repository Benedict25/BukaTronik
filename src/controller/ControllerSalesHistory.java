/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ControllerPerson.conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.DeliveryStatus;
import model.Transaction;

/**
 *
 * @author Ignatius Dariel
 */
public class ControllerSalesHistory {

    public ArrayList<Transaction> catchArrSalesSeller() {
        ArrayList<Transaction> arrSalesSeller = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM transaction WHERE idSeller='" + SingletonActiveId.getInstance().getActiveId() + "' AND deliveryStatus='DELIVERED' OR deliveryStatus='CANCELLED'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transaction newTrans = new Transaction();
                newTrans.setIdTransaction(rs.getInt("idTransaction"));
                newTrans.setPurchaseDate(rs.getString("purchaseDate"));
                newTrans.setCourierType(new ControllerPurchaseHistory().enumCourType(rs.getString("courierType")));
                newTrans.setCourierPrice(rs.getInt("courierPrice"));
                newTrans.setCashback(rs.getInt("cashback"));
                newTrans.setPayAmount(rs.getInt("payAmount"));
                newTrans.setDeliveryStatus(enumDeliveryStatus(rs.getString("deliveryStatus")));
                arrSalesSeller.add(newTrans);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrSalesSeller;
    }

    public ArrayList<Transaction> catchArrSalesAdmin() {
        ArrayList<Transaction> allSales = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM transaction";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transaction newTrans = new Transaction();
                newTrans.setIdTransaction(rs.getInt("idTransaction"));
                newTrans.setPurchaseDate(rs.getString("purchaseDate"));
                newTrans.setCourierType(new ControllerPurchaseHistory().enumCourType(rs.getString("courierType")));
                newTrans.setCourierPrice(rs.getInt("courierPrice"));
                newTrans.setCashback(rs.getInt("cashback"));
                newTrans.setPayAmount(rs.getInt("payAmount"));
                newTrans.setDeliveryStatus(enumDeliveryStatus(rs.getString("deliveryStatus")));
                allSales.add(newTrans);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allSales;
    }

    private DeliveryStatus enumDeliveryStatus(String str) {
        if (str.equals("PROCESSED")) {
            return DeliveryStatus.PROCESSED;
        } else if (str.equals("CANCELLING")) {
            return DeliveryStatus.CANCELLING;
        } else if (str.equals("DELIVERED")) {
            return DeliveryStatus.DELIVERED;
        } else if (str.equals("CANCELLED")) {
            return DeliveryStatus.CANCELLED;
        } else {
            return null;
        }
    }
}
