// FILE     : Date.java
// AUTHOR   : Connor Kuljis
// USERNAME : 19459138
// UNIT     : PDI
// PURPOSE  : class of an date object
// REFERENCE: worksheet 6 q 2
// COMMENTS : 
// REQUIRES : none
// LAST MOD : 02/05/2020
import java.util.*;
public class Date
{
    // need to make class fields for day, month and year (integers)
    // fields are variables accessable from anywhere in the class -> unlike declaring a variable in the main method
    // but hidden from the outside world
    // public submodules will be concerned about initialising, accessing or modifying the class fields

    private int day, month, year;

    /************************************************************
     * Default Constructor:
     * IMPORT: none
     * EXPORT: address of new Date object
     * ASSERTION: 
     * COMMENT: Constructors initialise the class fields and guarentee they are valid
     ************************************************************/
    public Date()
    {
        day = 1;
        month = 1;
        year = 0;
    }

    /************************************************************
     * Alternate Constructor:
     * IMPORT: none
     * EXPORT: none
     * ASSERTION: 
     * COMMENT: Imports information which is used to calculate or otherwise obtain values for classes
     ************************************************************/
    public Date(int inIntegerFullDate)
    {
        int inDay, inMonth, inYear;
        double rawDay, rawMonth, rawYear;

        // essentially shifting the decimal each time and then mutliplying the remainder
        rawDay = (double) inIntegerFullDate / 1000000;
        inDay = (int) rawDay;

        rawMonth = (rawDay % inDay) * 100.0;
        inMonth = (int) rawMonth;

        rawYear = (rawMonth % inMonth) * 10000.01; // accounting for loss of precision
        inYear = (int) rawYear;

        setYear(inYear);
        setMonth(inMonth);
        setDay(inDay);
    }

    /************************************************************
     *Copy Constructor:
     *IMPORT: inDate (Date) 
     *EXPORT: address of new date object
     *ASSERTION: Creates an object with an identical object state as the import.
     ************************************************************/
     public Date(Date inDate)
    {
        day = inDate.getDay();
        month = inDate.getMonth();
        year = inDate.getYear();
    }

    //MUTATORS
    /************************************************************
     * SUBMODULE: setDay
     * IMPORT: inDay (Integer)
     * EXPORT: none
     * ASSERTION: sets the  to inDay
     ************************************************************/
    public void setDay(int inDay)
    {
        if (!validDay(inDay, month, year))
        {
            throw new IllegalArgumentException("Invalid Day");
        }
        day = inDay;
    }

    /************************************************************
     * SUBMODULE: setMonth
     * IMPORT: inMonth (Integer)
     * EXPORT: none
     * ASSERTION: sets the month to inMonth
     ************************************************************/
    public void setMonth(int inMonth)
    {
        if (!validMonth(inMonth))
        {
            throw new IllegalArgumentException("Invalid Month");
        }
        month = inMonth;
    }

    /************************************************************
     * SUBMODULE: setYear
     * IMPORT: inYear (Integer)
     * EXPORT: none
     * ASSERTION: sets the year to inYear
     ************************************************************/
    public void setYear(int inYear)
    {
        if (!validYear(inYear))
        {
            throw new IllegalArgumentException("Invalid Year");
        }
        year = inYear;
    }

    // ACCESSORS
    public int getDay()
    {
        return day;
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }
    
    /************************************************************
     * SUBMODULE: clone
     * IMPORT: none
     * EXPORT: clones current object
     * ASSERTION: constructs a new object using the copy constructor
     ************************************************************/
    // clone(): Date
    public Date clone()
    {
        return new Date(this);
    }

    /************************************************************
     * SUBMODULE: equals
     * IMPORT: inObject (Object)
     * EXPORT: areEqual (boolean)
     * ASSERTION: two dates are the same if they have the same day 
     *            and month and year
     ************************************************************/
    // equals(Object): Boolean
    public boolean equals(Object inObj)
    {
        boolean areEqual = false;
        if(inObj instanceof Date)  // if the date object we took in is an intance of the date class then
        {
            Date inDate = (Date) inObj;  // casting inObj to type Date class 
            areEqual = (day == inDate.getDay()) && (month == inDate.getMonth()) && (year == inDate.getYear()); // comparisons of day month and year values
        }
        return areEqual;
    }

    /************************************************************
     * SUBMODULE: toString
     * IMPORT: none
     * EXPORT: str (String)
     ************************************************************/
    // toString(): String
    public String toString()
    {
        return ("It is the " + day + getSuffix(day) + " day of " + getMonthName(month) + " in " + year + " " + printIfLeapYear(year));
    }

    /************************************************************
     * SUBMODULE: isLeapYear
     * IMPORT: inYear(integer)
     * EXPORT: isLeapYear(boolean)
     ************************************************************/
    // isLeapYear(): Boolean
    private boolean isLeapYear(int inYear)
    {
        boolean isLeapYear = false;
        if((inYear % 400 == 0) || (inYear % 100 == 0) || (inYear % 4 == 0))
        {
            isLeapYear = true;
        }
        return isLeapYear;
    }

    /************************************************************
     * SUBMODULE: getSuffix
     * IMPORT: inDay(integer)
     * EXPORT: suffix(String)
     ************************************************************/
    // getSuffix(): String
    private String getSuffix(int inDay)
    {
        String suffix;
        int lastDigit = inDay % 10;
        if(lastDigit == 1)
        {
            suffix = "st";
        }
        else if (lastDigit == 2)
        {
            suffix = "nd";
        }
        else if (lastDigit == 3)
        {
            suffix = "rd";
        }
        else
        {
            suffix = "th";
        }
        return suffix;
    }

    /************************************************************
     * SUBMODULE: validDay
     * IMPORT: inDay(integer), month(integer), year(integer)
     * EXPORT: isValid(boolean)
     ************************************************************/
    private boolean validDay(int inDay, int month, int year)
    {
        boolean isValid = false;
        int maxDays;

        if(isLeapYear(year) == false)
        {
            int[] calendarDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
            maxDays = calendarDays[month - 1];

            if((inDay <= maxDays) && (inDay > 0))
            {
                isValid = true;
            }
        }
        else
        {
            int[] leapCalendarDays = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            maxDays = leapCalendarDays[month - 1];

            if((inDay <= maxDays) && (inDay > 0))
            {
                isValid = true;
            }
        }
        return isValid;
    }

    /************************************************************
     * SUBMODULE: validMonth
     * IMPORT: inMonth(integer)
     * EXPORT: isValid(boolean)
     ************************************************************/
    private boolean validMonth(int inMonth)
    {
        boolean isValid = false;
        if ((inMonth > 0) || (inMonth <= 12))
        {
            isValid = true;
        }
        return isValid;

    }
    
    /************************************************************
     * SUBMODULE: validYear
     * IMPORT: inYear(integer)
     * EXPORT: isValid(boolean)
     ************************************************************/
    private boolean validYear(int inYear)
    {
        boolean isValid = false;
        if ((inYear >= 0) || (inYear < 10000))
        {
            isValid = true;
        }
        return isValid;
    }

    /************************************************************
     * SUBMODULE: printIfLeapYear
     * IMPORT: inYear(integer)
     * EXPORT: lyString(String)
     ************************************************************/
    private String printIfLeapYear(int inYear)
    {
        String lyString = "It is not a leap year.";
        if(isLeapYear(inYear) == true)
        {
            lyString = "It is a leap year.";
        }
        return lyString;
    }

    /************************************************************
     * SUBMODULE: getMonthName
     * IMPORT: inMonth(integer)
     * EXPORT: monthNames(String)
     ************************************************************/
    private String getMonthName(int inMonth)
    {
        String[] monthNames = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[inMonth - 1];
    }
}
