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

        JButton bProfit = new JButton("See Profit >");
        bProfit.setBounds(270, 220, 150, 50);

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

        bProfit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuProfit();
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
                MenuKonfirmasiLogOut();
                frameMainMenuSeller.setVisible(false);
            }
        });

        frameMainMenuSeller.add(lUsername);
        frameMainMenuSeller.add(bProfile);
        frameMainMenuSeller.add(bManageItem);
        frameMainMenuSeller.add(bManageOrder);
        frameMainMenuSeller.add(bProfit);
        frameMainMenuSeller.add(bSalesHistory);
        frameMainMenuSeller.add(bLogOut);
        frameMainMenuSeller.add(lWelcome);
        frameMainMenuSeller.setLayout(null);
        frameMainMenuSeller.setVisible(true);
    }

    public void menuProfit() {

        int profit = new ControllerPerson().getSellerProfit();

        JFrame frame = new JFrame("Result Login");
        frame.setSize(450, 410);

        JLabel lProfit, lUsername;
        JButton bBack;

        lProfit = new JLabel("Profit: Rp.");
        lProfit.setBounds(50, 20, 500, 100);
        lProfit.setFont(new Font("Serif", Font.BOLD, 30));

        lUsername = new JLabel(String.valueOf(profit));
        lUsername.setBounds(50, 120, 500, 100);
        lUsername.setFont(new Font("Serif", Font.BOLD, 30));

        bBack = new JButton("Ok!");
        bBack.setBounds(140, 250, 150, 50);
        bBack.setFont(new Font("Serif", Font.BOLD, 20));

        frame.add(lProfit);
        frame.add(lUsername);
        frame.add(bBack);

        bBack.addActionListener((ActionEvent e) -> {
            new MainMenuSeller();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void MenuKonfirmasiLogOut() {
        JFrame frame = new JFrame("Log Out");
        frame.setSize(400, 400);

        JLabel lResult;
        JButton bConfirm, bBack;

        lResult = new JLabel("Log Out?");
        lResult.setBounds(68, 20, 800, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 60));

        bConfirm = new JButton("Yes!");
        bConfirm.setBounds(110, 150, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 40));

        bBack = new JButton("No!");
        bBack.setBounds(110, 250, 150, 50);
        bBack.setFont(new Font("Serif", Font.BOLD, 40));

        frame.add(lResult);
        frame.add(bConfirm);
        frame.add(bBack);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuLogin();
            frame.setVisible(false);
        });

        bBack.addActionListener((ActionEvent e) -> {
            new MainMenuSeller();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
