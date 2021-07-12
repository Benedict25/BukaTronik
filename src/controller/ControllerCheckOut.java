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
import java.util.ArrayList;
import model.CourierType;
import model.DeliveryStatus;
import model.Item;
import model.ItemInShoppingCart;
import model.Person;
import model.Transaction;

/**
 *
 * @author Matthew
 */
public class ControllerCheckOut {

    static DatabaseHandler conn = new DatabaseHandler();

    public int hitungHargaCourier(String courier, String city) {
        int hargaKurir = 0;

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

    public int hitungTotalHargaCourier(int hargaKurir) {
        ArrayList<ItemInShoppingCart> arrShoppingCart = new ArrayList();
        arrShoppingCart = new ControllerShoppingCart().getShoppingCartData();

        int totalHargaCourier = 0;

        for (int i = 0; i < arrShoppingCart.size(); i++) {
            totalHargaCourier += hargaKurir * arrShoppingCart.get(i).getQuantity();
        }

        return totalHargaCourier;
    }
    
    public void updateTotalbayarCourier(int tambahBiaya, int idTransaction){
        conn.connect();
        int initialPrice = 0;
        int newTotal = 0;

        String query = "SELECT * FROM transaction WHERE idTransaction='" + idTransaction + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                initialPrice = rs.getInt("courierPrice"); //get initial price
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        newTotal = initialPrice + tambahBiaya;

        String query2 = "UPDATE transaction SET courierPrice='" + newTotal + "'WHERE idTransaction='" + idTransaction + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int hitungTotalHargaItem() {
        int totalHarga = 0;

        ArrayList<ItemInShoppingCart> arrShoppingCart = new ArrayList();
        arrShoppingCart = new ControllerShoppingCart().getShoppingCartData();

        ArrayList<Item> arrItem = new ArrayList();
        arrItem = new ControllerShoppingCart().getItemDataForShoppingCart(arrShoppingCart);

        for (int i = 0; i < arrShoppingCart.size(); i++) {
            totalHarga += (arrItem.get(i).getPrice() * arrShoppingCart.get(i).getQuantity());
        }

        return totalHarga;
    }

    public Person cekUser() {
        conn.connect();

        String query = "SELECT * FROM person WHERE idPerson='" + SingletonActiveId.getInstance().getActiveId() + "'";
        Person person = new Person();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                person.setBalance(rs.getInt("balance"));
                person.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    public int hitungBiayaAdministrasi() {
        return 10_000;
    }

    public int hitungTotalHargaKeseluruhan(int totalHargaCourier, int totalHargaItem, int biayaAdministrasi) {
        int totalKeseluruhan = totalHargaCourier + totalHargaItem + biayaAdministrasi;
        return totalKeseluruhan;
    }

    public boolean pengecekanSaldo(int hargaKurir, int totalKeseluruhan, int saldoUser, String courierType) {
        if (totalKeseluruhan < saldoUser) {
            penguranganSaldoBuyerDanPenambahanSaldoSeller(totalKeseluruhan, saldoUser, hargaKurir);

            ArrayList<ItemInShoppingCart> arrShoppingCart = new ArrayList();
            arrShoppingCart = new ControllerShoppingCart().getShoppingCartData();

            updateStock(arrShoppingCart);

            transaksi(hargaKurir, totalKeseluruhan, courierType);

            resetShoppingCart();
            return (true);
        } else {
            return (false);
        }
    }

    public void penguranganSaldoBuyerDanPenambahanSaldoSeller(int totalKeseluruhan, int saldoUser, int hargaKurir) {

        ArrayList<ItemInShoppingCart> arrShoppingCart = new ArrayList();
        arrShoppingCart = new ControllerShoppingCart().getShoppingCartData();

        ArrayList<Item> arrItem = new ArrayList();
        arrItem = new ControllerShoppingCart().getItemDataForShoppingCart(arrShoppingCart);

        int penguranganSaldoBuyer = saldoUser - totalKeseluruhan;

        conn.connect();

        String query1 = "UPDATE person SET balance='" + penguranganSaldoBuyer + "'WHERE idPerson='" + SingletonActiveId.getInstance().getActiveId() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < arrShoppingCart.size(); i++) {
            int saldoAwalSeller = getSellerBalance(arrItem.get(i).getIdPerson());
            int newSaldo = saldoAwalSeller + (arrItem.get(i).getPrice() * arrShoppingCart.get(i).getQuantity()) + hargaKurir;
            String query2 = "UPDATE person SET balance='" + newSaldo + "'WHERE idPerson='" + arrItem.get(i).getIdPerson() +"'";
            try {
                Statement stmt = conn.con.createStatement();
                stmt.executeUpdate(query2);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public int getSellerBalance(int idSeller) {
        int sellerBalance = 0;
        conn.connect();
        String query = "SELECT * FROM person WHERE idPerson='" + idSeller + "'";

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                sellerBalance = rs.getInt("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sellerBalance;
    }

    public void resetShoppingCart() {
        conn.connect();
        String query = "DELETE FROM iteminshoppingcart WHERE idPerson='" + SingletonActiveId.getInstance().getActiveId() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getInitialStock(int idItem) {
        conn.connect();
        int initialStock = 0;
        String query = "SELECT * FROM item WHERE idItem='" + idItem + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                initialStock = rs.getInt("stock");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return initialStock;
    }

    public void updateStock(ArrayList<ItemInShoppingCart> arrShoppingCart) {
        conn.connect();
        int initialStock = 0;
        int newStock = 0;

        for (int i = 0; i < arrShoppingCart.size(); i++) {
            initialStock = getInitialStock(arrShoppingCart.get(i).getIdItem());
            newStock = initialStock - arrShoppingCart.get(i).getQuantity();
            String query = "UPDATE item SET stock='" + newStock + "'WHERE idItem='" + arrShoppingCart.get(i).getIdItem() + "'";
            try {
                Statement stmt = conn.con.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void newTransaction(int totalHargaCourier, int currenItemPrice, String courierType, int idSeller, int quantity) {
        CourierType courier = CourierType.REG;
        if (courierType.equals("YES")) {
            courier = CourierType.YES;
        }

        Transaction newTransaction = new Transaction();
        newTransaction = setTransaction(totalHargaCourier, currenItemPrice, courier, idSeller, quantity);

        insertTransaction(newTransaction);

    }

    public Transaction setTransaction(int totalHargaCourier, int currentItemPrice, CourierType courierType, int idSeller, int quantity) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String strDate = formatter.format(date);

        Transaction newTransaction = new Transaction();
        newTransaction.setIdBuyer(SingletonActiveId.getInstance().getActiveId());
        newTransaction.setIdSeller(idSeller);
        newTransaction.setPurchaseDate(strDate);
        newTransaction.setDeliveryStatus(DeliveryStatus.PROCESSED);
        newTransaction.setCourierType(courierType);
        newTransaction.setCourierPrice(totalHargaCourier);
        newTransaction.setDiscount(0);
        int initialPrice = currentItemPrice * quantity;
        newTransaction.setPayAmount(initialPrice);

        return newTransaction;

    }

    public void insertTransaction(Transaction newTransaction) {
        conn.connect();
        String query = "INSERT INTO transaction VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, newTransaction.getIdBuyer());
            stmt.setInt(3, newTransaction.getIdSeller());
            String str = newTransaction.getPurchaseDate();
            Date date = Date.valueOf(str);
            stmt.setDate(4, date);
            stmt.setString(5, (String.valueOf(newTransaction.getDeliveryStatus().PROCESSED)));
            stmt.setString(6, String.valueOf(newTransaction.getCourierType()));
            stmt.setInt(7, newTransaction.getCourierPrice());
            stmt.setInt(8, newTransaction.getDiscount());
            stmt.setInt(9, newTransaction.getPayAmount());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //all function for inserting data into transaction and detailed transaction in sql
    public static int getIdTransaction(int idBuyer) {
        conn.connect();
        int idTransaction = 0;
        String query = "SELECT * FROM transaction WHERE idBuyer='" + idBuyer + "'";
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

    public static void insertToDetailedTransaction(int idTransaction, int idItem, int quantity) {
        conn.connect();
        String query = "INSERT INTO detailedtransaction VALUES(?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, idTransaction);
            stmt.setInt(2, idItem);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTransaction(int idTransaction, int addAmount, int quantity) {
        conn.connect();

        int initialPayAmount = getInitialPayAmount(idTransaction);
        int total = initialPayAmount + (addAmount * quantity);

        String query = "UPDATE transaction SET payAmount='" + total + "'WHERE idTransaction='" + idTransaction + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getInitialPayAmount(int idTransaction) {
        conn.connect();
        int payAmount = 0;
        String query = "SELECT * FROM transaction WHERE idTransaction='" + idTransaction + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                payAmount = rs.getInt("payAmount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payAmount;
    }

    public void transaksi(int hargaKurir, int totalKeseluruhan, String courierType) {
        ArrayList<ItemInShoppingCart> arrShoppingCart = new ArrayList();
        arrShoppingCart = new ControllerShoppingCart().getShoppingCartData();

        ArrayList<Item> arrItem = new ArrayList();
        arrItem = new ControllerShoppingCart().getItemDataForShoppingCart(arrShoppingCart);

        int temp = 0;
        int counterInit = 0;
        int counter = 0;
        int idTransaction = 0;
        int idSeller = 0;
        int checkIdSeller = 0;
        int currentItemPrice = 0;
        int totalBayarCourier = 0;

        for (int i = 0; i < arrShoppingCart.size(); i++) {

            for (int j = 0; j < arrItem.size(); j++) { //get id seller for temp
                if (arrShoppingCart.get(i).getIdItem() == arrItem.get(j).getIdItem()) {
                    idSeller = arrItem.get(j).getIdPerson();
                }
            }

            if (temp != idSeller) {
                temp = idSeller;

                for (int j = 0; j < arrShoppingCart.size(); j++) {
                    for (int k = 0; k < arrItem.size(); k++) { //get id seller to check
                        if (arrShoppingCart.get(j).getIdItem() == arrItem.get(k).getIdItem()) {
                            totalBayarCourier = hargaKurir * arrShoppingCart.get(j).getQuantity();
                            checkIdSeller = arrItem.get(k).getIdPerson();
                            currentItemPrice = arrItem.get(k).getPrice();
                        }
                    }
                    
                    if (temp == checkIdSeller) {
                        if (counterInit == 0) {
                            newTransaction(totalBayarCourier, currentItemPrice, courierType, temp, arrShoppingCart.get(j).getQuantity()); //temp = id for current seller
                            idTransaction = getIdTransaction(SingletonActiveId.getInstance().getActiveId());
                            insertToDetailedTransaction(idTransaction, arrShoppingCart.get(j).getIdItem(), arrShoppingCart.get(j).getQuantity());
                            counterInit++;
                        } else {
                            idTransaction = getIdTransaction(SingletonActiveId.getInstance().getActiveId());
                            updateTotalbayarCourier(totalBayarCourier, idTransaction);
                            updateTransaction(idTransaction, currentItemPrice, arrShoppingCart.get(j).getQuantity());
                            insertToDetailedTransaction(idTransaction, arrShoppingCart.get(j).getIdItem(), arrShoppingCart.get(j).getQuantity());
                        }
                        counter++;
                    }
                }
                
                idTransaction = getIdTransaction(SingletonActiveId.getInstance().getActiveId()); //get latest buyer's transaction
                finalizeTotalPayment(idTransaction);

                if (counter == arrShoppingCart.size()) {
                    break;
                }
            }

            counterInit = 0;
        }
    }
    
    public void finalizeTotalPayment(int idTransaction){
        conn.connect();
        int initialTotal = 0;
        int totalCourierPrice = 0;
        int newTotal = 0;

        String query = "SELECT * FROM transaction WHERE idTransaction='" + idTransaction + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                initialTotal = rs.getInt("payAmount"); //get initial price
                totalCourierPrice = rs.getInt("courierPrice");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        newTotal = initialTotal + totalCourierPrice;

        String query2 = "UPDATE transaction SET payAmount='" + newTotal + "'WHERE idTransaction='" + idTransaction + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
