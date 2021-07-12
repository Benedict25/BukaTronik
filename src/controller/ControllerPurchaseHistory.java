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
import model.CourierType;
import model.DeliveryStatus;
import model.DetailedTransaction;
import model.Transaction;

/**
 *
 * @author Ignatius Dariel
 */
public class ControllerPurchaseHistory {

    public ArrayList<Transaction> catchArrOrder(String statusOrder) {
        ArrayList<Transaction> ongoingOrders = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM transaction WHERE idBuyer='" + SingletonActiveId.getInstance().getActiveId() + "' AND deliveryStatus='" + statusOrder + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transaction newTrans = new Transaction();
                newTrans.setIdTransaction(rs.getInt("idTransaction"));
                newTrans.setPurchaseDate(rs.getString("purchaseDate"));
                newTrans.setCourierType(enumCourType(rs.getString("courierType")));
                newTrans.setCourierPrice(rs.getInt("courierPrice"));
                newTrans.setDiscount(rs.getInt("discount"));
                newTrans.setPayAmount(rs.getInt("payAmount"));
                newTrans.setDeliveryStatus(enumOrderStatus(rs.getString("deliveryStatus")));
                ongoingOrders.add(newTrans);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ongoingOrders;
    }

    public CourierType enumCourType(String category) {
        if (category.equals("INSTANT")) {
            return CourierType.INSTANT;
        } else if (category.equals("REGULAR")) {
            return CourierType.REG;
        } else if (category.equals("YES")) {
            return CourierType.YES;
        } else {
            return null;
        }
    }

    public DeliveryStatus enumOrderStatus(String status) {
        if (status.equals("PROCESSED")) {
            return DeliveryStatus.PROCESSED;
        } else if (status.equals("CANCELLING")) {
            return DeliveryStatus.CANCELLING;
        } else if (status.equals("DELIVERED")) {
            return DeliveryStatus.DELIVERED;
        } else if (status.equals("CANCELLED")) {
            return DeliveryStatus.CANCELLED;
        } else {
            return null;
        }
    }

    public ArrayList<DetailedTransaction> catchArrDetailed(int idTransaction) {
        ArrayList<DetailedTransaction> detailedList = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM detailedtransaction WHERE idTransaction='" + idTransaction + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DetailedTransaction newDetailed = new DetailedTransaction();
                newDetailed.setIdItem(rs.getInt("idItem"));
                newDetailed.setQuantity(rs.getInt("quantity"));
                detailedList.add(newDetailed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailedList;
    }

    public boolean cancelOrder(int idTransaction) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "UPDATE transaction SET deliveryStatus='" + DeliveryStatus.CANCELLING + "' "
                + "WHERE idTransaction='" + idTransaction + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }
    }
}
