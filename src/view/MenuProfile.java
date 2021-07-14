/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProfile;
import controller.ControllerPerson;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Person;
import model.UserType;

/**
 *
 * @author Benedict
 */
public class MenuProfile {
    
    ControllerPerson control = new ControllerPerson();
    
    public void seeProfile() {
        Person activePerson = new Person();
        activePerson = control.getPersonDataById();
        String membership = "";
        
        if (activePerson.getUserType().equals(UserType.BUYER)) {
            membership = control.getMembershipStatus();
        }
        
        JFrame frame = new JFrame("Profile");
        frame.setSize(800, 900);
        JLabel lUsername, lName, lAddress, lCity, lPhone, lEmail, lBalance, lType, lProfile;
        JLabel username, name, address, city, phone, email, balance, type;
        JButton bDeposit, bWithdraw, bEditProfile, bBack;
        
        lProfile = new JLabel("My Profile", JLabel.CENTER);
        lProfile.setBounds(0, 30, 800, 80);
        lProfile.setFont(new Font("Serif", Font.BOLD, 60));
        
        lUsername = new JLabel("Username: ");
        lUsername.setBounds(200, 150, 200, 50);
        lUsername.setFont(new Font("Serif", Font.BOLD, 30));
        lName = new JLabel("Name: ");
        lName.setBounds(200, 200, 200, 50);
        lName.setFont(new Font("Serif", Font.BOLD, 30));
        lAddress = new JLabel("Address: ");
        lAddress.setBounds(200, 250, 200, 50);
        lAddress.setFont(new Font("Serif", Font.BOLD, 30));
        lCity = new JLabel("City: ");
        lCity.setBounds(200, 300, 200, 50);
        lCity.setFont(new Font("Serif", Font.BOLD, 30));
        lPhone = new JLabel("Phone: ");
        lPhone.setBounds(200, 350, 200, 50);
        lPhone.setFont(new Font("Serif", Font.BOLD, 30));
        lEmail = new JLabel("Email: ");
        lEmail.setBounds(200, 400, 200, 50);
        lEmail.setFont(new Font("Serif", Font.BOLD, 30));
        lBalance = new JLabel("Balance: ");
        lBalance.setBounds(200, 450, 200, 50);
        lBalance.setFont(new Font("Serif", Font.BOLD, 30));
        lType = new JLabel("I'm a: ");
        lType.setBounds(200, 500, 200, 50);
        lType.setFont(new Font("Serif", Font.BOLD, 30));
        
        username = new JLabel(activePerson.getUsername());
        username.setBounds(340, 150, 600, 50);
        username.setFont(new Font("Serif", Font.BOLD, 30));
        name = new JLabel(activePerson.getName());
        name.setBounds(290, 200, 600, 50);
        name.setFont(new Font("Serif", Font.BOLD, 30));
        address = new JLabel(activePerson.getAddress());
        address.setBounds(320, 250, 600, 50);
        address.setFont(new Font("Serif", Font.BOLD, 30));
        city = new JLabel(activePerson.getCity());
        city.setBounds(270, 300, 600, 50);
        city.setFont(new Font("Serif", Font.BOLD, 30));
        phone = new JLabel(activePerson.getPhoneNumber());
        phone.setBounds(295, 350, 600, 50);
        phone.setFont(new Font("Serif", Font.BOLD, 30));
        email = new JLabel(activePerson.getEmail());
        email.setBounds(290, 400, 600, 50);
        email.setFont(new Font("Serif", Font.BOLD, 30));
        balance = new JLabel(activePerson.getFormattedBalance());
        balance.setBounds(315, 450, 600, 50);
        balance.setFont(new Font("Serif", Font.BOLD, 30));
        type = new JLabel(String.valueOf(activePerson.getUserType()));
        type.setBounds(280, 500, 600, 50);
        type.setFont(new Font("Serif", Font.BOLD, 30));
        
        bDeposit = new JButton("Deposit");
        bDeposit.setBounds(100, 575, 175, 100);
        bDeposit.setFont(new Font("Serif", Font.BOLD, 30));
        bWithdraw = new JButton("Withdraw");
        bWithdraw.setBounds(475, 575, 175, 100);
        bWithdraw.setFont(new Font("Serif", Font.BOLD, 30));
        bEditProfile = new JButton("Edit Profile");
        bEditProfile.setBounds(220, 710, 300, 100);
        bEditProfile.setFont(new Font("Serif", Font.BOLD, 30));
        bBack = new JButton("Back");
        bBack.setBounds(320, 600, 100, 40);
        bBack.setFont(new Font("Serif", Font.BOLD, 30));
        
        if (activePerson.getUserType().equals(UserType.BUYER)) {
            JLabel lMembership = new JLabel(membership + " Membership");
            lMembership.setBounds(250, 813, 300, 40);
            lMembership.setFont(new Font("Serif", Font.BOLD, 25));
            frame.add(lMembership);
        }
        
        frame.add(lProfile);
        frame.add(lUsername);
        frame.add(lName);
        frame.add(lAddress);
        frame.add(lCity);
        frame.add(lPhone);
        frame.add(lEmail);
        frame.add(lBalance);
        frame.add(lType);
        frame.add(username);
        frame.add(name);
        frame.add(address);
        frame.add(city);
        frame.add(phone);
        frame.add(email);
        frame.add(balance);
        frame.add(type);
        frame.add(bDeposit);
        frame.add(bWithdraw);
        frame.add(bEditProfile);
        frame.add(bBack);
        
        bDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuBalance().depositBalance();
                frame.setVisible(false);
            }
        });
        
        bWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuBalance().withdrawBalance();
                frame.setVisible(false);
            }
        });
        
        bEditProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editProfile();
                frame.setVisible(false);
            }
        });
        
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (type.getText().equals("BUYER")) {
                    new MainMenuBuyer();
                } else if (type.getText().equals("SELLER")) {
                    new MainMenuSeller();
                } else {
                    new MainMenuAdmin();
                }
                frame.setVisible(false);
            }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public void editProfile() {
        Person activePerson = new Person();
        activePerson = control.getPersonDataById();
        
        JFrame frame = new JFrame("Profile");
        frame.setSize(870, 1000);
        JLabel lUsername, lName, lAddress, lCity, lPhone, lEmail, lProfile, lPass;
        JTextField tUsername, tName, tAddress, tCity, tPhone, tEmail, tPass;
        JButton bEdit, bBack;
        
        lProfile = new JLabel("Edit Profile");
        lProfile.setBounds(290, 30, 300, 80);
        lProfile.setFont(new Font("Serif", Font.BOLD, 60));
        
        lUsername = new JLabel("Username: ");
        lUsername.setBounds(200, 150, 200, 30);
        lUsername.setFont(new Font("Serif", Font.BOLD, 30));
        lName = new JLabel("Name: ");
        lName.setBounds(200, 250, 200, 30);
        lName.setFont(new Font("Serif", Font.BOLD, 30));
        lAddress = new JLabel("Address: ");
        lAddress.setBounds(200, 350, 200, 30);
        lAddress.setFont(new Font("Serif", Font.BOLD, 30));
        lCity = new JLabel("City: ");
        lCity.setBounds(200, 450, 200, 30);
        lCity.setFont(new Font("Serif", Font.BOLD, 30));
        lPhone = new JLabel("Phone: ");
        lPhone.setBounds(200, 550, 200, 30);
        lPhone.setFont(new Font("Serif", Font.BOLD, 30));
        lEmail = new JLabel("Email: ");
        lEmail.setBounds(200, 650, 200, 30);
        lEmail.setFont(new Font("Serif", Font.BOLD, 30));
        lPass = new JLabel("Pass: ");
        lPass.setBounds(200, 750, 200, 30);
        lPass.setFont(new Font("Serif", Font.BOLD, 30));
        
        tUsername = new JTextField(activePerson.getUsername());
        tUsername.setBounds(340, 141, 300, 50);
        tUsername.setFont(new Font("Serif", Font.BOLD, 30));
        tName = new JTextField(activePerson.getName());
        tName.setBounds(290, 241, 350, 50);
        tName.setFont(new Font("Serif", Font.BOLD, 30));
        tAddress = new JTextField(activePerson.getAddress());
        tAddress.setBounds(320, 341, 320, 50);
        tAddress.setFont(new Font("Serif", Font.BOLD, 30));
        tCity = new JTextField(activePerson.getCity());
        tCity.setBounds(270, 441, 370, 50);
        tCity.setFont(new Font("Serif", Font.BOLD, 30));
        tPhone = new JTextField(activePerson.getPhoneNumber());
        tPhone.setBounds(295, 541, 345, 50);
        tPhone.setFont(new Font("Serif", Font.BOLD, 30));
        tEmail = new JTextField(activePerson.getEmail());
        tEmail.setBounds(290, 641, 350, 50);
        tEmail.setFont(new Font("Serif", Font.BOLD, 30));
        tPass = new JTextField(activePerson.getPassword());
        tPass.setBounds(290, 741, 350, 50);
        tPass.setFont(new Font("Serif", Font.BOLD, 30));
        
        bEdit = new JButton("Edit!");
        bEdit.setBounds(240, 825, 150, 100);
        bEdit.setFont(new Font("Serif", Font.BOLD, 30));
        
        bBack = new JButton("Back");
        bBack.setBounds(440, 825, 150, 100);
        bBack.setFont(new Font("Serif", Font.BOLD, 30));
        
        frame.add(lProfile);
        frame.add(lUsername);
        frame.add(lName);
        frame.add(lAddress);
        frame.add(lCity);
        frame.add(lPhone);
        frame.add(lEmail);
        frame.add(lPass);
        frame.add(tUsername);
        frame.add(tName);
        frame.add(tAddress);
        frame.add(tCity);
        frame.add(tPhone);
        frame.add(tEmail);
        frame.add(tPass);
        frame.add(bEdit);
        frame.add(bBack);
        
        bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person person = new Person();
                person.setUsername(tUsername.getText());
                person.setName(tName.getText());
                person.setAddress(tAddress.getText());
                person.setCity(tCity.getText());
                person.setPhoneNumber(tPhone.getText());
                person.setEmail(tEmail.getText());
                person.setPassword(tPass.getText());
                boolean result = new ControllerProfile().editProfile(person);
                new MenuResult().menuResultEditProfile(result, tUsername.getText());
                frame.setVisible(false);
            }
        });
        
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seeProfile();
                frame.setVisible(false);
            }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
}
