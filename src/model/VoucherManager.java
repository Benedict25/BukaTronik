/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ignatius Dariel
 */
public interface VoucherManager {

    public void createVoucher(int minTransaction, int cashback, String voucherCode, String endDate);

    public void deleteVoucher(int idVoucher);

    public void seeVoucher();
}
