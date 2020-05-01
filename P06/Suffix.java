import java.util.*;
public class Suffix
{
    public static void main(String[] args)
    {
        for(int i=0; i < 10; i++)
        {
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            getSuffix(input);
        }
    }

    public static  String getSuffix(int inDay)
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
        System.out.println(suffix);
        return suffix;
    }
}
