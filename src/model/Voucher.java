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
public class Voucher {

    private int idVoucher;
    private int minTransaction;
    private int cashback;
    private String voucherCode;
    private String endDate;
    private int isAvailable;

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public int getMinTransaction() {
        return minTransaction;
    }

    public void setMinTransaction(int minTransaction) {
        this.minTransaction = minTransaction;
    }

    public int getCashback() {
        return cashback;
    }

    public void setCashback(int cashback) {
        this.cashback = cashback;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getFormattedCashback() {
        return String.format("Rp.%,.2f", (double) cashback);
    }

    public String getFormattedMinTransaction() {
        return String.format("Rp.%,.2f", (double) minTransaction);
    }
}
