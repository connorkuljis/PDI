// FILE:     Menu.java
// AUTHOR:   Connor Kuljis
// USERNAME: 19459138
// UNIT: PDI
// PURPOSE: Monolithic menu program that loops through a selction of 6 smaller programs
// REFERENCE: is an updated copy of Menu.java from P03
// COMMENTS: added in option 6
// REQUIRES:
// LAST MOD: 6th April 2020

import java.util.*;

public class Menu
{
    public static void main(String[] args)
    {
        boolean close = false;
        do
        {
            // this is what the menu prompt looks like
            System.out.println("\nConnor Kuljis, 19459138 - PDI Worksheet 4");
            System.out.println("What would you like to do?\n"); 
            System.out.println("1. Sum of 2 Integers"); 
            System.out.println("2. Convert a Temperature"); 
            System.out.println("3. Convert a Characters Case"); 
            System.out.println("4. Print the ASCII equivalent of a Character"); 
            System.out.println("5. Check if 2 Integers are divisible"); 
            System.out.println("6. Split a date into its components"); 
            System.out.println("0. Exit\n"); 

            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
      
            switch(ch)
            {
                case(1):    // adds two integers
                    int numOne, numTwo, answer;

                    System.out.print("Enter the first integer: ");
                    while (!sc.hasNextInt())    // Scans the next line for integer input
                    {
                        String notInt = sc.next();
                        System.out.println("Not an integer: " + notInt); 
                        System.out.println("Please enter the first integer"); 
                    }
                    numOne = sc.nextInt();
           
                    System.out.print("Enter the second integer: "); 
                    while (!sc.hasNextInt())
                    {
                        String notInt = sc.next();
                        System.out.println("Not an integer: " + notInt); 
                        System.out.println("Please enter the second integer"); 
                    } 
                    numTwo = sc.nextInt();
              
                    answer = numOne + numTwo;
                    System.out.println("\n\tThe answer is " + numOne + " + " + numTwo + " = " + answer); 
                    break;

                case(2):
                    double tempInCels, tempInFaren, farenheit, celcius;
                    char choice1;
                    boolean finish;    

                    finish = false;    // because this is set to false the while loop will repeat untill this is set to true

                    // sanatised input to be either 'C' or 'F', all other inputs will require the prompt to be issued again.
                    do
                    {
                        System.out.println("What temperature are you working with? (C)elcius / (F)arenheit");
                        choice1 = sc.next().charAt(0);
                        choice1 = Character.toUpperCase(choice1);

                        switch(choice1)
                        {
                            case('C'):
                                System.out.println("Please enter the temperature in Celsius (c)");
                                tempInCels = sc.nextDouble();

                                farenheit = ((tempInCels * 9.0) / 5.0) + 32.0;

                                System.out.println("\n\tTemp in farenheit: " + farenheit);
                                finish = true;    // set to true to satisfy condition
                                break;
                          
                             case('F'):
                                System.out.println("Please enter the temperature in Farenheit (f)");
                                tempInFaren = sc.nextDouble();

                                celcius = (tempInFaren - 32) * 5 / 9;

                                System.out.println("\n\tTemp in celcius: " + celcius);
                                finish = true;   // and again to satify condition
                                break;
                        }
                    } while(!finish);
                    break;


                case(3):
                    char uppercaseChar, lowercaseChar, choice, upperToLower, lowerToUpper;
                    int upperAscii, lowerAscii;
                    boolean cd;

                    cd = false;

                    do
                    {
                        System.out.println("Convert to (U)ppercase or (L)owercase?\nPlease select an option."); 
                        choice = sc.next().charAt(0);
                        choice = Character.toUpperCase(choice);

                        switch(choice)
                        {
                            case('U'):
                                do
                                {
                                    System.out.println("Please enter a lowercase character");    // body of the loop
                                    lowercaseChar = sc.next().charAt(0);
                                    lowerAscii = (int)(lowercaseChar);    

                                } while ((lowerAscii < 96) || (lowerAscii > 123));    // if this boolean expression is true the body of the loop is executed

                                lowerToUpper = (char)(lowerAscii - 32);
                                System.out.println("\n\tUppercase: " + lowerToUpper);
                                cd = true;
                                break;

                             case('L'):
                                do
                                {
                                    System.out.println("Please enter an uppercase character");
                                    uppercaseChar = sc.next().charAt(0);
                                    upperAscii = (int)(uppercaseChar);
     
                                } while ((upperAscii < 64) || (upperAscii > 91));

                                upperToLower = (char)(upperAscii + 32);
                                System.out.println("\n\tLowercase: " + upperToLower);
                                cd = true;
                                break;
                              
                              default:
                                  System.out.println("\nError: you have not selected a valid option\n ");   
                        }
     
                    } while (!cd);
                    break;

                case(4):
                    char myChar;
                    int charToAscii;

                    do
                    {
                        System.out.println("Enter a character to convert to associated ASCII number."); 
                        myChar = sc.next().charAt(0);
                        charToAscii = (int)(myChar);
                    } while ((charToAscii < 0) || (charToAscii > 127));

                    System.out.println("\n\tASCII value: " + charToAscii); 
                    break;

                case(5):
                    System.out.println("Check if two integers are divisible."); 
                    int intOne, intTwo;
     
                    do
                    {
                        System.out.println("Enter first integer. "); 
                        intOne = sc.nextInt();
                    } while (intOne <= 0);
                    
                    do
                    {
                        System.out.println("Enter second integer. "); 
                        intTwo = sc.nextInt();
                    } while (intTwo <=0);
      
                    if (intOne % intTwo != 0)
                    {
                        System.out.println("\n\tNot Divisible! "); 
                    }
                    else
                    {
                        System.out.println("\n\tDivisible! "); 
                    }
                    break;

                case(6):
                    double input, day, month, year;
                    int roundedDay, roundedMonth, roundedYear;
                    String str, errorStr, outStr;
                    str = "Please enter the date as an integer eg: '27032000' for 27th March 2000. ";
                    errorStr = "Error. The value must be between 01010001 and 31129999.";
                    outStr = str;
                    do 
                    {
                        System.out.println(outStr); 
                        input = sc.nextDouble();
                        outStr = errorStr + str;
                    } while ((input < 01010001 ) || (input> 31129999));

                    // split the day
                    day = input / 1000000;
                    roundedDay = (int)(day);
                    // System.out.println(roundedDay);

                    // split the month
                    month = day % roundedDay;
                    month = month * 100;
                    roundedMonth = (int)(month);
                    // System.out.println(roundedMonth);

                    // split the year
                    year = month % roundedMonth;
                    year = year * 10000;
                    roundedYear = (int)(year);
                    // System.out.println(roundedYear);

                    switch(roundedMonth)
                    {
                        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                            // days in month = 31
                            if((roundedDay > 0) && (roundedDay <= 31))
                            {
                                System.out.println("It is day " + roundedDay + " of month " + roundedMonth + ", in the year " + roundedYear);
                            }
                            else
                            {
                                System.out.println("Not a valid date");
                            }
                        break;
                        case 4: case 6: case 9: case 11:
                            // days in month = 30
                            if((roundedDay > 0) && (roundedDay <= 30))
                            {
                                System.out.println("It is day " + roundedDay + " of month " + roundedMonth + ", in the year " + roundedYear);
                            }
                            else
                            {
                                System.out.println("Not a valid date");
                            }
                        break;
                        case 2:
                            // days in month = 29 if not a leap year
                            if((roundedYear % 4 != 0) && (roundedYear % 100 != 0))
                            {
                                if((roundedDay) > 0 && (roundedDay <=29))
                                {
                                    System.out.println("It is day " + roundedDay + " of month " + roundedMonth + ", in the year " + roundedYear);
                                }
                                else
                                {
                                    System.out.println("Not a valid date");
                                }
                            }
                            else
                            {
                                if((roundedDay) > 0 && (roundedDay <=28))
                                {
                                    System.out.println("It is day " + roundedDay + " of month " + roundedMonth + ", in the year " + roundedYear + ". It is a leap year");
                                }
                                else
                                {
                                    System.out.println("Not a valid date");
                                }
                            }
                        break;
                        default:
                            System.out.println("Not a valid date");
                    }
                    break;
             
                case(0):
                    System.out.println("Goodbye!"); 
                    close = true;
                    break;

                default:
            }
        } while(!close);
    }
}
