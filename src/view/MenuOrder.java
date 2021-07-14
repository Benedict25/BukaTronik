/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerItem;
import controller.ControllerPurchaseHistory;
import controller.ControllerPerson;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import model.DeliveryStatus;
import model.DetailedTransaction;
import model.Item;
import model.Person;
import model.Transaction;
import model.UserType;

/**
 *
 * @author Ignatius Dariel
 */
public class MenuOrder {

    public void seeOngoingOrder() { //bedanya dengan function seeOtherStatusOrder adalah disini ada button cancel order
        JFrame frameOrder = new JFrame("Ongoing Orders");
        frameOrder.setSize(390, 1000);
        JScrollPane scroll = new JScrollPane();
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        int y = 90;
        ArrayList<Transaction> arrTrans = new ControllerPurchaseHistory().catchArrOrder("PROCESSED");

        JLabel lHeading = new JLabel("Order - " + new ControllerPerson().getActivePersonUsername());
        lHeading.setBounds(25, 10, 300, 60);
        lHeading.setFont(new Font("Serif", Font.BOLD, 30));

        for (int i = 0; i < arrTrans.size(); i++) {
            JLabel lPayAmount, lcashback, lOrderId, lpurchaseDate, lCourType, lStatus;
            JLabel payAmount, cashback, orderId, purchaseDate, courType, status;
            JButton bDetails, bDelete;

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
            lStatus = new JLabel("Status: ");
            lStatus.setBounds(25, 100, 100, 25);

            orderId = new JLabel(String.valueOf(arrTrans.get(i).getIdTransaction()));
            orderId.setBounds(125, 0, 100, 25);
            payAmount = new JLabel(arrTrans.get(i).getFormattedPayAmount());
            payAmount.setBounds(125, 20, 200, 25);
            cashback = new JLabel(arrTrans.get(i).getFormattedCashback());
            cashback.setBounds(125, 40, 100, 25);
            purchaseDate = new JLabel(arrTrans.get(i).getPurchaseDate());
            purchaseDate.setBounds(125, 60, 100, 25);
            courType = new JLabel(String.valueOf(arrTrans.get(i).getCourierType()));
            courType.setBounds(125, 80, 100, 25);
            status = new JLabel(String.valueOf(arrTrans.get(i).getDeliveryStatus()));
            status.setBounds(125, 100, 100, 25);

            bDetails = new JButton("Details");
            bDetails.setBounds(240, 15, 75, 25);
            bDelete = new JButton("Cancel");
            bDelete.setBounds(240, 55, 75, 25);

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
            panel.add(lStatus);
            panel.add(status);
            panel.add(bDelete);
            panel.add(bDetails);

            frameOrder.add(panel);

            bDetails.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    seeDetailedOrder(Integer.parseInt(orderId.getText()), "seeOngoingOrder");
                    frameOrder.setVisible(false);
                }
            });

            bDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuCancelOrder(Integer.parseInt(orderId.getText()));
                    frameOrder.setVisible(false);
                }
            });

            panel.setLayout(null);
            panel.setVisible(true);

            y += 145;
        }

        JButton bBack = new JButton("Back");
        bBack.setBounds(25, 900, 100, 50);
        bBack.setFont(new Font("Serif", Font.BOLD, 30));

        frameOrder.add(bBack);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subMenuOrder();
                frameOrder.setVisible(false);
            }
        });
        frameOrder.add(scroll);
        frameOrder.add(lHeading);
        frameOrder.setLayout(null);
        frameOrder.setVisible(true);
    }

    public void seeOtherStatusOrder(String status) {
        JFrame framePurchaseHistory = new JFrame("Orders");
        framePurchaseHistory.setSize(390, 1000);
        int y = 90;
        ArrayList<Transaction> arrTrans = new ControllerPurchaseHistory().catchArrOrder(status);

        JLabel lHeading = new JLabel("Order - " + new ControllerPerson().getActivePersonUsername());
        lHeading.setBounds(25, 10, 300, 60);
        lHeading.setFont(new Font("Serif", Font.BOLD, 30));

        for (int i = 0; i < arrTrans.size(); i++) {
            JLabel lPayAmount, lcashback, lCourierType, lpurchaseDate, lStatus;
            JLabel payAmount, cashback, courierType, purchaseDate, showStatus;
            JButton bDetails;

            JPanel panel = new JPanel();
            panel.setBounds(25, y, 325, 105);
            panel.setBackground(new Color(150, 150, 150, 50)); //rgba ; a = %

            lCourierType = new JLabel("Order Id: ");
            lCourierType.setBounds(25, 0, 100, 25);
            lPayAmount = new JLabel("Pay Amount: ");
            lPayAmount.setBounds(25, 20, 100, 25);
            lcashback = new JLabel("Cashback: ");
            lcashback.setBounds(25, 40, 100, 25);
            lpurchaseDate = new JLabel("Purchase Date: ");
            lpurchaseDate.setBounds(25, 60, 100, 25);
            lStatus = new JLabel("Status: ");
            lStatus.setBounds(25, 80, 100, 25);

            courierType = new JLabel(String.valueOf(arrTrans.get(i).getIdTransaction()));
            courierType.setBounds(125, 0, 100, 25);
            payAmount = new JLabel(arrTrans.get(i).getFormattedPayAmount());
            payAmount.setBounds(125, 20, 200, 25);
            cashback = new JLabel(arrTrans.get(i).getFormattedCashback());
            cashback.setBounds(125, 40, 100, 25);
            purchaseDate = new JLabel(arrTrans.get(i).getPurchaseDate());
            purchaseDate.setBounds(125, 60, 100, 25);
            showStatus = new JLabel(String.valueOf(arrTrans.get(i).getDeliveryStatus()));
            showStatus.setBounds(125, 80, 100, 25);

            bDetails = new JButton("Details");
            bDetails.setBounds(240, 15, 75, 25);

            panel.add(lPayAmount);
            panel.add(payAmount);
            panel.add(lcashback);
            panel.add(cashback);
            panel.add(lCourierType);
            panel.add(courierType);
            panel.add(lpurchaseDate);
            panel.add(purchaseDate);
            panel.add(lStatus);
            panel.add(showStatus);
            panel.add(bDetails);

            framePurchaseHistory.add(panel);

            JLabel id = new JLabel(String.valueOf(arrTrans.get(i).getIdTransaction())); //invisible j label untuk menampung id

            bDetails.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    seeDetailedOrder(Integer.parseInt(id.getText()), "seeOtherStatusOrder");
                    framePurchaseHistory.setVisible(false);
                }
            });

            panel.setLayout(null);
            panel.setVisible(true);

            y += 125;
        }

        JButton bBack = new JButton("Back");
        bBack.setBounds(25, 900, 100, 50);
        bBack.setFont(new Font("Serif", Font.BOLD, 30));

        framePurchaseHistory.add(bBack);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subMenuOrder();
                framePurchaseHistory.setVisible(false);
            }
        });

        framePurchaseHistory.add(lHeading);
        framePurchaseHistory.setLayout(null);
        framePurchaseHistory.setVisible(true);
    }

    public void seeDetailedOrder(int idTransaction, String backPath) {
        JFrame frameOrder = new JFrame("See Detailed Orders");
        frameOrder.setSize(390, 1000);
        int y = 90;
        ArrayList<DetailedTransaction> arrDetailed = new ControllerPurchaseHistory().catchArrDetailed(idTransaction);
        ArrayList<Item> arrItemsInDetailed = new ControllerItem().getArrItemFromDetailed(arrDetailed);

        JButton bBack = new JButton("Back");
        bBack.setBounds(140, 20, 70, 40);

        for (int i = 0; i < arrItemsInDetailed.size(); i++) {
            JLabel lPrice, lStocks, lItemName, lCategory, lItemWeight, lQuantity;
            JLabel price, stocks, itemName, category, itemWeight, quantity;

            JPanel panel = new JPanel();
            panel.setBounds(25, y, 325, 130);
            panel.setBackground(new Color(150, 150, 150, 50)); //rgba ; a = %

            lItemName = new JLabel("Item Name: ");
            lItemName.setBounds(25, 0, 100, 25);
            lPrice = new JLabel("Pay Amount: ");
            lPrice.setBounds(25, 20, 100, 25);
            lStocks = new JLabel("Stocks: ");
            lStocks.setBounds(25, 40, 100, 25);
            lCategory = new JLabel("Category: ");
            lCategory.setBounds(25, 60, 100, 25);
            lItemWeight = new JLabel("Item Weight: ");
            lItemWeight.setBounds(25, 80, 100, 25);
            lQuantity = new JLabel("Quantity: ");
            lQuantity.setBounds(25, 100, 100, 25);

            itemName = new JLabel(String.valueOf(arrItemsInDetailed.get(i).getItemName()));
            itemName.setBounds(125, 0, 100, 25);
            price = new JLabel(arrItemsInDetailed.get(i).getFormattedPrice());
            price.setBounds(125, 20, 100, 25);
            stocks = new JLabel(String.valueOf(arrItemsInDetailed.get(i).getStocks()));
            stocks.setBounds(125, 40, 100, 25);
            category = new JLabel(new ControllerItem().strGadgetType(arrItemsInDetailed.get(i)));
            category.setBounds(125, 60, 100, 25);
            itemWeight = new JLabel(String.valueOf(arrItemsInDetailed.get(i).getItemWeight()) + "gram");
            itemWeight.setBounds(125, 80, 100, 25);
            quantity = new JLabel(String.valueOf(arrDetailed.get(i).getQuantity()));
            quantity.setBounds(125, 100, 100, 25);

            panel.add(lPrice);
            panel.add(price);
            panel.add(lStocks);
            panel.add(stocks);
            panel.add(lItemName);
            panel.add(itemName);
            panel.add(lCategory);
            panel.add(category);
            panel.add(lItemWeight);
            panel.add(itemWeight);
            panel.add(lQuantity);
            panel.add(quantity);

            frameOrder.add(panel);

            panel.setLayout(null);
            panel.setVisible(true);

            y += 155;
        }
        frameOrder.add(bBack);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //backpath untuk pengembalian menu (back button)
                if (backPath.equals("seeOngoingOrder")) {
                    subMenuOrder();
                } else if (backPath.equals("seeOtherStatusOrder")) {
                    subMenuOrder();
                } else if (backPath.equals("seeSalesHistory")) {
                    new MenuSalesHistory().seeSalesHistorySeller();
                } else if (backPath.equals("seeSalesAll")) {
                    new MenuSalesHistory().seeSalesHistoryAdmin();
                } else if (backPath.equals("manageOrder")) {
                    new MenuManageOrder().menuSeeOrder();
                }
                frameOrder.setVisible(false);
            }
        });

        frameOrder.setLayout(null);
        frameOrder.setVisible(true);
    }

    public void menuCancelOrder(int idTransaction) {
        JFrame frameCancelOrder = new JFrame("Menu Cancel Order");
        frameCancelOrder.setSize(400, 300);
        JLabel lKonfirmasi, lIdOrder, lKonfirmasiFee;
        JButton bCancelOrder;
        lKonfirmasi = new JLabel("Yakin Ingin Cancel Order ini?");
        lKonfirmasi.setBounds(100, 25, 400, 25);
        lIdOrder = new JLabel("Id Order: " + idTransaction);
        lIdOrder.setBounds(125, 55, 200, 25);
        lKonfirmasiFee = new JLabel("Fee Cancel: 10.000");
        lKonfirmasiFee.setBounds(125, 75, 200, 25);

        bCancelOrder = new JButton("Cancel Order!");
        bCancelOrder.setBounds(100, 125, 200, 40);

        JButton bBack = new JButton("Back");
        bBack.setBounds(165, 175, 70, 40);

        frameCancelOrder.add(lKonfirmasi);
        frameCancelOrder.add(lIdOrder);
        frameCancelOrder.add(lKonfirmasiFee);
        frameCancelOrder.add(bCancelOrder);
        frameCancelOrder.add(bBack);

        bCancelOrder.addActionListener((ActionEvent e) -> {
            boolean result = new ControllerPurchaseHistory().cancelOrder(idTransaction);
            new MenuResult().menuResultCancelOrderBuyer(result);
            frameCancelOrder.setVisible(false);
        });

        bBack.addActionListener((ActionEvent e) -> {
            seeOngoingOrder();
            frameCancelOrder.setVisible(false);
        });

        frameCancelOrder.setLayout(null);
        frameCancelOrder.setVisible(true);
    }

    public void subMenuOrder() {
        JFrame frame = new JFrame("Oders");
        frame.setSize(600, 650);

        JButton bProcessed, bCancelling, bDelivered, bCancelled, bBack;

        bProcessed = new JButton("Processed");
        bProcessed.setBounds(160, 50, 250, 75);
        bProcessed.setFont(new Font("Serif", Font.BOLD, 20));

        bCancelling = new JButton("Cancelling");
        bCancelling.setBounds(160, 150, 250, 75);
        bCancelling.setFont(new Font("Serif", Font.BOLD, 20));

        bDelivered = new JButton("Delivered");
        bDelivered.setBounds(160, 250, 250, 75);
        bDelivered.setFont(new Font("Serif", Font.BOLD, 20));

        bCancelled = new JButton("Cancelled");
        bCancelled.setBounds(160, 350, 250, 75);
        bCancelled.setFont(new Font("Serif", Font.BOLD, 20));

        bBack = new JButton("Back");
        bBack.setBounds(233, 470, 100, 75);
        bBack.setFont(new Font("Serif", Font.BOLD, 20));

        frame.add(bProcessed);
        frame.add(bCancelling);
        frame.add(bDelivered);
        frame.add(bCancelled);
        frame.add(bBack);

        bProcessed.addActionListener((ActionEvent e) -> {
            seeOngoingOrder();
            frame.setVisible(false);
        });

        bCancelling.addActionListener((ActionEvent e) -> {
            seeOtherStatusOrder(String.valueOf(DeliveryStatus.CANCELLING));
            frame.setVisible(false);
        });

        bDelivered.addActionListener((ActionEvent e) -> {
            seeOtherStatusOrder(String.valueOf(DeliveryStatus.DELIVERED));
            frame.setVisible(false);
        });

        bCancelled.addActionListener((ActionEvent e) -> {
            seeOtherStatusOrder(String.valueOf(DeliveryStatus.CANCELLED));
            frame.setVisible(false);
        });

        bBack.addActionListener((ActionEvent e) -> {
            new MainMenuBuyer();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
