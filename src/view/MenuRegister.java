/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ControllerRegister;
import model.Person;
import model.UserType;

/**
 *
 * @author Benedict
 */
public class MenuRegister {

    public MenuRegister() {
        JTextField tUsername, tName, tAddress, tCity, tPhoneNumber, tEmail;
        JPasswordField tPassword;
        JLabel lUsername, lPass, lName, lAddress, lCity, lPhone, lEmail, lType;

        JFrame frame = new JFrame("Register");
        frame.setSize(580, 625);

        //textField
        String userType[] = {"Buyer", "Seller"};
        JComboBox cbUserType;

        lUsername = new JLabel("Username: ");
        lUsername.setBounds(130, 50, 200, 25);
        frame.add(lUsername);
        tUsername = new JTextField();
        tUsername.setBounds(225, 50, 200, 25);
        frame.add(tUsername);

        lPass = new JLabel("Password: ");
        lPass.setBounds(130, 100, 200, 25);
        frame.add(lPass);
        tPassword = new JPasswordField();
        tPassword.setBounds(225, 100, 200, 25);
        frame.add(tPassword);

        lName = new JLabel("Name: ");
        lName.setBounds(130, 150, 200, 25);
        frame.add(lName);
        tName = new JTextField();
        tName.setBounds(225, 150, 200, 25);
        frame.add(tName);

        lAddress = new JLabel("Address: ");
        lAddress.setBounds(130, 200, 200, 25);
        frame.add(lAddress);
        tAddress = new JTextField();
        tAddress.setBounds(225, 200, 200, 25);
        frame.add(tAddress);

        lCity = new JLabel("City: ");
        lCity.setBounds(130, 250, 200, 25);
        frame.add(lCity);
        tCity = new JTextField();
        tCity.setBounds(225, 250, 200, 25);
        frame.add(tCity);

        lPhone = new JLabel("Phone Number: ");
        lPhone.setBounds(130, 300, 200, 25);
        frame.add(lPhone);
        tPhoneNumber = new JTextField();
        tPhoneNumber.setBounds(225, 300, 200, 25);
        frame.add(tPhoneNumber);

        lEmail = new JLabel("Email: ");
        lEmail.setBounds(130, 350, 200, 25);
        frame.add(lEmail);
        tEmail = new JTextField();
        tEmail.setBounds(225, 350, 200, 25);
        frame.add(tEmail);

        lType = new JLabel("Wanna Be The: ");
        lType.setBounds(130, 400, 200, 25);
        frame.add(lType);
        cbUserType = new JComboBox(userType);
        cbUserType.setBounds(225, 400, 200, 25);
        frame.add(cbUserType);

        //Button
        JButton bRegister = new JButton("Register Now!");
        bRegister.setBounds(175, 470, 200, 25);
        frame.add(bRegister);
        
        JButton bBack = new JButton("Back");
        bBack.setBounds(175, 520, 200, 25);
        frame.add(bBack);

        //last
        frame.setLayout(null);
        frame.setVisible(true);

        //get data
        bRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Person newPerson = new Person();
                newPerson.setUsername(tUsername.getText());
                newPerson.setPassword(new String(tPassword.getPassword()));
                newPerson.setName(tName.getText());
                newPerson.setAddress(tAddress.getText());
                newPerson.setCity(tCity.getText());
                newPerson.setPhoneNumber(tPhoneNumber.getText());
                newPerson.setEmail(tEmail.getText());
                
                String userType = (String) cbUserType.getItemAt(cbUserType.getSelectedIndex()); //set user type
                if (userType.equals("buyer")) {
                    newPerson.setUserType(UserType.BUYER);
                } else {
                    newPerson.setUserType(UserType.SELLER);
                }

                boolean result = new ControllerRegister().insertNewPerson(newPerson);
                new MenuResult().menuResultRegister(result, tUsername.getText());
                frame.setVisible(false);

            }
        });
        
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuLogin();
                frame.setVisible(false);
            }
        });
    }
}