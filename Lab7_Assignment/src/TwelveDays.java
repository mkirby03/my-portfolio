//Name: Makiya Kirby
//Class Name and Section: CS 232 (Computer Programming II), Section 002
//Name of Program: TwelveDays.java
//Brief Description of Program: calculates number of gifts mentioned in twelve days of christmas song using recursion
//Due Date: 10/24/22


import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;



public class TwelveDays {
    public static void main (String[] args) throws IOException
    {
        //Prompt user to enter name of input file and open input file and add its words to an ArrayList or Hashmap
        Scanner in = new Scanner (System.in);
        System.out.println("Enter the name of the input file: ");
        String name_of_file = in.nextLine();
        System.out.println("\n");
        Scanner input = new Scanner(Paths.get(name_of_file), "UTF-8");
        //reading/putting input file content into an ArrayList
        ArrayList<String> twelve_days = new ArrayList<>();
        
        while(input.hasNextLine())
        {
            
            String days_and_gifts = input.nextLine();
            twelve_days.add(days_and_gifts);
        }
        //Outputting input file of twelve days song to the console window
        for(int i = 0; i < twelve_days.size(); i++)
        {
            System.out.println(twelve_days.get(i));
        }
        //Attempt to create ArrayList of numbers and a Hashmap with strings from input file as keys and days as values 
        ArrayList<Integer> numbered_days = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < twelve_days.size(); i++)
        {
            if (null != twelve_days.get(i))
            switch (twelve_days.get(i)) {
                case "On the first day of Christmas":
                    map.put(twelve_days.get(i), numbered_days.get(0));
                    break;
                case "On the second day of Christmas":
                    map.put(twelve_days.get(i), numbered_days.get(1));
                    break;
                case "On the third day of Christmas":
                    map.put(twelve_days.get(i), numbered_days.get(2));
                    break;
                case "On the fourth day of Christmas":
                    map.put(twelve_days.get(i), numbered_days.get(3));
                    break;
                case "On the fifth day of Christmas":
                    map.put(twelve_days.get(i), numbered_days.get(4));
                    break;
                case "On the sixth day of Christmas":
                    map.put(twelve_days.get(i), numbered_days.get(5));
                    break;
                case "On the seventh day of Christmas":
                    map.put(twelve_days.get(i), numbered_days.get(6));
                    break;
                case "On the eigth day of Christmas":
                    map.put(twelve_days.get(i), numbered_days.get(7));
                    break;
                case "On the ninth day of Christmas":
                    map.put(twelve_days.get(i), numbered_days.get(8));
                    break;
                case "On the tenth day of Christmas":
                    map.put(twelve_days.get(i), numbered_days.get(9));
                    break;
                case "On the eleventh day of Christmas":
                    map.put(twelve_days.get(i), numbered_days.get(10));
                    break;
                case "On the twelfth day of Christmas":
                    map.put(twelve_days.get(i), numbered_days.get(11));
                    break;
                default:
                    break;
            }
        }
        //System.out.println(map);
        System.out.println("\n");
        countGifts(12, 0);
        
        
    }
    
    //Calculating number of gifts mentioned in song recursively
    public static int countGifts(int currentDay, int total)
    {
        //int total = 0;
        for (int i = 0; i < 12; i++)
        {
           if (i == 1)
           {
               total = 12*1;
               //countGifts(currentDay - 1, total);
              // System.out.println(total);
           }
           else if (i == 2)
           {
               total += 11*2;
               //countGifts(currentDay - 1, total);
           }
           else if (i == 3)
           {
               total += 10*3;
               //countGifts(currentDay - 1, total);
           }
           else if (i == 4)
           {
               total += 9*4;
               //countGifts(currentDay - 1, total);
           }
           else if (i == 5)
           {
               total += 8*5;
               //countGifts(currentDay - 1, total);
           }
           else if (i == 6)
           {
               total += 7*6;
               //countGifts(currentDay - 1, total);
           }
           else if (i == 7)
           {
               total += 6*7;
               //countGifts(currentDay - 1, total);
           }
           else if (i == 8)
           {
               total += 5*8;
               //countGifts(currentDay - 1, total);
           }
           else if (i == 9)
           {
               total += 4*9;
               //countGifts(currentDay - 1, total);
           }
           else if (i == 10)
           {
               total += 3*10;
               //countGifts(currentDay - 1, total);
           }
           else if (i == 11)
           {
               total += 2*11;
               //countGifts(currentDay - 1, total);
           }
           else if (i == 12)
           {
               total += 1*12;
               //countGifts(currentDay - 1, total);
           }
           
        }
       // System.out.println(total);
        //countGifts(currentDay - 1, total);
        /*
        if (currentDay > 1)
        {
            //total += 1;
            //countGifts(currentDay - 1, total);
            
           //total = total + countGifts(currentDay - 1, total);
           // return total;
        }
        */
        //Output total number of gifts mentioned in song
        System.out.println("The number of presents is: " + total);
        return 1;
    }
    
}
