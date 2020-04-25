// FILE:     PDIPortfolio.java
// AUTHOR:   Connor Kuljis
// USERNAME: 19459138
// UNIT:     PDI
// PURPOSE:  Provide a looping menu presenting a portfolio of all the work so far
// REFERENCE: is an updated copy of Menu.java from P04
// COMMENTS: 
// REQUIRES: -
// LAST MOD: 22nd April 2020

import java.util.*;

public class PDIPortfolio
{
    public static void main(String[] args)
    {
        boolean close = false;  // use this boolean to close the loop
        do
        {
            // this is what the menu prompt looks like
            System.out.println("\nWelcome to my Porfolio!");
            System.out.println("Select an option:\n "); 
            System.out.println("\t1. Sum of 2 Integers"); 
            System.out.println("\t2. Convert a Temperature"); 
            System.out.println("\t3. Convert a Characters Case"); 
            System.out.println("\t4. Print the ASCII equivalent of a Character"); 
            System.out.println("\t5. Check if 2 Integers are divisible"); 
            System.out.println("\t6. Split a date into its components"); 
            System.out.println("\t7. Arrays 1st dimension"); 
            System.out.println("\t8. Arrays 2nd dimension"); 
            System.out.println("\t0. Exit\n"); 

            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
      
            switch(ch)
            {
                case(1):    // adds two integers
                    sum2ints();
                    break;

                case(2):
                    temp();
                    break;

                case(3):
                    charConv();
                    break;

                case(4):
                    asciiConv();
                    break;

                case(5):
                    divisible();
                    break;

                case(6):
                    splitDate();
                    break;
             
                case(7):
                    firstArrays();
                    break;

                case(8):
                    secondArrays();
                    break;

                case(0):
                    System.out.println("Goodbye!"); 
                    close = true;
                    break;

                default:
                    System.out.println("\tError! You have not selected a valid menu option"); 
            }
        } while(!close);
    }    // end main

    /*
     * Name: sum2ints
     * Date: 22/04/2020
     * Import: nothing
     * Export: nothing
     * Purpose: output the result of two integers
     */
    public static void sum2ints()
    {
        Scanner sc = new Scanner(System.in);
        int numOne, numTwo, answer;
        int lower, upper;
        String prompt;

        numOne = inputInt("Please enter the first integer: ", 0, 100);  // how can we set the maximum to infinity? or at least the maximum size of an integer

        numTwo = inputInt("Please enter the second integer: ", 0, 100);

        answer = numOne + numTwo;
        System.out.println("\n\tThe answer is " + numOne + " + " + numTwo + " = " + answer);    
    }

    /*
     * Name: temp
     * Date: 22/04/2020
     * Import: nothing
     * Export: nothing
     * Purpose: converts a given temperature to Celcius/Farenheit and prints the result
     */

    public static void temp()
    {
        Scanner sc = new Scanner(System.in);
        double tempInCels, tempInFaren, farenheit, celcius;
        char choice;
        boolean finish;    
        String prompt;

        finish = false;    // because this is set to false the while loop will repeat untill this is set to true

        // sanatised input to be either 'C' or 'F', all other inputs will require the prompt to be issued again.
        do
        {
            System.out.print("What temperature are you working with? (C)elcius / (F)arenheit: ");
            choice = sc.next().charAt(0);
            choice = Character.toUpperCase(choice);

            switch(choice)
            {
                case('C'):
                    // get input
                    tempInCels = inputInt("Please enter the temperature in Celcius (c): ", 0, 99999);
                    // send input to converter
                    farenheit = calcFaren(tempInCels);
                    System.out.println("\n\tTemp in farenheit: " + farenheit);
                    finish = true;    // set to true to satisfy condition
                    break;
              
                 case('F'):
                    tempInFaren = inputInt("Please enter the temperature in Farenheit (f): ", 0, 99999);
                    celcius = calcCelcius(tempInFaren);
                    System.out.println("\n\tTemp in celcius: " + celcius);
                    finish = true;   // and again to satify condition
                    break;
            }
        } while(!finish);
    }

    /*
     * Name: charConv
     * Date: 22/04/2020
     * Import: nothing
     * Export: nothing
     * Purpose: changes a characters case
     */
    public static void charConv()
    {               
        Scanner sc = new Scanner(System.in);
        char uppercaseChar, lowercaseChar, choice, upperToLower, lowerToUpper;
        int upperAscii, lowerAscii;
        boolean cd;

        cd = false;

        do
        {
            System.out.println("Convert to (U)ppercase or (L)owercase?\nPlease select an option."); 
            choice = inputChar();
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
    }

    /*
     * Name: asciiConv
     * Date: 22/04/2020
     * Import: nothing
     * Export: nothing
     * Purpose: prints the ascii value of a character input
     */
    public static void asciiConv()
    {
        Scanner sc = new Scanner(System.in);
        char myChar;
        int charToAscii;

        do
        {
            System.out.println("Enter a character to convert to associated ASCII number."); 
            myChar = inputChar();
            charToAscii = (int)(myChar);
        } while ((charToAscii < 0) || (charToAscii > 127));

        System.out.println("\n\tASCII value: " + charToAscii); 
    }

    /*
     * Name: divisible
     * Date: 22/04/2020
     * Import: nothing
     * Export: nothing
     * Purpose: prints a message if two integers are divisible
     */
    public static void divisible()
    {
        Scanner sc = new Scanner(System.in);
        int numOne, numTwo;
        String prompt;

        System.out.println("Check if two integers are divisible."); 

        numOne = inputInt("Enter the first number: ", 0, 9999);

        numTwo = inputInt("Divided by: ", 0, 9999);

        if (numOne % numTwo != 0)
        {
            System.out.println("\n\tNot Divisible! "); 
        }
        else
        {
            System.out.println("\n\tDivisible! "); 
        }
    }

    public static void splitDate()
    {
        Scanner sc = new Scanner(System.in);
        double input, day, month, year;
        int roundedDay, roundedMonth, roundedYear, lower, upper;
        String prompt;

        prompt = "Enter the full date as an integer eg 01022020 for 1st of Feb, 2020: ";
        lower = 1010001;
        upper = 31129999;
        input = inputInt(prompt, lower, upper);

        // split the day
        day = input / 1000000;
        roundedDay = (int)(day);

        // split the month
        month = day % roundedDay;
        month = month * 100;
        roundedMonth = (int)(month);

        // split the year
        year = month % roundedMonth;
        year = year * 10000;
        roundedYear = (int)(year);

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
    }

    /*
     * Name: validDate
     * Date: 22/04/2020
     * Import: dayNo (integer)
     * Export: isValid (boolean)
     * Purpose: returns a string 
     */
    public static boolean validDate(int dayNo, int dayMin, int dayMax)
    {
        boolean isValid = false;
        if((dayNo > dayMin) && (dayNo <= dayMax))
        {
            isValid = true
        }
        else
        {
            isValid = false;
        }
        return isValid
    }

    /*
     * Name: firstArrays
     * Date: 22/04/2020
     * Import: nothing
     * Export: nothing
     * Purpose: creates an array of random numbers and then can search for a given index
     */
    public static void firstArrays()
    {
        Scanner sc = new Scanner(System.in);
        int size, min, max, number, search, lower, upper;
        int[] myArray;
        String prompt;
        Random rand = new Random();   // check Java API for more info

        // set the size of the arrray from user input
        size = inputInt("Please enter the size of the array (between 1 and 20 inclusive): ", 1, 20);
        myArray = new int[size];

        min = 1;
        max = 15;
        for(int i = 0; i < myArray.length; i++)    // loops through the array, increments of 1 
        {
            number = rand.nextInt((max - min) + 1) + min;   // get a random number between 1 and 15. rand.nextInt() takes a seed as an argument
            myArray[i] = number;
        }

        // Now we want to print the value at any given index
        search = inputInt("Please input the array postition: ", lower, myArray.length);   // the search number cannot be bigger than the length of the array 
        System.out.println("Found: " + myArray[search] + " at position " + search);       // eg myArray[5] will give the result 5 is the search value

    }                                                       

    /*
     * Name: secondArrays
     * Date: 22/04/2020
     * Import: nothing 
     * Export: nothing
     * Purpose: modular times table program
     */
    public static void secondArrays()
    {
        Scanner sc = new Scanner(System.in);
        int rows, cols;
        int[][] twoD;
        String prompt;

        prompt = "Please Enter Rows: ";
        rows = inputInt(prompt, 0, 9);

        prompt = "Please Enter Columns : ";
        cols = inputInt(prompt, 0, 9);

        System.out.println("The " + rows + " times " + cols + " table.\n ");

        System.out.print("  | ");
        for(int j = 0; j < cols; j++)     // header
        {
            System.out.print(j + 1 + "\t");
        }

        System.out.println("\n------------------------------------------------------------------");     // not exacly sure how to format this

        twoD = new int[rows + 1][cols  + 1];
        for(int i = 1; i < twoD.length; i++)    // rows
        {
            System.out.print(i + " | ");     // formats beginning of each row
            for(int j = 1; j < twoD[i].length; j++)    // cols
            {
                twoD[i][j] = i * j;
                System.out.print(twoD[i][j] + "\t");     // prints each element with tab spacing
            }
            System.out.println();    // move to the next line as we go through the loop again
        }
    }

    /*
     * Name: calcFaren
     * Date: 22/04/2020
     * Import: tempInCels (double)
     * Export: farenheit (double)
     * Purpose: converts celcius to farenheit
     */
    public static double calcFaren(double tempInCels)
    {
        double farenheit;
        farenheit = ((tempInCels * 9.0) / 5.0) + 32.0;
        return farenheit;
    }

    /*
     * Name: calcCelcius
     * Date: 22/04/2020
     * Import: tempInFaren (double)
     * Export: celcius (double)
     * Purpose: converts farent to celcius
     */
    public static double calcCelcius(double tempInFaren)
    {
        double celcius;
        celcius = (tempInFaren - 32) * 5 / 9;
        return celcius;
    }

 
    public static char inputChar()
    {
        Scanner sc = new Scanner(System.in);
        char character;
        character = sc.next().charAt(0);
        return character;
    }

    /*
     * Name: inputInt 
     * Date: 22/04/2020
     * Import: prompt (String), lower (int), upper (int) 
     * Export: integer (int)
     * Purpose: returns a valid integer - given its upper and lower bounds
     */
    public static int inputInt(String prompt, int lower, int upper)
    {
        Scanner sc = new Scanner(System.in);
        String outputPrompt, errorMsg;
        int integer;

        errorMsg = "\nERROR value must be between " + lower + " and " + upper;
        outputPrompt = prompt;
        do
        {
            System.out.print(outputPrompt);
            integer = sc.nextInt();
            outputPrompt = errorMsg + "\n" + prompt;
        } while ((integer < lower) || (integer > upper));    // will loop until condition is false
        
        return integer;
    }
}
