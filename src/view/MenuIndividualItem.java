/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Item;
import controller.ControllerItem;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Benedict
 */
public class MenuIndividualItem {

    ControllerItem controlItem = new ControllerItem();

    public void ShowIndividualData(int idItem) {
        Item item = new Item();
        item = controlItem.getDataItemByID(idItem);
        JFrame frame = new JFrame("Detailed Info");
        frame.setSize(500, 485);
        JLabel lItemName, lPrice, lStock, lCategory, litemWeight;
        JLabel itemName, price, stock, category, itemWeight;
        JButton bSeeWishlist, bAddToWishlist, bBackToList, bAddToCart;

        lItemName = new JLabel("Name: ");
        lItemName.setBounds(120, 100, 150, 30);
        lItemName.setFont(new Font("Serif", Font.BOLD, 25));
        lPrice = new JLabel("Price: Rp. ");
        lPrice.setBounds(120, 150, 150, 30);
        lPrice.setFont(new Font("Serif", Font.BOLD, 25));
        lStock = new JLabel("Stock: ");
        lStock.setBounds(120, 200, 150, 30);
        lStock.setFont(new Font("Serif", Font.BOLD, 25));
        lCategory = new JLabel("Category: ");
        lCategory.setBounds(120, 250, 150, 30);
        lCategory.setFont(new Font("Serif", Font.BOLD, 25));
        litemWeight = new JLabel("Item Weight: ");
        litemWeight.setBounds(120, 300, 150, 30);
        litemWeight.setFont(new Font("Serif", Font.BOLD, 25));

        itemName = new JLabel(item.getItemName());
        itemName.setBounds(200, 100, 500, 30);
        itemName.setFont(new Font("Serif", Font.BOLD, 25));
        price = new JLabel(String.valueOf(item.getPrice()));
        price.setBounds(235, 150, 150, 30);
        price.setFont(new Font("Serif", Font.BOLD, 25));
        stock = new JLabel(String.valueOf(item.getStocks()));
        stock.setBounds(200, 200, 150, 30);
        stock.setFont(new Font("Serif", Font.BOLD, 25));
        category = new JLabel(String.valueOf(item.getCategory()));
        category.setBounds(235, 250, 150, 30);
        category.setFont(new Font("Serif", Font.BOLD, 25));
        itemWeight = new JLabel(String.valueOf(item.getItemWeight()));
        itemWeight.setBounds(270, 300, 150, 30);
        itemWeight.setFont(new Font("Serif", Font.BOLD, 25));

        bSeeWishlist = new JButton("My Wishlist");
        bSeeWishlist.setBounds(20, 30, 140, 40);
        bSeeWishlist.setFont(new Font("Serif", Font.BOLD, 20));
        bAddToWishlist = new JButton("+ Wishlist");
        bAddToWishlist.setBounds(315, 30, 140, 40);
        bAddToWishlist.setFont(new Font("Serif", Font.BOLD, 20));
        bBackToList = new JButton("Back to See Items");
        bBackToList.setBounds(20, 370, 200, 40);
        bBackToList.setFont(new Font("Serif", Font.BOLD, 20));
        bAddToCart = new JButton("+ Shopping Cart");
        bAddToCart.setBounds(260, 370, 200, 40);
        bAddToCart.setFont(new Font("Serif", Font.BOLD, 20));

        frame.add(lItemName);
        frame.add(lPrice);
        frame.add(lStock);
        frame.add(lCategory);
        frame.add(litemWeight);
        frame.add(itemName);
        frame.add(price);
        frame.add(stock);
        frame.add(category);
        frame.add(itemWeight);
        frame.add(bSeeWishlist);
        frame.add(bAddToWishlist);
        frame.add(bBackToList);
        frame.add(bAddToCart);

        JLabel invisibleIdItem = new JLabel(String.valueOf(idItem));

        bSeeWishlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuWishlist().seeWishlist();
                frame.setVisible(false);
            }
        });

        bAddToWishlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuWishlist().addToWishlist(Integer.parseInt(invisibleIdItem.getText()), itemName.getText());
                frame.setVisible(false);
            }
        });

        bBackToList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuItem().menuItemForBuyer();
                frame.setVisible(false);
            }
        });

        bAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.setVisible(false);
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);

    }
}
