/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Matthew
 */
public class Buyer extends Person{
    private MembershipStatus membershipStatus;
    private ArrayList<Transaction> transactions = new ArrayList();
    private ArrayList<Wishlist> wishlist = new ArrayList();
    private ArrayList<ItemInShoppingCart> shoppingCart = new ArrayList();

    public MembershipStatus getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(MembershipStatus membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Wishlist> getWishlist() {
        return wishlist;
    }

    public void setWishlist(ArrayList<Wishlist> wishlist) {
        this.wishlist = wishlist;
    }

    public ArrayList<ItemInShoppingCart> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<ItemInShoppingCart> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    
    public int depositBalance(int balance){
        /*masih kosong gaes*/
        return balance;
    }
    
    public void seePurchase(){
        
    }
}
