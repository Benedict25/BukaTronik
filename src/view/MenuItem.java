/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import model.GadgetType;
import model.Item;

/**
 *
 * @author Ignatius Dariel
 */
public class MenuItem {
    
    public void MenuItemForSeller() {
        JFrame sellerMenuFrame = new JFrame("Seller Menu");
        sellerMenuFrame.setSize(700, 800);

        //Menu Add Item
        JPanel panelAddItem = new JPanel();
        
        JTextField tItemName = new JTextField();
        JLabel lItemName = new JLabel("Item Name: ");
        tItemName.setBounds(210, 125, 200, 25);
        lItemName.setBounds(65, 125, 200, 25);
        
        JTextField tPrice = new JTextField();
        JLabel lPrice = new JLabel("Item Price: ");
        tPrice.setBounds(210, 175, 200, 25);
        lPrice.setBounds(65, 175, 200, 25);
        
        JTextField tStocks = new JTextField();
        JLabel lStocks = new JLabel("Item Stocks: ");
        tStocks.setBounds(210, 225, 200, 25);
        lStocks.setBounds(65, 225, 200, 25);
        
        JRadioButton rLaptop = new JRadioButton("Laptop");
        rLaptop.setBounds(210, 275, 200, 25);
        
        JRadioButton rHandphone = new JRadioButton("Handphone");
        rHandphone.setBounds(210, 300, 200, 25);
        
        JRadioButton rAcc = new JRadioButton("Accessories");
        rAcc.setBounds(210, 325, 200, 25);
        
        JLabel lCategory = new JLabel("Category: ");
        lCategory.setBounds(65, 275, 200, 25);
        
        ButtonGroup rCategory = new ButtonGroup();
        rCategory.add(rAcc);
        rCategory.add(rHandphone);
        rCategory.add(rLaptop);
        
        JTextField tItemWeight = new JTextField();
        JLabel lItemWeight = new JLabel("Item Weight: ");
        tItemWeight.setBounds(210, 375, 200, 25);
        lItemWeight.setBounds(65, 375, 200, 25);
        
        JButton submitAddItem = new JButton("Submit");
        submitAddItem.setBounds(200, 450, 100, 25);

        //Add components Add Item
        panelAddItem.add(tItemName);
        panelAddItem.add(lItemName);
        panelAddItem.add(tPrice);
        panelAddItem.add(lPrice);
        panelAddItem.add(tStocks);
        panelAddItem.add(lStocks);
        panelAddItem.add(rLaptop);
        panelAddItem.add(rHandphone);
        panelAddItem.add(rAcc);
        panelAddItem.add(lCategory);
        panelAddItem.add(tItemWeight);
        panelAddItem.add(lItemWeight);
        panelAddItem.add(submitAddItem);

        //Button function Add Item
        submitAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item newItem = new Item();
                newItem.setItemName(tItemName.getText());
                newItem.setPrice(Integer.parseInt(tPrice.getText()));
                newItem.setStocks(Integer.parseInt(tStocks.getText()));
                if (rLaptop.isSelected()) {
                    newItem.setCategory(GadgetType.LAPTOP);
                } else if (rHandphone.isSelected()) {
                    newItem.setCategory(GadgetType.HANDPHONE);
                } else if (rAcc.isSelected()) {
                    newItem.setCategory(GadgetType.ACC);
                }
                newItem.setItemWeight(Integer.parseInt(tItemWeight.getText()));
                new ControllerItem().insertSellerItem(newItem);
            }
        });
        
        //Menu See Item

        //Menu Delete Item
        JPanel panelDeleteItem = new JPanel();
        
        JTextField tIdItemDelete = new JTextField();
        JLabel lIdItemDelete = new JLabel("Masukkan id item yang ingin di delete: ");
        tIdItemDelete.setBounds(140, 250, 200, 25);
        lIdItemDelete.setBounds(135, 200, 400, 25);
        
        JButton submitDeleteItem = new JButton("Submit");
        submitDeleteItem.setBounds(165, 300, 150, 40);

        //Add components Delete Item
        panelDeleteItem.add(tIdItemDelete);
        panelDeleteItem.add(lIdItemDelete);
        panelDeleteItem.add(submitDeleteItem);

        //Button function Delete Item
        submitDeleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idItemDelete = Integer.parseInt(tIdItemDelete.getText());
                new ControllerItem().deleteSellerItem(idItemDelete);
            }
        });

        //Edit Item
        JPanel panelEditItem = new JPanel();
        
        JTextField tIdEditItem = new JTextField();
        JLabel lIdEditItem = new JLabel("Id item : ");
        tIdEditItem.setBounds(210, 75, 200, 25);
        lIdEditItem.setBounds(65, 75, 200, 25);
        
        JTextField tNewItemName = new JTextField();
        JLabel lNewItemName = new JLabel("Item Name: ");
        tNewItemName.setBounds(210, 125, 200, 25);
        lNewItemName.setBounds(65, 125, 200, 25);
        
        JTextField tNewPrice = new JTextField();
        JLabel lNewPrice = new JLabel("Item Price: ");
        tNewPrice.setBounds(210, 175, 200, 25);
        lNewPrice.setBounds(65, 175, 200, 25);
        
        JTextField tNewStocks = new JTextField();
        JLabel lNewStocks = new JLabel("Item Stocks: ");
        tNewStocks.setBounds(210, 225, 200, 25);
        lNewStocks.setBounds(65, 225, 200, 25);
        
        JRadioButton rNewLaptop = new JRadioButton("Laptop");
        rNewLaptop.setBounds(210, 275, 200, 25);
        
        JRadioButton rNewHandphone = new JRadioButton("Handphone");
        rNewHandphone.setBounds(210, 300, 200, 25);
        
        JRadioButton rNewAcc = new JRadioButton("Accessories");
        rNewAcc.setBounds(210, 325, 200, 25);
        
        JLabel lNewCategory = new JLabel("Category: ");
        lNewCategory.setBounds(65, 275, 200, 25);
        
        ButtonGroup rNewCategory = new ButtonGroup();
        rNewCategory.add(rNewAcc);
        rNewCategory.add(rNewHandphone);
        rNewCategory.add(rNewLaptop);
        
        JTextField tNewItemWeight = new JTextField();
        JLabel lNewItemWeight = new JLabel("Item Weight: ");
        tNewItemWeight.setBounds(210, 375, 200, 25);
        lNewItemWeight.setBounds(65, 375, 200, 25);
        
        JButton submitEditItem = new JButton("Submit");
        submitEditItem.setBounds(200, 450, 100, 25);

        //Add components Edit Item
        panelEditItem.add(tIdEditItem);
        panelEditItem.add(lIdEditItem);
        panelEditItem.add(tNewItemName);
        panelEditItem.add(lNewItemName);
        panelEditItem.add(tNewPrice);
        panelEditItem.add(lNewPrice);
        panelEditItem.add(tNewStocks);
        panelEditItem.add(lNewStocks);
        panelEditItem.add(rNewLaptop);
        panelEditItem.add(rNewHandphone);
        panelEditItem.add(rNewAcc);
        panelEditItem.add(lNewCategory);
        panelEditItem.add(tNewItemWeight);
        panelEditItem.add(lNewItemWeight);
        panelEditItem.add(submitEditItem);

        //Button function Edit Item
        submitEditItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item newItem = new Item();
                newItem.setIdItem(Integer.parseInt(tIdEditItem.getText()));
                newItem.setItemName(tNewItemName.getText());
                newItem.setPrice(Integer.parseInt(tNewPrice.getText()));
                newItem.setStocks(Integer.parseInt(tNewStocks.getText()));
                if (rNewLaptop.isSelected()) {
                    newItem.setCategory(GadgetType.LAPTOP);
                } else if (rNewHandphone.isSelected()) {
                    newItem.setCategory(GadgetType.HANDPHONE);
                } else if (rNewAcc.isSelected()) {
                    newItem.setCategory(GadgetType.ACC);
                }
                newItem.setItemWeight(Integer.parseInt(tNewItemWeight.getText()));
                new ControllerItem().editSellerItem(newItem);
            }
        });
        
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(90, 60, 500, 600);
        tp.add("Add Item", panelAddItem);
        //tp.add see Items
        tp.add("Delete Item", panelDeleteItem);
        tp.add("Edit Item", panelEditItem);
        sellerMenuFrame.add(tp);
        
        panelAddItem.setLayout(null);
        panelDeleteItem.setLayout(null);
        panelEditItem.setLayout(null);
        sellerMenuFrame.setLayout(null);
        sellerMenuFrame.setVisible(true);
    }
    
    public void MenuItemForBuyer() {
        JFrame buyerMenuFrame = new JFrame("Buyer Menu");
        buyerMenuFrame.setSize(700, 800);
        
        buyerMenuFrame.setLayout(null);
        buyerMenuFrame.setVisible(true);
    }
    
}
