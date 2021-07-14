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
        JLabel lAppName = new JLabel("Welcome to Bukatronik!",JLabel.CENTER);
        lAppName.setFont(new Font("Serif", Font.BOLD, 35));
        lAppName.setBounds(0, 10, 500, 50);
        JLabel lWelcome = new JLabel(username, JLabel.CENTER);
        lWelcome.setFont(new Font("Serif", Font.BOLD, 35));
        lWelcome.setBounds(0, 50, 500, 50);

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

        frameMainMenuSeller.add(lAppName);
        frameMainMenuSeller.add(lWelcome);
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

        lProfit = new JLabel("Profit: ");
        lProfit.setBounds(50, 20, 500, 100);
        lProfit.setFont(new Font("Serif", Font.BOLD, 30));

        lUsername = new JLabel(String.format("Rp.%,.2f", (double) profit));
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
            new MainMenuSeller();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
