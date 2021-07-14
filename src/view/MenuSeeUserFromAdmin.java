/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerPrintUserData;
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
import model.Buyer;
import model.Person;
import model.Seller;

/**
 *
 * @author Ignatius Dariel
 */
public class MenuSeeUserFromAdmin {

    public void menuSeePersonList() {

        ArrayList<Person> arrPerson = new ArrayList();
        arrPerson = new ControllerPrintUserData().getListUserData();

        JFrame frame = new JFrame("See Person User List");
        frame.setSize(900, 880);

        JButton bBack;

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
            Person person = arrPerson.get(i);

            if (person instanceof Buyer) {
                JLabel lIdBuyer = new JLabel("Id: ");
                lIdBuyer.setBounds(20, 10, 75, 25);
                lIdBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel lNameBuyer = new JLabel("Name: ");
                lNameBuyer.setBounds(20, 30, 150, 25);
                lNameBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel lAddressBuyer = new JLabel("Address: ");
                lAddressBuyer.setBounds(20, 50, 150, 25);
                lAddressBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel lCityBuyer = new JLabel("City: ");
                lCityBuyer.setBounds(20, 70, 150, 25);
                lCityBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel lPhoneNumberBuyer = new JLabel("Phone: ");
                lPhoneNumberBuyer.setBounds(20, 90, 150, 25);
                lPhoneNumberBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel lEmailBuyer = new JLabel("Email: ");
                lEmailBuyer.setBounds(20, 110, 150, 25);
                lEmailBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel lMembershipStatus = new JLabel("Membership: ");
                lMembershipStatus.setBounds(20, 130, 150, 25);
                lMembershipStatus.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel idBuyer = new JLabel(String.valueOf(arrPerson.get(i).getIdPerson()));
                idBuyer.setBounds(43, 10, 100, 25);
                idBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel nameBuyer = new JLabel(arrPerson.get(i).getName());
                nameBuyer.setBounds(70, 30, 150, 25);
                nameBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel addressBuyer = new JLabel(arrPerson.get(i).getAddress());
                addressBuyer.setBounds(82, 50, 150, 25);
                addressBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel cityBuyer = new JLabel(arrPerson.get(i).getCity());
                cityBuyer.setBounds(55, 70, 150, 25);
                cityBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel phoneNumberBuyer = new JLabel(arrPerson.get(i).getPhoneNumber());
                phoneNumberBuyer.setBounds(70, 90, 150, 25);
                phoneNumberBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel emailBuyer = new JLabel(arrPerson.get(i).getEmail());
                emailBuyer.setBounds(65, 110, 150, 25);
                emailBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel membershipStatus = new JLabel(String.valueOf(((Buyer) arrPerson.get(i)).getMembershipStatus()));
                membershipStatus.setBounds(110, 130, 150, 25);
                membershipStatus.setFont(new Font("Serif", Font.BOLD, 15));

                JPanel panel = new JPanel();
                panel.setBounds(x, y, 300, 170);
                panel.setBackground(new Color(150, 150, 150, 50));

                panel.add(lIdBuyer);
                panel.add(lNameBuyer);
                panel.add(lAddressBuyer);
                panel.add(lCityBuyer);
                panel.add(lPhoneNumberBuyer);
                panel.add(lEmailBuyer);
                panel.add(lMembershipStatus);
                panel.add(idBuyer);
                panel.add(nameBuyer);
                panel.add(addressBuyer);
                panel.add(cityBuyer);
                panel.add(phoneNumberBuyer);
                panel.add(emailBuyer);
                panel.add(membershipStatus);

                panelBuyer.add(panel);

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
            Person person = arrPerson.get(i);

            if (person instanceof Seller) {
                JLabel lIdBuyer = new JLabel("Id: ");
                lIdBuyer.setBounds(20, 10, 75, 25);
                lIdBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel lNameBuyer = new JLabel("Name: ");
                lNameBuyer.setBounds(20, 30, 150, 25);
                lNameBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel lAddressBuyer = new JLabel("Address: ");
                lAddressBuyer.setBounds(20, 50, 150, 25);
                lAddressBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel lCityBuyer = new JLabel("City: ");
                lCityBuyer.setBounds(20, 70, 150, 25);
                lCityBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel lPhoneNumberBuyer = new JLabel("Phone: ");
                lPhoneNumberBuyer.setBounds(20, 90, 150, 25);
                lPhoneNumberBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel lEmailBuyer = new JLabel("Email: ");
                lEmailBuyer.setBounds(20, 110, 150, 25);
                lEmailBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel idBuyer = new JLabel(String.valueOf(arrPerson.get(i).getIdPerson()));
                idBuyer.setBounds(43, 10, 100, 25);
                idBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel nameBuyer = new JLabel(arrPerson.get(i).getName());
                nameBuyer.setBounds(70, 30, 150, 25);
                nameBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel addressBuyer = new JLabel(arrPerson.get(i).getAddress());
                addressBuyer.setBounds(82, 50, 150, 25);
                addressBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel cityBuyer = new JLabel(arrPerson.get(i).getCity());
                cityBuyer.setBounds(55, 70, 150, 25);
                cityBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel phoneNumberBuyer = new JLabel(arrPerson.get(i).getPhoneNumber());
                phoneNumberBuyer.setBounds(70, 90, 150, 25);
                phoneNumberBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JLabel emailBuyer = new JLabel(arrPerson.get(i).getEmail());
                emailBuyer.setBounds(65, 110, 150, 25);
                emailBuyer.setFont(new Font("Serif", Font.BOLD, 15));

                JPanel panel = new JPanel();
                panel.setBounds(x, y, 300, 150);
                panel.setBackground(new Color(150, 150, 150, 50));

                panel.add(lIdBuyer);
                panel.add(lNameBuyer);
                panel.add(lAddressBuyer);
                panel.add(lCityBuyer);
                panel.add(lPhoneNumberBuyer);
                panel.add(lEmailBuyer);
                panel.add(idBuyer);
                panel.add(nameBuyer);
                panel.add(addressBuyer);
                panel.add(cityBuyer);
                panel.add(phoneNumberBuyer);
                panel.add(emailBuyer);

                x += 350;
                counterPanel++;
                if (counterPanel == 2) {
                    x = 45;
                    y += 175;
                    counterPanel = 0;
                }
                panelSeller.add(panel);
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
}
