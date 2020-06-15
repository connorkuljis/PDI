/* FILE: Levenstein
 * AUTHOR: CONNOR KULJIS
 * STUDENT ID: 19459138
 * UNIT: PDI
 * PURPOSE: levensteins finds the difference between two strings
 * DATE: 15/06/2020
 */
import java.util.*;

public class Levenstein
{
    public static void main(String[] args)
    {
	System.out.println(calculateLevenshtein("kitten", "sitting")); 
    }


    /*
    SUBMODULE: calculateLevenshtein
    IMPORTS: x (String), y (String)
    EXPORTS: result(Integer)
    ASSERTION: will return the difference between 2 strings
    NOTICE: This has been taken from PDI LECTURE 10 slide 22 (acessed 15/06/2020)
    */
    public static int calculateLevenshtein(String x, String y)
    {
	int result = 0;
	int[][] dp = new int[x.length()][y.length()]; // setting up the matrix
	for (int ii = 0; ii < x.length(); ii++) // looping through the first string
	{
	    for (int jj = 0; jj < y.length(); jj++) // looping through the second string
	    {
		if (ii == 0)  // checking if there is no substition to be made
		{
		    dp[ii][jj] = jj; 
		}
		else if (jj == 0)
		{
		    dp[ii][jj] = ii;
		}
		else
		{
		    // take 3 values adjacent to current position in matrix
		    int cost = dp[ii-1][jj-1] + costOfSubstitution(x.charAt(ii-1), y.charAt(jj-1)); // previous element + the cost of sub
		    int top = dp[ii-1][jj]; // element above
		    int previous = dp[ii][jj-1]; // element directly to the left
		    dp[ii][jj] = min(cost, top, previous);
		}
	    }
	}
	result = dp[x.length() - 1][y.length() - 1]; // answer will be diagonal in the last corner 
	return result;
    }

    /*
    SUBMODULE: costOfSubstitution
    IMPORTS: x (Character), y (Character)
    EXPORTS: substitutionCost (Integer)
    PURPOSE: returns 1 if two characters are different
    */
    public static int costOfSubstitution(char x, char y)
    {
	int substitutionCost = 0;
	if (x == y)
	{
	    substitutionCost = 0;
	}
	else
	{
	    substitutionCost = 1;
	}
	return substitutionCost;
    }

    /*
    SUBMODULE: min
    IMPORTS: a, b, c (Integer)
    EXPORTS: min (integer)
    PURPOSE: returns the minimum of given three values
    */
    public static int min(int a, int b, int c)
    {
	int min = 0;
	if (a < b && a < c)
	{
	    min = a;
	}
	else if (b < a && b < c)
	{
	    min = b;
	}
	else if (c < a && c < b)
	{
	    min = c;
	}
	return min;
    }
}
