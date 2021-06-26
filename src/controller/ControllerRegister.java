/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.nio.file.attribute.AclEntry;
import java.util.ArrayList;
import model.Buyer;
import model.MembershipStatus;
import model.Seller;
import model.UserType;

/**
 *
 * @author Benedict
 */
public class ControllerRegister {

    public void insertNewBuyer(ArrayList<Buyer> buyer, String username, String password, String name, String address, String city, String phoneNumber, String email, String userType) {
        //set id ntah gmn
        Buyer newBuyer = new Buyer();
        newBuyer.setUsername(username);
        newBuyer.setPassword(password);
        newBuyer.setName(name);
        newBuyer.setAddress(address);
        newBuyer.setCity(city);
        newBuyer.setPhoneNumber(phoneNumber);
        newBuyer.setEmail(email);
        newBuyer.setBalance(0);
        newBuyer.setUserType(UserType.BUYER);
        newBuyer.setMembershipStatus(MembershipStatus.BRONZE);

        buyer.add(newBuyer);

        System.out.println("Sukses Registrasi");
    }

    public void insertNewSeller(ArrayList<Seller> seller, String username, String password, String name, String address, String city, String phoneNumber, String email, String userType) {
        //set id ntah gmn
        Seller newSeller = new Seller();
        newSeller.setUsername(username);
        newSeller.setPassword(password);
        newSeller.setName(name);
        newSeller.setAddress(address);
        newSeller.setCity(city);
        newSeller.setPhoneNumber(phoneNumber);
        newSeller.setEmail(email);

        newSeller.setUserType(UserType.SELLER);

        seller.add(newSeller);

        System.out.println("Sukses Registrasi");
    }
}
