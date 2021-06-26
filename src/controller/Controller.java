/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Buyer;
import model.Flashsale;
import model.Seller;
import model.Voucher;
import controller.ControllerRegister;

/**
 *
 * @author Benedict
 */
public class Controller {

    static ArrayList<Buyer> buyer = new ArrayList();
    static ArrayList<Seller> seller = new ArrayList();
    static ArrayList<Flashsale> flashsale = new ArrayList();
    static ArrayList<Voucher> voucher = new ArrayList();

    public void insertNewBuyer(String username, String password, String name, String address, String city, String phoneNumber, String email, String userType) {
        new ControllerRegister().insertNewBuyer(buyer, username, password, name, address, city, phoneNumber, email, userType);
        
        for (int i = 0; i < buyer.size(); i++) {
            System.out.println(buyer.get(i).getName());
        }
    }
    
    public void insertNewSeller(String username, String password, String name, String address, String city, String phoneNumber, String email, String userType) {
        new ControllerRegister().insertNewSeller(seller, username, password, name, address, city, phoneNumber, email, userType);
         for (int i = 0; i < seller.size(); i++) {
            System.out.println(seller.get(i).getName());
        }
    }
    
}
