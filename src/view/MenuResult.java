/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Benedict
 */
public class MenuResult {

    //Ben
    //Result Log In & Register
    public void menuResultLogin(boolean result, String username) {
        JFrame frame = new JFrame("Result Login");
        frame.setSize(450, 410);

        JLabel lResult, lUsername;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lUsername = new JLabel("Username: " + username);
        lUsername.setBounds(0, 120, 450, 100);
        lUsername.setHorizontalAlignment(JLabel.CENTER);
        lUsername.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Login Succeed");
        } else {
            lResult.setText("Login Failed");
        }

        frame.add(lResult);
        frame.add(lUsername);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultRegister(boolean result, String username) {
        JFrame frame = new JFrame("Result Register");
        frame.setSize(450, 410);

        JLabel lResult, lUsername;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lUsername = new JLabel("Username: " + username);
        lUsername.setBounds(0, 120, 450, 100);
        lUsername.setHorizontalAlignment(JLabel.CENTER);
        lUsername.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Registration Succeed");
        } else {
            lResult.setText("Registration Failed");
        }

        frame.add(lResult);
        frame.add(lUsername);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuLogin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    //Result Voucher
    public void menuResultCreateVoucher(boolean result, String voucherCode) {
        JFrame frame = new JFrame("Result Create Voucher");
        frame.setSize(450, 410);

        JLabel lResult, lVoucherCode;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Vouch Code: " + voucherCode);
        lVoucherCode.setBounds(0, 120, 450, 100);
        lVoucherCode.setHorizontalAlignment(JLabel.CENTER);
        lVoucherCode.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Create Voucher Succeed");
        } else {
            lResult.setText("Create Voucher Failed");
        }

        frame.add(lResult);
        frame.add(lVoucherCode);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuVoucher().MenuSeeVoucherForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultEditVoucher(boolean result, String voucherCode) {
        JFrame frame = new JFrame("Result Edit Voucher");
        frame.setSize(450, 410);

        JLabel lResult, lVoucherCode;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Vouch Code: " + voucherCode);
        lVoucherCode.setBounds(0, 120, 450, 100);
        lVoucherCode.setHorizontalAlignment(JLabel.CENTER);
        lVoucherCode.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Edit Voucher Succeed");
        } else {
            lResult.setText("Edit Voucher Failed");
        }

        frame.add(lResult);
        frame.add(lVoucherCode);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuVoucher().MenuSeeVoucherForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultDeleteVoucher(boolean result, String voucherCode) {
        JFrame frame = new JFrame("Result Delete Voucher");
        frame.setSize(450, 410);

        JLabel lResult, lVoucherCode;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Vouch Code: " + voucherCode);
        lVoucherCode.setBounds(0, 120, 450, 100);
        lVoucherCode.setHorizontalAlignment(JLabel.CENTER);
        lVoucherCode.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Delete Voucher Succeed");
        } else {
            lResult.setText("Delete Voucher Failed");
        }

        frame.add(lResult);
        frame.add(lVoucherCode);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuVoucher().MenuSeeVoucherForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    //Result Wishlist
    public void menuResultAddToWishlist(boolean result, String itemName) {
        JFrame frame = new JFrame("Result Add To Wishlist");
        frame.setSize(450, 410);

        JLabel lResult, lItemName;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lItemName = new JLabel("Item Name: " + itemName);
        lItemName.setBounds(0, 120, 450, 100);
        lItemName.setHorizontalAlignment(JLabel.CENTER);
        lItemName.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Added to Wishlist");
        } else {
            lResult.setText("Failed to Add");
        }

        frame.add(lResult);
        frame.add(lItemName);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuWishlist().seeWishlist();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultRemoveFromWishlist(boolean result, String itemName) {
        JFrame frame = new JFrame("Result Remove From Wishlist");
        frame.setSize(450, 410);

        JLabel lResult, lItemName;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lItemName = new JLabel("Item Name: " + itemName);
        lItemName.setBounds(0, 120, 450, 100);
        lItemName.setHorizontalAlignment(JLabel.CENTER);
        lItemName.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Removed From Wishlist");
        } else {
            lResult.setText("Failed to Remove");
        }

        frame.add(lResult);
        frame.add(lItemName);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuWishlist().seeWishlist();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    //Result Profile & Balance
    public void menuResultEditProfile(boolean result, String username) {
        JFrame frame = new JFrame("Result Edit Profile");
        frame.setSize(450, 410);

        JLabel lResult, lUserName;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lUserName = new JLabel("Username: " + username);
        lUserName.setBounds(0, 120, 450, 100);
        lUserName.setHorizontalAlignment(JLabel.CENTER);
        lUserName.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Success Edit For:");
        } else {
            lResult.setText("Edit Failed");
        }

        frame.add(lResult);
        frame.add(lUserName);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuProfile().seeProfile();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultDepositBalance(boolean result, int balance) {
        JFrame frame = new JFrame("Result Deposit Balance");
        frame.setSize(450, 410);

        JLabel lResult, lDeposit;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lDeposit = new JLabel("Amount: " + String.format("Rp.%,.2f", (double) balance));
        lDeposit.setBounds(0, 120, 450, 100);
        lDeposit.setHorizontalAlignment(JLabel.CENTER);
        lDeposit.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Deposit Succeed");
        } else {
            lResult.setText("Deposit Failed");
        }

        frame.add(lResult);
        frame.add(lDeposit);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuProfile().seeProfile();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultWithdrawBalance(boolean result, int withdrawAmount, String noTujuan) {
        JFrame frame = new JFrame("Result Withdraw Balance To " + noTujuan);
        frame.setSize(450, 410);

        JLabel lResult, lWithdraw;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lWithdraw = new JLabel("Amount: " + String.format("Rp.%,.2f", (double) withdrawAmount));
        lWithdraw.setBounds(0, 120, 450, 100);
        lWithdraw.setHorizontalAlignment(JLabel.CENTER);
        lWithdraw.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Withdraw Succeed");
        } else {
            lResult.setText("Withdraw Failed");
        }

        frame.add(lResult);
        frame.add(lWithdraw);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuProfile().seeProfile();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    //Result Remove User
    public void menuResultRemoveUser(boolean result, String username) {
        JFrame frame = new JFrame("Result Remove User");
        frame.setSize(450, 410);

        JLabel lResult, lUsername;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lUsername = new JLabel("UN: " + username);
        lUsername.setBounds(0, 120, 450, 100);
        lUsername.setHorizontalAlignment(JLabel.CENTER);
        lUsername.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("User Removed");
        } else {
            lResult.setText("Failed to Remove");
        }

        frame.add(lResult);
        frame.add(lUsername);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuRemovePerson().menuSeePersonList();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    //Matthew
    //Result Flashsale
    public void menuResultCreateFlashsale(boolean result, String idFlashsale) {
        JFrame frame = new JFrame("Result Create Flashsale");
        frame.setSize(450, 410);

        JLabel lResult, lVoucherCode;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Flashsale ID: " + idFlashsale);
        lVoucherCode.setBounds(0, 120, 450, 100);
        lVoucherCode.setHorizontalAlignment(JLabel.CENTER);
        lVoucherCode.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Create Flashsale Succeed");
        } else {
            lResult.setText("Create Flashsale Failed");
        }

        frame.add(lResult);
        frame.add(lVoucherCode);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuFlashsale().menuSeeFlashsaleForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultEditFlashsale(boolean result, String idFlashsale) {
        JFrame frame = new JFrame("Result Edit Flashsale");
        frame.setSize(450, 410);

        JLabel lResult, lVoucherCode;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Flashsale ID: " + idFlashsale);
        lVoucherCode.setBounds(0, 120, 450, 100);
        lVoucherCode.setHorizontalAlignment(JLabel.CENTER);
        lVoucherCode.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Edit Flashsale Succeed");
        } else {
            lResult.setText("Edit Flashsale Failed");
        }

        frame.add(lResult);
        frame.add(lVoucherCode);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuFlashsale().menuSeeFlashsaleForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultDeleteFlashsale(boolean result, String idFlashsale) {
        JFrame frame = new JFrame("Result Delete Flashsale");
        frame.setSize(450, 410);

        JLabel lResult, lVoucherCode;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Flashsale ID : " + idFlashsale);
        lVoucherCode.setBounds(0, 120, 450, 100);
        lVoucherCode.setHorizontalAlignment(JLabel.CENTER);
        lVoucherCode.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Delete Flashsale Succeed");
        } else {
            lResult.setText("Delete Flashsale Failed");
        }

        frame.add(lResult);
        frame.add(lVoucherCode);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuFlashsale().menuSeeFlashsaleForAdmin();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    //Result Shopping Cart
    public void menuResultAddToShoppingCart(boolean result) {
        JFrame frame = new JFrame("Result Add To Shopping Cart");
        frame.setSize(450, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Added to Shopping Cart");
        } else {
            lResult.setText("Add Item Failed");
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuShoppingCart().MenuSeeShoppingCart();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultChangeQuantityShoppingCart(boolean result) {
        JFrame frame = new JFrame("Result Change Quantity");
        frame.setSize(450, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Change Quantity Succeed");
        } else {
            lResult.setText("Change Quantity Failed");
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuShoppingCart().MenuSeeShoppingCart();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultRemoveShoppingCart(boolean result) {
        JFrame frame = new JFrame("Result Remove From Shopping Cart");
        frame.setSize(450, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Remove Item Succeed");
        } else {
            lResult.setText("Remove Item Failed");
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuShoppingCart().MenuSeeShoppingCart();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    //Result Order
    public void menuResultApproveOrder(boolean result) {
        JFrame frame = new JFrame("Result Approve Order");
        frame.setSize(450, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Approved!");
        } else {
            lResult.setText("Failed!");
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuManageOrder().menuSeeOrder();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultApproveCancelOrder(boolean result) {
        JFrame frame = new JFrame("Result Approve Cancel Order");
        frame.setSize(450, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Cancellation Approved!");
        } else {
            lResult.setText("Failed!");
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuManageOrder().menuSeeOrder();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultCheckOut(boolean result) {
        JFrame frame = new JFrame("Result Check Out");
        frame.setSize(750, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 750, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(300, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Check Out Succeed");
        } else {
            lResult.setText("Check Out Failed, Please Check Your Balance");
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MainMenuBuyer();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    //Igna
    //Result Item
    public void menuResultAddSellerItem(boolean result) {
        JFrame frame = new JFrame("Result Add Seller Item");
        frame.setSize(450, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Item Added Successfully");
        } else {
            lResult.setText("Add Item Failed");
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuItem().seeItemSeller();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultEditSellerItem(boolean result) {
        JFrame frame = new JFrame("Result Edit Seller Item");
        frame.setSize(450, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Item Edited Successfully");
        } else {
            lResult.setText("Edit Item Failed");
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuItem().seeItemSeller();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void menuResultDeleteSellerItem(boolean result) {
        JFrame frame = new JFrame("Result Delete Seller Item");
        frame.setSize(450, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Item Deleted Successfully");
        } else {
            lResult.setText("Delete Item Failed");
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuItem().seeItemSeller();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    //Result Order
    public void menuResultCancelOrderBuyer(boolean result) {
        JFrame frame = new JFrame("Result Cancel Order");
        frame.setSize(450, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 450, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Cancelled!");
        } else {
            lResult.setText("Failed to Cancel");
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuOrder().subMenuOrder();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public void menuResultUseVoucher(String voucherCode, boolean result){
        JFrame frame = new JFrame("");
        frame.setSize(1100, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(0, 20, 1100, 100);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(500, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("");
        } else {
            lResult.setText("Pembelian anda tidak memenuhi minimal transaksi dari Voucher : "+voucherCode);
        }

        frame.add(lResult);
        frame.add(bConfirm);

        bConfirm.addActionListener((ActionEvent e) -> {
            new MenuCheckOut().menuCheckOutCourier();
            frame.setVisible(false);
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
