/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
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
        frameMainMenuAdmin.setSize(500, 500);
        String username = new MainController().getActivePersonUsername();
        JLabel lUsername = new JLabel("Welcome " + username + "!");
        lUsername.setBounds(125, 10, 500, 70);
        lUsername.setFont(new Font("Serif", Font.BOLD, 40));

        JButton bProfile = new JButton("Profile >");
        bProfile.setBounds(175, 110, 150, 50);

        JButton bManageFlashsale = new JButton("Manage Flashsale >");
        bManageFlashsale.setBounds(175, 180, 150, 50);

        JButton bManageUser = new JButton("Manage User >");
        bManageUser.setBounds(175, 250, 150, 50);

        JButton bLogOut = new JButton("Log Out >");
        bLogOut.setBounds(175, 320, 150, 50);

        JLabel lWelcome = new JLabel("This is Bukatronik ADMIN");
        lWelcome.setBounds(175, 395, 150, 50);

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

                frameMainMenuAdmin.setVisible(false);
            }
        });

        bManageUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frameMainMenuAdmin.setVisible(false);
            }
        });

        bLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuLogin();
                frameMainMenuAdmin.setVisible(false);
            }
        });

        frameMainMenuAdmin.add(lUsername);
        frameMainMenuAdmin.add(bProfile);
        frameMainMenuAdmin.add(bManageFlashsale);
        frameMainMenuAdmin.add(bManageUser);
        frameMainMenuAdmin.add(bLogOut);
        frameMainMenuAdmin.add(lWelcome);
        frameMainMenuAdmin.setLayout(null);
        frameMainMenuAdmin.setVisible(true);
    }

}
