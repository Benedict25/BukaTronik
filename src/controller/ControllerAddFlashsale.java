/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Flashsale;
import view.MenuAddFlashsale;

/**
 *
 * @author Matthew
 */
public class ControllerAddFlashsale {
    
    public void insertFlashsale(ArrayList<Flashsale> flashsale,int idItem, int flashsaleStock, int discountedPrice, String endDate ){
        Flashsale newFlashsale = new Flashsale();
        newFlashsale.setIdItem(idItem);
        newFlashsale.setFlashsaleStock(flashsaleStock);
        newFlashsale.setDiscountedPrice(discountedPrice);
        newFlashsale.setEndDate(endDate);
        
        flashsale.add(newFlashsale);
        System.out.println("berhasil insert data Flashsale");
    }
}
