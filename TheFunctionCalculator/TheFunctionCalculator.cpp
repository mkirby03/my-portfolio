// TheFunctionCalculator.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
//Name: Makiya Kirby
//Class Name: CS 231 Computer Programming I
//Name of Program: TheFunctionCalculator.cpp
//Description of Program: Uses switch statment to control menu options of math calculations & call functions, & uses functions & user
// input to calculate and output results
//Due Date: 03/15/22

#include <iostream>
#include<cmath>
using namespace std;


//Function Prototypes
void calculate_squareroot();  
void calculate_cube();
void calculate_naturallog();
void calculate_inverse();
void calculate_abs_value();



//Main routine/function, contains switch statment and while loop for menu
//Output menu with options & collect/cin user's menu option/choice
int main(void)
{
    
    char menu_option = 0;
    while (menu_option != '0')
    {
        cout << '\t' << "M " << " E " << " N " << " U " << endl;
        cout << "1 - Calculate Square Root" << endl << "2 - Calculate Cube" << endl << "3 - Calculate Natural Logarithm" << endl;
        cout << "4 - Calculate Inverse" << endl << "5 - Calculate Absolute Value" << endl << "0 - Exit Program" << endl;
        cin >> menu_option;
        cout << "Enter menu option = " << menu_option << endl;

        switch (menu_option)
        {
        case '1':
            //call square root function
            calculate_squareroot();
            break;
        case '2':
            //call cube function
            calculate_cube();
            break;
        case '3':
            //call natural log function
            calculate_naturallog();
            break;
        case '4':
            //call inverse function
            calculate_inverse();
            break;
        case '5':
            //call abs value function
            calculate_abs_value();
            break;
        default: 
            //loop menu again
            break;
        }
        if (menu_option == '0')
        {
            cout << "Goodbye!";
        }
    }
    return 0;

}



//Math Functions/Calculations
// 
//Calculate square root & output results, & recognize negative input numbers
void calculate_squareroot()  
{
    double inputnumber;
    cout << "Enter in a non-negative decimal number: ";
    cin >> inputnumber;
    if (inputnumber < 0)
    {    
        cout << "Error: Incorrect Value Entered" << endl; 
        return;
    }
    cout << "The square root of " << inputnumber << " is " << sqrt(inputnumber) << endl << endl;
}

//Calculate cube & output results
void calculate_cube()
{
    double inputnumber;
    cout << "Enter in a decimal number: ";
    cin >> inputnumber;
    cout << "The cube of " << inputnumber << " is " << pow(inputnumber, 3) << endl << endl;
}

//Calculate natural log & output results, & recognize negative input numbers
void calculate_naturallog()
{
    double inputnumber;
    cout << "Enter in a non-negative decimal number: ";
    cin >> inputnumber;
    if (inputnumber < 0)
    {    
        cout << "Error: Incorrect Value Entered" << endl;
        return;
    }
    cout << "The natural log of " << inputnumber << " is " << log(inputnumber) << endl << endl;
}

//Calculate inverse & output results
void calculate_inverse()
{
    double inputnumber;
    cout << "Enter in a decimal number: ";
    cin >> inputnumber;
    cout << "The inverse of " << inputnumber << " is " << 1.0 / inputnumber << endl << endl;
}

//Calculate absolute value & output results
void calculate_abs_value()
{
    double inputnumber;
    cout << "Enter in a decimal number: ";
    cin >> inputnumber;
    cout << "The absolute value of " << inputnumber << " is " << fabs(inputnumber) << endl << endl;
}