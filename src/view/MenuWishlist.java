/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.Wishlist;
import controller.ControllerWishlist;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Item;

/**
 *
 * @author Benedict
 */
public class MenuWishlist {

    ControllerWishlist controlWishlist = new ControllerWishlist();

    public void seeWishlist() {
        ArrayList<Wishlist> arrWishlist = new ArrayList();
        arrWishlist = controlWishlist.getWishlistData();

        ArrayList<Item> arrItem = new ArrayList();
        arrItem = controlWishlist.getItemDataForWishlist(arrWishlist);

        JFrame frame = new JFrame("My Wishlist");
        frame.setSize(1500, 1000);

        JButton bBack = new JButton("Back");
        bBack.setBounds(500, 10, 500, 70);
        bBack.setFont(new Font("Serif", Font.BOLD, 40));
        frame.add(bBack);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuBuyer();
                frame.setVisible(false);
            }
        });

        int panelCounter = 0; //print kepinggir, kalau udh 4 -> kebawah
        int x = 10;
        int y = 100;

        for (int i = 0; i < arrItem.size(); i++) {

            JLabel lItemName, lPrice, lStock;
            JLabel itemName, price, stock;

            JPanel panel = new JPanel();
            panel.setBounds(x, y, 350, 105);
            panel.setBackground(new Color(150, 150, 150, 50));

            lItemName = new JLabel("Name: ");
            lItemName.setBounds(30, 20, 100, 25);
            lPrice = new JLabel("Price: ");
            lPrice.setBounds(30, 40, 100, 25);
            lStock = new JLabel("Stock: ");
            lStock.setBounds(30, 60, 100, 25);

            itemName = new JLabel(arrItem.get(i).getItemName());
            itemName.setBounds(90, 20, 100, 25);
            price = new JLabel(arrItem.get(i).getFormattedPrice());
            price.setBounds(90, 40, 100, 25);
            stock = new JLabel(String.valueOf(arrItem.get(i).getStocks()));
            stock.setBounds(90, 60, 100, 25);

            JButton bCheckItem = new JButton("Check Item");
            bCheckItem.setBounds(220, 20, 120, 25);
            JButton bDelete = new JButton("Remove");
            bDelete.setBounds(220, 60, 120, 25);

            panel.add(lItemName);
            panel.add(lPrice);
            panel.add(lStock);
            panel.add(itemName);
            panel.add(price);
            panel.add(stock);
            panel.add(bCheckItem);
            panel.add(bDelete);

            panel.setLayout(null);
            panel.setVisible(true);

            JLabel idItem = new JLabel(String.valueOf(arrItem.get(i).getIdItem()));

            bCheckItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MenuIndividualItem().ShowIndividualData(Integer.parseInt(idItem.getText()));
                    frame.setVisible(false);
                }
            });

            bDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeFromWishlist(Integer.parseInt(idItem.getText()), itemName.getText());
                    frame.setVisible(false);
                }
            });

            frame.add(panel);

            x += 370;
            panelCounter++;
            if (panelCounter == 4) {
                x = 10; //reset x
                y += 125; //y kebawah
            }
        }

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void removeFromWishlist(int idWishlist, String itemName) {
        JFrame frame = new JFrame("Remove From Wishlist");
        frame.setSize(400, 300);
        JLabel lKonfirmasi, lidWishlist, lItemName;

        lKonfirmasi = new JLabel("Remove From Wishlist?");
        lKonfirmasi.setBounds(123, 25, 400, 25);
        lItemName = new JLabel("Item Name: " + itemName);
        lItemName.setBounds(125, 75, 200, 25);

        JButton bRemove = new JButton("Yes Remove!");
        bRemove.setBounds(115, 125, 150, 40);

        JButton bBack = new JButton("Back");
        bBack.setBounds(140, 185, 100, 40);

        frame.add(lKonfirmasi);
        frame.add(lItemName);
        frame.add(bRemove);
        frame.add(bBack);

        lidWishlist = new JLabel(String.valueOf(idWishlist)); //invisible

        bRemove.addActionListener((ActionEvent e) -> {
            boolean result = controlWishlist.removeFromWishlist(Integer.parseInt(lidWishlist.getText()));
            new MenuResult().menuResultRemoveFromWishlist(result, itemName);
            frame.setVisible(false);
        });

        bBack.addActionListener((ActionEvent e) -> {
            seeWishlist();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void addToWishlist(int idItem, String itemName) {
        JFrame frame = new JFrame("Confirmation");
        frame.setSize(400, 360);
        JLabel lConfirmation, lItemName;
        JButton bAdd, bBack;

        lConfirmation = new JLabel("Add To Wishlist?");
        lConfirmation.setBounds(100, 50, 200, 50);
        lConfirmation.setFont(new Font("Serif", Font.BOLD, 25));
        lItemName = new JLabel("Name: " + itemName);
        lItemName.setBounds(100, 90, 200, 100);
        lItemName.setFont(new Font("Serif", Font.BOLD, 25));

        bAdd = new JButton("Yes!");
        bAdd.setBounds(75, 200, 100, 50);
        bAdd.setFont(new Font("Serif", Font.BOLD, 25));
        bBack = new JButton("Back");
        bBack.setBounds(225, 200, 100, 50);
        bBack.setFont(new Font("Serif", Font.BOLD, 25));

        frame.add(lConfirmation);
        frame.add(lItemName);
        frame.add(bAdd);
        frame.add(bBack);

        JLabel invisibleIDItem = new JLabel(String.valueOf(idItem));

        bAdd.addActionListener((ActionEvent e) -> {
            boolean result = controlWishlist.addToWishlist(Integer.parseInt(invisibleIDItem.getText()));
            new MenuResult().menuResultAddToWishlist(result, itemName);
            frame.setVisible(false);
        });

        bBack.addActionListener((ActionEvent e) -> {
            new MenuIndividualItem().ShowIndividualData(Integer.parseInt(invisibleIDItem.getText())); //back to menu individual item
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

}
