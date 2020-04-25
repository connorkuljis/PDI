// FILE:     Arrays.java
// AUTHOR:   Connor Kuljis
// USERNAME: 19459138
// UNIT: PDI
// PURPOSE:  
// REFERENCE:
// COMMENTS:
// REQUIRES:
// LAST MOD: 6th April 2020

import java.util.*;
public class Arrays
{
    public static void main(String[] args)
    {
        int size, min, max, number, search;
        int[] myArray;
        String prompt, errorMsg, out;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();   // check Java API for more info

        prompt = "\nPlease enter the size of the array (between 1 and 20 inclusive) "; 
        errorMsg = "Error: The value must be between 1 and 20. ";
        out = prompt;
        do 
        {
            System.out.println(out); 
            size = sc.nextInt();
            out = errorMsg + prompt;
        } while((size < 1) || (size > 20));    // repeats until condition is set to true

        myArray = new int[size];
        
        min = 1;
        max = 15;
        for(int i = 0; i < myArray.length; i++)    // initialise at 0, stop 
        {
            number = rand.nextInt((max - min) + 1) + min;   // get a random number between 1 and 15. rand.nextInt() takes a seed as an argument
            myArray[i] = number;
        }

        prompt = "\nPlease input the array position.";
        errorMsg = "Error: The value must be greater than 0.";
        out = prompt;
        do
        {
            System.out.println(out);
            search = sc.nextInt(); 
            out = errorMsg + prompt;
        } while (search <= 0);
 
        // System.out.println("Found: " + myArray[search] + " at position " + search); 
        if (search < myArray.length)
        {
            System.out.println("Found: " +  myArray[search]); 
        }
        else
        {
            System.out.println("Not found: " + search);
        } 

    }
}
