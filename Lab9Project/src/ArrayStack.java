//Name: Makiya Kirby
//Class Name and Section: CS 232 (Computer Programming II), Section 002
//Name of Program: ArrayStack.java
//Brief Description of Program: providing a stack ADT implementation using an array (arrayStack)
//Due Date: 11/28/22


import java.util.Arrays;
import java.util.EmptyStackException;
//implement your ArrayStack implementation here


public class ArrayStack implements DStack
{
    private int top;
    private int stackSize = 10;
    private double[] arrayStack;
    
    //private int size = 0;
    
     public ArrayStack()
     {
             // Your constructor code
        //arrayStack = new double[10];
        //size = arrayStack.length;
        arrayStack = new double[stackSize];
        top = -1;
     }
     @Override
    public boolean isEmpty() 
    {
            // Insert your isEmpty code here
        /*
        boolean empty = true;
        if(arrayStack != null)
        {
            empty = false;
        }
        return empty;   //Replace with your own return statement
        */
        return top == -1;   //Replace with your own return statement
    }
    @Override
    public void push(double d) 
    {
         // Insert your push code here
        /*
        if(size == arrayStack.length)
        {
            //size = size * 2;
            int newSize = arrayStack.length;
            arrayStack = Arrays.copyOf(arrayStack, newSize);
        }
        for(int i = 0; i < size; i++)
        {
            arrayStack[i] = d;
        }
        */
        
        if(++top == arrayStack.length)
        {
            double[] newStack = new double[2 * arrayStack.length];
        
            for(int i = 0; i < arrayStack.length; i++)
            {
                newStack[i] = arrayStack[i];
            }
            arrayStack[top] = d;
        }
        
    }
    @Override
    public double pop()
    {
         // Insert your pop code here
        /*
        double popped = 0;
        boolean empty = isEmpty();
        if(empty == true)
        {
            throw new EmptyStackException();
        }
        for(int i = 0; i > size; i--)
        {
            popped = arrayStack[i];
            arrayStack[i] = 0;
        }
        return popped;  //replace with your own return statement
        */
        
        if(top == -1)
        {
            throw new EmptyStackException();
        }
        else
        {
            return arrayStack[top--];    //replace with your own return statement
        }
        
    }
    @Override
    public double peek()
    {
        // Insert your peek code here
        /*
        boolean empty = isEmpty();
        if(empty == true)
        {
            throw new EmptyStackException();
        }
        double stackTop = pop();
        return stackTop;  //replace with your own return statement
        */
        
        if(top == -1)
        {
            throw new EmptyStackException();
        }
        else
        {
            return arrayStack[top];    //replace with your own return statement
        }
        
    }
}
