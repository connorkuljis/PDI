import java.util.*;

public class TestDate
{
    public static void main(String[] args)
    {
        do
        {
            Scanner sc = new Scanner(System.in);
            int day, month, year;

            System.out.println("day: ");
            day = sc.nextInt();
            System.out.println("month: ");
            month = sc.nextInt();
            System.out.println("year: ");
            year = sc.nextInt();

            Date d = new Date(day, month, year);
            System.out.println(d.toString());
        } while(2 > 1);

    }
}
