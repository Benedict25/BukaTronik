/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerBalance;
import controller.MainController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.beans.value.ChangeListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import model.Person;

/**
 *
 * @author Benedict
 */
public class MenuBalance {

    MainController control = new MainController();
    ControllerBalance controlBalance = new ControllerBalance();

    public void depositBalance() {
        JFrame frame = new JFrame("Profile");
        frame.setSize(400, 400);
        JLabel lKeterangan;
        JButton bKonfirmasi, bBack;

        SpinnerModel value = new SpinnerNumberModel(100000, //initial value  
                0, //minimum value  
                1000000000, //maximum value  
                50000); //step   
        JSpinner sJumlahTopUp = new JSpinner(value);
        sJumlahTopUp.setBounds(40, 100, 300, 50);
        sJumlahTopUp.setFont(new Font("Serif", Font.BOLD, 40));

        lKeterangan = new JLabel("Masukkan jumlah Topup (Maks 1 milyar): ");
        lKeterangan.setBounds(15, 30, 400, 30);
        lKeterangan.setFont(new Font("Serif", Font.BOLD, 20));

        bKonfirmasi = new JButton("Top Up!");
        bKonfirmasi.setBounds(90, 190, 200, 50);
        bKonfirmasi.setFont(new Font("Serif", Font.BOLD, 20));

        bBack = new JButton("Back");
        bBack.setBounds(90, 275, 200, 50);
        bBack.setFont(new Font("Serif", Font.BOLD, 20));

        frame.add(sJumlahTopUp);
        frame.add(lKeterangan);
        frame.add(bKonfirmasi);
        frame.add(bBack);

        bKonfirmasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlBalance.depositBalance((int)sJumlahTopUp.getValue());

            }
        });

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuProfile().seeProfile();
                frame.setVisible(false);
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void withdrawBalance() {
        int balance = control.getActivePersonBalance();

        JFrame frame = new JFrame("Profile");
        frame.setSize(400, 620);
        JLabel lKeterangan, lNoTujuan;
        JTextField tNoTujuan;
        JButton bKonfirmasi, bBack;

        SpinnerModel value = new SpinnerNumberModel(100000, //initial value  
                0, //minimum value  
                balance, //maximum value  //maxnya sesuai balance
                50000); //step   
        JSpinner sJumlahWd = new JSpinner(value);
        sJumlahWd.setBounds(40, 100, 300, 50);
        sJumlahWd.setFont(new Font("Serif", Font.BOLD, 40));

        lKeterangan = new JLabel("Masukkan jumlah Withdraw: ");
        lKeterangan.setBounds(70, 50, 400, 30);
        lKeterangan.setFont(new Font("Serif", Font.BOLD, 20));

        lNoTujuan = new JLabel("Masukkan Nomor Rekening BCO: ");
        lNoTujuan.setBounds(45, 200, 400, 30);
        lNoTujuan.setFont(new Font("Serif", Font.BOLD, 20));

        tNoTujuan = new JTextField();
        tNoTujuan.setBounds(30, 250, 325, 50);
        tNoTujuan.setFont(new Font("Serif", Font.BOLD, 40));

        bKonfirmasi = new JButton("Withdraw!");
        bKonfirmasi.setBounds(90, 350, 200, 50);
        bKonfirmasi.setFont(new Font("Serif", Font.BOLD, 20));

        bBack = new JButton("Back");
        bBack.setBounds(90, 450, 200, 50);
        bBack.setFont(new Font("Serif", Font.BOLD, 20));

        frame.add(sJumlahWd);
        frame.add(lKeterangan);
        frame.add(lNoTujuan);
        frame.add(tNoTujuan);
        frame.add(bKonfirmasi);
        frame.add(bBack);

        bKonfirmasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlBalance.withdrawBalance((int) sJumlahWd.getValue());
                
            }
        });

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuProfile().seeProfile();
                frame.setVisible(false);
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
