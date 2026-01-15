
//Name: Makiya Kirby
//Class Name and Section: CS 232 (Computer Programming II), Section 002
//Name of Program: Marathon.java
//Brief Description of Program: driver class that sorts an ArrayList alphabetically, finds a name, and outputs results
//Due Date: 10/31/22


package lab8;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Scanner;


public class Marathon {
    //Create ArrayList of runners
    public static ArrayList<String> runners = new ArrayList<>();

    //Create sortRunners method to sort names alphabetically from A-Z    
    public static void sortRunners( ArrayList<String> runners )
    {
        
        int n = runners.size();
        
        String temp;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
               
                if (runners.get(j).compareTo(runners.get(j+1)) > 0)
                {
                    temp = runners.get(j);
                    
                    runners.set(j, runners.get(j + 1));
                    runners.set(j + 1, temp);
                }
            }
            
        }
    }
    //Create a findRunner method that searches for name from userInput and outputs results or name found
    public static int findRunner(ArrayList<String> runners, String userInput)
    {
        int runnerIndex;
        int left = 0;
        int right = runners.size();
        int mid = (left + right) / 2;
        while (left <= right)
        {
            if (userInput.equals(runners.get(mid)))
            {
                
                left = mid + 1;
            }
            
            else
            {
                right = mid - 1;
                mid = (left + right) / 2;
            }
            
            if (left > right)
            {
                runnerIndex = mid;
            }
            
            else 
            {
                System.out.println("The Runner was not found within the list of Runners who participated in the Boston Marathon.");
                return -1;
            }

        }
        runnerIndex = mid;
       // Runner object_one = new Runner();
      //  object_one.setName(userInput);
      //  object_one.setTime(runnerIndex);
        //System.out.println(object_one);
        System.out.println(runnerIndex);
        return runnerIndex;
    }
    //Opens inputfile of runner names and times, and puts them into runners ArrayList
    public static void main(String[] args) throws IOException 
    {
       
        Scanner input = new Scanner(Paths.get("runners.txt"), "UTF-8");
        while ( input.hasNextLine() ) 
        {    
            
                
            String line = input.nextLine();
            runners.add(line);
        }
       Marathon.sortRunners(runners);
       Scanner in = new Scanner (System.in);
       System.out.println("Enter a name: ");
       String userInput = in.nextLine();
       Marathon.findRunner(runners, userInput);
        //Runner object_one = new Runner();
      // object_one.setName(userInput);
      // object_one.setTime(runnerIndex);
       //System.out.println(object_one);
       System.out.println(runners);
        

        
    }
    
   
    
}
