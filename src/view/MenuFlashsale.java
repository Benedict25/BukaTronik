/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerFlashsale;
import controller.ControllerItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Flashsale;
import model.Item;

/**
 *
 * @author Matthew
 */
public class MenuFlashsale {

    ControllerFlashsale controllerFlashsale = new ControllerFlashsale();
    MenuResult menuResult = new MenuResult();

    public void menuSeeFlashsaleForAdmin() { //bedanya dengan buyer adalah di seller ada edit delete
        ArrayList<Flashsale> arrFlashsale = new ArrayList();
        arrFlashsale = controllerFlashsale.getFlashsaleData();

        JButton bBack = new JButton("Back");
        bBack.setBounds(25, 20, 70, 50);

        JButton bCreate = new JButton("Create Flashsale");
        bCreate.setBounds(140, 20, 150, 50);

        JFrame frame = new JFrame("See Flashsale Admin");
        frame.setSize(450, 1000);

        int y = 100;

        frame.add(bBack);
        frame.add(bCreate);

        /*back to menu admin*/
        bBack.addActionListener((ActionEvent e) -> {
            new MainMenuAdmin();
            frame.setVisible(false);
        });

        /*Insert data*/
        bCreate.addActionListener((ActionEvent e) -> {
            menuInsertFlashsale();
            frame.setVisible(false);
        });

        for (int i = 0; i < arrFlashsale.size(); i++) {
            JLabel lidFlashsale, lidItem, ldiscountedPrice, lflashsaleStock, lendDate;
            JLabel idItem, discountedPrice, idFlashsale, endDate, flashsaleStock;
            JButton bEdit, bDelete;

            JPanel panel = new JPanel();
            panel.setBounds(15, y, 400, 110);
            panel.setBackground(Color.gray);

            lidFlashsale = new JLabel("Id Flashsale : ");
            lidFlashsale.setBounds(25, 0, 150, 25);
            lidItem = new JLabel("Id Item : ");
            lidItem.setBounds(25, 20, 150, 25);
            ldiscountedPrice = new JLabel("Discounted Price : ");
            ldiscountedPrice.setBounds(25, 40, 150, 25);
            lflashsaleStock = new JLabel("Flashsale Stock : ");
            lflashsaleStock.setBounds(25, 60, 150, 25);
            lendDate = new JLabel("End Date : ");
            lendDate.setBounds(25, 80, 150, 25);

            idFlashsale = new JLabel(String.valueOf(arrFlashsale.get(i).getIdFlashsale()));
            idFlashsale.setBounds(200, 0, 100, 25);
            idItem = new JLabel(String.valueOf(arrFlashsale.get(i).getIdItem()));
            idItem.setBounds(200, 20, 100, 25);
            discountedPrice = new JLabel(arrFlashsale.get(i).getFormattedDiscountPrice());
            discountedPrice.setBounds(200, 40, 100, 25);
            flashsaleStock = new JLabel(String.valueOf(arrFlashsale.get(i).getFlashsaleStock()));
            flashsaleStock.setBounds(200, 60, 100, 25);
            endDate = new JLabel(arrFlashsale.get(i).getEndDate());
            endDate.setBounds(200, 80, 100, 25);

            bEdit = new JButton("Edit");
            bEdit.setBounds(300, 20, 75, 25);
            bDelete = new JButton("Delete");
            bDelete.setBounds(300, 60, 75, 25);

            panel.add(lidFlashsale);
            panel.add(idFlashsale);
            panel.add(lidItem);
            panel.add(idItem);
            panel.add(ldiscountedPrice);
            panel.add(discountedPrice);
            panel.add(lflashsaleStock);
            panel.add(flashsaleStock);
            panel.add(lendDate);
            panel.add(endDate);

            panel.add(bEdit);
            panel.add(bDelete);

            frame.add(panel);

            JLabel id = new JLabel(String.valueOf(arrFlashsale.get(i).getIdFlashsale()));

            /*edit data*/
            bEdit.addActionListener((ActionEvent e) -> {
                menuEditFlashsale(Integer.parseInt(id.getText()));
                frame.setVisible(false);
            });

            /*delete data*/
            bDelete.addActionListener((ActionEvent e) -> {
                menuDeleteFlashsale(Integer.parseInt(id.getText()));
                frame.setVisible(false);
            });

            panel.setLayout(null);
            panel.setVisible(true);

            y += 125;
        }

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuInsertFlashsale() {
        JFrame frame = new JFrame("Menu Insert Flashsale");
        frame.setSize(500, 550);

        //P1 (Menu Add Flashsale)
        /*variable add*/
        JTextField addIdItem, addFlashsaleStock, addDiscountedPrice, addEndDate;
        JLabel JInsertIdItem, JInsertFlashsaleStock, JInsertDiscountedPrice, JInsertEndDate;

        /*frame posisition & text*/
        JInsertIdItem = new JLabel("input idItem : ");
        JInsertIdItem.setBounds(50, 100, 200, 25);
        addIdItem = new JTextField();
        addIdItem.setBounds(220, 100, 200, 25);

        JInsertFlashsaleStock = new JLabel("input flashsaleStock : ");
        JInsertFlashsaleStock.setBounds(50, 150, 200, 25);
        addFlashsaleStock = new JTextField();
        addFlashsaleStock.setBounds(220, 150, 200, 25);

        JInsertDiscountedPrice = new JLabel("input discountedPrice : ");
        JInsertDiscountedPrice.setBounds(50, 200, 200, 25);
        addDiscountedPrice = new JTextField();
        addDiscountedPrice.setBounds(220, 200, 200, 25);

        JInsertEndDate = new JLabel("input endDate (YYYY-MM-DD) : ");
        JInsertEndDate.setBounds(50, 250, 200, 25);
        addEndDate = new JTextField();
        addEndDate.setBounds(220, 250, 200, 25);

        JButton button = new JButton("Submit");
        button.setBounds(165, 300, 150, 30);
        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(165, 350, 150, 30);

        /*add frame*/
        frame.add(JInsertIdItem);
        frame.add(addIdItem);

        frame.add(JInsertFlashsaleStock);
        frame.add(addFlashsaleStock);

        frame.add(JInsertDiscountedPrice);
        frame.add(addDiscountedPrice);

        frame.add(JInsertEndDate);
        frame.add(addEndDate);

        frame.add(button);
        frame.add(buttonBack);

        /*add data*/
        button.addActionListener((ActionEvent e) -> {
            Flashsale newFlashsale = new Flashsale();
            newFlashsale.setIdItem(Integer.parseInt(addIdItem.getText()));
            newFlashsale.setFlashsaleStock(Integer.parseInt(addFlashsaleStock.getText()));
            newFlashsale.setDiscountedPrice(Integer.parseInt(addDiscountedPrice.getText()));
            newFlashsale.setEndDate(addEndDate.getText());

            boolean result = controllerFlashsale.insertFlashsale(newFlashsale);
            frame.setVisible(false);
            menuResult.menuResultCreateFlashsale(result, addIdItem.getText());
        });

        /*back*/
        buttonBack.addActionListener((ActionEvent e) -> {

            menuSeeFlashsaleForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuEditFlashsale(int idFlashsale) {
        JFrame frame = new JFrame("Menu Edit Flashsale");
        frame.setSize(500, 550);

        Flashsale flashsale = new Flashsale();
        flashsale = controllerFlashsale.getFlashsaleDataById(idFlashsale);

        //p2(Menu Edit Flashsale)
        /*variable update*/
        JTextField updateIdFlashsale, updateFlashsaleStock, updateDiscountedPrice, updateEndDate;
        JLabel JEditFlashsale, JEditFlashsaleStock, JEditDiscountedPrice, JEditEndDate;

        /*frame posisition & text*/
        JEditFlashsale = new JLabel("input idFlashsale : ");
        JEditFlashsale.setBounds(50, 100, 200, 25);
        updateIdFlashsale = new JTextField(String.valueOf(flashsale.getIdFlashsale()));
        updateIdFlashsale.setBounds(220, 100, 200, 25);

        JEditFlashsaleStock = new JLabel("input flashsaleStock : ");
        JEditFlashsaleStock.setBounds(50, 150, 200, 25);
        updateFlashsaleStock = new JTextField(String.valueOf(flashsale.getFlashsaleStock()));
        updateFlashsaleStock.setBounds(220, 150, 200, 25);

        JEditDiscountedPrice = new JLabel("input discountedPrice : ");
        JEditDiscountedPrice.setBounds(50, 200, 200, 25);
        updateDiscountedPrice = new JTextField(String.valueOf(flashsale.getDiscountedPrice()));
        updateDiscountedPrice.setBounds(220, 200, 200, 25);

        JEditEndDate = new JLabel("input endDate (YYYY-MM-DD) : ");
        JEditEndDate.setBounds(50, 250, 200, 25);
        updateEndDate = new JTextField(String.valueOf(flashsale.getEndDate()));
        updateEndDate.setBounds(220, 250, 200, 25);

        JButton button = new JButton("Edit Flashsale");
        button.setBounds(165, 300, 200, 30);
        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(165, 350, 150, 30);

        /*add frame*/
        frame.add(JEditFlashsale);
        frame.add(updateIdFlashsale);

        frame.add(JEditFlashsaleStock);
        frame.add(updateFlashsaleStock);

        frame.add(JEditDiscountedPrice);
        frame.add(updateDiscountedPrice);

        frame.add(JEditEndDate);
        frame.add(updateEndDate);

        frame.add(button);
        frame.add(buttonBack);

        JLabel id = new JLabel(String.valueOf(flashsale.getIdFlashsale()));

        /*edit data*/
        button.addActionListener((ActionEvent e) -> {
            Flashsale updateFlashsale = new Flashsale();
            updateFlashsale.setIdFlashsale(Integer.parseInt(updateIdFlashsale.getText()));
            updateFlashsale.setFlashsaleStock(Integer.parseInt(updateFlashsaleStock.getText()));
            updateFlashsale.setDiscountedPrice(Integer.parseInt(updateDiscountedPrice.getText()));
            updateFlashsale.setEndDate(updateEndDate.getText());

            boolean result = new ControllerFlashsale().editFlashsale(updateFlashsale);
            frame.setVisible(false);
            menuResult.menuResultEditFlashsale(result, updateIdFlashsale.getText());
        });

        /*back*/
        buttonBack.addActionListener((ActionEvent e) -> {

            menuSeeFlashsaleForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuDeleteFlashsale(int idFlashsale) {
        JFrame frame = new JFrame("Menu Delete Flashsale");
        frame.setSize(400, 150);

        //p3(Menu delete Flashsale)
        /*variable update*/
        JTextField deleteIdFlashsale;
        JLabel JdeleteIdFlashsale;

        /*frame posisition & text*/
        JdeleteIdFlashsale = new JLabel("input idFlashsale : ");
        JdeleteIdFlashsale.setBounds(20, 10, 150, 30);
        deleteIdFlashsale = new JTextField(String.valueOf(idFlashsale));
        deleteIdFlashsale.setBounds(140, 10, 200, 30);

        JButton button = new JButton("Submit");
        button.setBounds(50, 70, 95, 30);
        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(250, 70, 95, 30);

        /*add frame*/
        frame.add(JdeleteIdFlashsale);
        frame.add(deleteIdFlashsale);

        frame.add(button);
        frame.add(buttonBack);

        /*delete data*/
        button.addActionListener((ActionEvent e) -> {
            int inputDeleteFlashsale = Integer.parseInt(deleteIdFlashsale.getText());
            boolean result = controllerFlashsale.deleteFlashsale(inputDeleteFlashsale);
            frame.setVisible(false);
            menuResult.menuResultDeleteFlashsale(result, deleteIdFlashsale.getText());
        });

        /*back*/
        buttonBack.addActionListener((ActionEvent e) -> {

            menuSeeFlashsaleForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuSeeFlashsaleForBuyer() {
        JFrame frame = new JFrame("Flashsale Items !!!");
        frame.setSize(450, 1000);

        ArrayList<Flashsale> arrFlashsale = new ArrayList();
        arrFlashsale = controllerFlashsale.getFlashsaleData();

        ArrayList<Item> arrItem = new ArrayList();
        arrItem = controllerFlashsale.getItemDataForFlashsale(arrFlashsale);

        JButton bBack = new JButton("Back");
        bBack.setBounds(160, 10, 100, 50);
        frame.add(bBack);

        bBack.addActionListener((ActionEvent e) -> {
            new MainMenuBuyer();
            frame.setVisible(false);
        });

        int y = 100;

        for (int i = 0; i < arrItem.size(); i++) {
            JLabel lItemName, lPrice, lStock, lEndDate;
            JLabel itemName, price, stock, endDate;
            JButton bItemDetails;

            JPanel panel = new JPanel();
            panel.setBounds(15, y, 400, 65);
            panel.setBackground(new Color(150, 150, 150, 50));

            lItemName = new JLabel("Name: ");
            lItemName.setBounds(25, 0, 150, 25);
            lPrice = new JLabel("Price: ");
            lPrice.setBounds(25, 20, 150, 25);
            lStock = new JLabel("Stock: ");
            lStock.setBounds(25, 40, 100, 25);
            lEndDate = new JLabel("End Date: ");
            lEndDate.setBounds(25, 40, 100, 25);

            itemName = new JLabel(arrItem.get(i).getItemName());
            itemName.setBounds(100, 0, 100, 25);
            price = new JLabel(arrFlashsale.get(i).getFormattedDiscountPrice());
            price.setBounds(100, 20, 100, 25);
            stock = new JLabel(String.valueOf(arrFlashsale.get(i).getFlashsaleStock()));
            stock.setBounds(100, 40, 100, 25);
            endDate = new JLabel(String.valueOf(arrFlashsale.get(i).getEndDate()));
            endDate.setBounds(100, 40, 100, 25);

            bItemDetails = new JButton("Details");
            bItemDetails.setBounds(260, 20, 100, 25);

            panel.add(lItemName);
            panel.add(itemName);
            panel.add(lPrice);
            panel.add(price);
            panel.add(lStock);
            panel.add(stock);
            panel.add(bItemDetails);
            panel.setLayout(null);
            panel.setVisible(true);
            frame.add(panel);

            int itemId = arrItem.get(i).getIdItem();
            int idFlashsale = arrFlashsale.get(i).getIdFlashsale();

            bItemDetails.addActionListener((ActionEvent e) -> {
                menuShowIndividualDataItemFlashsale(itemId, idFlashsale);
                frame.setVisible(false);
            });

            y += 90;
        }
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void menuShowIndividualDataItemFlashsale(int idItem, int idFlashsale) {
        Item item = new Item();
        item = new ControllerItem().getDataItemByID(idItem);
        Flashsale flashsale = new Flashsale();
        flashsale = controllerFlashsale.getFlashsaleDataById(idFlashsale);
        JFrame frame = new JFrame("Detailed Info");
        frame.setSize(500, 575);
        JLabel lItemName, lPrice, lStock, lCategory, litemWeight;
        JLabel itemName, price, stock, category, itemWeight;
        JButton bBackToList, bBuy;

        lItemName = new JLabel("Name: ");
        lItemName.setBounds(120, 100, 150, 30);
        lItemName.setFont(new Font("Serif", Font.BOLD, 25));
        lPrice = new JLabel("Price: ");
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
        price = new JLabel(flashsale.getFormattedDiscountPrice());
        price.setBounds(200, 150, 300, 30);
        price.setFont(new Font("Serif", Font.BOLD, 25));
        stock = new JLabel(String.valueOf(flashsale.getFlashsaleStock()));
        stock.setBounds(200, 200, 150, 30);
        stock.setFont(new Font("Serif", Font.BOLD, 25));
        category = new JLabel(String.valueOf(item.getCategory()));
        category.setBounds(235, 250, 150, 30);
        category.setFont(new Font("Serif", Font.BOLD, 25));
        itemWeight = new JLabel(String.valueOf(item.getItemWeight()) + " gram");
        itemWeight.setBounds(270, 300, 150, 30);
        itemWeight.setFont(new Font("Serif", Font.BOLD, 25));

        bBackToList = new JButton("Back to Flashsale");
        bBackToList.setBounds(20, 370, 200, 40);
        bBackToList.setFont(new Font("Serif", Font.BOLD, 20));
        bBuy = new JButton("Buy");
        bBuy.setBounds(260, 370, 200, 40);
        bBuy.setFont(new Font("Serif", Font.BOLD, 20));

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
        frame.add(bBackToList);
        frame.add(bBuy);

//        JLabel invisibleIdItem = new JLabel(String.valueOf(idItem));
        bBackToList.addActionListener((ActionEvent e) -> {
            menuSeeFlashsaleForBuyer();
            frame.setVisible(false);
        });

        bBuy.addActionListener((ActionEvent e) -> {
            //langsung ngarah ke check out khusus flashsale
            new MenuCheckOutFlashsale().menuCheckOutCourierFlashsale(idItem, idFlashsale);
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);

    }
}
