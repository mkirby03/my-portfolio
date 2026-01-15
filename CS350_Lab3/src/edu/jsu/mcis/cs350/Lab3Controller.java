package edu.jsu.mcis.cs350;


public class Lab3Controller extends AbstractController
{
 
    public static final String ADD_ELEMENT = "AddElement";
    public static final String REMOVE_ELEMENT = "RemoveElement";
    public static final String OUTPUT_MESSAGE = "OutputMessage";
    
    
 
    public void addElement(String value) {
        
        // INSERT YOUR CODE HERE
        Thread run = new Thread(new Lab3Producer(this, value));
        run.start();
    }
    
    public void removeElement() {
        
        // INSERT YOUR CODE HERE
        Thread run = new Thread(new Lab3Consumer(this));
        run.start();
    }  
    
}