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
import controller.MainController;

/**
 *
 * @author Benedict
 */
public class MainMenuBuyer {

    public MainMenuBuyer() {
        JFrame frame = new JFrame("Main Menu Buyer");
        frame.setSize(500, 500);
        JButton bProfile, bSeeItems, bWishlist, bShoppingCart, bPurchaseHistory, bLogout, bVoucher;
        JLabel lWelcome, lAppName;
        String activeUsername = new MainController().getActivePersonUsername();

        bProfile = new JButton("Profile >");
        bProfile.setBounds(75, 100, 150, 50);
        bProfile.setFont(new Font("Serif", Font.BOLD, 20));
        bSeeItems = new JButton("See Items >");
        bSeeItems.setBounds(250, 100, 150, 50);
        bSeeItems.setFont(new Font("Serif", Font.BOLD, 20));
        bWishlist = new JButton("Wishlist >");
        bWishlist.setBounds(75, 200, 150, 50);
        bWishlist.setFont(new Font("Serif", Font.BOLD, 20));
        bShoppingCart = new JButton("Shopping Cart >");
        bShoppingCart.setBounds(250, 200, 150, 50);
        bShoppingCart.setFont(new Font("Serif", Font.BOLD, 15));
        bPurchaseHistory = new JButton("Purchase History >");
        bPurchaseHistory.setBounds(75, 300, 150, 50);
        bPurchaseHistory.setFont(new Font("Serif", Font.BOLD, 13));
        bLogout = new JButton("Log Out >");
        bLogout.setBounds(250, 300, 150, 50);
        bLogout.setFont(new Font("Serif", Font.BOLD, 20));
        
        lWelcome = new JLabel("Welcome " + activeUsername + "!");
        lWelcome.setFont(new Font("Serif", Font.BOLD, 40));
        lWelcome.setBounds(75, 20, 450, 50);
        lAppName = new JLabel("Welcome to Bukatronik");
        lAppName.setBounds(175, 375, 150, 50);
        bVoucher = new JButton("Available Voucher");
        bVoucher.setBounds(165, 420, 150, 30);

        frame.add(bProfile);
        frame.add(bSeeItems);
        frame.add(bWishlist);
        frame.add(bShoppingCart);
        frame.add(bPurchaseHistory);
        frame.add(bLogout);
        frame.add(lWelcome);
        frame.add(lAppName);
        frame.add(bVoucher);
        
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
                
                frame.setVisible(false);
            }
        });
        
        bPurchaseHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                frame.setVisible(false);
            }
        });
        
        bLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuLogin();
                frame.setVisible(false);
            }
        });
        
        bVoucher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuLogin();
                frame.setVisible(false);
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
