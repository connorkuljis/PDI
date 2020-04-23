import java.util.*;
import java.lang.Math;
public class PI
{
    public static void main(String[] args)
    {
        double[] fullArray = storeArray();
        printArray(fullArray);
    }

    public static double[] storeArray()
    {
        int k = getInt();
        k = 1000;
        double[] piArray = new double[k+1];

        for(int i=0; i<piArray.length; i++)
        {
            piArray[i] = terms(i);
        }

        piArray[piArray.length - 1] = sumArray(piArray);
        
        return piArray;
    }

    public static double terms(int k)
    {
        double degrees, radians, sum;
        
        sum = 1.0 / (2.0 * k + 1.0);

        return sum;
    }

    public static double sumArray(double[] piArray)
    {
        double piApprox = 0.0;

        for(int i=0; i<piArray.length; i++)
        {
            piApprox = piApprox + piArray[i];
        }

        return piApprox;
    }

    public static void printArray(double[] piArray)
    {
        for(int i=0; i<piArray.length; i++)
        {
            System.out.println(piArray[i]);
        }
    }

    public static int getInt()
    {
        int x = 0;

        return x;
    }
}
