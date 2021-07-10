/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.DeliveryStatus;
import model.Transaction;

/**
 *
 * @author Benedict
 */
public class ControllerManageOrder {

    static DatabaseHandler conn = new DatabaseHandler();

    private DeliveryStatus enumDeliveryStatus(String str) {
        if (str.equals("PROCESSED")) {
            return DeliveryStatus.PROCESSED;
        } else if (str.equals("CANCELLING")) {
            return DeliveryStatus.CANCELLING;
        } else if (str.equals("DELIVERED")) {
            return DeliveryStatus.DELIVERED;
        } else if (str.equals("CANCELED")) {
            return DeliveryStatus.CANCELLED;
        }
        return null;
    }

    public ArrayList<Transaction> getTransactionDataForSeller() {
        ArrayList<Transaction> arrTransaction = new ArrayList();

        conn.connect();
        String query = "SELECT * FROM transaction WHERE idSeller='" + MainController.activeID + "'";

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transaction newTrans = new Transaction();
                newTrans.setIdBuyer(rs.getInt("idBuyer"));
                newTrans.setIdTransaction(rs.getInt("idTransaction"));
                newTrans.setPurchaseDate(rs.getString("purchaseDate"));
                newTrans.setCourierType(new ControllerPurchaseHistory().enumCourType(rs.getString("courierType")));
                newTrans.setCourierPrice(rs.getInt("courierPrice"));
                newTrans.setDiscount(rs.getInt("discount"));
                newTrans.setPayAmount(rs.getInt("payAmount"));
                newTrans.setDeliveryStatus(enumDeliveryStatus(rs.getString("deliveryStatus")));
                arrTransaction.add(newTrans);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrTransaction;
    }

    public boolean updateStatusOrder(int idTransaction, String deliveryStatus) {
        conn.connect();
        String query = "UPDATE transaction SET deliveryStatus='" + deliveryStatus + "' "
                + "WHERE idTransaction='" + idTransaction + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

}
