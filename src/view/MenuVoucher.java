/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerVoucher;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Voucher;

/**
 *
 * @author Benedict
 */
public class MenuVoucher {

    ControllerVoucher controlVoucher = new ControllerVoucher();
    MenuResult menuResult = new MenuResult();

    public void MenuCreateVoucher() {
        JFrame frame = new JFrame("Create Voucher");
        frame.setSize(500, 550);

        JTextField tMinTransaction, tCashback, tVoucherCode, tEndDate;
        JLabel lMT, lCb, lVC, lED;

        lMT = new JLabel("Minimal Transaction: ");
        lMT.setBounds(65, 100, 200, 25);
        tMinTransaction = new JTextField();
        tMinTransaction.setBounds(210, 100, 200, 25);

        lCb = new JLabel("Cashback (rupiah): ");
        lCb.setBounds(65, 150, 200, 25);
        tCashback = new JTextField();
        tCashback.setBounds(210, 150, 200, 25);

        lVC = new JLabel("Voucher Code: ");
        lVC.setBounds(65, 200, 200, 25);
        tVoucherCode = new JTextField();
        tVoucherCode.setBounds(210, 200, 200, 25);

        lED = new JLabel("End Date (YYYY-MM-DD): ");
        lED.setBounds(65, 250, 200, 25);
        tEndDate = new JTextField();
        tEndDate.setBounds(210, 250, 200, 25);

        JButton bCreateVoucher = new JButton("Create Voucher!");
        bCreateVoucher.setBounds(140, 300, 200, 30);

        JButton bBack = new JButton("Back");
        bBack.setBounds(165, 350, 150, 30);

        bCreateVoucher.addActionListener((ActionEvent e) -> {
            Voucher newVoucher = new Voucher();
            newVoucher.setMinTransaction(Integer.parseInt(tMinTransaction.getText()));
            newVoucher.setCashback(Integer.parseInt(tCashback.getText()));
            newVoucher.setVoucherCode(tVoucherCode.getText());
            newVoucher.setEndDate(tEndDate.getText());
            boolean result = controlVoucher.createVoucher(newVoucher);
            menuResult.menuResultCreateVoucher(result, tVoucherCode.getText());
            frame.setVisible(false);
        });

        bBack.addActionListener((ActionEvent e) -> {
            MenuSeeVoucherForAdmin();
            frame.setVisible(false);
        });

        frame.add(lMT);
        frame.add(tMinTransaction);
        frame.add(lCb);
        frame.add(tCashback);
        frame.add(lVC);
        frame.add(tVoucherCode);
        frame.add(lED);
        frame.add(tEndDate);
        frame.add(bCreateVoucher);
        frame.add(bBack);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void MenuEditVoucher(int idVoucher) {
        JFrame frame = new JFrame("Edit Voucher");
        frame.setSize(500, 720);

        Voucher voucher = new Voucher();
        voucher = controlVoucher.getVoucherDataById(idVoucher); //ambil data untuk di text field

        JTextField tNewMinimum, tNewCashback, tNewCode, tNewEndDate, tNewStatus;
        JLabel lNM, lNC, lNCd, lNED, lNS, lDescription;

        lNM = new JLabel("New Minimum: ");
        lNM.setBounds(65, 125, 200, 25);
        tNewMinimum = new JTextField(String.valueOf(voucher.getMinTransaction()));
        tNewMinimum.setBounds(210, 125, 200, 25);

        lNC = new JLabel("New Cashback (Rp.): ");
        lNC.setBounds(65, 175, 200, 25);
        tNewCashback = new JTextField(String.valueOf(voucher.getCashback()));
        tNewCashback.setBounds(210, 175, 200, 25);

        lNCd = new JLabel("New Code: ");
        lNCd.setBounds(65, 225, 200, 25);
        tNewCode = new JTextField(voucher.getVoucherCode());
        tNewCode.setBounds(210, 225, 200, 25);

        lNED = new JLabel("End Date (YYYY-MM-DD): ");
        lNED.setBounds(65, 275, 200, 25);
        tNewEndDate = new JTextField(voucher.getEndDate());
        tNewEndDate.setBounds(210, 275, 200, 25);

        lNS = new JLabel("New Status (0/1): ");
        lNS.setBounds(65, 325, 200, 25);
        tNewStatus = new JTextField(String.valueOf(voucher.getIsAvailable()));
        tNewStatus.setBounds(210, 325, 200, 25);

        lDescription = new JLabel("0 = Unavailable / 1 = Available");
        lDescription.setBounds(160, 375, 200, 25);

        JButton bEditVoucher = new JButton("Edit Voucher!");
        bEditVoucher.setBounds(140, 425, 200, 30);

        JButton bBack = new JButton("Back");
        bBack.setBounds(165, 475, 150, 30);

        frame.add(lNM);
        frame.add(tNewMinimum);
        frame.add(lNC);
        frame.add(tNewCashback);
        frame.add(lNCd);
        frame.add(tNewCode);
        frame.add(lNED);
        frame.add(tNewEndDate);
        frame.add(lNS);
        frame.add(tNewStatus);
        frame.add(lDescription);
        frame.add(bEditVoucher);
        frame.add(bBack);

        JLabel id = new JLabel(String.valueOf(voucher.getIdVoucher())); //invisible j label untuk menampung id

        bEditVoucher.addActionListener((ActionEvent e) -> {
            Voucher editVoucher = new Voucher();
            editVoucher.setIdVoucher(Integer.parseInt(id.getText())); //parsing id
            editVoucher.setMinTransaction(Integer.parseInt(tNewMinimum.getText()));
            editVoucher.setCashback(Integer.parseInt(tNewCashback.getText()));
            editVoucher.setVoucherCode(tNewCode.getText());
            editVoucher.setEndDate(tNewEndDate.getText());
            editVoucher.setIsAvailable(Integer.parseInt(tNewStatus.getText()));
            boolean result = controlVoucher.editVoucher(editVoucher);
            menuResult.menuResultEditVoucher(result, tNewCode.getText());
            frame.setVisible(false);
        });

        bBack.addActionListener((ActionEvent e) -> {
            MenuSeeVoucherForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void MenuDeleteVoucher(String idVoucher, String voucherCode) {
        JFrame frame = new JFrame("Delete Voucher");
        frame.setSize(400, 300);
        JLabel lKonfirmasi, lIdVoucher, lVoucherCode;

        lKonfirmasi = new JLabel("Yakin Ingin Hapus Voucher ini?", JLabel.CENTER);
        lKonfirmasi.setBounds(0, 25, 400, 25);
        lVoucherCode = new JLabel("Voucher Code: " + voucherCode, JLabel.CENTER);
        lVoucherCode.setBounds(0, 75, 400, 25);

        JButton bDeleteVoucher = new JButton("Delete Voucher!");
        bDeleteVoucher.setBounds(115, 125, 150, 40);

        JButton bBack = new JButton("Back");
        bBack.setBounds(140, 185, 100, 40);

        frame.add(lKonfirmasi);
        frame.add(lVoucherCode);
        frame.add(bDeleteVoucher);
        frame.add(bBack);

        lIdVoucher = new JLabel(idVoucher); //invisible

        bDeleteVoucher.addActionListener((ActionEvent e) -> {
            boolean result = controlVoucher.deleteVoucher(Integer.parseInt(lIdVoucher.getText()));
            menuResult.menuResultDeleteVoucher(result, voucherCode);
            frame.setVisible(false);
        });

        bBack.addActionListener((ActionEvent e) -> {
            MenuSeeVoucherForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void MenuSeeVoucherForAdmin() { //bedanya dengan buyer adalah di seller ada edit delete
        ArrayList<Voucher> arrVoucher = new ArrayList();
        arrVoucher = controlVoucher.getVoucherDataAdmin();

        JButton bBack = new JButton("Back");
        bBack.setBounds(25, 25, 70, 40);

        JButton bCreate = new JButton("Create Voucher");
        bCreate.setBounds(110, 20, 150, 50);

        JFrame frame = new JFrame("Voucher List");
        frame.setSize(390, 1000);
        int y = 90;

        frame.add(bCreate);
        frame.add(bBack);

        bCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuCreateVoucher();
                frame.setVisible(false);
            }
        });

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuAdmin();
                frame.setVisible(false);
            }
        });

        for (int i = 0; i < arrVoucher.size(); i++) {
            JLabel lMinTransaction, lCashback, lVoucherCode, lEndDate, lIsAvailable;
            JLabel minTransaction, cashback, voucherCode, endDate, isAvailable;
            JButton bEdit, bDelete;

            JPanel panel = new JPanel();
            panel.setBounds(25, y, 325, 105);
            panel.setBackground(new Color(150, 150, 150, 50)); //rgba ; a = %

            lVoucherCode = new JLabel("Code: ");
            lVoucherCode.setBounds(25, 0, 100, 25);
            lMinTransaction = new JLabel("Min Transaction: ");
            lMinTransaction.setBounds(25, 20, 100, 25);
            lCashback = new JLabel("Cashback: ");
            lCashback.setBounds(25, 40, 100, 25);
            lEndDate = new JLabel("End Date: ");
            lEndDate.setBounds(25, 60, 100, 25);
            lIsAvailable = new JLabel("Is Available: ");
            lIsAvailable.setBounds(25, 80, 100, 25);

            voucherCode = new JLabel(arrVoucher.get(i).getVoucherCode());
            voucherCode.setBounds(125, 0, 100, 25);
            minTransaction = new JLabel(arrVoucher.get(i).getFormattedMinTransaction());
            minTransaction.setBounds(125, 20, 200, 25);
            cashback = new JLabel(arrVoucher.get(i).getFormattedCashback());
            cashback.setBounds(125, 40, 200, 25);
            endDate = new JLabel(arrVoucher.get(i).getEndDate());
            endDate.setBounds(125, 60, 100, 30);
            isAvailable = new JLabel(String.valueOf(arrVoucher.get(i).getIsAvailable()));
            isAvailable.setBounds(125, 80, 100, 25);

            bEdit = new JButton("Edit");
            bEdit.setBounds(240, 20, 75, 25);
            bDelete = new JButton("Delete");
            bDelete.setBounds(240, 60, 75, 25);

            panel.add(lMinTransaction);
            panel.add(minTransaction);
            panel.add(lCashback);
            panel.add(cashback);
            panel.add(lVoucherCode);
            panel.add(voucherCode);
            panel.add(lEndDate);
            panel.add(endDate);
            panel.add(lIsAvailable);
            panel.add(isAvailable);
            panel.add(bEdit);
            panel.add(bDelete);

            frame.add(panel);

            JLabel id = new JLabel(String.valueOf(arrVoucher.get(i).getIdVoucher())); //invisible j label untuk menampung id

            bEdit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MenuEditVoucher(Integer.parseInt(id.getText()));
                    frame.setVisible(false);
                }
            });

            bDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MenuDeleteVoucher(id.getText(), voucherCode.getText());
                    frame.setVisible(false);
                }
            });

            panel.setLayout(null);
            panel.setVisible(true);

            y += 125;
        }

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void MenuSeeVoucherForBuyer() {
        ArrayList<Voucher> arrVoucher = new ArrayList();
        arrVoucher = controlVoucher.getVoucherDataNonSeller();

        JFrame frame = new JFrame("Voucher List");
        frame.setSize(390, 1000);

        JButton bBack = new JButton("Back");
        bBack.setBounds(150, 10, 70, 40);

        frame.add(bBack);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuBuyer();
                frame.setVisible(false);
            }
        });

        int y = 60;

        for (int i = 0; i < arrVoucher.size(); i++) {
            JLabel lMinTransaction, lCashback, lVoucherCode, lEndDate, lIsAvailable;
            JLabel minTransaction, cashback, voucherCode, endDate, isAvailable, availableInfo;

            JPanel panel = new JPanel();
            panel.setBounds(25, y, 325, 105);
            panel.setBackground(new Color(150, 150, 150, 50)); //rgba ; a = %

            lVoucherCode = new JLabel("Code: ");
            lVoucherCode.setBounds(25, 0, 100, 25);
            lMinTransaction = new JLabel("Min Transaction: ");
            lMinTransaction.setBounds(25, 20, 100, 25);
            lCashback = new JLabel("Cashback: ");
            lCashback.setBounds(25, 40, 100, 25);
            lEndDate = new JLabel("End Date: ");
            lEndDate.setBounds(25, 60, 100, 25);
            lIsAvailable = new JLabel("Is Available: ");
            lIsAvailable.setBounds(25, 80, 100, 25);

            voucherCode = new JLabel(arrVoucher.get(i).getVoucherCode());
            voucherCode.setBounds(125, 0, 100, 25);
            minTransaction = new JLabel(arrVoucher.get(i).getFormattedMinTransaction());
            minTransaction.setBounds(125, 20, 200, 25);
            cashback = new JLabel(arrVoucher.get(i).getFormattedCashback());
            cashback.setBounds(125, 40, 200, 25);
            endDate = new JLabel(arrVoucher.get(i).getEndDate());
            endDate.setBounds(125, 60, 100, 30);
            isAvailable = new JLabel(String.valueOf(arrVoucher.get(i).getIsAvailable()));
            isAvailable.setBounds(125, 80, 100, 25);

            if (arrVoucher.get(i).getIsAvailable() == 1) {
                availableInfo = new JLabel("I'm Available!");
                availableInfo.setBounds(230, 40, 100, 30);
            } else {
                availableInfo = new JLabel("Not Available!");
                availableInfo.setBounds(230, 40, 100, 30);
            }

            panel.add(lMinTransaction);
            panel.add(minTransaction);
            panel.add(lCashback);
            panel.add(cashback);
            panel.add(lVoucherCode);
            panel.add(voucherCode);
            panel.add(lEndDate);
            panel.add(endDate);
            panel.add(lIsAvailable);
            panel.add(isAvailable);
            panel.add(availableInfo);

            frame.add(panel);

            panel.setLayout(null);
            panel.setVisible(true);

            y += 125;
        }

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
