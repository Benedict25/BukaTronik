/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import model.Flashsale;

/**
 *
 * @author Ignatius Dariel
 */
public class ControllerCheckOutFlashsale {

    DatabaseHandler conn = new DatabaseHandler();

    public boolean pengecekanSaldoFlashsale(int idFlashsale, int hargaKurir, int totalKeseluruhan, int saldoUser, String courierType) {
        if (totalKeseluruhan < saldoUser) {
            new ControllerCheckOut().penguranganSaldoBuyerDanPenambahanSaldoSeller(totalKeseluruhan, saldoUser, hargaKurir);

            Flashsale flashsaleItem = new ControllerFlashsale().getFlashsaleDataById(idFlashsale);

            updateStockFlashsale(flashsaleItem);

            transaksiFlashsale(flashsaleItem, hargaKurir, totalKeseluruhan, courierType);

            insertToDetailedTransaction(flashsaleItem.getIdItem());

            new ControllerCheckOut().insertToAdmin(new ControllerCheckOut().hitungBiayaAdministrasi());

            return (true);
        } else {
            return (false);
        }
    }

    public void updateStockFlashsale(Flashsale flashsaleItem) {
        conn.connect();
        int newStock = flashsaleItem.getFlashsaleStock() - 1;
        String query = "UPDATE flashsale SET flashsaleStock='" + newStock + "'WHERE idItem='" + flashsaleItem.getIdItem() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getInitialStock(int idFlashsale) {
        conn.connect();
        int initialStock = 0;
        String query = "SELECT * FROM flashsale WHERE idFlashsale='" + idFlashsale + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                initialStock = rs.getInt("flashsaleStock");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return initialStock;
    }

    public void transaksiFlashsale(Flashsale flashsaleItem, int hargaKurir, int totalKeseluruhan, String courierType) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String strDate = formatter.format(date);
        conn.connect();
        String query = "INSERT INTO transaction VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, SingletonActiveId.getInstance().getActiveId());
            stmt.setInt(3, getSellerIdFromItemId(flashsaleItem.getIdItem()));
            stmt.setString(4, strDate);
            stmt.setString(5, "PROCESSED");
            stmt.setString(6, courierType);
            stmt.setInt(7, hargaKurir);
            stmt.setInt(8, 0);
            stmt.setInt(9, totalKeseluruhan);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertToDetailedTransaction(int idItem) {
        conn.connect();
        String query = "INSERT INTO detailedtransaction VALUES(?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, getIdTransactionByIdBuyer());
            stmt.setInt(2, idItem);
            stmt.setInt(3, 1);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int hitungTotalHargaItemFlashsale(int idFlashsale) {
        Flashsale item = new ControllerFlashsale().getFlashsaleDataById(idFlashsale);
        int totalHarga = item.getDiscountedPrice();
        return totalHarga;
    }

    public int getSellerIdFromItemId(int idItem) {
        conn.connect();
        int idSeller = 0;
        String query = "SELECT * FROM item WHERE idItem='" + idItem + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                idSeller = rs.getInt("idPerson");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idSeller;
    }

    public int getIdTransactionByIdBuyer() {
        conn.connect();
        int idTransaction = 0;
        String query = "SELECT * FROM transaction WHERE idBuyer='" + SingletonActiveId.getInstance().getActiveId() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                idTransaction = rs.getInt("idTransaction");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idTransaction;
    }
}
