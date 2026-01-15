//Name: Makiya Kirby
//Class Name and Section: CS 232 (Computer Programming II), Section 002
//Name of Program: ListStack.java
//Brief Description of Program: providing a stack ADT implementation using a linked list (listStack)
//Due Date: 11/28/22


import java.util.EmptyStackException;
//Implement your ListStack class here...

public class ListStack implements DStack
{
    class Node
    {
        private double value;
        private Node next;
        
        //contructor for node class
        public Node(double d)
        {
            value = d;
            next = null;
        }
    }
    
    private Node head;
    
    public ListStack()
    {
            // Your constructor code
        head = null;
    }
     @Override
    public boolean isEmpty() 
    {
            // Insert your isEmpty code here
          return head == null;  //Replace with your own return statement
    }
    @Override
    public void push(double d) 
    {
         // Insert your push code here
        Node node = new Node(d);
        node.next = head;
        head = node;
    }
    @Override
    public double pop()
    {
         // Insert your pop code here
        if (head == null)
        {
            throw new EmptyStackException();
        }
        else
        {
            double t = head.value;
            head = head.next;
            return t;  //replace with your own return statement
        }
        
    }
    @Override
    public double peek()
    {
        // Insert your peek code here
        if(head == null)
        {
            throw new EmptyStackException();
        }
        else
        {
            return head.value;  //replace with your own return statement
        }
    }

}
