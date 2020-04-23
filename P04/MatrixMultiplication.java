/*
FILE       : MatrixMultiplication.java
AUTHOR     : Connor Kuljis
USERNAME   : 19459138
PURPOSE    : Multiplys two matrices
REFERENCE  :
COMMENTS   : The algorithm uses nested for loops to multiply two arrays
REQUIRES   : Makes use of Matrix.java that contains a class used to store some sample arrays
LAST MOD   : 6th April 2020
*/

import java.util.*;
public class MatrixMultiplication
{
    public static void main(String[] args)
    {
        int[][] arrayA = Matrix.ARRAY_A;
        int[][] arrayB = Matrix.ARRAY_B;
        int aRows, aCols, bRows, bCols;

        aRows = arrayA.length;     // 2
        aCols = arrayA[0].length;  // 3
 
        bRows = arrayB.length;     // 3
        bCols = arrayB[0].length;  // 2

        System.out.println("Matrix A: " + aRows + " x " + aCols); 
        System.out.println("Matrix B: " + bRows + " x " + bCols); 

        if (aCols == bRows)
        {
            int[][] arrayC = new int[aRows][bCols];
            int sum = 0;

            // nesting loops to access each element individually
            for ( int i=0; i < arrayC.length; i++ )
            {
                for ( int j=0; j < arrayC[0].length; j++ )
                {
                    for ( int k=0; k < arrayA[0].length; k++ )     // loops 3 times(number of columns)
                    {
                        sum = sum + arrayA[i][k] * arrayB[k][j];   // au + bw + cy
                    }                                              // same as formula given
                    arrayC[i][j] = sum;
                    sum = 0;
                }    
            }
          
            // printing the array
            for ( int i=0; i < arrayC.length; i++ )
            {
                for(int j=0; j < arrayC[0].length; j++ )
                {
                    System.out.print(arrayC[i][j] + " ");    // spaces between each element
                }
                System.out.println();  // new lines on each row
            }

        }
        else
        {
            System.out.println("Error: can not multiply"); 
        }
    }
}
