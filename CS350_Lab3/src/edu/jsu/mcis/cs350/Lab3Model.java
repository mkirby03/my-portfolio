package edu.jsu.mcis.cs350;

public class Lab3Model extends AbstractModel {
    
    private final BoundedBuffer<Integer> buffer;
 
    public Lab3Model() {
 
        buffer = new BoundedBuffer<>(this);
 
    }

    public void setAddElement(String value) {
        
        StringBuilder s = new StringBuilder();
        
        // INSERT YOUR CODE HERE       
        buffer.insert(Integer.parseInt(value));
        
        s.append("Element Added: ").append(value).append(System.lineSeparator());
            
        s.append(buffer);

        firePropertyChange(Lab3Controller.OUTPUT_MESSAGE, null, s.toString());
        
    }

    public void setRemoveElement(String value) {
 
        StringBuilder s = new StringBuilder();
        
        // INSERT YOUR CODE HERE
        s.append("Element Removed: ").append(buffer.remove()).append(System.lineSeparator());

        s.append(buffer);

        firePropertyChange(Lab3Controller.OUTPUT_MESSAGE, null, s.toString());
        
    }
    
    public void sendProducerBlocked(){
        
        StringBuilder s = new StringBuilder();
        
        s.append("Buffer Full; Producer Blocked!");
        
        firePropertyChange(Lab3Controller.OUTPUT_MESSAGE, null, s.toString());
    }
    
    public void sendConsumerBlocked(){
        
        StringBuilder s = new StringBuilder();
        
        s.append("Buffer Empty; Consumer Blocked!");
        
        firePropertyChange(Lab3Controller.OUTPUT_MESSAGE, null, s.toString());
    }
    
    public void sendOutputMessage(String message) {
        
        firePropertyChange(Lab3Controller.OUTPUT_MESSAGE, null, message);
        
    }
    
}