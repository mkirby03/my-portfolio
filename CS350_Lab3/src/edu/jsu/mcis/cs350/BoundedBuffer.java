/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.jsu.mcis.cs350;

/**
 *
 * @author mkirby8
 */
public class BoundedBuffer<Integer> {
    
    private static final int BUFFER_SIZE = 5;
    private int count, in, out;
    private Integer[] buffer;
    private Lab3Model model;
    
    public BoundedBuffer(Lab3Model model) {
        
        this.model = model;
        count = in = out = 0;
        buffer = (Integer[]) new Object[BUFFER_SIZE];
        
    }
    
    public synchronized void insert(Integer item) {
        
        while (count == BUFFER_SIZE) {
            try {
                model.sendProducerBlocked();
                wait();
            } catch (InterruptedException e) {}
        }
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;
        count++;
        notifyAll();
        
    }
    
    public synchronized Integer remove() {
        
        Integer item;
        while (count == 0) {
            try {
                model.sendConsumerBlocked();
                wait();
            } catch (InterruptedException e) {}
        }
        item = buffer[out];
        buffer[out] = null;
        out = (out + 1) % BUFFER_SIZE;
        count--;
        notifyAll();
        return item;
        
    }
    
    public String toString() {
        
        return "Bounded Buffer Contents: " + buffer[0] + " " + buffer[1] + " " + buffer[2] + " " + buffer[3] + " " + buffer[4];
    }

}
