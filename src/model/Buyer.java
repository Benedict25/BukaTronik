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
public class Buyer {
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
    
    public void addToWishList(int idItem){
        
    }
    
    public void removeFromWishlist(int idItem){
        
    }
    
    public void addToShoppingCart(int idItem){
        
    }
    
    public void removeFromShoppingCart(int idItem){
        
    }
    
    public void seeOnGoingOrder(){
        
    }
    
    public void seeWishlist(){
        
    }
    
    public void seeShoppingCart(){
        
    }
    
    public void checkOut(){
        
    }
    
    public void cancelOrder(int idTransaction){
        
    }
    
    public int depositBalance(int balance){
        /*masih kosong gaes*/
        return balance;
    }
    
    public void seePurchase(){
        
    }
}
