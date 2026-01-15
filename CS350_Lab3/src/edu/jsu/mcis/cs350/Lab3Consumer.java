/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.jsu.mcis.cs350;

/**
 *
 * @author mkirby8
 */
public class Lab3Consumer implements Runnable{
    
    private Lab3Controller controller;;
    
    public Lab3Consumer(Lab3Controller controller) {
        
        this.controller = controller;        
    }
    
    @Override
    public void run() {
        
        controller.setModelProperty(Lab3Controller.REMOVE_ELEMENT, "");
        
    }
    
}
