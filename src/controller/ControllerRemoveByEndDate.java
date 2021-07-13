/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author Benedict
 */
public class ControllerRemoveByEndDate {

    DatabaseHandler conn = new DatabaseHandler();

    public ControllerRemoveByEndDate() {
        conn.connect();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String dateToday = formatter.format(date);

        int idVoucher = 0;
        int idFlashsale = 0;
        String endDateVoucher = "";
        String endDateFlashsale = "";

        //voucher
        String query = "SELECT * FROM voucher";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                endDateVoucher = rs.getString("endDate");
                if (dateToday.equals(endDateVoucher)) {
                    idVoucher = rs.getInt("idVoucher");
                    removeFromSql("voucher", idVoucher);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //flashsale
        String query2 = "SELECT * FROM flashsale";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query2);
            while (rs.next()) {
                endDateFlashsale = rs.getString("endDate");
                if (dateToday.equals(endDateFlashsale)) {
                    idFlashsale = rs.getInt("idFlashsale");
                    removeFromSql("flashsale", idFlashsale);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeFromSql(String type, int id) {
        conn.connect();
        String query = "";

        if (type.equals("voucher")) {
            query = "DELETE FROM voucher WHERE idVoucher='" + id + "'";
        } else {
            query = "DELETE FROM flashsale WHERE idFlashsale='" + id + "'";
        }

        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
