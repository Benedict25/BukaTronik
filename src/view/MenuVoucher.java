/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerFlashsale;
import controller.ControllerVoucher;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import model.Voucher;

/**
 *
 * @author Benedict
 */
public class MenuVoucher {

    public MenuVoucher() {
        ControllerVoucher controlVoucher = new ControllerVoucher();
        JFrame frame = new JFrame("Voucher Manager");
        frame.setSize(700, 800);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        //Create Voucher
        JTextField tMinTransaction, tCashback, tVoucherCode, tEndDate;
        JLabel lMT, lCb, lVC, lED;

        lMT = new JLabel("Minimal Transaction: ");
        lMT.setBounds(65, 125, 200, 25);
        tMinTransaction = new JTextField();
        tMinTransaction.setBounds(210, 125, 200, 25);

        lCb = new JLabel("Cashback (rupiah): ");
        lCb.setBounds(65, 175, 200, 25);
        tCashback = new JTextField();
        tCashback.setBounds(210, 175, 200, 25);

        lVC = new JLabel("Voucher Code: ");
        lVC.setBounds(65, 225, 200, 25);
        tVoucherCode = new JTextField();
        tVoucherCode.setBounds(210, 225, 200, 25);

        lED = new JLabel("End Date (YYYY-MM-DD): ");
        lED.setBounds(65, 275, 200, 25);
        tEndDate = new JTextField();
        tEndDate.setBounds(210, 275, 200, 25);

        JButton bCreateVoucher = new JButton("Create Voucher!");
        bCreateVoucher.setBounds(140, 325, 200, 30);

        p1.add(lMT);
        p1.add(tMinTransaction);
        p1.add(lCb);
        p1.add(tCashback);
        p1.add(lVC);
        p1.add(tVoucherCode);
        p1.add(lED);
        p1.add(tEndDate);
        p1.add(bCreateVoucher);
        
        bCreateVoucher.addActionListener((ActionEvent e) -> {
            Voucher newVoucher = new Voucher();
            newVoucher.setMinTransaction(Integer.parseInt(tMinTransaction.getText()));
            newVoucher.setCashback(Integer.parseInt(tCashback.getText()));
            newVoucher.setVoucherCode(tVoucherCode.getText());
            newVoucher.setEndDate(tEndDate.getText());
            controlVoucher.createVoucher(newVoucher);
        });

        //See Vouchers
        System.out.println("Belom ada");

        //Edit Voucher
        JTextField tEditID, tNewMinimum, tNewCashback, tNewCode, tNewEndDate, tNewStatus;
        JLabel lEI, lNM, lNC, lNCd, lNED, lNS, lDescription;
        
        lEI = new JLabel("ID Voucher Edit: ");
        lEI.setBounds(65, 75, 200, 25);
        tEditID = new JTextField();
        tEditID.setBounds(210, 75, 200, 25);

        lNM = new JLabel("New Minimum: ");
        lNM.setBounds(65, 125, 200, 25);
        tNewMinimum = new JTextField();
        tNewMinimum.setBounds(210, 125, 200, 25);

        lNC = new JLabel("New Cashback (Rp.): ");
        lNC.setBounds(65, 175, 200, 25);
        tNewCashback = new JTextField();
        tNewCashback.setBounds(210, 175, 200, 25);

        lNCd = new JLabel("New Code: ");
        lNCd.setBounds(65, 225, 200, 25);
        tNewCode = new JTextField();
        tNewCode.setBounds(210, 225, 200, 25);

        lNED = new JLabel("End Date (YYYY-MM-DD): ");
        lNED.setBounds(65, 275, 200, 25);
        tNewEndDate = new JTextField();
        tNewEndDate.setBounds(210, 275, 200, 25);

        lNS = new JLabel("New Status (0/1): ");
        lNS.setBounds(65, 325, 200, 25);
        tNewStatus = new JTextField();
        tNewStatus.setBounds(210, 325, 200, 25);

        lDescription = new JLabel("0 = Unavailable / 1 = Available");
        lDescription.setBounds(160, 375, 200, 25);

        JButton bEditVoucher = new JButton("Edit Voucher!");
        bEditVoucher.setBounds(140, 425, 200, 30);
        
        p3.add(lEI);
        p3.add(tEditID);
        p3.add(lNM);
        p3.add(tNewMinimum);
        p3.add(lNC);
        p3.add(tNewCashback);
        p3.add(lNCd);
        p3.add(tNewCode);
        p3.add(lNED);
        p3.add(tNewEndDate);
        p3.add(lNS);
        p3.add(tNewStatus);
        p3.add(lDescription);
        p3.add(bEditVoucher);
        
        bEditVoucher.addActionListener((ActionEvent e) -> {
            Voucher editVoucher = new Voucher();
            editVoucher.setIdVoucher(Integer.parseInt(tEditID.getText()));
            editVoucher.setMinTransaction(Integer.parseInt(tNewMinimum.getText()));
            editVoucher.setCashback(Integer.parseInt(tNewCashback.getText()));
            editVoucher.setVoucherCode(tNewCode.getText());
            editVoucher.setEndDate(tNewEndDate.getText());
            editVoucher.setIsAvailable(Integer.parseInt(tNewStatus.getText()));
            controlVoucher.editVoucher(editVoucher);
        });

        //Delete Voucher
        JTextField tIdVoucher;
        JLabel lIDVoucher;

        lIDVoucher = new JLabel("Masukkan ID Voucher Yang Ingin Dhapus: ");
        lIDVoucher.setBounds(135, 200, 400, 25);
        tIdVoucher = new JTextField();
        tIdVoucher.setBounds(150, 250, 200, 25);

        JButton bDeleteVoucher = new JButton("Delete Voucher!");
        bDeleteVoucher.setBounds(175, 300, 150, 40);

        p4.add(lIDVoucher);
        p4.add(tIdVoucher);
        p4.add(bDeleteVoucher);
        
        bDeleteVoucher.addActionListener((ActionEvent e) -> {
            int idVoucherDelete =  Integer.parseInt(tIdVoucher.getText());
            controlVoucher.deleteVoucher(idVoucherDelete);
        });

        //tabbed pane
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(90, 60, 500, 600);
        tp.add("Create Voucher", p1);
        tp.add("See Vouchers", p2);
        tp.add("Edit Voucher", p3);
        tp.add("Delete Voucher", p4);
        frame.add(tp);

        //last
        p1.setLayout(null);
        p2.setLayout(null);
        p3.setLayout(null);
        p4.setLayout(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
