// FILE:     Menu.java
// AUTHOR:   Connor Kuljis
// USERNAME: 19459138
// UNIT: PDI
// PURPOSE: Combines all the programs up to prac 3 into a single menu 
// REFERENCE: see P02 and P03
// COMMENTS: ignored option 6
// REQUIRES:
// LAST MOD: 24th March 2020

import java.util.*;

public class Menu
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Programming Design and Implementation, Workshop 3 ");
        System.out.println("What would you like to do?"); 
        System.out.println("1. Sum of 2 Integers"); 
        System.out.println("2. Convert a Temperature"); 
        System.out.println("3. Convert a Characters Case"); 
        System.out.println("4. Print the ASCII equivalent of a Character"); 
        System.out.println("5. Check if 2 Integers are divisable"); 
        System.out.println("6. Split a date into its components"); 
        System.out.println("0. Exit"); 

        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
  
        switch(ch)
        {
            case(1):
                System.out.println("Enter the first number: "); 
                double numOne = sc.nextDouble();
       
                System.out.println("Enter the second number: "); 
                double numTwo = sc.nextDouble();
          
                double answer = numOne + numTwo;
  
                System.out.println("The answer is " + numOne + " + " + numTwo + " = " + answer); 
                break;

            case(2):
                double tempInCels, tempInFaren, farenheit, celcius;
                char choice1;
                System.out.println("What temperature are you working with? (C)elcius / (F)arenheit");
                choice1 = sc.next().charAt(0);

                if (choice1 == 'C' || choice1 == 'c')
                {
                    System.out.println("Please enter the temperature in Celsius (c)");
                    tempInCels = sc.nextDouble();

                    farenheit = ((tempInCels * 9.0) / 5.0) + 32.0;

                    System.out.println("Temp in farenheit: " + farenheit);
                }
                else if (choice1 == 'F' || choice1 == 'f')
                {
                    System.out.println("Please enter the temperature in Farenheit (f)");
                    tempInFaren = sc.nextDouble();

                    celcius = (tempInFaren -32) * 5 / 9;

                    System.out.println("Temp in celcius: " + celcius);
                }
                break;

            case(3):
                char uppercaseChar, lowercaseChar, choice, upperToLower, lowerToUpper;
                int upperAscii, lowerAscii;

                System.out.println("Convert to (U)ppercase or (L)owercase?\nPlease select an option."); 
                choice = sc.next().charAt(0);

                if (choice ==  'U' || choice == 'u')
                {
                    // get user input as char and convert to integer (ascii)
                    System.out.println("Please enter a lowercase character");
                    lowercaseChar = sc.next().charAt(0);
                    lowerAscii = (int)(lowercaseChar);    

                    // check if ascii number is within lowercase range
                    if ((lowerAscii > 96) && (lowerAscii < 123 ))
                    {
                        lowerToUpper = (char)(lowerAscii - 32);
                        System.out.println("Uppercase: " + lowerToUpper);
                    }
                    else
                    {
                        System.out.println("Error! Not a lowercase character"); 
                    }
                }
                else if (choice == 'L' || choice == 'l')
                {
                    System.out.println("Please enter an uppercase character");
                    uppercaseChar = sc.next().charAt(0);
                    upperAscii = (int)(uppercaseChar);

                    // check if ascii number is within uppercase range
                    if ((upperAscii > 64) && (upperAscii < 91))
                    {
                        upperToLower = (char)(upperAscii + 32);
                        System.out.println("Lowercase: " + upperToLower);
                    }
                    else
                    {
                        System.out.println("Error! Not an uppercase character"); 
                    }
                }
                break;

            case(4):
                System.out.println("Enter a character to convert to ASCII number."); 
                char myChar = sc.next().charAt(0);
  
                int charToAscii = (int)(myChar);
                System.out.println("ASCII value: " + charToAscii); 
                break;

            case(5):
                System.out.println("Check if two integers are divisable."); 
                int intOne, intTwo;
 
                System.out.println("Enter first integer. "); 
                intOne = sc.nextInt();

                System.out.println("Enter second integer. "); 
                intTwo = sc.nextInt();
  
                if (intOne % intTwo != 0)
                {
                    System.out.println("Not Divisible! "); 
                }
                else
                {
                    System.out.println("Divisible! "); 
                }
                break;

            case(6):
                System.out.println("This has not been implemented yet"); 
                break;
         
            case(0):
                System.out.println("Goodbye!"); 
                break;

            default:
                

     
 

        }
    }
}
