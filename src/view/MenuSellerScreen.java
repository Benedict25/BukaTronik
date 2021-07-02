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
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.GadgetType;
import model.Item;

/**
 *
 * @author Dingdingding
 */
public class MenuSellerScreen {

    public MenuSellerScreen() {
        JFrame frame = new JFrame("Add Item");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        JButton button = new JButton("Press");
        frame.getContentPane().add(button);

        JTextField tItemName = new JTextField();
        JLabel lItemName = new JLabel("Item Name: ");
        tItemName.setBounds(100, 20, 200, 25);
        lItemName.setBounds(20, 20, 200, 25);

        JTextField tPrice = new JTextField();
        JLabel lPrice = new JLabel("Item Price: ");
        tPrice.setBounds(100, 60, 200, 25);
        lPrice.setBounds(20, 60, 200, 25);

        JTextField tStocks = new JTextField();
        JLabel lStocks = new JLabel("Item Stocks: ");
        tStocks.setBounds(100, 100, 200, 25);
        lStocks.setBounds(20, 100, 200, 25);

        JRadioButton rLaptop = new JRadioButton("LAPTOP");
        rLaptop.setBounds(90, 140, 200, 25);

        JRadioButton rHandphone = new JRadioButton("HANDPHONE");
        rHandphone.setBounds(90, 160, 200, 25);

        JRadioButton rAcc = new JRadioButton("ACC");
        rAcc.setBounds(90, 180, 200, 25);

        JLabel lCategory = new JLabel("Category: ");
        lCategory.setBounds(20, 140, 200, 25);

        ButtonGroup rCategory = new ButtonGroup();
        rCategory.add(rAcc);
        rCategory.add(rHandphone);
        rCategory.add(rLaptop);

        JTextField tItemWeight = new JTextField();
        JLabel lItemWeight = new JLabel("Item Weight: ");
        tItemWeight.setBounds(100, 220, 200, 25);
        lItemWeight.setBounds(20, 220, 200, 25);

        JButton submit = new JButton("Submit");
        submit.setBounds(50, 280, 100, 25);

        //Add components
        frame.add(tItemName);
        frame.add(lItemName);
        frame.add(tPrice);
        frame.add(lPrice);
        frame.add(tStocks);
        frame.add(lStocks);
        frame.add(rLaptop);
        frame.add(rHandphone);
        frame.add(rAcc);
        frame.add(lCategory);
        frame.add(tItemWeight);
        frame.add(lItemWeight);
        frame.add(submit);

        //Visible layout
        frame.setLayout(null);
        frame.setVisible(true);

        //Button function
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item newItem = new Item();
                newItem.setItemName(tItemName.getText());
                newItem.setPrice(Integer.parseInt(tPrice.getText()));
                newItem.setStocks(Integer.parseInt(tStocks.getText()));
                ButtonModel comps = rCategory.getSelection();
                if (comps == rLaptop) {
                    newItem.setCategory(GadgetType.LAPTOP);
                } else if (comps == rHandphone) {
                    newItem.setCategory(GadgetType.HANDPHONE);
                } else if (comps == rAcc) {
                    newItem.setCategory(GadgetType.ACC);
                }
                newItem.setItemWeight(Integer.parseInt(tItemWeight.getText()));
                new ControllerItem().insertSellerItem(newItem);
                frame.setVisible(false);
            }
        });

    }
    
}
