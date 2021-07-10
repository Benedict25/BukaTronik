/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ControllerFlashsale.conn;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Voucher;

/**
 *
 * @author Benedict
 */
public class ControllerVoucher {

    static DatabaseHandler conn = new DatabaseHandler();

    public boolean createVoucher(Voucher newVoucher) {
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
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean editVoucher(Voucher editVoucher) {
        conn.connect();
        String str = editVoucher.getEndDate();
        Date date = Date.valueOf(str);

        String query = "UPDATE voucher SET minTransaction='" + editVoucher.getMinTransaction() + "', "
                + "cashback='" + editVoucher.getCashback() + "', "
                + "voucherCode='" + editVoucher.getVoucherCode() + "', "
                + "endDate='" + date + "', "
                + "isAvailable='" + editVoucher.getIsAvailable() + "' "
                + "WHERE idVoucher='" + editVoucher.getIdVoucher() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean deleteVoucher(int idVoucherDelete) {
        conn.connect();
        String query = "DELETE FROM voucher WHERE idVoucher='" + idVoucherDelete + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public ArrayList<Voucher> getVoucherDataSeller() {
        conn.connect();
        String query = "SELECT * FROM voucher WHERE idPerson='" + MainController.activeID + "'";
        ArrayList<Voucher> arrVoucher = new ArrayList();

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Voucher newVoucher = new Voucher();
                newVoucher.setIdVoucher(rs.getInt("idVoucher"));
                newVoucher.setMinTransaction(rs.getInt("minTransaction"));
                newVoucher.setCashback(rs.getInt("cashback"));
                newVoucher.setVoucherCode(rs.getString("voucherCode"));
                String date = rs.getDate("endDate").toString();
                newVoucher.setEndDate(date);
                newVoucher.setIsAvailable(rs.getInt("isAvailable"));
                arrVoucher.add(newVoucher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrVoucher;
    }

    public ArrayList<Voucher> getVoucherDataNonSeller() {
        conn.connect();
        String query = "SELECT * FROM voucher";
        ArrayList<Voucher> arrVoucher = new ArrayList();

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Voucher newVoucher = new Voucher();
                newVoucher.setIdVoucher(rs.getInt("idVoucher"));
                newVoucher.setMinTransaction(rs.getInt("minTransaction"));
                newVoucher.setCashback(rs.getInt("cashback"));
                newVoucher.setVoucherCode(rs.getString("voucherCode"));
                String date = rs.getDate("endDate").toString();
                newVoucher.setEndDate(date);
                newVoucher.setIsAvailable(rs.getInt("isAvailable"));
                arrVoucher.add(newVoucher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrVoucher;
    }

    public Voucher getVoucherDataById(int idVoucher) {
        conn.connect();
        String query = "SELECT * FROM voucher WHERE idVoucher='" + idVoucher + "'";
        Voucher voucher = new Voucher();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                voucher.setIdVoucher(rs.getInt("idVoucher"));
                voucher.setMinTransaction(rs.getInt("minTransaction"));
                voucher.setCashback(rs.getInt("cashback"));
                voucher.setVoucherCode(rs.getString("voucherCode"));
                String date = rs.getDate("endDate").toString();
                voucher.setEndDate(date);
                voucher.setIsAvailable(rs.getInt("isAvailable"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voucher;
    }

}
