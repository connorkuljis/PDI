/* FILE: NumberConverter 
 * Author: Connor Kuljis
 * Date: 15/06/2020
 * Unit: PDI
 * Purpose: Number Converter
 * NOTE: TEST VALUES; BINARY TO OCTAL = 100011010 OUTPUT 4 3 2
 *                    BINARY TO HEXADECIMAL = 100011010001 OUTPUT 8 D 1
 */

import java.util.*;
public class NumberConverter
{
    public static void main(String[] args)
    {
 	menu();

    }

    // NAME: menu
    // IMPORTS: none
    // EXPORTS: none
    // PURPOSE: acts as a driver menu
    public static void menu()
    {
	boolean close = false;
	do
	{
	    Scanner sc = new Scanner(System.in);
	    // ask for input
	    System.out.println("Please select 1.Binary, 2. Decimal, 3. Octal, 4. Hexadecimal. 0. Exit"); 
	    int choice = sc.nextInt();

	    // initialise values
	    String input = "";
	    boolean isReal = false;

	    switch(choice)
	    {
		case 1: // binary
		    input = inputNumber();
		    isReal = isRealNumber(input);
		    convertSubMenu(input, isReal);
		    break;
		case 2: // decimal
		    input = inputNumber();
		    isReal = isRealNumber(input);
		    convertSubMenu(input, isReal);
		    break;
		case 3: // octal
		    input = inputNumber();
		    isReal = isRealNumber(input);
		    convertSubMenu(input, isReal);
		    break;
		case 4: // hexadecimal
		    input = inputNumber();
		    isReal = isRealNumber(input);
		    convertSubMenu(input, isReal);
		    break;
		case 0: // exit
		    System.out.println("Goodbye"); 
		    close = true; // teminate loop
		    break;
		default: // if an invalid input
		    System.out.println("Please select a valid option."); 
		    break;
	    }
	}while(!close);
    }

    // NAME: inputNumber
    // IMPORTS: none
    // EXPORTS: input (String)
    // PURPOSE: accepting input for alphanumeric string
    public static String inputNumber()
    {
	System.out.println("Please enter a numeric string to covert"); 
	Scanner sc = new Scanner(System.in);
	String input = sc.next();
	return input;
    }

    // NAME: isRealNumber
    // IMPORTS: number String)
    // EXPORTS: real (boolean)
    // PURPOSE: returns true is the number is a real number (has decimal point)
    public static boolean isRealNumber(String number)
    {
	boolean real = false;
	try
	{
	    String[] splitString = number.split("//.");
	    real = true;
	}
	catch(Exception e)
	{
	    real = false;
	}
	return real;
    }

    // NAME: convertSubMenu
    // IMPORTS: input (String)
    // EXPORTS: isReal(boolean)
    // PURPOSE: a sub-menu to selec the output type
    public static void convertSubMenu(String input, boolean isReal)
    {
	System.out.println("What would you like to convert to: 1.Binary, 2. Decimal, 3. Octal, 4. Hexadecimal. 0. Exit"); 
	Scanner sc = new Scanner(System.in);
	int choice = sc.nextInt();
	boolean close = false;
	switch(choice)
	{
	    case 1: // binary
		break;
	    case 2: // Decimal
		break;
	    case 3: // Octal
		if (!isReal)
		{
		    System.out.println("Will not convert as a real number has been entered"); 
		}
		else
		{
		    binaryToOctal(input);
		}
		break;
	    case 4: // Hex
		if (isReal)
		{
		    System.out.println("Will not convert as a real number has been entered"); 
		}
		else
		{
		    binaryToHex(input);
		}
		break;
	    case 0:
		System.out.println("Goodbye"); 
		break;
	    default:
		System.out.println("Please select a valid option."); 
		break;
	}
    }


    // NAME: printArray
    // IMPORTS: myArray (ARRAY of String)
    // EXPORTS: none
    // PURPOSE: prints all elements in array
    public static void printArray(String[] myArray)
    {
	System.out.println("PRINTING OUTPUT"); 
	for (int i=myArray.length - 1; i >= 0; i--)
	{
	    System.out.print(myArray[i] + " "); 
	}
    }

    // NAME: binaryToOcatal
    // IMPORTS: number (String)
    // EXPORTS: none
    // PURPOSE: prints binary number in Octal
    public static void binaryToOctal(String number)
    {
	String[] groupedStrings = split(number, 3);
	int[] exponents = {4,2,1};
	String[] converted = sumGroups(groupedStrings, exponents);
	printArray(converted);
    }

    // NAME: binaryToHex
    // IMPORTS: numer (String)
    // EXPORTS: none
    // PURPOSE: prints binary number in Hex
    public static void binaryToHex(String number)
    {
	String[] groupedStrings = split(number, 4);
	int[] exponents = {8,4,2,1};
	String[] converted = sumGroups(groupedStrings, exponents);
	String[] newconverted = hexMap(converted);
	printArray(newconverted);
    }

    // NAME: hexMap
    // IMPORTS: converted (Array of String)
    // EXPORTS: converted (Array of String)
    // PURPOSE: converts groups to Hexadecimal if the value is 13 or more
    public static String[] hexMap(String[] converted)
    {
	for (int i = 0; i < converted.length - 1; i++)
	{
	    if(converted[i] == null)
	    {
		System.out.println("0"); 
	    }
	    else if (converted[i].equals("10"))
	    {
		converted[i] = "A";
	    }
	    else if (converted[i].equals("11"))
	    {
		converted[i] = "B";
	    }
	    else if (converted[i].equals("12"))
	    {
		converted[i] = "C";
	    }
	    else if (converted[i].equals("13"))
	    {
		converted[i] = "D";
	    }
	    else if (converted[i].equals("14"))
	    {
		converted[i] = "E";
	    }
	    else if (converted[i].equals("15"))
	    {
		converted[i] = "F";
	    }
	}
	return converted;
    }

    // NAME: sumGroups
    // IMPORTS: groupedStrings (Array of String), exponents (Array of Integers)
    // EXPORTS: converted (Array of String)
    // PURPOSE: finds the sum of each binary group.
    public static String[] sumGroups(String[] groupedStrings, int[] exponents)
    {
	String[] converted = new String[exponents.length];
	for (int i = 0; i < groupedStrings.length - 1; i++)
	{
	    // System.out.println(groupedStrings[i]); 
	    int sum = 0;
	    for (int j = 0; j < groupedStrings[i].length(); j++)
	    {
		int number = Character.getNumericValue(groupedStrings[i].charAt(j));
		int exponent = exponents[j];
		sum = sum + (number * exponent);
		// System.out.print(groupedStrings[i].charAt(j)); 
	    }
	    converted[i] = String.valueOf(sum);
	}
	return converted;
    }

    // NAME: split
    // IMPORTS: number(String), grouping (int)
    // EXPORTS: groupedStrings (Array of String)
    // PURPOSE: splits the numeric string into groups, defined by the grouping value
    public static String[] split(String number, int grouping)
    {
	int count = 0;
	for (int i = number.length(); i >= 0; i -= grouping) // check how many 'groups'
	{
	    count++; 
	}
	String[] groupedStrings = new String[count]; // allocate array the size of groups

	count = 0; // reset count
	for (int i = number.length(); i >= 0; i -= grouping)
	{
	    int temp = i - grouping; // simplify substring expression
	    groupedStrings[count] = number.substring(max(temp, 0), i); // append string to array
	    count++; // then increment count (start at 0)
	}
	return groupedStrings;
    }

    // NAME: max
    // IMPORTS: a (integer), b (integer)
    // EXPORTS: max (integers)
    // PURPOSE: returns the greatest value
    public static int max(int a, int b)
    {
	int max = 0;
	if (a > b)
	{
	    max = a;
	}
	else if (b > a)
	{
	    max = b;
	}
	return max;
    }
}
