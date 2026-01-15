// ThePrintMonthFunction.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
//Name: Makiya Kirby
//Class Name: CS 231 Computer Programming I
//Name of Program: ThePrintMonthFunction.cpp
//Description of Program: Uses a function to create and print out a calendar month (main routine calls function to test it)
//Due Date: 03/08/22


#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

//return type and parameters of function printmonth
void printmonth(const int month, const int startday, const bool leapyear)
{
//Output alphabetic month name using index of const int month (or numeric valued being passed in) & format output
//initialize string array
    string MonthArray[13] = { " ","January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
        "November", "December" };
    setw(25);
    for (int i = 0; i < 13; i++)
    {
        if (month == i)
        {
            cout << '\t' << '\t' << '\t' << MonthArray[i] << endl;
            cout << endl;
        }
    }

//Output days of the week using three letter abbreviation & format output
//initialize string array
    string days_of_week[7] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
    for (int i = 0; i < 7; i++)
    {
        cout << days_of_week[i] << "\t";
    }
    cout << endl;


//Initialize integer arrays & check for leapyear
    int days[31] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
    
    int days_in_month[13] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    if (leapyear == true)
    {
        days_in_month[2] = 29;
    }
    
//Output first of month on appropriate day of the week
    if (startday == 1)
    {
        cout << '\t';
    }
    if (startday == 2)
    {
        cout << '\t' << '\t';
    }
    if (startday == 3)
    {
        cout << '\t' << '\t' << '\t';
    }
    if (startday == 4)
    {
        cout << '\t' << '\t' << '\t' << '\t';
    }
    if (startday == 5)
    {
        cout << '\t' << '\t' << '\t' << '\t' << '\t';
    }
    if (startday == 6)
    {
        cout << '\t' << '\t' << '\t' << '\t' << '\t' << '\t';
    }


//Output number of days for the month of February according to leapyear or no leapyear
//Output the rest of the month from the 1st & format output
    for (int i = 0; i < 28; i++)
    {
        if (month == 2 && leapyear == false)
        {
            cout << days[i] << '\t';
            if (i % 7 == 0)
            {
                cout << endl;
            }
        }
    }
    for (int i = 0; i < 29; i++)
    {
        if (month == 2 && leapyear == true)
        {
            cout << days[i] << '\t';
            if (i % 7 == 0)
            {
                cout << endl;
            }
        }
    }

//Output days for months with 30 days, output the rest of the month from the 1st, & format ouput
    for (int i = 0; i < 30; i++)
    {
        if (month == 4 || month == 6 || month == 9 || month == 11)
        {
            cout << days[i] << '\t';
            if (i % 7 == 0)
            {
                cout << endl;
            }
        }
    }

//Output days for months with 31 days, output the rest of the month from the 1st, & format output
    for (int i = 0; i < 31; i++)
    {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
        {
            cout << days[i] << '\t';
        }
        if (i % 7 == 0) 
        {
            cout << endl;
        }
    }
   
    cout << endl << endl;

}

//main function/routine
//call function to test it
int main(void)
{
    printmonth(1, 0, false);
    printmonth(2, 1, true);
    printmonth(1, 2, false);
    printmonth(2, 3, false);
    printmonth(1, 4, false);
    printmonth(2, 5, false);
    printmonth(1, 6, false);
    printmonth(6, 1, false);
    printmonth(12, 4, false);


    return 0;
}

