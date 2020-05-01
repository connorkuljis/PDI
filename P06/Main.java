import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Date a = new Date();
        System.out.println(a.toString());
    }

    private static boolean isLeapYear(int inYear)
    {
        boolean leapYear = false;
        if (inYear % 400 == 0)
        {
            leapYear = true;
        }
        return leapYear;
    }

    private static boolean validDay(int inDay, int inMonth, int inYear)
    {
        boolean isValid = false;
        int maxDays;

        if(isLeapYear(inYear) == false)
        {
            int[] calendarDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
            maxDays = calendarDays[inMonth - 1];

            System.out.println("month: " + inMonth);
            System.out.println("index (month - 1): " + (inMonth - 1));
            System.out.println("days in month: " + maxDays);

            if((inDay <= maxDays) && (inDay > 0))
            {
                isValid = true;
            }
        }
        else
        {
            int[] leapCalendarDays = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            
            maxDays = leapCalendarDays[inMonth - 1];

            System.out.println("month: " + inMonth);
            System.out.println("index (month - 1): " + (inMonth - 1));
            System.out.println("days in month: " + maxDays);

            if((inDay <= maxDays) && (inDay > 0))
            {
                isValid = true;
            }
        }
        System.out.println("valid date?: " + isValid);
        return isValid;
    }
}

// from tutor
//SetDay(int inDay) {
//  SetDate(inDay, month, year);
//  }
//}
