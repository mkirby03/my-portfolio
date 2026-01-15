package edu.jsu.mcis.cs350;

import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {
        
        /* Create Controller */

        Lab3Controller controller = new Lab3Controller();
        
        /* Create Model */

        Lab3Model model = new Lab3Model();

        /* Register Model */

        controller.addModel(model);
        
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                
                /* Create Views */
                
                Lab3View window = new Lab3View(controller);
                window.setVisible(true);
                
                /* Register Views */
                
                controller.addView(window);
                
            }
            
        });
        
    }
    
}