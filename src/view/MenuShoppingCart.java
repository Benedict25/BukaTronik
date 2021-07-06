/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Item;
import controller.ControllerShoppingCart;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import model.ItemInShoppingCart;
import model.Person;

/**
 *
 * @author Matthew
 */
public class MenuShoppingCart {

    ControllerShoppingCart controlShoppingCart = new ControllerShoppingCart();

    public void MenuSeeShoppingCart() {
        ArrayList<ItemInShoppingCart> arrShoppingCart = new ArrayList();
        arrShoppingCart = controlShoppingCart.getShoppingCartData();

        ArrayList<Item> arrItem = new ArrayList();
        arrItem = controlShoppingCart.getItemDataForShoppingCart(arrShoppingCart);
        
        ArrayList<Person> arrPerson = new ArrayList();
        arrPerson = controlShoppingCart.getSellerData(arrItem);

        JFrame frame = new JFrame("Shopping Cart");
        frame.setSize(450, 1000);

        JButton bBack = new JButton("Back");
        bBack.setBounds(160, 10, 100, 50);
        frame.add(bBack);

        bBack.addActionListener((ActionEvent e) -> {
            new MainMenuBuyer();
            frame.setVisible(false);
        });

        int y = 100;

        for (int i = 0; i < arrItem.size(); i++) {
            JLabel litemName, lQuantity, lSeller, lHarga;
            JLabel Quantity, itemName, Seller, Harga;
            JButton bRemove, bQuantity;

            JPanel panel = new JPanel();
            panel.setBounds(15, y, 400, 110);
            panel.setBackground(Color.gray);

            litemName = new JLabel("Item Name : ");
            litemName.setBounds(25, 0, 150, 25);
            lQuantity = new JLabel("Quantity : ");
            lQuantity.setBounds(25, 20, 150, 25);
            lHarga = new JLabel("Harga : ");
            lHarga.setBounds(25, 40, 150, 25);
            lSeller = new JLabel("Seller : ");
            lSeller.setBounds(25, 60, 150, 25);

            itemName = new JLabel(String.valueOf(arrItem.get(i).getItemName()));
            itemName.setBounds(120, 0, 100, 25);
            Quantity = new JLabel(String.valueOf(arrShoppingCart.get(i).getQuantity()));
            Quantity.setBounds(120, 20, 100, 25);
            Harga = new JLabel(String.valueOf(arrItem.get(i).getPrice()));
            Harga.setBounds(120, 40, 100, 25);
            Seller = new JLabel(arrPerson.get(i).getName());
            Seller.setBounds(120, 60, 100, 25);

            bRemove = new JButton("Remove");
            bRemove.setBounds(220, 20, 140, 25);
            bQuantity = new JButton("Change quantity");
            bQuantity.setBounds(220, 60, 140, 25);

            panel.add(litemName);
            panel.add(lQuantity);
            panel.add(lHarga);
            panel.add(lSeller);
            
            panel.add(itemName);
            panel.add(Quantity);
            panel.add(Harga);
            panel.add(Seller);

            panel.add(bRemove);
            panel.add(bQuantity);

            frame.add(panel);

            JLabel id = new JLabel(String.valueOf(arrShoppingCart.get(i).getIdItem()));

            /*remove data*/
            bRemove.addActionListener((ActionEvent e) -> {
                MenuRemoveFromShoppingCart(Integer.parseInt(id.getText()),itemName.getText());
                frame.setVisible(false);
            });

            /*Change Quantity*/
            bQuantity.addActionListener((ActionEvent e) -> {
                MenuChangeQuantity(Integer.parseInt(id.getText()), Integer.parseInt(Quantity.getText()));
                frame.setVisible(false);
            });

            panel.setLayout(null);
            panel.setVisible(true);

            y += 125;
        }

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void MenuChangeQuantity(int id, int quantity) {
        JFrame frame = new JFrame();
        frame.setSize(500, 100);

        JLabel Jquantity = new JLabel("Quantity : ");
        Jquantity.setBounds(25, 10, 100, 25);

        SpinnerModel value = new SpinnerNumberModel(quantity, 0, 10, 1); //step  
        JSpinner Squantity = new JSpinner(value);
        Squantity.setBounds(100, 10, 60, 35);

        JButton bSubmit = new JButton("Submit Quantity");
        bSubmit.setBounds(200, 10, 130, 25);

        JButton bBack = new JButton("Back");
        bBack.setBounds(350, 10, 100, 25);

        /*add frame*/
        frame.add(Jquantity);
        frame.add(Squantity);

        frame.add(bSubmit);
        frame.add(bBack);

        /*change quantity*/
        bSubmit.addActionListener((ActionEvent e) -> {

            new ControllerShoppingCart().changeQuantity((int) Squantity.getValue(), id);
        });

        /*Back*/
        bBack.addActionListener((ActionEvent e) -> {

            MenuSeeShoppingCart();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public void MenuRemoveFromShoppingCart(int id, String itemName) {
        JFrame frame = new JFrame();
        frame.setSize(400, 200);

        JLabel jLabel1 = new JLabel("Kamu yakin mau delete ini :");
        jLabel1.setBounds(120, 10, 200, 25);

        JLabel jItemName = new JLabel(itemName);
        jItemName.setBounds(120, 40, 100, 25);
        
        JLabel jLabel2 = new JLabel("dari keranjang kamu ?");
        jLabel2.setBounds(120, 70, 200, 25);

        JButton bSubmit = new JButton("Yes");
        bSubmit.setBounds(80, 120, 70, 25);

        JButton bBack = new JButton("No");
        bBack.setBounds(200, 120, 70, 25);

        /*add frame*/
        frame.add(jLabel1);
        frame.add(jLabel2);
        frame.add(jItemName);

        frame.add(bSubmit);
        frame.add(bBack);

        /*Yes*/
        bSubmit.addActionListener((ActionEvent e) -> {
            new ControllerShoppingCart().removeFromShoppingCart(id);
        });

        /*No*/
        bBack.addActionListener((ActionEvent e) -> {
            MenuSeeShoppingCart();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}


