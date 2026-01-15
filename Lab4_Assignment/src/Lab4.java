//Name: Makiya Kirby
//Class Name and Section: CS 232 (Computer Programming II), Section 002
//Name of Program: Lab4.java
//Brief Description of Program: uses source code as a starting point to write a collection of names in the form of standard address blocks to an output file
//also utilizes input and output files, ArrayLists, and a HashMap
//Due Date: 09/26/22


import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.io.PrintWriter;

public class Lab4 {

    public static void main(String[] args) {
        
        /* Row Objects */
        
        ArrayList<String> keys;             // Holds key names from header row
        ArrayList<String> values;           // Holds the values read from subsequent rows
        
        HashMap<String, String> row;        // Holds the key/value pairs for each data row

        String line, header;

        /* Container for File Data */
        
        ArrayList data = new ArrayList<>(); // Create ArrayList to hold HashMaps for all rows
        
        try {
            
            /* Attempt to open input file */

            Scanner in = new Scanner(Paths.get("lab4_input.csv"), "UTF-8");
            
            /* Get list of keys from the header row; split into an ArrayList */
            
            header = in.nextLine();
            keys = new ArrayList(Arrays.asList(header.split(",")));
            
            /* Read and process every subsequent row (record) in CSV file */
            
            while ( in.hasNextLine() ) {
                
                /* Get next line */
                
                line = in.nextLine();
                
                /* Create new map for current row */
                
                row = new HashMap<>();
                
                /* Split comma-separated values into ArrayList */
                
                values = new ArrayList(Arrays.asList(line.split(",")));
                
                /* Populate map, using key names from the header row */
                
                for (int i = 0; i < keys.size(); i++) {
                    
                    row.put(keys.get(i), values.get(i));
                    
                }
                
                /* Add map to data container */
                
                data.add(row);

            }
            
            /* Print number of records read from file (should be 500, not including header) */
            
            System.out.println("Number of records read: " + data.size());
            
            /* Close input file */
            
            in.close();

            /* Parse data from records; print as formatted address blocks */


            /* INSERT YOUR CODE HERE */
            //Open an output file called "mailing_list.txt" using PrintWriter
            PrintWriter output = new PrintWriter("mailing_list.txt", "UTF-8");
            
            /* Retrieve the map from the list using the lists get() method, and cast map back into a HashMap before using it */
            for(int i =0; i < data.size(); ++i)
            {
                row = (HashMap)data.get(i);
                
                //then retrieve value from map by calling its get() method and giving the name of the corresponding key as an argument
                //and write values into an output file in a mailing address format
                output.write("\n" + row.get("FirstName") + " " + (row.get("MiddleInitial")) + " " + (row.get("LastName")) + "\n");
                output.write(row.get("StreetAddress") + "\n");
                output.write(row.get("City") + ", " + (row.get("State")) + " " + (row.get("ZipCode")) + "\n");
            }
            
            /* Close output file */
            output.close();
        }
        
        catch (Exception e) {
            
            System.err.println(e.toString());
            
        }
        
    }

}
