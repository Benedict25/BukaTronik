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
/**
 *
 * @author Benedict
 */
public class Controller {
    static ArrayList<Buyer> buyer = new ArrayList();
    static ArrayList<Seller> seller = new ArrayList();
    static ArrayList<Flashsale> flashsale = new ArrayList();
    static ArrayList<Voucher> voucher = new ArrayList();
    
    public void insertFlashsale(int idItem, int flashsaleStock, int discountedPrice, String endDate ){
        new ControllerAddFlashsale().insertFlashsale(flashsale, idItem, flashsaleStock, discountedPrice, endDate);
    }
}
