//Name: Makiya Kirby
//Class Name and Section: CS 232 (Computer Programming II), Section 002
//Name of Program: Lab3_Assignment.java
//Brief Description of Program: finds the smallest, largest, and average of an arbitrary number of values entered by the user between 1 and 1000 inclusive
//Due Date: 09/19/22

import java.util.Scanner;

public class Lab3_Assignment 
{
    public static void main(String[] args)
    {
        //Scanner for console input
        Scanner input = new Scanner (System.in);
        
        //Prompt user for number of values being entered
        System.out.println("Please enter the total number of values you want to find the min, max, and average of: ");
        int num_of_values = input.nextInt();
        
        //Prompt user for values between 1 and 1000 inclusive, set variables as doubles, use a while loop to get input and check for largest and smallest values
        //as each number is entered, then add each value to the total sum
        System.out.println("Enter " + num_of_values + " numbers between 1 and 1000 inclusive, and I will tell you the smallest, the largest, and the average of these numbers: ");
        int i = 0;
        double largest = 0;
        double smallest = 1001;
        double sum_of_values = 0;
        
        while (i < num_of_values)
        {
            double value = input.nextDouble();
            if (value > largest)
            {
                largest = value;
            }
            if (value < smallest)
            {
                smallest = value;
            }
            sum_of_values += value;
            i++;
        }
        
        //Calculate the average of all the values entered and output the smallest, the largest, and the average
        double average_of_values = sum_of_values / num_of_values;
        System.out.println("Smallest: " + smallest);
        System.out.println("Largest: " + largest);
        System.out.println("Average: " + average_of_values);
    }
}
