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
import model.Flashsale;

/**
 *
 * @author Matthew
 */
public class MenuFlashsale {
    
    public void MenuAddFlashsale(){
        JFrame frame = new JFrame();
        frame.setSize(600, 700);

        /*variable*/
        JTextField tIdItem, tFlashsaleStock, tDiscountedPrice, tEndDate;
        JLabel lIdItem, lFlashsaleStock, lDiscountedPrice, lEndDate;
        
        /*frame posisition & text*/
        lIdItem = new JLabel("input idItem : ");
        lIdItem.setBounds(70, 150, 150, 30);
        tIdItem = new JTextField();
        tIdItem.setBounds(250, 150, 200, 30);

        lFlashsaleStock = new JLabel("input flashsaleStock : ");
        lFlashsaleStock.setBounds(70, 200, 150, 30);
        tFlashsaleStock = new JTextField();
        tFlashsaleStock.setBounds(250, 200, 200, 30);

        lDiscountedPrice = new JLabel("input discountedPrice : ");
        lDiscountedPrice.setBounds(70, 250, 150, 30);
        tDiscountedPrice = new JTextField();
        tDiscountedPrice.setBounds(250, 250, 200, 30);

        lEndDate = new JLabel("input endDate (YYYY-MM-DD) : ");
        lEndDate.setBounds(70, 300, 200, 30);
        tEndDate = new JTextField();
        tEndDate.setBounds(250, 300, 200, 30);

        JButton button = new JButton("Submit");
        button.setBounds(100, 400, 95, 30);
        button.addActionListener((ActionEvent e) -> {
            
        });

        /*add frame*/
        frame.add(lIdItem);
        frame.add(tIdItem);

        frame.add(lFlashsaleStock);
        frame.add(tFlashsaleStock);

        frame.add(lDiscountedPrice);
        frame.add(tDiscountedPrice);

        frame.add(lEndDate);
        frame.add(tEndDate);
        
        frame.add(button);
        
        /*add data*/
        button.addActionListener((ActionEvent e) -> {
            Flashsale newFlashsale = new Flashsale();
            newFlashsale.setIdItem(Integer.parseInt(tIdItem.getText()));
            newFlashsale.setFlashsaleStock(Integer.parseInt(tFlashsaleStock.getText()));
            newFlashsale.setDiscountedPrice(Integer.parseInt(tDiscountedPrice.getText()));
            newFlashsale.setEndDate(tEndDate.getText());
            
            new ControllerFlashsale().insertFlashsale(newFlashsale);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public void MenuEditFlashsale(){
        JFrame frame = new JFrame();
        frame.setSize(600, 700);

        /*variable*/
        JTextField tidFlashsale, tFlashsaleStock, tDiscountedPrice, tEndDate;
        JLabel lIdItem, lFlashsaleStock, lDiscountedPrice, lEndDate;
        
        /*frame posisition & text*/
        lIdItem = new JLabel("input idFlashsale : ");
        lIdItem.setBounds(70, 150, 150, 30);
        tidFlashsale = new JTextField();
        tidFlashsale.setBounds(250, 150, 200, 30);

        lFlashsaleStock = new JLabel("input flashsaleStock : ");
        lFlashsaleStock.setBounds(70, 200, 150, 30);
        tFlashsaleStock = new JTextField();
        tFlashsaleStock.setBounds(250, 200, 200, 30);

        lDiscountedPrice = new JLabel("input discountedPrice : ");
        lDiscountedPrice.setBounds(70, 250, 150, 30);
        tDiscountedPrice = new JTextField();
        tDiscountedPrice.setBounds(250, 250, 200, 30);

        lEndDate = new JLabel("input endDate (YYYY-MM-DD) : ");
        lEndDate.setBounds(70, 300, 200, 30);
        tEndDate = new JTextField();
        tEndDate.setBounds(250, 300, 200, 30);

        JButton button = new JButton("Submit");
        button.setBounds(100, 400, 95, 30);
        button.addActionListener((ActionEvent e) -> {
            
        });

        /*add frame*/
        frame.add(lIdItem);
        frame.add(tidFlashsale);

        frame.add(lFlashsaleStock);
        frame.add(tFlashsaleStock);

        frame.add(lDiscountedPrice);
        frame.add(tDiscountedPrice);

        frame.add(lEndDate);
        frame.add(tEndDate);
        
        frame.add(button);
        
        /*add data*/
        button.addActionListener((ActionEvent e) -> {
            Flashsale updateFlashsale = new Flashsale();
            updateFlashsale.setIdFlashsale(Integer.parseInt(tidFlashsale.getText()));
            updateFlashsale.setFlashsaleStock(Integer.parseInt(tFlashsaleStock.getText()));
            updateFlashsale.setDiscountedPrice(Integer.parseInt(tDiscountedPrice.getText()));
            updateFlashsale.setEndDate(tEndDate.getText());
            
            new ControllerFlashsale().EditFlashsale(updateFlashsale);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
