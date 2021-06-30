/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerAddFlashsale;

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
public class MenuAddFlashsale {
    
    public MenuAddFlashsale(){
        JFrame frame = new JFrame();
        frame.setSize(600, 700);

        /*variable*/
        JTextField tIdItem, tFlashsaleStock, tDiscountedPrice, tEndDate;
        JLabel lIdItem, lFlashsaleStock, lDiscountedPrice, lEndDate;
        
        /*frame posisition & text*/
        lIdItem = new JLabel("input idItem : ");
        lIdItem.setBounds(100, 150, 150, 30);
        tIdItem = new JTextField();
        tIdItem.setBounds(250, 150, 200, 30);

        lFlashsaleStock = new JLabel("input flashsaleStock : ");
        lFlashsaleStock.setBounds(100, 200, 150, 30);
        tFlashsaleStock = new JTextField();
        tFlashsaleStock.setBounds(250, 200, 200, 30);

        lDiscountedPrice = new JLabel("input discountedPrice : ");
        lDiscountedPrice.setBounds(100, 250, 150, 30);
        tDiscountedPrice = new JTextField();
        tDiscountedPrice.setBounds(250, 250, 200, 30);

        lEndDate = new JLabel("input endDate : ");
        lEndDate.setBounds(100, 300, 150, 30);
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
            
            new ControllerAddFlashsale().insertFlashsale(newFlashsale);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
