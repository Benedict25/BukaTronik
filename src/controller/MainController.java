/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Person;

/**
 *
 * @author Benedict
 */
public class MainController {
    static int activeID = -1;
    
    public boolean checkLoginAndSetActivePerson(String username, String password){
        ControllerLogin control = new ControllerLogin();
        boolean successLogin = control.checkLoginAndSetActivePerson(username, password);
        return successLogin;
    }
    

}
