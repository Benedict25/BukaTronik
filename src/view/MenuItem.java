/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerItem;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.GadgetType;
import model.Item;

/**
 *
 * @author Ignatius Dariel
 */
public class MenuItem {

    public void mainMenuItemSeller() {
        JFrame frameMenuItem = new JFrame();
        frameMenuItem.setSize(500, 600);

    }

    public void seeItemSeller() {
        JFrame frameSeeItem = new JFrame("See Item Seller");
        frameSeeItem.setSize(390, 1000);

        ArrayList<Item> itemList = new ControllerItem().getSellerItemsData();
        int y = 90;

        JButton bAddItem = new JButton("Add Item");
        bAddItem.setBounds(145, 20, 100, 50);

        bAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAddItem();
                frameSeeItem.setVisible(false);
            }
        });

        for (int i = 0; i < itemList.size(); i++) {
            JLabel lItemName, lItemWeight, lItemId, lItemPrice, lItemStocks, lItemCategory;
            JLabel itemName, itemWeight, itemId, itemPrice, itemStocks, itemCategory;
            JButton bEdit, bDelete;

            JPanel newPanel = new JPanel();
            newPanel.setBounds(25, y, 325, 125);
            newPanel.setBackground(new Color(150, 150, 150, 50)); //rgba ; a = %

            lItemId = new JLabel("Item Id: ");
            lItemId.setBounds(10, 0, 70, 25);
            lItemName = new JLabel("Item Name: ");
            lItemName.setBounds(10, 20, 70, 25);
            lItemWeight = new JLabel("Item Weight: ");
            lItemWeight.setBounds(10, 40, 100, 25);
            lItemPrice = new JLabel("Item Price: ");
            lItemPrice.setBounds(10, 60, 100, 25);
            lItemStocks = new JLabel("Item Stocks: ");
            lItemStocks.setBounds(10, 80, 100, 25);
            lItemCategory = new JLabel("Item Category: ");
            lItemCategory.setBounds(10, 100, 100, 25);

            itemId = new JLabel(String.valueOf(itemList.get(i).getIdItem()));
            itemId.setBounds(60, 0, 100, 25);
            itemName = new JLabel(itemList.get(i).getItemName());
            itemName.setBounds(80, 20, 100, 25);
            itemWeight = new JLabel(String.valueOf(itemList.get(i).getItemWeight()));
            itemWeight.setBounds(85, 40, 100, 25);
            itemPrice = new JLabel(String.valueOf(itemList.get(i).getPrice()));
            itemPrice.setBounds(75, 60, 100, 25);
            itemStocks = new JLabel(String.valueOf(itemList.get(i).getStocks()));
            itemStocks.setBounds(85, 80, 100, 25);
            itemCategory = new JLabel(String.valueOf(itemList.get(i).getCategory()));
            itemCategory.setBounds(95, 100, 100, 25);

            bEdit = new JButton("EDIT");
            bEdit.setBounds(210, 30, 75, 25);
            bDelete = new JButton("DELETE");
            bDelete.setBounds(195, 75, 100, 25);

            newPanel.add(lItemId);
            newPanel.add(lItemName);
            newPanel.add(lItemPrice);
            newPanel.add(lItemWeight);
            newPanel.add(lItemCategory);
            newPanel.add(lItemStocks);
            newPanel.add(itemId);
            newPanel.add(itemName);
            newPanel.add(itemPrice);
            newPanel.add(itemWeight);
            newPanel.add(itemCategory);
            newPanel.add(itemStocks);
            newPanel.add(bDelete);
            newPanel.add(bEdit);
            newPanel.setLayout(null);
            newPanel.setVisible(true);
            frameSeeItem.add(newPanel);

            bDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuDeleteItem(Integer.parseInt(itemId.getText()));
                    frameSeeItem.setVisible(false);
                }
            });

            bEdit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuEditItem(Integer.parseInt(itemId.getText()));
                    frameSeeItem.setVisible(false);
                }
            });
            y += 135;
        }
        frameSeeItem.add(bAddItem);
        frameSeeItem.setLayout(null);
        frameSeeItem.setVisible(true);
    }

    public void menuAddItem() {
        //Menu Add Item
        JFrame frameAddItem = new JFrame("Menu Add Item");
        frameAddItem.setSize(500, 600);

        JTextField tItemName = new JTextField();
        JLabel lItemName = new JLabel("Item Name: ");
        tItemName.setBounds(210, 75, 200, 25);
        lItemName.setBounds(65, 75, 200, 25);

        JTextField tPrice = new JTextField();
        JLabel lPrice = new JLabel("Item Price: ");
        tPrice.setBounds(210, 125, 200, 25);
        lPrice.setBounds(65, 125, 200, 25);

        JTextField tStocks = new JTextField();
        JLabel lStocks = new JLabel("Item Stocks: ");
        tStocks.setBounds(210, 175, 200, 25);
        lStocks.setBounds(65, 175, 200, 25);

        JRadioButton rLaptop = new JRadioButton("Laptop");
        rLaptop.setBounds(210, 225, 200, 25);

        JRadioButton rHandphone = new JRadioButton("Handphone");
        rHandphone.setBounds(210, 250, 200, 25);

        JRadioButton rAcc = new JRadioButton("Accessories");
        rAcc.setBounds(210, 275, 200, 25);

        JLabel lCategory = new JLabel("Category: ");
        lCategory.setBounds(65, 225, 200, 25);

        ButtonGroup rCategory = new ButtonGroup();
        rCategory.add(rAcc);
        rCategory.add(rHandphone);
        rCategory.add(rLaptop);

        JTextField tItemWeight = new JTextField();
        JLabel lItemWeight = new JLabel("Item Weight: ");
        tItemWeight.setBounds(210, 325, 200, 25);
        lItemWeight.setBounds(65, 325, 200, 25);

        JButton bSubmit = new JButton("Submit");
        bSubmit.setBounds(200, 375, 100, 40);
        JButton bBack = new JButton("Back");
        bBack.setBounds(40, 500, 70, 40);

        //Add components Add Item
        frameAddItem.add(tItemName);
        frameAddItem.add(lItemName);
        frameAddItem.add(tPrice);
        frameAddItem.add(lPrice);
        frameAddItem.add(tStocks);
        frameAddItem.add(lStocks);
        frameAddItem.add(rLaptop);
        frameAddItem.add(rHandphone);
        frameAddItem.add(rAcc);
        frameAddItem.add(lCategory);
        frameAddItem.add(tItemWeight);
        frameAddItem.add(lItemWeight);
        frameAddItem.add(bSubmit);
        frameAddItem.add(bBack);

        //Button function Add Item
        bSubmit.addActionListener(new ActionListener() {
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
                seeItemSeller();
                frameAddItem.setVisible(false);
            }
        });

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seeItemSeller();
                frameAddItem.setVisible(false);
            }
        });

        frameAddItem.setLayout(null);
        frameAddItem.setVisible(true);
    }

    public void menuDeleteItem(int idItem) {
        //Menu Delete Item
        JFrame frameDeleteItem = new JFrame("Menu Delete Item");
        frameDeleteItem.setSize(400, 300);

        Item currentItem = new ControllerItem().getDataItemByID(idItem);

        JLabel lIdItemDelete = new JLabel("Apakah anda yakin ingin menghapus \nitem id: " + currentItem.getIdItem());
        lIdItemDelete.setBounds(50, 40, 300, 70);
        JLabel lNamaItem = new JLabel("Item Name: " + currentItem.getItemName());
        lNamaItem.setBounds(125, 70, 150, 70);

        JButton bDelete = new JButton("Submit DELETE");
        bDelete.setBounds(115, 130, 150, 40);
        JButton bBack = new JButton("Back");
        bBack.setBounds(140, 190, 100, 40);

        //Add components Delete Item
        frameDeleteItem.add(lIdItemDelete);
        frameDeleteItem.add(lNamaItem);
        frameDeleteItem.add(bDelete);
        frameDeleteItem.add(bBack);

        //Button function Delete Item
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seeItemSeller();
                frameDeleteItem.setVisible(false);
            }
        });

        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ControllerItem().deleteSellerItem(currentItem.getIdItem());
                seeItemSeller();
                frameDeleteItem.setVisible(false);
            }
        });

        frameDeleteItem.setLayout(null);
        frameDeleteItem.setVisible(true);
    }

    public void menuEditItem(int idItem) {
        //Edit Item
        JFrame frameEditItem = new JFrame("Menu Edit Item");
        frameEditItem.setSize(500, 600);

        Item currentItem = new ControllerItem().getDataItemByID(idItem);

        JTextField tIdEditItem = new JTextField(String.valueOf(currentItem.getIdItem()));
        JLabel lIdEditItem = new JLabel("Id item : ");
        tIdEditItem.setBounds(210, 75, 200, 25);
        lIdEditItem.setBounds(65, 75, 200, 25);

        JTextField tNewItemName = new JTextField(currentItem.getItemName());
        JLabel lNewItemName = new JLabel("Item Name: ");
        tNewItemName.setBounds(210, 125, 200, 25);
        lNewItemName.setBounds(65, 125, 200, 25);

        JTextField tNewPrice = new JTextField(String.valueOf(currentItem.getPrice()));
        JLabel lNewPrice = new JLabel("Item Price: ");
        tNewPrice.setBounds(210, 175, 200, 25);
        lNewPrice.setBounds(65, 175, 200, 25);

        JTextField tNewStocks = new JTextField(String.valueOf(currentItem.getStocks()));
        JLabel lNewStocks = new JLabel("Item Stocks: ");
        tNewStocks.setBounds(210, 225, 200, 25);
        lNewStocks.setBounds(65, 225, 200, 25);

        JTextField tNewItemWeight = new JTextField(String.valueOf(currentItem.getItemWeight()));
        JLabel lNewItemWeight = new JLabel("Item Weight: ");
        tNewItemWeight.setBounds(210, 375, 200, 25);
        lNewItemWeight.setBounds(65, 375, 200, 25);

        //Untuk menentukan category yang terpilih di radio button
        boolean cLaptop = false, cHandphone = false, cAcc = false;
        if (currentItem.getCategory().equals(GadgetType.LAPTOP)) {
            cLaptop = true;
        } else if (currentItem.getCategory().equals(GadgetType.HANDPHONE)) {
            cHandphone = true;
        } else if (currentItem.getCategory().equals(GadgetType.ACC)) {
            cAcc = true;
        }

        JRadioButton rNewLaptop = new JRadioButton("Laptop", cLaptop);
        rNewLaptop.setBounds(210, 275, 200, 25);

        JRadioButton rNewHandphone = new JRadioButton("Handphone", cHandphone);
        rNewHandphone.setBounds(210, 300, 200, 25);

        JRadioButton rNewAcc = new JRadioButton("Accessories", cAcc);
        rNewAcc.setBounds(210, 325, 200, 25);

        JLabel lNewCategory = new JLabel("Category: ");
        lNewCategory.setBounds(65, 275, 200, 25);

        ButtonGroup rNewCategory = new ButtonGroup();
        rNewCategory.add(rNewAcc);
        rNewCategory.add(rNewHandphone);
        rNewCategory.add(rNewLaptop);

        JButton bEditItem = new JButton("Submit");
        bEditItem.setBounds(200, 450, 100, 25);

        JButton bBack = new JButton("Back");
        bBack.setBounds(50, 500, 100, 25);

        //Add components Edit Item
        frameEditItem.add(tIdEditItem);
        frameEditItem.add(lIdEditItem);
        frameEditItem.add(tNewItemName);
        frameEditItem.add(lNewItemName);
        frameEditItem.add(tNewPrice);
        frameEditItem.add(lNewPrice);
        frameEditItem.add(tNewStocks);
        frameEditItem.add(lNewStocks);
        frameEditItem.add(rNewLaptop);
        frameEditItem.add(rNewHandphone);
        frameEditItem.add(rNewAcc);
        frameEditItem.add(lNewCategory);
        frameEditItem.add(tNewItemWeight);
        frameEditItem.add(lNewItemWeight);
        frameEditItem.add(bEditItem);
        frameEditItem.add(bBack);

        //Button function Edit Item
        bEditItem.addActionListener(new ActionListener() {
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
                seeItemSeller();
                frameEditItem.setVisible(false);
            }
        });

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seeItemSeller();
                frameEditItem.setVisible(false);
            }
        });

        frameEditItem.setLayout(null);
        frameEditItem.setVisible(true);
    }

    public void menuItemForBuyer() {
        JFrame buyerMenuFrame = new JFrame("Buyer Menu");
        buyerMenuFrame.setSize(700, 800);

        buyerMenuFrame.setLayout(null);
        buyerMenuFrame.setVisible(true);
    }

}
