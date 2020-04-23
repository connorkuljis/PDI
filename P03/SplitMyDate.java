// FILE:     SplitMyDate.java
// AUTHOR:   Connor Kuljis
// USERNAME: 19459138
// UNIT: PDI
// PURPOSE: splits a long date into day, month and year. Checks for valid dates and leap years
// REFERENCE:
// COMMENTS:
// REQUIRES:
// LAST MOD: 24th March 2020

import java.util.*;

public class SplitMyDate
{
    public static void main(String[] args)
    {
        double input, day, month, year;
        int roundedDay, roundedMonth, roundedYear;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the date as a full number eg: [date][month][year] : 00/00/0000"); 
        input = sc.nextDouble();

        // split the day
        day = input / 1000000;
        roundedDay = (int)(day);
        // System.out.println(roundedDay); 

        // split the month
        month = day % roundedDay;
        month = month * 100;
        roundedMonth = (int)(month);
        // System.out.println(roundedMonth); 

        // split the year
        year = month % roundedMonth;
        year = year * 10000;
        roundedYear = (int)(year);
        // System.out.println(roundedYear); 
 
        switch(roundedMonth)
        { 
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                // days in month = 31
                if((roundedDay > 0) && (roundedDay <= 31))
                {
                    System.out.println("It is day " + roundedDay + " of month " + roundedMonth + ", in the year " + roundedYear); 
                }
                else
                {
                    System.out.println("Not a valid date");    
                }
            break;
            case 4: case 6: case 9: case 11:
                // days in month = 30
                if((roundedDay > 0) && (roundedDay <= 30))
                {
                    System.out.println("It is day " + roundedDay + " of month " + roundedMonth + ", in the year " + roundedYear); 
                }
                else
                {
                    System.out.println("Not a valid date");    
                }
            break;
            case 2:
                // days in month = 29 if not a leap year
                if(roundedYear % 4 != 0)
                {
                    if((roundedDay) > 0 && (roundedDay <=29))
                    {
                        System.out.println("It is day " + roundedDay + " of month " + roundedMonth + ", in the year " + roundedYear); 
                    }
                    else
                    {
                        System.out.println("Not a valid date");           
                    }
                }
                else
                {
                    if((roundedDay) > 0 && (roundedDay <=29))
                    {
                        System.out.println("It is day " + roundedDay + " of month " + roundedMonth + ", in the year " + roundedYear + ". It is a leap year"); 
                    }
                    else
                    {
                        System.out.println("Not a valid date"); 
                    } 
                }
            break;
            default:
                System.out.println("Not a valid date"); 
        }
    }
}
