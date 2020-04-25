// FILE: PI.java
// AUTHOR: Connor Kuljis
// ID: 19459138
// UNIT: PDI
// DATE: 25/04/2020
// PURPOSE: Approximation of Pi

import java.util.*;
import java.lang.Math;
public class PI
{
    public static void main(String[] args)
    {
        double[] piArray = storeArray();
        double[] newArray = sumArray(piArray);
        printArray(newArray);
    } // end main

    /* Name: storeArray
     * Imports nothing
     * Exports: piArray (2D Array of integers)
     * Purpose: creates a valid array and stores the calculation at each term 
     * Assertion: using two variables to reduce arithmetic errors with brackets/precedence*/
    public static double[] storeArray()
    {
        int k = inputInteger("Enter number of terms (k) between 20 and 100. ", 20, 100);
        double theta = inputDouble("Enter degrees between 0 and 360 inclusive: ", 0, 360);
        double radians = Math.toRadians(theta);

        double[] piArray = new double[k + 1]; // add 1 at end to put sum value eg pi approximation

        for(int i=0; i < piArray.length - 1; i++) // exclude last value of array
        {
            double nume = Math.sin(radians * ((2 * i) + 1));
            double denom = (2 * i) + 1;
            double pi = nume / denom;
            pi = pi * 4;
            piArray[i] = pi;
        }
        return piArray;
    }

    /* Name: sumArray
     * Imports piArray (2D Array of integers)
     * Exports: piArray (2D Array of integers)
     * Purpose: calculates the approximation of pi by summing all the elements and returns the new array*/
    public static double[] sumArray(double[] piArray)
    {
        double piApprox = 0.0;
        for(int i=0; i<piArray.length; i++)
        {
            piApprox = piApprox + piArray[i];
        }

        piArray[piArray.length -1] = piApprox;
        return piArray;
    }

    /* Name: printArray
     * Imports piArray (2D Array of integers)
     * Exports: nothing
     * Purpose: prints an array
     * Assertion: array[0] is the first term eg: element 1 and the last element is the approximation of PI*/
    public static void printArray(double[] piArray)
    {
        for(int i=0; i<piArray.length - 1; i++) // going to print every term EXCEPT the last term
        {
            System.out.println((i + 1) + ": " + piArray[i]); // array[0] = term n = 1
        }
        System.out.println("PI approx: " + piArray[piArray.length - 1]);  // printing the last element

    }

    /* Name: inputDouble
     * Imports: prompt (String), lower (integer), max (integer)
     * Exports: value (double)
     * Purpose: validates double input */
    public static double inputDouble(String prompt, int lower, int upper)
    {
        Scanner sc = new Scanner(System.in);
        String outputPrompt, errorMsg;
        double value;

        errorMsg = "\nERROR value must be between " + lower + " and " + upper;
        outputPrompt = prompt;
        do
        {
            System.out.print(outputPrompt);
            value = sc.nextDouble();
            outputPrompt = errorMsg + "\n" + prompt;
        } while ((value< lower) || (value> upper));    // will loop until condition is false
        return value;
    }

    /* Name: inputInteger
     * Imports: prompt (String), lower (integer), max (integer)
     * Exports: value (integer)
     * Purpose: validates integer input */
    public static int inputInteger(String prompt, int lower, int upper)
    {
        Scanner sc = new Scanner(System.in);
        String outputPrompt, errorMsg;
        int value;

        errorMsg = "\nERROR value must be between " + lower + " and " + upper;
        outputPrompt = prompt;
        do
        {
            System.out.print(outputPrompt);
            value = sc.nextInt();
            outputPrompt = errorMsg + "\n" + prompt;
        } while ((value< lower) || (value> upper));    // will loop until condition is false
        return value;
    }
}
