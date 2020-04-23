// FILE     : AssignmentTask.java
// AUTHOR   : Connor Kuljis
// USERNAME : 19459138
// UNIT     : PDI
// PURPOSE  : Produces a convoluted matrix/array given the original array and the kernel
// REFERENCE: Convolute.java, Kernel.java
// COMMENTS : Unsure of how to output the arrays in a grid format as shown in the worksheet
// REQUIRES : Convolute.java, Kernel.java
// LAST MOD : 23/04/2020

import java.util.*;
public class AssignmentTask
{
    public static void main(String[] args)
    {
        int resultArray[][];
        int[][] convolute = Convolute.MATRIX_D;
        int[][] kernel = Kernel.VERTICAL;

        resultArray = createResultArray(convolute, kernel);  // this is going to give us a correctly sized resultArray
        calcResult(resultArray, convolute, kernel);          // filling this correctly sized array with the convolute algorithm

        printArray("Convolute", convolute);

        printArray("Kernel", kernel);

        printArray("Result", resultArray);
    } // end main

    /*
     * Name: createResultArray
     * Date: 23/04/2020
     * Import: convolute (2D array of integers), kernel (2D array of integers)
     * Export: resultArray (2D array of integers)
     * Purpose: returns a correctly sized result array
     */
    public static int[][] createResultArray(int[][] convolute, int[][] kernel)
    {
        int n, m, k;
        int[][] resultArray;

        // getting dimentions of the convolute array
        n = convolute.length;        // rows
        m = convolute[0].length;     // columns

        k = kernel.length;    // getting dimensions of kernel assuming it is k by k

        // producing a valid result array
        resultArray = new int[(n - k + 1)][(m - k + 1)];
        
        return resultArray;
    }

    /*
     * Name: calcResult
     * Date: 23/04/2020
     * Import: resultARray (2D array of integers), convolute (2D array of integers), kernel (2D array of integers)
     * Export: resultArray (2D array of integers)
     * Purpose: returns a populated sized result array
     */
    public static int[][] calcResult(int[][] resultArray, int[][] convolute, int[][] kernel)
    {
        // simply loops through each position in the result array
        for(int i = 0; i < resultArray.length; i++)
        {
            for(int j = 0; j < resultArray[0].length; j++)
            {
                resultArray[i][j] = calcConvolute(i, j, convolute, kernel); 
            }
        }
        return resultArray;
    }

    /*
     * Name: calcConvolute
     * Date: 23/04/2020
     * Import: x (integer), y (integer), convolute (2D array of integers), kernel (2D array of integers)
     * Export: result (integer)
     * Purpose: this submodule performs the convolution operation
     */
    public static int calcConvolute(int x, int y, int[][] convolute, int[][] kernel)
    {
        int result = 0;

        // we are going to multiply everything in the kernel by the given convolute positions (x,y) <-- how much we are going to shift the kernel overlay
        for(int a = 0; a < kernel.length; a++)
        {
            for(int b = 0; b < kernel[0].length; b++)
            {
                result = result + convolute[a + x][b + y] * kernel[a][b];
            }
        }
        return result;
    }

    /*
     * Name: printArray
     * Date: 23/04/2020
     * Import: name (String), pArray (2D array of integers)
     * Export: nothing
     * Purpose: prints a 2D array
     */
    public static void printArray(String name, int[][] pArray)
    {
        System.out.println(name + ":");
        for(int i = 0; i < pArray.length; i++)
        {
            for(int ii = 0; ii < pArray[0].length; ii++)
            {
                System.out.printf("%4d", pArray[i][ii]);  // formatting using printf
            }
            System.out.println();
        }
    }
}
