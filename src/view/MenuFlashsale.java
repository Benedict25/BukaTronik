/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerFlashsale;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Flashsale;

/**
 *
 * @author Matthew
 */
public class MenuFlashsale {

    ControllerFlashsale controllerFlashsale = new ControllerFlashsale();
    MenuResult menuResult = new MenuResult();

    public void MenuSeeFlashsaleForAdmin() { //bedanya dengan buyer adalah di seller ada edit delete
        ArrayList<Flashsale> arrFlashsale = new ArrayList();
        arrFlashsale = controllerFlashsale.getFlashsaleDataAdmin();

        JButton bBack = new JButton("Back");
        bBack.setBounds(25, 20, 70, 50);

        JButton bCreate = new JButton("Create Flashsale");
        bCreate.setBounds(140, 20, 150, 50);

        JFrame frame = new JFrame();
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
            MenuInsertFlashsale();
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
            discountedPrice = new JLabel(String.valueOf(arrFlashsale.get(i).getDiscountedPrice()));
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
                MenuEditFlashsale(Integer.parseInt(id.getText()));
                frame.setVisible(false);
            });

            /*delete data*/
            bDelete.addActionListener((ActionEvent e) -> {
                MenuDeleteFlashsale(Integer.parseInt(id.getText()));
                frame.setVisible(false);
            });

            panel.setLayout(null);
            panel.setVisible(true);

            y += 125;
        }

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void MenuInsertFlashsale() {
        JFrame frame = new JFrame();
        frame.setSize(700, 800);

        //P1 (Menu Add Flashsale)
        /*variable add*/
        JTextField addIdItem, addFlashsaleStock, addDiscountedPrice, addEndDate;
        JLabel JInsertIdItem, JInsertFlashsaleStock, JInsertDiscountedPrice, JInsertEndDate;

        /*frame posisition & text*/
        JInsertIdItem = new JLabel("input idItem : ");
        JInsertIdItem.setBounds(70, 150, 150, 30);
        addIdItem = new JTextField();
        addIdItem.setBounds(250, 150, 200, 30);

        JInsertFlashsaleStock = new JLabel("input flashsaleStock : ");
        JInsertFlashsaleStock.setBounds(70, 200, 150, 30);
        addFlashsaleStock = new JTextField();
        addFlashsaleStock.setBounds(250, 200, 200, 30);

        JInsertDiscountedPrice = new JLabel("input discountedPrice : ");
        JInsertDiscountedPrice.setBounds(70, 250, 150, 30);
        addDiscountedPrice = new JTextField();
        addDiscountedPrice.setBounds(250, 250, 200, 30);

        JInsertEndDate = new JLabel("input endDate (YYYY-MM-DD) : ");
        JInsertEndDate.setBounds(70, 300, 200, 30);
        addEndDate = new JTextField();
        addEndDate.setBounds(250, 300, 200, 30);

        JButton button = new JButton("Submit");
        button.setBounds(100, 400, 95, 30);
        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(400, 400, 95, 30);

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

            MenuSeeFlashsaleForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void MenuEditFlashsale(int idFlashsale) {
        JFrame frame = new JFrame();
        frame.setSize(700, 800);

        Flashsale flashsale = new Flashsale();
        flashsale = controllerFlashsale.getFlashsaleDataById(idFlashsale);

        //p2(Menu Edit Flashsale)
        /*variable update*/
        JTextField updateIdFlashsale, updateFlashsaleStock, updateDiscountedPrice, updateEndDate;
        JLabel JEditFlashsale, JEditFlashsaleStock, JEditDiscountedPrice, JEditEndDate;

        /*frame posisition & text*/
        JEditFlashsale = new JLabel("input idFlashsale : ");
        JEditFlashsale.setBounds(70, 150, 150, 30);
        updateIdFlashsale = new JTextField(String.valueOf(flashsale.getIdFlashsale()));
        updateIdFlashsale.setBounds(250, 150, 200, 30);

        JEditFlashsaleStock = new JLabel("input flashsaleStock : ");
        JEditFlashsaleStock.setBounds(70, 200, 150, 30);
        updateFlashsaleStock = new JTextField(String.valueOf(flashsale.getFlashsaleStock()));
        updateFlashsaleStock.setBounds(250, 200, 200, 30);

        JEditDiscountedPrice = new JLabel("input discountedPrice : ");
        JEditDiscountedPrice.setBounds(70, 250, 150, 30);
        updateDiscountedPrice = new JTextField(String.valueOf(flashsale.getDiscountedPrice()));
        updateDiscountedPrice.setBounds(250, 250, 200, 30);

        JEditEndDate = new JLabel("input endDate (YYYY-MM-DD) : ");
        JEditEndDate.setBounds(70, 300, 200, 30);
        updateEndDate = new JTextField(String.valueOf(flashsale.getEndDate()));
        updateEndDate.setBounds(250, 300, 200, 30);

        JButton button = new JButton("Edit Flashsale");
        button.setBounds(100, 400, 150, 30);
        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(400, 400, 95, 30);

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

            boolean result = new ControllerFlashsale().EditFlashsale(updateFlashsale);
            frame.setVisible(false);
            menuResult.menuResultEditFlashsale(result, updateIdFlashsale.getText());
        });

        /*back*/
        buttonBack.addActionListener((ActionEvent e) -> {

            MenuSeeFlashsaleForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void MenuDeleteFlashsale(int idFlashsale) {
        JFrame frame = new JFrame();
        frame.setSize(700, 800);

        //p3(Menu delete Flashsale)
        /*variable update*/
        JTextField deleteIdFlashsale;
        JLabel JdeleteIdFlashsale;

        /*frame posisition & text*/
        JdeleteIdFlashsale = new JLabel("input idFlashsale : ");
        JdeleteIdFlashsale.setBounds(70, 150, 150, 30);
        deleteIdFlashsale = new JTextField(String.valueOf(idFlashsale));
        deleteIdFlashsale.setBounds(250, 150, 200, 30);

        JButton button = new JButton("Submit");
        button.setBounds(100, 400, 95, 30);
        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(400, 400, 95, 30);

        /*add frame*/
        frame.add(JdeleteIdFlashsale);
        frame.add(deleteIdFlashsale);

        frame.add(button);
        frame.add(buttonBack);

        /*delete data*/
        button.addActionListener((ActionEvent e) -> {
            int inputDeleteFlashsale = Integer.parseInt(deleteIdFlashsale.getText());
            boolean result = controllerFlashsale.DeleteFlashsale(inputDeleteFlashsale);
            frame.setVisible(false);
            menuResult.menuResultDeleteFlashsale(result, deleteIdFlashsale.getText());
        });

        /*back*/
        buttonBack.addActionListener((ActionEvent e) -> {

            MenuSeeFlashsaleForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

}
