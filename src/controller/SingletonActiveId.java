/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Benedict
 */
public class SingletonActiveId {

    private static SingletonActiveId instance;
    private int activeId;

    private SingletonActiveId() {
    }

    public static SingletonActiveId getInstance() {
        if (instance == null) {
            instance = new SingletonActiveId();
        }
        return instance;
    }

    public int getActiveId() {
        return activeId;
    }

    public void setActiveId(int activeId) {
        this.activeId = activeId;
    }

}
