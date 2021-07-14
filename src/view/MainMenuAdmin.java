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
public class MainMenuAdmin {

    public MainMenuAdmin() {
        JFrame frameMainMenuAdmin = new JFrame("Main Menu Admin");
        frameMainMenuAdmin.setSize(550, 550);
        String username = new ControllerPerson().getActivePersonUsername();
        JLabel lUsername = new JLabel("Welcome " + username + "!", JLabel.CENTER);
        lUsername.setBounds(0, 10, 550, 70);
        lUsername.setFont(new Font("Serif", Font.BOLD, 40));

        JButton bProfile = new JButton("Profile >");
        bProfile.setBounds(63, 110, 150, 50);

        JButton bManageFlashsale = new JButton("Manage Flashsale >");
        bManageFlashsale.setBounds(318, 110, 150, 50);

        JButton bManageUser = new JButton("Manage User >");
        bManageUser.setBounds(63, 200, 150, 50);

        JButton bSeeSalesHistory = new JButton("See Sales >");
        bSeeSalesHistory.setBounds(318, 200, 150, 50);

        JButton bLogOut = new JButton("Log Out >");
        bLogOut.setBounds(63, 290, 150, 50);

        JButton bPrintUserData = new JButton("Print Userdata >");
        bPrintUserData.setBounds(318, 290, 150, 50);

        JButton bManageVoucher = new JButton("Manage Voucher >");
        bManageVoucher.setBounds(190, 380, 150, 50);


        bProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuProfile().seeProfile();
                frameMainMenuAdmin.setVisible(false);
            }
        });

        bManageFlashsale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuFlashsale().menuSeeFlashsaleForAdmin();
                frameMainMenuAdmin.setVisible(false);
            }
        });

        bManageUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuRemovePerson().menuSeePersonList();
                frameMainMenuAdmin.setVisible(false);
            }
        });

        bLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuKonfirmasiLogOut();
                frameMainMenuAdmin.setVisible(false);
            }
        });

        bSeeSalesHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuSalesHistory().seeSalesHistoryAdmin();
                frameMainMenuAdmin.setVisible(false);
            }
        });

        bManageVoucher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuVoucher().MenuSeeVoucherForAdmin();
                frameMainMenuAdmin.setVisible(false);
            }
        });

        bPrintUserData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuSeeUserFromAdmin().menuSeePersonList();
                frameMainMenuAdmin.setVisible(false);
            }
        });

        frameMainMenuAdmin.add(bSeeSalesHistory);
        frameMainMenuAdmin.add(lUsername);
        frameMainMenuAdmin.add(bProfile);
        frameMainMenuAdmin.add(bManageFlashsale);
        frameMainMenuAdmin.add(bManageUser);
        frameMainMenuAdmin.add(bLogOut);
        frameMainMenuAdmin.add(bManageVoucher);
        frameMainMenuAdmin.add(bPrintUserData);
        frameMainMenuAdmin.setLayout(null);
        frameMainMenuAdmin.setVisible(true);
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
            new MainMenuAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

}