/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerCheckOut;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Person;
import model.Voucher;

/**
 *
 * @author Matthew
 */
public class MenuCheckOut {

    ControllerCheckOut controllerCheckOut = new ControllerCheckOut();
    MenuResult menuResult = new MenuResult();

    public void menuCheckOutCourier() {

        Person person = new Person();
        person = controllerCheckOut.cekUser();

        ArrayList<Voucher> arrVoucher = new ArrayList();
        arrVoucher = controllerCheckOut.getVoucherData();

        String arrayVoucher[] = new String[arrVoucher.size()];
        for (int i = 0; i < arrVoucher.size(); i++) {
            arrayVoucher[i] = arrVoucher.get(i).getVoucherCode();
        }

        JFrame frame = new JFrame("Check Out");
        frame.setSize(400, 400);

        JLabel lShipmentTo, lCourier, lCity, lShipment, lVoucher;
        JComboBox cCourier, cCity, cVoucher;
        JButton bConfirm, bBack;

        lShipmentTo = new JLabel("Shipment to : ");
        lShipmentTo.setBounds(25, 0, 300, 25);
        lCourier = new JLabel("Courier Type :  ");
        lCourier.setBounds(25, 80, 200, 25);
        lCity = new JLabel("Kota Tujuan : ");
        lCity.setBounds(25, 120, 200, 25);
        lVoucher = new JLabel("Voucher : ");
        lVoucher.setBounds(25, 160, 200, 25);

        lShipment = new JLabel(person.getAddress());
        lShipment.setBounds(25, 30, 300, 25);
        lShipment.setFont(lShipment.getFont().deriveFont(20.0f));

        String Courier[] = {"REG", "YES"};
        cCourier = new JComboBox(Courier);
        cCourier.setBounds(120, 80, 100, 25);

        String City[] = {"BANDUNG", "JAKARTA"};
        cCity = new JComboBox(City);
        cCity.setBounds(120, 120, 100, 25);

        cVoucher = new JComboBox(arrayVoucher);
        cVoucher.setBounds(120, 160, 100, 25);

        bConfirm = new JButton("Confirm");
        bConfirm.setBounds(150, 240, 100, 25);
        bBack = new JButton("Back");
        bBack.setBounds(150, 280, 100, 25);

        frame.add(lShipmentTo);
        frame.add(lShipment);
        frame.add(lCourier);
        frame.add(cCourier);
        frame.add(lCity);
        frame.add(cCity);
        frame.add(lVoucher);
        frame.add(cVoucher);

        frame.add(bConfirm);
        frame.add(bBack);

        /*confirm data*/
        bConfirm.addActionListener((ActionEvent e) -> {
            String courierType = (String) cCourier.getItemAt(cCourier.getSelectedIndex());
            String city = (String) cCity.getItemAt(cCity.getSelectedIndex());
            String voucher = (String) cVoucher.getItemAt(cVoucher.getSelectedIndex());
            int cashback = controllerCheckOut.cekVoucherMinimumTransaction(voucher, controllerCheckOut.hitungTotalHargaItem());
            if (cashback == -1) {
                menuResult.menuResultUseVoucher(voucher, false);
                frame.setVisible(false);
            } else {
                int hargaKurir = controllerCheckOut.hitungHargaCourier(courierType, city);
                int totalHargaCourier = controllerCheckOut.hitungTotalHargaCourier(hargaKurir);
                menuCheckOutPayment(totalHargaCourier, hargaKurir, courierType, cashback);
                frame.setVisible(false);
            }
        });

        /*back*/
        bBack.addActionListener((ActionEvent e) -> {
            new MenuShoppingCart().MenuSeeShoppingCart();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuCheckOutPayment(int totalHargaCourier, int hargaKurir, String courierType, int cashback) {

        int totalHargaItem = controllerCheckOut.hitungTotalHargaItem();

        Person person = new Person();
        person = controllerCheckOut.cekUser();

        int biayaAdministrasi = controllerCheckOut.hitungBiayaAdministrasi();

        int totalKeseluruhan = controllerCheckOut.hitungTotalHargaKeseluruhan(totalHargaCourier, totalHargaItem, biayaAdministrasi);

        JFrame frame = new JFrame("Check Out");
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setBounds(15, 15, 355, 200);
        panel.setBackground(Color.gray);

        JLabel lCourierPrice, lItemPrice, lAdministrasion, lTotal, lBalance, lTotalHargaCourier, lTotalItemPrice,
                lTotalAdministrasion, lTotalPayment, lUserBalance, lBayar;
        JButton bConfirm, bBack;

        lCourierPrice = new JLabel("Harga Courier : ");
        lCourierPrice.setBounds(25, 0, 150, 25);
        lItemPrice = new JLabel("Total Harga Item :  ");
        lItemPrice.setBounds(25, 40, 150, 25);
        lAdministrasion = new JLabel("Biaya Administrasi : ");
        lAdministrasion.setBounds(25, 80, 150, 25);
        lTotal = new JLabel("Total Bayar : ");
        lTotal.setBounds(25, 120, 150, 25);
        lBalance = new JLabel("Saldo Anda : ");
        lBalance.setBounds(25, 160, 150, 25);
        lBayar = new JLabel("Bayar ?");
        lBayar.setBounds(25, 240, 150, 25);

        lTotalHargaCourier = new JLabel(String.format("Rp.%,.2f", (double) totalHargaCourier));
        lTotalHargaCourier.setBounds(150, 0, 150, 25);
        lTotalItemPrice = new JLabel(String.format("Rp.%,.2f", (double) totalHargaItem));
        lTotalItemPrice.setBounds(150, 40, 150, 25);
        lTotalAdministrasion = new JLabel(String.format("Rp.%,.2f", (double) biayaAdministrasi));
        lTotalAdministrasion.setBounds(150, 80, 150, 25);
        lTotalPayment = new JLabel(String.format("Rp.%,.2f", (double) totalKeseluruhan));
        lTotalPayment.setBounds(150, 120, 150, 25);
        lUserBalance = new JLabel(String.format("Rp.%,.2f", (double) person.getBalance()));
        lUserBalance.setBounds(150, 160, 150, 25);

        bConfirm = new JButton("Bayar");
        bConfirm.setBounds(140, 240, 100, 25);
        bBack = new JButton("Back");
        bBack.setBounds(140, 280, 100, 25);

        panel.add(lCourierPrice);
        panel.add(lItemPrice);
        panel.add(lAdministrasion);
        panel.add(lTotal);
        panel.add(lBalance);

        panel.add(lTotalHargaCourier);
        panel.add(lTotalItemPrice);
        panel.add(lTotalAdministrasion);
        panel.add(lTotalPayment);
        panel.add(lUserBalance);

        panel.setLayout(null);
        panel.setVisible(true);

        frame.add(lBayar);
        frame.add(panel);
        frame.add(bConfirm);
        frame.add(bBack);

        int saldoUser = person.getBalance();

        /*pengecekan saldo sekaligus pemotongan saldo*/
        bConfirm.addActionListener((ActionEvent e) -> {
            boolean result = controllerCheckOut.pengecekanSaldo(hargaKurir, totalKeseluruhan, saldoUser, courierType, cashback);
            frame.setVisible(false);
            menuResult.menuResultCheckOut(result);
        });

        /*back*/
        bBack.addActionListener((ActionEvent e) -> {
            new MenuShoppingCart().MenuSeeShoppingCart();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
