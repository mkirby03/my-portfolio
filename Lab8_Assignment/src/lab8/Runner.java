//Name: Makiya Kirby
//Class Name and Section: CS 232 (Computer Programming II), Section 002
//Name of Program: Runner.java
//Brief Description of Program: Runner class that creates instance variables, uses constructors 
//to instantiate them, provides a toString() method for outputting results, and uses a compareTo() method
//Due Date: 10/31/22

package lab8;

public class Runner implements Comparable<Runner>
{
    //Instance variables
    private String name;
    private int time;
    
    //default constructor
    public Runner()
    {
        name = "John Doe";
        time = 0;
    }
    //constructor with two parameters
    public Runner(String n, int a_time)
    {
        name = n;
        time = a_time;
    }
    //Create "setter" and "getter" methods for each instance variable
    public void setName(String n)
    {
       this.name = n;
    }
    public String getName()
    {
       return name;
    }
    public void setTime(int a_time)
    {
       this.time = a_time;
    }
    public int getTime()
    {
       return time;
    }
    //toString() method that returns a string that holds the runner's name and time
    public String toString()
    {
        String message = "Runner's name: " + name + " and Runner's time: " + time;
        return message;
    }
    //Create compareTo() method
    Runner r = new Runner();
    public int compareTo(Runner other)
    {
        if(this.time < r.time)
        {
            return -1;
        }
        else if(this.time == r.time)
        {
            return 0;
        }
        else if (this.time > r.time)
        {
            return 1;
        }
        return 2;
    }
           
    
}
