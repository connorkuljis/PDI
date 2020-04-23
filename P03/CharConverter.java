// FILE:     CharConverter.java
// AUTHOR:   Connor Kuljis
// USERNAME: 19459138
// UNIT: PDI
// PURPOSE: Allows the user to convert all lowercase to uppercase and vice versa
// REFERENCE:
// COMMENTS:
// REQUIRES:
// LAST MOD: 24th March 2020
import java.util.*;

public class CharConverter
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
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
    }
}
