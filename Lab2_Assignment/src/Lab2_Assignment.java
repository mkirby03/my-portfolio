//Name: Makiya Kirby
//Class Name and Section: CS 232 (Computer Programming II), Section 002
//Name of Program: Lab2_Assignment.java
//Brief Description of Program: Opens an input file with test scores, checks for number of test scores within a range, and puts them in the correct bin or variable for that range
//Due Date: 09/12/22

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Lab2_Assignment 
{
    public static void main(String[] args) throws IOException
    {
      //  String line;
        
        //Open input file using scanner
        Scanner input = new Scanner(Paths.get("lab2_input.txt"), "UTF-8"); 
        
        //Set counter variables for ranges 
        int range_one_counter = 0;
        int range_two_counter = 0;
        int range_three_counter = 0;
        int range_four_counter = 0;
        int range_five_counter = 0;
        int range_six_counter = 0;
        int range_seven_counter = 0;
        int range_eight_counter = 0;
        
        //Read in the numbers from input file, check for which range each test score belongs in, and place them in that range
        //also increment range counters
        while (input.hasNext())
        {
           
            int i = input.nextInt();
           // System.out.println(input.nextLine());
        //    System.out.println(i);
            
            if ( i >= 0 && i <= 24)
            {
               range_one_counter++;
            }
            else if (i > 24 && i <= 49 && i != 26)
            {
                range_two_counter++;
            }
            else if (i >= 50 && i <= 74)
            {
                range_three_counter++;
            }
            else if (i >= 75 && i <= 99)
            {
                range_four_counter++;
            }
            else if (i >= 100 && i <= 124)
            {
                range_five_counter++;
            }
            else if (i >= 125 && i <= 149)
            {
                range_six_counter++;
            }
            else if (i >= 150 && i <= 174)
            {
                range_seven_counter++;
            }
            else if (i >= 175 && i <= 200)
            {
                range_eight_counter++;
            }
        }
        
        //Output ranges and the number of test scores within each range
        System.out.println("[0-24]: " + range_one_counter);
        System.out.println("[25-49]: " + range_two_counter);
        System.out.println("[50-74]: " + range_three_counter);
        System.out.println("[75-99]: " + range_four_counter);
        System.out.println("[100-124]: " + range_five_counter);
        System.out.println("[125-149]: " + range_six_counter);
        System.out.println("[150-174]: " + range_seven_counter);
        System.out.println("[175-200]: " + range_eight_counter);
    }
}
/*
try {

            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_FIND);
                ps.setString(1, id);

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();

                    while (rs.next()) {

                        String shiftID = rs.getString("shiftid");
                        badge = new Badge(badge.getId(), shiftID);
                        

                    }

                }

            }
            

        } catch (SQLException e) {

            throw new DAOException(e.getMessage());

        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }

        }
*/