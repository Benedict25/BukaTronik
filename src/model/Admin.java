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
public class Admin extends Person implements TransactionHistory, VoucherManager{

    public void createFlashsale(int idItem, int price, String endDate) {

    }

    public void editFlashsale(int idFlashsale) {
        
    }
    
    public void deleteFlashsale(int idFlashsale) {
        
    }
    
    public void deleteUser(int idUser) {
        
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
