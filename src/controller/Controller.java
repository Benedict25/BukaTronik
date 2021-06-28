package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Buyer;
import model.Flashsale;
import model.Seller;
import model.Voucher;

public class Controller {

    protected ArrayList<Buyer> buyer = new ArrayList();
    protected ArrayList<Seller> seller = new ArrayList();
    protected ArrayList<Flashsale> flashsale = new ArrayList();
    protected ArrayList<Voucher> voucher = new ArrayList();

    static Scanner s = new Scanner (System.in);
    
    public void insertSellerItem (String itemName, int price, int stocks, String category, int itemWeight) {
        System.out.println("Masukkan kembali username: ");
        String username = s.next();
        new ControllerAddItem().insertSellerItem(seller, username, itemName, price, stocks, category, itemWeight);
    }

    public void insertNewBuyer(String username, String password, String name, String address, String city, String phoneNumber, String email, String userType) {
        new ControllerRegister().insertNewBuyer(buyer, username, password, name, address, city, phoneNumber, email, userType);
    }
    
    public void insertNewSeller(String username, String password, String name, String address, String city, String phoneNumber, String email, String userType) {
        new ControllerRegister().insertNewSeller(seller, username, password, name, address, city, phoneNumber, email, userType);
    }
  
  public void insertFlashsale(int idItem, int flashsaleStock, int discountedPrice, String endDate ){
        new ControllerAddFlashsale().insertFlashsale(flashsale, idItem, flashsaleStock, discountedPrice, endDate);
    }
    
}

