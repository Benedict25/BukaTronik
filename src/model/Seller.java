/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Ignatius Dariel
 */
public class Seller extends Person implements TransactionHistory, VoucherManager {

    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Voucher> vouchers = new ArrayList<Voucher>();
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(ArrayList<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    //Functions
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addItem(String namaBarang, int price, int stock, GadgetType category, int itemWeight) {
        Item newItem = new Item();
        newItem.setItemName(namaBarang);
        newItem.setPrice(price);
        newItem.setStocks(stock);
        newItem.setCategory(category);
        newItem.setItemWeight(itemWeight);
        items.add(newItem);
    }

    public void editItem(int idItem) {
    }

    public void deleteItem(int idItem) {
    }

    public void approveCancellation(int idTransaction) {
    }

    public void approveOrder(int idTransaction) {
    }

    public void seeOrders() {
    }

    @Override
    public void seeSalesHistory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createVoucher(int minTransaction, int cashback, String voucherCode, String endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteVoucher(int idVoucher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seeVoucher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
