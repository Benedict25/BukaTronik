/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Benedict
 */
public class Flashsale {

    private int idFlashsale;
    /*ini bakalan 0 hasilnya pas ngejalanin MenuAddFlashSale.java karena belum dimasukin dan  mau pake auto increment buat data base*/
    private int idItem;
    private int flashsaleStock;
    private int discountedPrice;
    private String endDate;

    public int getIdFlashsale() {
        return idFlashsale;
    }

    public void setIdFlashsale(int idFlashsale) {
        this.idFlashsale = idFlashsale;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getFlashsaleStock() {
        return flashsaleStock;
    }

    public void setFlashsaleStock(int flashsaleStock) {
        this.flashsaleStock = flashsaleStock;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(int discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFormattedDiscountPrice() {
        return String.format("Rp.%,.2f", (double) discountedPrice);
    }
}
