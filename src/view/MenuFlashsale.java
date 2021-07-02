/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerFlashsale;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import model.Flashsale;

/**
 *
 * @author Matthew
 */
public class MenuFlashsale {

    public MenuFlashsale() {
        JFrame frame = new JFrame();
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        
        frame.setSize(800, 900);
        
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

        JButton buttonP1 = new JButton("Submit");
        buttonP1.setBounds(100, 400, 95, 30);
        buttonP1.addActionListener((ActionEvent e) -> {

        });

        /*add frame*/
        p1.add(JInsertIdItem);
        p1.add(addIdItem);

        p1.add(JInsertFlashsaleStock);
        p1.add(addFlashsaleStock);

        p1.add(JInsertDiscountedPrice);
        p1.add(addDiscountedPrice);

        p1.add(JInsertEndDate);
        p1.add(addEndDate);

        p1.add(buttonP1);

        /*add data*/
        buttonP1.addActionListener((ActionEvent e) -> {
            Flashsale newFlashsale = new Flashsale();
            newFlashsale.setIdItem(Integer.parseInt(addIdItem.getText()));
            newFlashsale.setFlashsaleStock(Integer.parseInt(addFlashsaleStock.getText()));
            newFlashsale.setDiscountedPrice(Integer.parseInt(addDiscountedPrice.getText()));
            newFlashsale.setEndDate(addEndDate.getText());

            new ControllerFlashsale().insertFlashsale(newFlashsale);
        });


        //p2(Menu Edit Flashsale)
        /*variable update*/
        JTextField updateIdFlashsale, updateFlashsaleStock, updateDiscountedPrice, updateEndDate;
        JLabel JEditFlashsale, JEditFlashsaleStock, JEditDiscountedPrice, JEditEndDate;

        /*frame posisition & text*/
        JEditFlashsale = new JLabel("input idFlashsale : ");
        JEditFlashsale.setBounds(70, 150, 150, 30);
        updateIdFlashsale = new JTextField();
        updateIdFlashsale.setBounds(250, 150, 200, 30);

        JEditFlashsaleStock = new JLabel("input flashsaleStock : ");
        JEditFlashsaleStock.setBounds(70, 200, 150, 30);
        updateFlashsaleStock = new JTextField();
        updateFlashsaleStock.setBounds(250, 200, 200, 30);

        JEditDiscountedPrice = new JLabel("input discountedPrice : ");
        JEditDiscountedPrice.setBounds(70, 250, 150, 30);
        updateDiscountedPrice = new JTextField();
        updateDiscountedPrice.setBounds(250, 250, 200, 30);

        JEditEndDate = new JLabel("input endDate (YYYY-MM-DD) : ");
        JEditEndDate.setBounds(70, 300, 200, 30);
        updateEndDate = new JTextField();
        updateEndDate.setBounds(250, 300, 200, 30);

        JButton buttonP2 = new JButton("Submit");
        buttonP2.setBounds(100, 400, 95, 30);
        buttonP2.addActionListener((ActionEvent e) -> {

        });

        /*add frame*/
        p2.add(JEditFlashsale);
        p2.add(updateIdFlashsale);

        p2.add(JEditFlashsaleStock);
        p2.add(updateFlashsaleStock);

        p2.add(JEditDiscountedPrice);
        p2.add(updateDiscountedPrice);

        p2.add(JEditEndDate);
        p2.add(updateEndDate);

        p2.add(buttonP2);

        /*add data*/
        buttonP2.addActionListener((ActionEvent e) -> {
            Flashsale updateFlashsale = new Flashsale();
            updateFlashsale.setIdFlashsale(Integer.parseInt(updateIdFlashsale.getText()));
            updateFlashsale.setFlashsaleStock(Integer.parseInt(updateFlashsaleStock.getText()));
            updateFlashsale.setDiscountedPrice(Integer.parseInt(updateDiscountedPrice.getText()));
            updateFlashsale.setEndDate(updateEndDate.getText());

            new ControllerFlashsale().EditFlashsale(updateFlashsale);
        });


        
        //p3(Menu delete Flashsale)
        /*variable update*/
        JTextField deleteIdFlashsale;
        JLabel JdeleteIdFlashsale;

        /*frame posisition & text*/
        JdeleteIdFlashsale = new JLabel("input idFlashsale : ");
        JdeleteIdFlashsale.setBounds(70, 150, 150, 30);
        deleteIdFlashsale = new JTextField();
        deleteIdFlashsale.setBounds(250, 150, 200, 30);

        JButton buttonP3 = new JButton("Submit");
        buttonP3.setBounds(100, 400, 95, 30);
        buttonP3.addActionListener((ActionEvent e) -> {

        });

        /*add frame*/
        p3.add(JdeleteIdFlashsale);
        p3.add(deleteIdFlashsale);

        p3.add(buttonP3);

        /*add data*/
        buttonP3.addActionListener((ActionEvent e) -> {
            Flashsale deleteFlashsale = new Flashsale();
            deleteFlashsale.setIdFlashsale(Integer.parseInt(deleteIdFlashsale.getText()));

            new ControllerFlashsale().DeleteFlashsale(deleteFlashsale);
        });
        
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(100, 50, 600, 700);
        
        tp.add("Add", p1);
        tp.add("Edit", p2);
        tp.add("Delete", p3);
        
        frame.add(tp);
        
        p1.setLayout(null);
        p2.setLayout(null);
        p3.setLayout(null);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
