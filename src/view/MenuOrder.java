/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerItem;
import controller.ControllerPurchaseHistory;
import controller.MainController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.DetailedTransaction;
import model.Item;
import model.Transaction;

/**
 *
 * @author Ignatius Dariel
 */
public class MenuOrder {

    public void seeOngoingOrder() {
        JFrame frameOrder = new JFrame("See Orders");
        frameOrder.setSize(390, 1000);
        int y = 90;
        ArrayList<Transaction> arrTrans = new ControllerPurchaseHistory().catchArrOrder("PROCESSED");

        JLabel lHeading = new JLabel("List Order " + new MainController().getActivePersonUsername());
        lHeading.setBounds(25, 10, 300, 60);
        lHeading.setFont(new Font("Serif", Font.BOLD, 40));

        for (int i = 0; i < arrTrans.size(); i++) {
            JLabel lPayAmount, lDiscount, lOrderId, lpurchaseDate, lCourType;
            JLabel payAmount, discount, orderId, purchaseDate, courType;
            JButton bDetails, bDelete;

            JPanel panel = new JPanel();
            panel.setBounds(25, y, 325, 105);
            panel.setBackground(new Color(150, 150, 150, 50)); //rgba ; a = %

            lOrderId = new JLabel("Order Id: ");
            lOrderId.setBounds(25, 0, 100, 25);
            lPayAmount = new JLabel("Pay Amount: ");
            lPayAmount.setBounds(25, 20, 100, 25);
            lDiscount = new JLabel("Discount: ");
            lDiscount.setBounds(25, 40, 100, 25);
            lpurchaseDate = new JLabel("Purchase Date: ");
            lpurchaseDate.setBounds(25, 60, 100, 25);
            lCourType = new JLabel("Cour Type: ");
            lCourType.setBounds(25, 80, 100, 25);

            orderId = new JLabel(String.valueOf(arrTrans.get(i).getIdTransaction()));
            orderId.setBounds(125, 0, 100, 25);
            payAmount = new JLabel(String.valueOf(arrTrans.get(i).getPayAmount()));
            payAmount.setBounds(125, 20, 100, 25);
            discount = new JLabel(String.valueOf(arrTrans.get(i).getDiscount()));
            discount.setBounds(125, 40, 100, 25);
            purchaseDate = new JLabel(arrTrans.get(i).getPurchaseDate());
            purchaseDate.setBounds(125, 60, 100, 30);
            courType = new JLabel(new ControllerPurchaseHistory().strCourType(arrTrans.get(i)));
            courType.setBounds(125, 80, 100, 30);

            bDetails = new JButton("Details");
            bDetails.setBounds(210, 15, 75, 25);
            bDelete = new JButton("Cancel");
            bDelete.setBounds(210, 55, 75, 25);

            panel.add(lPayAmount);
            panel.add(payAmount);
            panel.add(lDiscount);
            panel.add(discount);
            panel.add(lOrderId);
            panel.add(orderId);
            panel.add(lpurchaseDate);
            panel.add(purchaseDate);
            panel.add(lCourType);
            panel.add(courType);
            panel.add(bDelete);
            panel.add(bDetails);

            frameOrder.add(panel);

            JLabel id = new JLabel(String.valueOf(arrTrans.get(i).getIdTransaction())); //invisible j label untuk menampung id

            bDetails.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    seeDetailedOrder(Integer.parseInt(id.getText()), "seeOngoingOrder");
                    frameOrder.setVisible(false);
                }
            });

            bDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuCancelOrder(Integer.parseInt(id.getText()));
                    frameOrder.setVisible(false);
                }
            });

            panel.setLayout(null);
            panel.setVisible(true);

            y += 125;
        }

        frameOrder.add(lHeading);
        frameOrder.setLayout(null);
        frameOrder.setVisible(true);
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
            panel.setBounds(25, y, 325, 105);
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
            lQuantity.setBounds(200, 0, 100, 25);

            itemName = new JLabel(String.valueOf(arrItemsInDetailed.get(i).getItemName()));
            itemName.setBounds(125, 0, 100, 25);
            price = new JLabel(String.valueOf(arrItemsInDetailed.get(i).getPrice()));
            price.setBounds(125, 20, 100, 25);
            stocks = new JLabel(String.valueOf(arrItemsInDetailed.get(i).getStocks()));
            stocks.setBounds(125, 40, 100, 25);
            category = new JLabel(new ControllerItem().strGadgetType(arrItemsInDetailed.get(i)));
            category.setBounds(125, 60, 100, 25);
            itemWeight = new JLabel(String.valueOf(arrItemsInDetailed.get(i).getItemWeight()) + "g");
            itemWeight.setBounds(125, 80, 100, 25);
            quantity = new JLabel(String.valueOf(arrDetailed.get(i).getQuantity()));
            quantity.setBounds(260, 0, 100, 25);

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

            bBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (backPath.equals("seeOngoingOrder")) {
                        seeOngoingOrder();
                    } else if (backPath.equals("seePurchaseHistory")) {
                        seePurchaseHistory();
                    }
                    frameOrder.setVisible(false);
                }
            });

            panel.setLayout(null);
            panel.setVisible(true);

            y += 125;
        }
        frameOrder.add(bBack);
        frameOrder.setLayout(null);
        frameOrder.setVisible(true);
    }

    public void menuCancelOrder(int idTransaction) {
        JFrame frameCancelOrder = new JFrame("Delete Voucher");
        frameCancelOrder.setSize(400, 300);
        JLabel lKonfirmasi, lIdOrder, lKonfirmasiFee;

        lKonfirmasi = new JLabel("Yakin Ingin Hapus Order ini?");
        lKonfirmasi.setBounds(100, 25, 400, 25);
        lIdOrder = new JLabel("Id Order: " + idTransaction);
        lIdOrder.setBounds(125, 55, 200, 25);
        lKonfirmasiFee = new JLabel("Fee Cancel: 10.000");
        lKonfirmasiFee.setBounds(125, 75, 200, 25);

        JButton bDeleteVoucher = new JButton("Cancel Order!");
        bDeleteVoucher.setBounds(100, 125, 200, 40);

        JButton bBack = new JButton("Back");
        bBack.setBounds(165, 175, 70, 40);

        frameCancelOrder.add(lKonfirmasi);
        frameCancelOrder.add(lIdOrder);
        frameCancelOrder.add(lKonfirmasiFee);
        frameCancelOrder.add(bDeleteVoucher);
        frameCancelOrder.add(bBack);

        bDeleteVoucher.addActionListener((ActionEvent e) -> {
            new ControllerPurchaseHistory().cancelOrder(idTransaction);
            seeOngoingOrder();
            frameCancelOrder.setVisible(false);
        });

        bBack.addActionListener((ActionEvent e) -> {
            seeOngoingOrder();
            frameCancelOrder.setVisible(false);
        });

        frameCancelOrder.setLayout(null);
        frameCancelOrder.setVisible(true);
    }

    public void seePurchaseHistory() {
        JFrame framePurchaseHistory = new JFrame("History Orders");
        framePurchaseHistory.setSize(390, 1000);
        int y = 90;
        ArrayList<Transaction> arrTrans = new ControllerPurchaseHistory().catchArrOrder("DELIVERED");

        JLabel lHeading = new JLabel("History Order " + new MainController().getActivePersonUsername());
        lHeading.setBounds(25, 10, 300, 60);
        lHeading.setFont(new Font("Serif", Font.BOLD, 30));

        for (int i = 0; i < arrTrans.size(); i++) {
            JLabel lPayAmount, lDiscount, lCourierType, lpurchaseDate;
            JLabel payAmount, discount, courierType, purchaseDate;
            JButton bDetails;

            JPanel panel = new JPanel();
            panel.setBounds(25, y, 325, 105);
            panel.setBackground(new Color(150, 150, 150, 50)); //rgba ; a = %

            lCourierType = new JLabel("Order Id: ");
            lCourierType.setBounds(25, 0, 100, 25);
            lPayAmount = new JLabel("Pay Amount: ");
            lPayAmount.setBounds(25, 20, 100, 25);
            lDiscount = new JLabel("Discount: ");
            lDiscount.setBounds(25, 40, 100, 25);
            lpurchaseDate = new JLabel("Purchase Date: ");
            lpurchaseDate.setBounds(25, 60, 100, 25);

            courierType = new JLabel(String.valueOf(arrTrans.get(i).getIdTransaction()));
            courierType.setBounds(125, 0, 100, 25);
            payAmount = new JLabel(String.valueOf(arrTrans.get(i).getPayAmount()));
            payAmount.setBounds(125, 20, 100, 25);
            discount = new JLabel(String.valueOf(arrTrans.get(i).getDiscount()));
            discount.setBounds(125, 40, 100, 25);
            purchaseDate = new JLabel(arrTrans.get(i).getPurchaseDate());
            purchaseDate.setBounds(125, 60, 100, 30);

            bDetails = new JButton("Details");
            bDetails.setBounds(210, 15, 75, 25);

            panel.add(lPayAmount);
            panel.add(payAmount);
            panel.add(lDiscount);
            panel.add(discount);
            panel.add(lCourierType);
            panel.add(courierType);
            panel.add(lpurchaseDate);
            panel.add(purchaseDate);
            panel.add(bDetails);

            framePurchaseHistory.add(panel);

            JLabel id = new JLabel(String.valueOf(arrTrans.get(i).getIdTransaction())); //invisible j label untuk menampung id

            bDetails.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    seeDetailedOrder(Integer.parseInt(id.getText()), "seePurchaseHistory");
                    framePurchaseHistory.setVisible(false);
                }
            });

            panel.setLayout(null);
            panel.setVisible(true);

            y += 125;
        }

        framePurchaseHistory.add(lHeading);
        framePurchaseHistory.setLayout(null);
        framePurchaseHistory.setVisible(true);
    }
}