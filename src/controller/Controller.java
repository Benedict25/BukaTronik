/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Buyer;
import model.Flashsale;
import model.Seller;
import model.Voucher;

/**
 *
 * @author Benedict
 */
public class Controller {

    static ArrayList<Buyer> buyer = new ArrayList();
    static ArrayList<Seller> seller = new ArrayList();
    static ArrayList<Flashsale> flashSale = new ArrayList();
    static ArrayList<Voucher> voucher = new ArrayList();
    static Scanner s = new Scanner (System.in);
    
    public void insertSellerItem (String itemName, int price, int stocks, String category, int itemWeight) {
        System.out.println("Masukkan kembali username: ");
        String username = s.next();
        new ControllerAddItem().insertSellerItem(seller, username, itemName, price, stocks, category, itemWeight);
    }
}
