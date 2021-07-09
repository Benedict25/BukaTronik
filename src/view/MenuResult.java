/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Benedict
 */
public class MenuResult {

    //result flashsale
    public void menuResultCreateFlashsale(boolean result, String idFlashsale) {
        JFrame frame = new JFrame("Result Create Flashsale");
        frame.setSize(450, 410);

        JLabel lResult, lVoucherCode;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Flashsale ID: " + idFlashsale);
        lVoucherCode.setBounds(50, 120, 500, 100);
        lVoucherCode.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Create Flashsale Succeed");
        } else {
            lResult.setText("Create Flashsale Failed");
        }

        frame.add(lResult);
        frame.add(lVoucherCode);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuFlashsale().MenuSeeFlashsaleForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    //result flashsale
    public void menuResultEditFlashsale(boolean result, String idFlashsale) {
        JFrame frame = new JFrame("Result Edit Flashsale");
        frame.setSize(450, 410);

        JLabel lResult, lVoucherCode;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Flashsale ID: " + idFlashsale);
        lVoucherCode.setBounds(50, 120, 500, 100);
        lVoucherCode.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Edit Flashsale Succeed");
        } else {
            lResult.setText("Edit Flashsale Failed");
        }

        frame.add(lResult);
        frame.add(lVoucherCode);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuFlashsale().MenuSeeFlashsaleForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    //result flashsale
    public void menuResultDeleteFlashsale(boolean result, String idFlashsale) {
        JFrame frame = new JFrame("Result Delete Flashsale");
        frame.setSize(450, 410);

        JLabel lResult, lVoucherCode;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Flashsale ID : " + idFlashsale);
        lVoucherCode.setBounds(50, 120, 500, 100);
        lVoucherCode.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Delete Flashsale Succeed");
        } else {
            lResult.setText("Delete Flashsale Failed");
        }

        frame.add(lResult);
        frame.add(lVoucherCode);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuFlashsale().MenuSeeFlashsaleForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    //result shopping cart
    public void menuResultAddToShoppingCart(boolean result) {
        JFrame frame = new JFrame("Result Create Voucher");
        frame.setSize(450, 410);

        JLabel lResult, lVoucherCode;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));
        
        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Success Add Item to Shopping Cart");
        } else {
            lResult.setText("Add Item Failed");
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuShoppingCart().MenuSeeShoppingCart();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    //result shopping cart
    public void menuResultChangeQuantityShoppingCart(boolean result) {
        JFrame frame = new JFrame("Result Create Voucher");
        frame.setSize(450, 410);

        JLabel lResult, lVoucherCode;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));
        
        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Change Quantity Succeed");
        } else {
            lResult.setText("Change Quantity Failed");
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuShoppingCart().MenuSeeShoppingCart();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    //result shopping cart
    public void menuResultRemoveShoppingCart(boolean result) {
        JFrame frame = new JFrame("Result Remove Voucher");
        frame.setSize(450, 410);

        JLabel lResult, lVoucherCode;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));
        
        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Remove Item Succeed");
        } else {
            lResult.setText("Remove Item Failed");
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuShoppingCart().MenuSeeShoppingCart();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

}
