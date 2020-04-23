// FILE:     TwoDArrays.java
// AUTHOR:   Connor Kuljis
// USERNAME: 19459138
// UNIT: PDI
// PURPOSE: uses nested for loops and nested for loops to produce a times table matrix
// REFERENCE: 
// COMMENTS: line 27: not sure how to format dotted line to match column size
// REQUIRES:
// LAST MOD: 6th April 2020 

import java.util.*;
public class TwoDArrays
{
    public static void main(String[] args)
    {
        int rows, cols;
        int[][] twoD;
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Please Enter Rows: ");
        rows = sc.nextInt();
 
        System.out.print("Please Enter Columns : ");
        cols = sc.nextInt();
        
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
}
