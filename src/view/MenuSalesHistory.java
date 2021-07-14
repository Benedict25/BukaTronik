/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerSalesHistory;
import controller.ControllerPerson;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Transaction;

/**
 *
 * @author Ignatius Dariel
 */
public class MenuSalesHistory {

    public void seeSalesHistorySeller() {
        JFrame frameSHSeller = new JFrame("See Seller Sales");
        frameSHSeller.setSize(390, 1000);
        int y = 90;
        ArrayList<Transaction> arrTrans = new ControllerSalesHistory().catchArrSalesSeller();

        JLabel lHeading = new JLabel("List Sales " + new ControllerPerson().getActivePersonUsername());
        lHeading.setBounds(25, 10, 300, 60);
        lHeading.setFont(new Font("Serif", Font.BOLD, 30));

        JButton bBack = new JButton("Back");
        bBack.setBounds(25, 900, 100, 50);
        bBack.setFont(new Font("Serif", Font.BOLD, 30));

        for (int i = 0; i < arrTrans.size(); i++) {
            JLabel lPayAmount, lcashback, lOrderId, lpurchaseDate, lCourType, lDeliveryStatus;
            JLabel payAmount, cashback, orderId, purchaseDate, courType, deliveryStatus;
            JButton bDetails;

            JPanel panel = new JPanel();
            panel.setBounds(25, y, 325, 125);
            panel.setBackground(new Color(150, 150, 150, 50)); //rgba ; a = %

            lOrderId = new JLabel("Order Id: ");
            lOrderId.setBounds(25, 0, 100, 25);
            lPayAmount = new JLabel("Pay Amount: ");
            lPayAmount.setBounds(25, 20, 100, 25);
            lcashback = new JLabel("Cashback: ");
            lcashback.setBounds(25, 40, 100, 25);
            lpurchaseDate = new JLabel("Purchase Date: ");
            lpurchaseDate.setBounds(25, 60, 100, 25);
            lCourType = new JLabel("Cour Type: ");
            lCourType.setBounds(25, 80, 100, 25);
            lDeliveryStatus = new JLabel("Status: ");
            lDeliveryStatus.setBounds(25, 100, 100, 25);

            orderId = new JLabel(String.valueOf(arrTrans.get(i).getIdTransaction()));
            orderId.setBounds(125, 0, 100, 25);
            payAmount = new JLabel(arrTrans.get(i).getFormattedPayAmount());
            payAmount.setBounds(125, 20, 100, 25);
            cashback = new JLabel(arrTrans.get(i).getFormattedCashback());
            cashback.setBounds(125, 40, 100, 25);
            purchaseDate = new JLabel(arrTrans.get(i).getPurchaseDate());
            purchaseDate.setBounds(125, 60, 100, 25);
            courType = new JLabel(String.valueOf(arrTrans.get(i).getCourierType()));
            courType.setBounds(125, 80, 100, 25);
            deliveryStatus = new JLabel(String.valueOf(arrTrans.get(i).getDeliveryStatus()));
            deliveryStatus.setBounds(125, 100, 100, 25);

            bDetails = new JButton("Details");
            bDetails.setBounds(230, 45, 75, 25);

            panel.add(lPayAmount);
            panel.add(payAmount);
            panel.add(lcashback);
            panel.add(cashback);
            panel.add(lOrderId);
            panel.add(orderId);
            panel.add(lpurchaseDate);
            panel.add(purchaseDate);
            panel.add(lCourType);
            panel.add(courType);
            panel.add(bDetails);
            panel.add(lDeliveryStatus);
            panel.add(deliveryStatus);

            frameSHSeller.add(panel);

            bDetails.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MenuOrder().seeDetailedOrder(Integer.parseInt(orderId.getText()), "seeSalesHistory");
                    frameSHSeller.setVisible(false);
                }
            });

            panel.setLayout(null);
            panel.setVisible(true);

            y += 145;
        }

        frameSHSeller.add(bBack);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuSeller();
                frameSHSeller.setVisible(false);
            }
        });

        frameSHSeller.add(lHeading);
        frameSHSeller.setLayout(null);
        frameSHSeller.setVisible(true);
    }

    public void seeSalesHistoryAdmin() {
        JFrame frameSHAdmin = new JFrame("See All Seller Sales");
        frameSHAdmin.setSize(390, 1000);
        int y = 90;
        ArrayList<Transaction> arrTrans = new ControllerSalesHistory().catchArrSalesAdmin();

        JLabel lHeading = new JLabel("List All Sales");
        lHeading.setBounds(25, 10, 300, 60);
        lHeading.setFont(new Font("Serif", Font.BOLD, 40));

        JButton bBack = new JButton("Back");
        bBack.setBounds(25, 900, 100, 50);
        bBack.setFont(new Font("Serif", Font.BOLD, 30));

        for (int i = 0; i < arrTrans.size(); i++) {
            JLabel lPayAmount, lcashback, lOrderId, lpurchaseDate, lCourType, lDeliveryStatus;
            JLabel payAmount, cashback, orderId, purchaseDate, courType, deliveryStatus;
            JButton bDetails;

            JPanel panel = new JPanel();
            panel.setBounds(25, y, 325, 125);
            panel.setBackground(new Color(150, 150, 150, 50)); //rgba ; a = %

            lOrderId = new JLabel("Order Id: ");
            lOrderId.setBounds(25, 0, 100, 25);
            lPayAmount = new JLabel("Pay Amount: ");
            lPayAmount.setBounds(25, 20, 100, 25);
            lcashback = new JLabel("Cashback: ");
            lcashback.setBounds(25, 40, 100, 25);
            lpurchaseDate = new JLabel("Purchase Date: ");
            lpurchaseDate.setBounds(25, 60, 100, 25);
            lCourType = new JLabel("Cour Type: ");
            lCourType.setBounds(25, 80, 100, 25);
            lDeliveryStatus = new JLabel("Delivery Status: ");
            lDeliveryStatus.setBounds(25, 100, 100, 25);

            orderId = new JLabel(String.valueOf(arrTrans.get(i).getIdTransaction()));
            orderId.setBounds(125, 0, 100, 25);
            payAmount = new JLabel(arrTrans.get(i).getFormattedPayAmount());
            payAmount.setBounds(125, 20, 100, 25);
            cashback = new JLabel(arrTrans.get(i).getFormattedCashback());
            cashback.setBounds(125, 40, 100, 25);
            purchaseDate = new JLabel(arrTrans.get(i).getPurchaseDate());
            purchaseDate.setBounds(125, 60, 100, 25);
            courType = new JLabel(String.valueOf(arrTrans.get(i).getCourierType()));
            courType.setBounds(125, 80, 100, 25);
            deliveryStatus = new JLabel(String.valueOf(arrTrans.get(i).getDeliveryStatus()));
            deliveryStatus.setBounds(125, 100, 100, 25);

            bDetails = new JButton("Details");
            bDetails.setBounds(210, 15, 75, 25);

            panel.add(lPayAmount);
            panel.add(payAmount);
            panel.add(lcashback);
            panel.add(cashback);
            panel.add(lOrderId);
            panel.add(orderId);
            panel.add(lpurchaseDate);
            panel.add(purchaseDate);
            panel.add(lCourType);
            panel.add(courType);
            panel.add(bDetails);
            panel.add(lDeliveryStatus);
            panel.add(deliveryStatus);

            frameSHAdmin.add(panel);

            bDetails.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MenuOrder().seeDetailedOrder(Integer.parseInt(orderId.getText()), "seeSalesAll");
                    frameSHAdmin.setVisible(false);
                }
            });

            panel.setLayout(null);
            panel.setVisible(true);

            y += 145;
        }

        frameSHAdmin.add(bBack);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuAdmin();
                frameSHAdmin.setVisible(false);
            }
        });

        frameSHAdmin.add(lHeading);
        frameSHAdmin.setLayout(null);
        frameSHAdmin.setVisible(true);
    }
}
