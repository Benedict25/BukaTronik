/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerPerson;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Ignatius Dariel
 */
public class MainMenuSeller {

    public MainMenuSeller() {
        JFrame frameMainMenuSeller = new JFrame("Main Menu Seller");
        frameMainMenuSeller.setSize(500, 500);
        String username = new ControllerPerson().getActivePersonUsername();
        JLabel lUsername = new JLabel("Welcome " + username + "!");
        lUsername.setBounds(125, 10, 500, 70);
        lUsername.setFont(new Font("Serif", Font.BOLD, 40));

        JButton bProfile = new JButton("Profile >");
        bProfile.setBounds(70, 120, 150, 50);

        JButton bManageItem = new JButton("Manage Items >");
        bManageItem.setBounds(270, 120, 150, 50);

        JButton bManageOrder = new JButton("Manage Orders >");
        bManageOrder.setBounds(70, 220, 150, 50);

        JButton bManageVoucher = new JButton("Manage Voucher >");
        bManageVoucher.setBounds(270, 220, 150, 50);

        JButton bSalesHistory = new JButton("Sales History >");
        bSalesHistory.setBounds(70, 320, 150, 50);

        JButton bLogOut = new JButton("Log Out >");
        bLogOut.setBounds(270, 320, 150, 50);

        JLabel lWelcome = new JLabel("Welcome to Bukatronik");
        lWelcome.setBounds(175, 395, 150, 50);

        bProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuProfile().seeProfile();
                frameMainMenuSeller.setVisible(false);
            }
        });

        bManageItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuItem().seeItemSeller();
                frameMainMenuSeller.setVisible(false);
            }
        });

        bManageOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuManageOrder().menuSeeOrder();
                frameMainMenuSeller.setVisible(false);
            }
        });

        bManageVoucher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuVoucher().MenuSeeVoucherForSeller();
                frameMainMenuSeller.setVisible(false);
            }
        });

        bSalesHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuSalesHistory().seeSalesHistorySeller();
                frameMainMenuSeller.setVisible(false);
            }
        });

        bLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuLogin();
                frameMainMenuSeller.setVisible(false);
            }
        });

        frameMainMenuSeller.add(lUsername);
        frameMainMenuSeller.add(bProfile);
        frameMainMenuSeller.add(bManageItem);
        frameMainMenuSeller.add(bManageOrder);
        frameMainMenuSeller.add(bManageVoucher);
        frameMainMenuSeller.add(bSalesHistory);
        frameMainMenuSeller.add(bLogOut);
        frameMainMenuSeller.add(lWelcome);
        frameMainMenuSeller.setLayout(null);
        frameMainMenuSeller.setVisible(true);
    }
}
