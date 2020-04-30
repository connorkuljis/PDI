// FILE: Markup,java
// AUTHOR: Connor Kuljis
// USERNAME: 19459138
// UNIT: PDI
// Purpose: approximates markups constant
// Comments:
// Requires:
// Last Mod:

import java.util.*;
public class Markup
{
    public static void main(String[] args)
    {
        System.out.println("Approximation of Markup's Constant: \n");
        int n = validInt("Enter number of terms to approximate Markup's Constant (between 2 and 35 inclusive): ", 2, 35);
        int k = validInt("Enter precision (between 5 and 100 inclusive): ", 5, 100);

        double[] emptyArray, markupArray, fullArray;
        
        // creating the array
        emptyArray = createArray(n);

        // filling the array with values
        markupArray = calcArray(emptyArray, k);

        // calculating the last term
        fullArray = lastValue(markupArray);

        // printing the array
        printArray(fullArray);

    }

    /* NAME: validInt
     * Purpose: return a valid integer within the given bounds
     * IMPORTS: prompt, min, max
     * EXPORTS: value */
    public static int validInt(String prompt, int min, int max)
    {
        String errorMsg, outMsg;
        int value;
        errorMsg = "ERROR: Value must be between " + min + " and " + max + " ";
        outMsg = prompt;
        do
        {
            Scanner sc = new Scanner(System.in);
            System.out.println(outMsg);
            value = sc.nextInt();
            outMsg = errorMsg + prompt;
        } while ((value < min) || (value > max));
        return value;
    }

    /* NAME: createArray
     * Purpose: creates an array of size n + 1 to allow for empty space at end
     * IMPORTS: n
     * EXPORTS: markupArray */
    public static double[] createArray(int n)
    {
        double[] markupArray = new double[n+1];
        return markupArray;
    }

    /* NAME: calcMarkup
     * Purpose: performs the operation/ algorithm for each element
     * IMPORTS: n, k, iterator
     * EXPORTS: value */
    public static double calcMarkup(int n, int k, int iterator)
    {
        double i, j, nume, denom, value, iSquared;

        i = iterator + 1; // start i at 1
        j = iterator;     // start j at 0

        iSquared = Math.pow(i, 2.0);
        nume = iSquared * (j + 1.0);
        denom = 4.0 * n * k;
        value = nume / denom;
        return value;
    }

    /* NAME: calcArray
     * Purpose: calculates each individual element in the array
     * IMPORTS: markupArray, k
     * EXPORTS: markupArray*/
    public static double[] calcArray(double[] markupArray, int k)
    {
        // going through each element of the array
        for (int i=0; i < markupArray.length - 1; i++)
        {
            int x = i + 1;
            markupArray[i] = calcMarkup(x, k, i);
        }
        return markupArray;
    }

    /* NAME: lastValue
     * Purpose: sums the array to calculate the last term and store it in the final value
     * IMPORTS: markupArray
     * EXPORTS: markupArray*/
    public static double[] lastValue(double[] markupArray)
    {
        double total = 0.0;
        for (int i= 0; i < markupArray.length -1; i++)
        {
            total = total + markupArray[i];
        }
        markupArray[markupArray.length - 1] = total;
        return markupArray;
    }

    /* NAME: printArray
     * Purpose: print every element in an array
     * IMPORTS: prrintableArray
     * EXPORTS: none*/
    public static void printArray(double[] printableArray)
    {
        System.out.println("Approximation: \n");
        for (int i=0; i < printableArray.length-1; i++)
        {
            System.out.println(printableArray[i]);
        }
        System.out.println("Approx: " + printableArray[printableArray.length -1]);
    }
}
