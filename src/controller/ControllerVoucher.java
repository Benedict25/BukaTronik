/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ControllerFlashsale.conn;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import model.Voucher;

/**
 *
 * @author Benedict
 */
public class ControllerVoucher {

    static DatabaseHandler conn = new DatabaseHandler();

    public void createVoucher(Voucher newVoucher) {
        conn.connect();
        String query = "INSERT INTO voucher VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, MainController.activeID);
            stmt.setInt(3, newVoucher.getMinTransaction());
            stmt.setInt(4, newVoucher.getCashback());
            stmt.setString(5, newVoucher.getVoucherCode());
            String str = newVoucher.getEndDate();
            Date date = Date.valueOf(str);
            stmt.setDate(6, date);
            stmt.setInt(7, 1);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void seeVoucher() {
        
    }

    public void editVoucher(Voucher editVoucher) {
        conn.connect();
        String str = editVoucher.getEndDate();
        Date date = Date.valueOf(str);
        
        String query = "UPDATE voucher SET minTransaction='" + editVoucher.getMinTransaction() + "', "
                + "cashback='" + editVoucher.getCashback() + "', "
                + "voucherCode='" + editVoucher.getVoucherCode()+ "', "
                + "endDate='" + date + "', "
                + "isAvailable='" + editVoucher.getIsAvailable() + "' "
                + "WHERE idVoucher='" + editVoucher.getIdVoucher() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVoucher(int idVoucherDelete) {
        conn.connect();
        String query = "DELETE FROM voucher WHERE idVoucher='" + idVoucherDelete + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
