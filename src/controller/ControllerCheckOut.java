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
import model.Item;
import model.ItemInShoppingCart;
import model.Person;

/**
 *
 * @author Matthew
 */
public class ControllerCheckOut {

    static DatabaseHandler conn = new DatabaseHandler();

    public double hitungTotalCourier(String courier, String city) {
        double hargaKurir = 0;
        if (courier.equals("REG")) {
            if (city.equals("BANDUNG")) {
                hargaKurir = 5000;
            } else if (city.equals("JAKARTA")) {
                hargaKurir = 15000;
            }
        }
        if (courier.equals("YES")) {
            if (city.equals("BANDUNG")) {
                hargaKurir = 10000;
            } else if (city.equals("JAKARTA")) {
                hargaKurir = 20000;
            }
        }
        return hargaKurir;
    }

    public double hitungTotalHargaItem() {
        double totalHarga = 0;

        ArrayList<ItemInShoppingCart> arrShoppingCart = new ArrayList();
        arrShoppingCart = new ControllerShoppingCart().getShoppingCartData();

        ArrayList<Item> arrItem = new ArrayList();
        arrItem = new ControllerShoppingCart().getItemDataForShoppingCart(arrShoppingCart);
        
        for (int i = 0; i < arrShoppingCart.size(); i++) {
            totalHarga += (arrItem.get(i).getPrice() * arrShoppingCart.get(i).getQuantity());
        }

        return totalHarga;
    }

    public Person cekSaldoUser() {
        conn.connect();

        String query = "SELECT * FROM person WHERE idPerson='" + MainController.activeID + "'";
        Person person = new Person();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                person.setBalance(rs.getInt("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    public double hitungBiayaAdministrasi(double totalHargaItem) {
        //biaya administrasi 2%
        double biayaAdministrasi = totalHargaItem * 0.02;
        return biayaAdministrasi;
    }

    public double hitungTotalHargaKeseluruhan(double totalHargaCourier, double totalHargaItem, double biayaAdministrasi) {
        double totalKeseluruhan = totalHargaCourier + totalHargaItem + biayaAdministrasi;
        return totalKeseluruhan;
    }

    public boolean pengecekanSaldo(double totalKeseluruhan, double saldoUser) {
        if (totalKeseluruhan < saldoUser) {
            penguranganSaldoUser(totalKeseluruhan, saldoUser);
            return (true);
        } else {
            return (false);
        }
    }

    public void penguranganSaldoUser(double totalKeseluruhan, double saldoUser) {
        double Hasil = saldoUser - totalKeseluruhan;

        conn.connect();

        String query = "UPDATE person SET balance='" + Hasil + "'WHERE idPerson='" + MainController.activeID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
