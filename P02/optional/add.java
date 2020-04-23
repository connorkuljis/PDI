import java.util.*;

public class add
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numOne, numTwo, result;

        System.out.println("Please enter your first number. ");
        numOne = sc.nextInt();

        System.out.println("Please enter your second number. ");
        numTwo = sc.nextInt();

        result = numOne + numTwo;

        if(result == 13 )
        {
             System.out.println("unlucky!");
        }
        else
        {
            System.out.println("Result: " + result);
        }

    }
}
