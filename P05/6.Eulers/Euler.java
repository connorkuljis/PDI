// FILE     : Euler.java
// AUTHOR   : Connor Kuljis
// USERNAME : 19459138
// UNIT     : PDI
// PURPOSE  : Approximates eulers constant
// REFERENCE: 
// COMMENTS : main could be made more modular, but works for now
// REQUIRES : 
// LAST MOD : 24/04/2020
//
import java.util.*;
public class Euler
{
    public static void main(String[] args)
    {
        int n = getInt("Enter the number of terms to approximate e: ", 6, 100);
        double[] factorialArray = new double[n+1];  // where we are going to store our values
        factorialArray[0] = 1; // set the first element to 0

        for(int i=1; i<n; i++)  // start the loop at the 2nd element
        {
            factorialArray[i] = calcTerms(i);
        }
        lastValue(factorialArray); // adding the last elemnt to sum
    } // end main

    // SUBMODULE: getInt
    // IMPORTS: String prompt, int min, int max
    // EXPORTS: int n, valid number given the constraints
    public static int getInt(String prompt, int min, int max)
    {
        Scanner sc = new Scanner(System.in);
        String errorPrompt, outPrompt;
        errorPrompt = "Error - input must be between " + min + " and " + max +  " inclusive.\n";
        outPrompt = prompt;

        int n;
        do
        {
            System.out.print(outPrompt);
            n = sc.nextInt();
            outPrompt = errorPrompt + prompt;
        } while((n < min ) || (n > max));
        return n;
    }

    // SUBMODULE: calcTerms
    // IMPORTS: int x, number of terms
    // EXPORTS: double value, this is our approximation
    public static double calcTerms(int x)
    {
        // initialise
        double value;
        double factorial = 1.0;

        for(int i=1; i<=x; i++) 
        {
            factorial = factorial * i;
        }
        value = 1.0 / factorial;
        return value;
    }

    // SUBMODULE: printArray
    // IMPORTS: double[] pArray
    // EXPORTS: nothing
    public static void printArray(double[] pArray)
    {
        for(int i=0; i<pArray.length; i++)
        {
            System.out.println(pArray[i]);
        }
    }

    // SUBMODULE: lastValue
    // IMPORTS: double[] myArray
    // EXPORTS: nothing
    public static void lastValue(double[] myArray)
    {
        int limit = myArray.length - 1;
        double e = 0.0;

        for(int i=0; i<limit; i++)
        {
            e += myArray[i];
        }

        myArray[limit] = e;
        printArray(myArray);
    }

}
