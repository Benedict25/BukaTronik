/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerRemovePerson;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.xml.ws.BindingProvider;
import model.Person;
import model.UserType;

/**
 *
 * @author Benedict
 */
public class MenuRemovePerson {

    ControllerRemovePerson controlRemove = new ControllerRemovePerson();

    public void menuSeePersonList() {

        ArrayList<Person> arrPerson = new ArrayList();
        arrPerson = controlRemove.getPersonData();

        JFrame frame = new JFrame("Edit User");
        frame.setSize(900, 880);

        JLabel lExplanation;
        JButton bBack;

        //For Frame
        lExplanation = new JLabel("UN = Username");
        lExplanation.setBounds(620, 25, 200, 70);
        lExplanation.setFont(new Font("Serif", Font.BOLD, 20));

        bBack = new JButton("Back");
        bBack.setBounds(377, 43, 100, 35);
        bBack.setFont(new Font("Serif", Font.BOLD, 30));

        //Panel
        JPanel panelBuyer = new JPanel();
        JPanel panelSeller = new JPanel();

        //Panel Buyer
        int x = 45;
        int y = 15;
        int counterPanel = 0;

        for (int i = 0; i < arrPerson.size(); i++) {
            if (arrPerson.get(i).getUserType().equals(UserType.BUYER)) {
                JLabel lIdBuyer = new JLabel("Id: ");
                lIdBuyer.setBounds(20, 20, 75, 25);
                lIdBuyer.setFont(new Font("Serif", Font.BOLD, 25));

                JLabel lUsernameBuyer = new JLabel("UN: ");
                lUsernameBuyer.setBounds(20, 60, 150, 25);
                lUsernameBuyer.setFont(new Font("Serif", Font.BOLD, 25));

                JLabel idBuyer = new JLabel(String.valueOf(arrPerson.get(i).getIdPerson()));
                idBuyer.setBounds(58, 20, 100, 25);
                idBuyer.setFont(new Font("Serif", Font.BOLD, 25));

                JLabel usernameBuyer = new JLabel(arrPerson.get(i).getUsername());
                usernameBuyer.setBounds(70, 60, 150, 25);
                usernameBuyer.setFont(new Font("Serif", Font.BOLD, 25));

                JButton bRemoveBuyer = new JButton("Remove");
                bRemoveBuyer.setBounds(80, 98, 150, 40);
                bRemoveBuyer.setFont(new Font("Serif", Font.BOLD, 25));

                JPanel panel = new JPanel();
                panel.setBounds(x, y, 300, 150);
                panel.setBackground(new Color(150, 150, 150, 50));

                panel.add(lIdBuyer);
                panel.add(lUsernameBuyer);
                panel.add(idBuyer);
                panel.add(usernameBuyer);
                panel.add(bRemoveBuyer);
                panelBuyer.add(panel);

                bRemoveBuyer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuRemovePerson(Integer.parseInt(idBuyer.getText()), usernameBuyer.getText());
                        frame.setVisible(false);
                    }
                });

                x += 350;
                counterPanel++;
                if (counterPanel == 2) {
                    x = 45;
                    y += 175;
                    counterPanel = 0;
                }

                panel.setLayout(null);
            }
        }

        //Panel Seller
        x = 45;
        y = 15;
        counterPanel = 0;

        for (int i = 0; i < arrPerson.size(); i++) {
            if (arrPerson.get(i).getUserType().equals(UserType.SELLER)) {
                JLabel lIdSeller = new JLabel("Id: ");
                lIdSeller.setBounds(20, 20, 75, 25);
                lIdSeller.setFont(new Font("Serif", Font.BOLD, 25));

                JLabel lUsernameSeller = new JLabel("UN: ");
                lUsernameSeller.setBounds(20, 60, 150, 25);
                lUsernameSeller.setFont(new Font("Serif", Font.BOLD, 25));

                JLabel idSeller = new JLabel(String.valueOf(arrPerson.get(i).getIdPerson()));
                idSeller.setBounds(58, 20, 100, 25);
                idSeller.setFont(new Font("Serif", Font.BOLD, 25));

                JLabel usernameSeller = new JLabel(arrPerson.get(i).getUsername());
                usernameSeller.setBounds(70, 60, 150, 25);
                usernameSeller.setFont(new Font("Serif", Font.BOLD, 25));

                JButton bRemoveSeller = new JButton("Remove");
                bRemoveSeller.setBounds(80, 98, 150, 40);
                bRemoveSeller.setFont(new Font("Serif", Font.BOLD, 25));

                JPanel panel = new JPanel();
                panel.setBounds(x, y, 300, 150);
                panel.setBackground(new Color(150, 150, 150, 50));

                panel.add(lIdSeller);
                panel.add(lUsernameSeller);
                panel.add(idSeller);
                panel.add(usernameSeller);
                panel.add(bRemoveSeller);
                panelSeller.add(panel);

                bRemoveSeller.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuRemovePerson(Integer.parseInt(idSeller.getText()), usernameSeller.getText());
                        frame.setVisible(false);
                    }
                });

                x += 350;
                counterPanel++;
                if (counterPanel == 2) {
                    x = 45;
                    y += 175;
                    counterPanel = 0;
                }

                panel.setLayout(null);
            }
        }

        //Tabbed Pane
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(60, 40, 750, 760);
        tp.add("Buyer", panelBuyer);
        tp.add("Seller", panelSeller);
        tp.setFont(new Font("Serif", Font.BOLD, 30));

        //Frame
        frame.add(bBack);
        frame.add(lExplanation);
        frame.add(tp);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuAdmin();
                frame.setVisible(false);
            }
        });

        //Set
        panelBuyer.setLayout(null);
        panelSeller.setLayout(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuRemovePerson(int idPerson, String username) {
        JFrame frame = new JFrame("Remove User");
        frame.setSize(300, 290);
        JLabel lKonfirmasi, lIdPerson, lUsername;

        lKonfirmasi = new JLabel("Yakin Remove User Ini?");
        lKonfirmasi.setBounds(10, 25, 400, 25);
        lKonfirmasi.setFont(new Font("Serif", Font.BOLD, 25));
        lUsername = new JLabel("UN: " + username);
        lUsername.setBounds(10, 75, 300, 25);
        lUsername.setFont(new Font("Serif", Font.BOLD, 25));

        JButton bRemove = new JButton("Remove!");
        bRemove.setBounds(70, 125, 150, 40);
        bRemove.setFont(new Font("Serif", Font.BOLD, 30));

        JButton bBack = new JButton("Back");
        bBack.setBounds(95, 185, 100, 40);
        bBack.setFont(new Font("Serif", Font.BOLD, 30));

        frame.add(lKonfirmasi);
        frame.add(lUsername);
        frame.add(bRemove);
        frame.add(bBack);

        lIdPerson = new JLabel(String.valueOf(idPerson)); //invisible

        bRemove.addActionListener((ActionEvent e) -> {
            controlRemove.removePerson(Integer.parseInt(lIdPerson.getText()));
        });

        bBack.addActionListener((ActionEvent e) -> {
            menuSeePersonList();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

}
