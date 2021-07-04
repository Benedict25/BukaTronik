/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Benedict
 */
public class MenuLogin {

    public MenuLogin() {
        JTextField tUsername;
        JPasswordField tPassword;
        JButton bLogin, bRegister;
        JLabel lUsername, lPassword;

        JFrame frame = new JFrame("Login");
        frame.setSize(400, 400);

        lUsername = new JLabel("Username: ");
        lUsername.setBounds(50, 100, 100, 25);

        lPassword = new JLabel("Password: ");
        lPassword.setBounds(50, 150, 100, 25);

        tUsername = new JTextField();
        tUsername.setBounds(125, 100, 200, 25);

        tPassword = new JPasswordField();
        tPassword.setBounds(125, 150, 200, 25);

        bLogin = new JButton("Login");
        bLogin.setBounds(50, 200, 100, 50);

        bRegister = new JButton("Register");
        bRegister.setBounds(225, 200, 100, 50);

        frame.add(lUsername);
        frame.add(tUsername);
        frame.add(lPassword);
        frame.add(tPassword);
        frame.add(bLogin);
        frame.add(bRegister);

        //last
        frame.setLayout(null);
        frame.setVisible(true);
        

        //button login
        bLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tUsername.getText();
                String password = new String(tPassword.getPassword());
                ControllerLogin control = new ControllerLogin();
                String userType = control.checkLoginAndSetActivePerson(username, password);
                boolean successLogin = true;
                //Jika user type kosong berarti user tidak ditemukan
                if (userType.equals("")) {
                    successLogin = false;
                }
                //Masuk menu tiap user
                System.out.println(userType);
                if (successLogin) {
                    System.out.println("Sukses");
                    switch (userType) {
                        case "ADMIN":
                            
                            break;
                        case "SELLER":
                            new MenuItem();
                            break;
                        case "BUYER":
                            
                            break;
                        default:
                            throw new AssertionError();
                    }
                }else{
                    System.out.println("Gagal");
                }
                frame.setVisible(false);
            } 
        });

        //button register
        bRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MenuRegister();
            }
        });
    }
}
