/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
import model.UserType;
import controller.ControllerManageOrder;
import model.DeliveryStatus;
import model.Transaction;

/**
 *
 * @author Benedict
 */
public class MenuManageOrder {

    ControllerManageOrder controlOrder = new ControllerManageOrder();

    public void menuSeeOrder() {
        ArrayList<Transaction> arrTrans = new ArrayList();
        arrTrans = controlOrder.getTransactionDataForSeller();

        JFrame frame = new JFrame("Manage Order");
        frame.setSize(900, 880);

        JLabel lExplanation;
        JButton bBack;

        //For Frame
        lExplanation = new JLabel("Aprv = Approve");
        lExplanation.setBounds(620, 25, 200, 70);
        lExplanation.setFont(new Font("Serif", Font.BOLD, 20));

        bBack = new JButton("Back");
        bBack.setBounds(377, 43, 100, 35);
        bBack.setFont(new Font("Serif", Font.BOLD, 30));

        //Panel
        JPanel panelBuyer = new JPanel();
        JPanel panelSeller = new JPanel();

        //Panel Status Processed
        int x = 45;
        int y = 15;
        int counterPanel = 0;

        for (int i = 0; i < arrTrans.size(); i++) {

            if (arrTrans.get(i).getDeliveryStatus() != null && arrTrans.get(i).getDeliveryStatus().equals(DeliveryStatus.PROCESSED)) {
                JLabel lPurchaseDate = new JLabel("Date: ");
                lPurchaseDate.setBounds(20, 20, 75, 25);
                lPurchaseDate.setFont(new Font("Serif", Font.BOLD, 25));

                JLabel lPayAMount = new JLabel("Amount: ");
                lPayAMount.setBounds(20, 60, 150, 25);
                lPayAMount.setFont(new Font("Serif", Font.BOLD, 25));

                JLabel purchaseDate = new JLabel(String.valueOf(arrTrans.get(i).getPurchaseDate()));
                purchaseDate.setBounds(80, 20, 200, 25);
                purchaseDate.setFont(new Font("Serif", Font.BOLD, 25));

                JLabel payAmount = new JLabel(String.valueOf(arrTrans.get(i).getPayAmount()));
                payAmount.setBounds(120, 60, 200, 25);
                payAmount.setFont(new Font("Serif", Font.BOLD, 25));

                JButton bAcceptOrder = new JButton("Deliver!");
                bAcceptOrder.setBounds(15, 98, 125, 40);
                bAcceptOrder.setFont(new Font("Serif", Font.BOLD, 25));
                
                JButton bSeeDetail = new JButton("Detail");
                bSeeDetail.setBounds(160, 98, 125, 40);
                bSeeDetail.setFont(new Font("Serif", Font.BOLD, 25));

                JPanel panel = new JPanel();
                panel.setBounds(x, y, 300, 150);
                panel.setBackground(new Color(150, 150, 150, 50));

                panel.add(lPurchaseDate);
                panel.add(lPayAMount);
                panel.add(purchaseDate);
                panel.add(payAmount);
                panel.add(bAcceptOrder);
                panel.add(bSeeDetail);
                panelBuyer.add(panel);

                JLabel invisibleId = new JLabel(String.valueOf(arrTrans.get(i).getIdTransaction()));

                bAcceptOrder.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean result = controlOrder.updateStatusOrder(Integer.parseInt(invisibleId.getText()), "DELIVERED");
                        new MenuResult().menuResultApproveOrder(result);
                        frame.setVisible(false);
                    }
                });
                
                bSeeDetail.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new MenuOrder().seeDetailedOrder(Integer.parseInt(invisibleId.getText()), "manageOrder");
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

        //Panel Status Cancelling
        x = 45;
        y = 15;
        counterPanel = 0;

        for (int i = 0; i < arrTrans.size(); i++) {
            if (arrTrans.get(i).getDeliveryStatus() != null && arrTrans.get(i).getDeliveryStatus().equals(DeliveryStatus.CANCELLING)) {
                JLabel lPurchaseDate = new JLabel("Date: ");
                lPurchaseDate.setBounds(20, 20, 75, 25);
                lPurchaseDate.setFont(new Font("Serif", Font.BOLD, 25));

                JLabel lPayAmount = new JLabel("Amount: ");
                lPayAmount.setBounds(20, 60, 150, 25);
                lPayAmount.setFont(new Font("Serif", Font.BOLD, 25));

                JLabel purchaseDate = new JLabel(String.valueOf(arrTrans.get(i).getPurchaseDate()));
                purchaseDate.setBounds(80, 20, 200, 25);
                purchaseDate.setFont(new Font("Serif", Font.BOLD, 25));

                JLabel payAmount = new JLabel(String.valueOf(arrTrans.get(i).getPayAmount()));
                payAmount.setBounds(120, 60, 200, 25);
                payAmount.setFont(new Font("Serif", Font.BOLD, 25));

                JButton bApproveCancel = new JButton("Aprv");
                bApproveCancel.setBounds(15, 98, 125, 40);
                bApproveCancel.setFont(new Font("Serif", Font.BOLD, 25));
                
                JButton bSeeDetailCancel = new JButton("Detail");
                bSeeDetailCancel.setBounds(160, 98, 125, 40);
                bSeeDetailCancel.setFont(new Font("Serif", Font.BOLD, 25));

                JPanel panel = new JPanel();
                panel.setBounds(x, y, 300, 150);
                panel.setBackground(new Color(150, 150, 150, 50));

                panel.add(lPurchaseDate);
                panel.add(lPayAmount);
                panel.add(purchaseDate);
                panel.add(payAmount);
                panel.add(bApproveCancel);
                panel.add(bSeeDetailCancel);
                panelSeller.add(panel);

                JLabel invisibleId = new JLabel(String.valueOf(arrTrans.get(i).getIdTransaction()));
                JLabel invisibleIdBuyer = new JLabel(String.valueOf(arrTrans.get(i).getIdBuyer()));

                bApproveCancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean result = controlOrder.updateStatusOrder(Integer.parseInt(invisibleId.getText()), "CANCELLED");
                        if (result == true) {
                            controlOrder.refundFromCancellation(Integer.parseInt(invisibleIdBuyer.getText()), Integer.parseInt(payAmount.getText()));
                        }
                        new MenuResult().menuResultApproveCancelOrder(result);
                        frame.setVisible(false);
                    }
                });
                
                bSeeDetailCancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new MenuOrder().seeDetailedOrder(Integer.parseInt(invisibleId.getText()), "manageOrder");
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
        tp.add("Order", panelBuyer);
        tp.add("Cancel", panelSeller);
        tp.setFont(new Font("Serif", Font.BOLD, 30));

        //Frame
        frame.add(bBack);
        frame.add(lExplanation);
        frame.add(tp);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuSeller();
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
