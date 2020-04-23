// FILE: CelsToFaren.java
// AUTHOR: Connor Kuljis
// USERNAME: 19459138
// UNIT: PDI
// PURPOSE: Converts celcius to farenheit
// REFERENCE: None
// COMMENTS: For Prac3 of PDI
// REQUIRES:
// LAST MOD: 03/03/2020

import java.util.*;

public class CelsToFaren
{
    public static void main(String[] args)
    {
        double tempInCels, tempInFaren, farenheit, celcius; 
        char choice;
        System.out.println("What temperature are you working with? (C)elcius / (F)arenheit");
        Scanner sc = new Scanner(System.in);
        choice = sc.next().charAt(0);

        if (choice == 'C' || choice == 'c')
        {
            System.out.println("Please enter the temperature in Celsius (c)");
            tempInCels = sc.nextDouble();
           
            farenheit = ((tempInCels * 9.0) / 5.0) + 32.0;

            System.out.println("Temp in farenheit: " + farenheit);
        }
        else if (choice == 'F' || choice == 'f')
        {
            System.out.println("Please enter the temperature in Farenheit (f)");
            tempInFaren = sc.nextDouble();

            celcius = (tempInFaren -32) * 5 / 9;

            System.out.println("Temp in celcius: " + celcius);
        }
    }
}
