/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.GadgetType;
import model.Seller;

/**
 *
 * @author Ignatius Dariel
 */
public class ControllerAddItem {

    public void insertSellerItem(ArrayList<Seller> seller, String username, String itemName, int price, int stocks, String category, int itemWeight) {
        for (int i = 0; i < seller.size(); i++) {
            if (seller.get(i).getUsername().equals(username)) {
                if (category.equals("Laptop")) {
                    seller.get(i).addItem(itemName, price, stocks, GadgetType.LAPTOP, itemWeight);
                } else if (category.equals("Handphone")) {
                    seller.get(i).addItem(itemName, price, stocks, GadgetType.HANDPHONE, itemWeight);
                } else {
                    seller.get(i).addItem(itemName, price, stocks, GadgetType.ACC, itemWeight);
                }
            }
        }
    }
}
