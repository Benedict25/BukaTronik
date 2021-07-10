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
    //Result Log In & Register
    public void menuResultLogin(boolean result, String username) {
        JFrame frame = new JFrame("Result Login");
        frame.setSize(450, 410);

        JLabel lResult, lUsername;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lUsername = new JLabel("Username: " + username);
        lUsername.setBounds(50, 120, 500, 100);
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
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lUsername = new JLabel("Username: " + username);
        lUsername.setBounds(50, 120, 500, 100);
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
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Vouch Code: " + voucherCode);
        lVoucherCode.setBounds(50, 120, 500, 100);
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
            new MenuVoucher().MenuSeeVoucherForSeller();
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
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Vouch Code: " + voucherCode);
        lVoucherCode.setBounds(50, 120, 500, 100);
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
            new MenuVoucher().MenuSeeVoucherForSeller();
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
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Vouch Code: " + voucherCode);
        lVoucherCode.setBounds(50, 120, 500, 100);
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
            new MenuVoucher().MenuSeeVoucherForSeller();
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
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lItemName = new JLabel("Item Name: " + itemName);
        lItemName.setBounds(50, 120, 500, 100);
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
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lItemName = new JLabel("Item Name: " + itemName);
        lItemName.setBounds(50, 120, 500, 100);
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
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lUserName = new JLabel("Username: " + username);
        lUserName.setBounds(50, 120, 500, 100);
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
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lDeposit = new JLabel("Amount: " + balance);
        lDeposit.setBounds(50, 120, 500, 100);
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
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lWithdraw = new JLabel("Amount: " + withdrawAmount);
        lWithdraw.setBounds(50, 120, 500, 100);
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
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lUsername = new JLabel("UN: " + username);
        lUsername.setBounds(50, 120, 500, 100);
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
    
    //result flashsale
    public void menuResultCreateFlashsale(boolean result, String idFlashsale) {
        JFrame frame = new JFrame("Result Create Flashsale");
        frame.setSize(450, 410);

        JLabel lResult, lVoucherCode;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Flashsale ID: " + idFlashsale);
        lVoucherCode.setBounds(50, 120, 500, 100);
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
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Flashsale ID: " + idFlashsale);
        lVoucherCode.setBounds(50, 120, 500, 100);
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
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));

        lVoucherCode = new JLabel("Flashsale ID : " + idFlashsale);
        lVoucherCode.setBounds(50, 120, 500, 100);
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

    //result shopping cart
    public void menuResultAddToShoppingCart(boolean result) {
        JFrame frame = new JFrame("Result Add To Shopping Cart");
        frame.setSize(450, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));
        
        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
        bConfirm.setFont(new Font("Serif", Font.BOLD, 20));

        if (result == true) {
            lResult.setText("Add Item to Shopping Cart Succeed");
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
        lResult.setBounds(50, 20, 500, 100);
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
        lResult.setBounds(50, 20, 500, 100);
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
    
    //result Order
    
    public void menuResultApproveOrder(boolean result) {
        JFrame frame = new JFrame("Result Approve Order");
        frame.setSize(450, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(50, 20, 500, 100);
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
        lResult.setBounds(50, 20, 500, 100);
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
        frame.setSize(450, 410);

        JLabel lResult;
        JButton bConfirm;

        lResult = new JLabel();
        lResult.setBounds(50, 20, 500, 100);
        lResult.setFont(new Font("Serif", Font.BOLD, 30));
        
        bConfirm = new JButton("Ok!");
        bConfirm.setBounds(140, 250, 150, 50);
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
}
