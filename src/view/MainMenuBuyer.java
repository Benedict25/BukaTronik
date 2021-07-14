/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import controller.ControllerPerson;

/**
 *
 * @author Benedict
 */
public class MainMenuBuyer {

    public MainMenuBuyer() {
        JFrame frame = new JFrame("Main Menu Buyer");
        frame.setSize(500, 600);
        JButton bProfile, bSeeItems, bWishlist, bShoppingCart, bOrders, bLogout, bVoucher, bFlashsale;
        JLabel lWelcome, lAppName;
        String activeUsername = new ControllerPerson().getActivePersonUsername();

        bProfile = new JButton("Profile >");
        bProfile.setBounds(75, 120, 150, 50);
        bProfile.setFont(new Font("Serif", Font.BOLD, 15));
        bSeeItems = new JButton("See Items >");
        bSeeItems.setBounds(250, 120, 150, 50);
        bSeeItems.setFont(new Font("Serif", Font.BOLD, 15));
        bWishlist = new JButton("Wishlist >");
        bWishlist.setBounds(75, 220, 150, 50);
        bWishlist.setFont(new Font("Serif", Font.BOLD, 15));
        bShoppingCart = new JButton("Shopping Cart >");
        bShoppingCart.setBounds(250, 220, 150, 50);
        bShoppingCart.setFont(new Font("Serif", Font.BOLD, 15));
        bOrders = new JButton("Orders >");
        bOrders.setBounds(75, 320, 150, 50);
        bOrders.setFont(new Font("Serif", Font.BOLD, 15));
        bLogout = new JButton("Log Out >");
        bLogout.setBounds(250, 320, 150, 50);
        bLogout.setFont(new Font("Serif", Font.BOLD, 15));

        lAppName = new JLabel("Welcome to Bukatronik!",JLabel.CENTER);
        lAppName.setFont(new Font("Serif", Font.BOLD, 35));
        lAppName.setBounds(0, 10, 500, 50);
        lWelcome = new JLabel(activeUsername, JLabel.CENTER);
        lWelcome.setFont(new Font("Serif", Font.BOLD, 35));
        lWelcome.setBounds(0, 50, 500, 50);
        bVoucher = new JButton("Available Voucher");
        bVoucher.setBounds(165, 400, 150, 30);
        bFlashsale = new JButton("Flashsale");
        bFlashsale.setBounds(165, 450, 150, 30);

        frame.add(bProfile);
        frame.add(bSeeItems);
        frame.add(bWishlist);
        frame.add(bShoppingCart);
        frame.add(bOrders);
        frame.add(bLogout);
        frame.add(lWelcome);
        frame.add(lAppName);
        frame.add(bVoucher);
        frame.add(bFlashsale);

        bProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuProfile().seeProfile();
                frame.setVisible(false);
            }
        });

        bSeeItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuItem().menuItemForBuyer();
                frame.setVisible(false);
            }
        });

        bWishlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuWishlist().seeWishlist();
                frame.setVisible(false);
            }
        });

        bShoppingCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuShoppingCart().MenuSeeShoppingCart();
                frame.setVisible(false);
            }
        });

        bOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuOrder().subMenuOrder();
                frame.setVisible(false);
            }
        });

        bLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuKonfirmasiLogOut();
                frame.setVisible(false);
            }
        });

        bVoucher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuVoucher().MenuSeeVoucherForBuyer();
                frame.setVisible(false);
            }
        });
        
        bFlashsale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Menu Flashsale untuk Buyer
                new MenuFlashsale().menuSeeFlashsaleForBuyer();
                frame.setVisible(false);
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public void MenuKonfirmasiLogOut() {
        JFrame frame = new JFrame("Log Out");
        frame.setSize(300, 300);

        JLabel lResult;
        JButton bConfirm, bBack;

        lResult = new JLabel("Log Out?", JLabel.CENTER);
        lResult.setBounds(0, 20, 300, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Yes!");
        bConfirm.setBounds(100, 150, 100, 30);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        bBack = new JButton("No!");
        bBack.setBounds(100, 200, 100, 30);
        bBack.setFont(new Font("Serif", Font.BOLD, 20));

        frame.add(lResult);
        frame.add(bConfirm);
        frame.add(bBack);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuLogin();
            frame.setVisible(false);
        });

        bBack.addActionListener((ActionEvent e) -> {
            new MainMenuBuyer();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
