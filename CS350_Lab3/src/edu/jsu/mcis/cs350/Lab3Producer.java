/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.jsu.mcis.cs350;

/**
 *
 * @author mkirby8
 */
public class Lab3Producer implements Runnable{
    
    private Lab3Controller controller;
    private String value;
    
    public Lab3Producer(Lab3Controller controller, String value) {
        
        this.controller = controller; 
        this.value = value;
    }
    
    @Override
    public void run() {
         
       controller.setModelProperty(Lab3Controller.ADD_ELEMENT, value);
       
    }
}
