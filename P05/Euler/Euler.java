
import java.util.*;
public class Euler
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n;
        String prompt, errorPrompt, outPrompt;

        prompt = "Enter number of terms: ";
        errorPrompt = "Error - input must be between 6 and 100 inclusive.\n";

        outPrompt = prompt;

        do
        {
            System.out.print(outPrompt);
            n = sc.nextInt();
            outPrompt = errorPrompt + prompt;
        } while((n<6) || (n>100));

        double[] factorialArray = new double[n+1];
        factorialArray[0] = 1;

        for(int i=1; i<n; i++)
        {
            factorialArray[i] = calcTerms(i);
        }

        // adding the last elemnt to sum
        lastValue(factorialArray);
    }

    public static double calcTerms(int x)
    {
        double value;
        double factorial = 1.0;

        for(int i=1; i<=x; i++) // had a block here --> did i > x instead
        {
            factorial = factorial * i;
        }
        value = 1.0 / factorial;
        return value;
    }

    public static void printArray(double[] pArray)
    {
        for(int i=0; i<pArray.length; i++)
        {
            System.out.println(pArray[i]);
        }
    }

    public static void lastValue(double[] myArray)
    {

        int limit = myArray.length - 1;
        double e = 0.0;

        for(int i=0; i<limit; i++)
        {
            e += myArray[i];
        }

        myArray[limit] = e;
        printArray(myArray);
    }

}
