
import java.util.*;
public class Fibonacci
{
    public static void main(String[] args)
    {
        System.out.println("Fibonacci:\nEnter mode of generation:");

        int[] fibArray = fibonacci();
        menu(fibArray);
    }

    public static int getInt(String prompt, int min, int max)
    {
        Scanner sc = new Scanner(System.in);
        String outPrompt, errorPrompt;
        int integerValue;

        outPrompt = prompt;
        errorPrompt = "Error. Values must be within " + min + " and " + max + "\n";
        do
        {
            System.out.print(outPrompt);
            integerValue = sc.nextInt();
            outPrompt = errorPrompt + prompt;
        } while((integerValue < min) || (integerValue > max));

        return integerValue;
    }

    public static int[] fibonacci()
    {
        boolean add = true;
        int mode;

        mode = getInt("1. Addition\n2. Subtraction\n", 1, 2);
        if (mode == 2)
        {
            add = false;
        }

        int numElements = getInt("Enter number of elements: ", 5, 50);
        int[] elements = new int[numElements];

        int a = getInt("First digit: ", -100, 100);
        int b = getInt("Second digit: ", -100, 100);

        elements[0] = a;
        elements[1] = b;

        for(int i=2; i<elements.length; i++)
        {
            if (add == true)
            {
                elements[i] = elements[i-2] + elements[i-1];
            }
            else
            {
                elements[i] = elements[i-2] - elements[i-1];
            }
        }
        return elements;
    }

    public static void menu(int[] elements)
    {
        int choice, position;
        boolean close = false;
        do
        {
            choice = getInt("\n1. View an element\n2. Print the array\n0. Exit\n", 0, 2);
            switch(choice)
            {
                case(1):
                    position = getInt("Enter search position: ", 0, elements.length);
                    position--;
                    System.out.println("Found: " + elements[position]);
                    break;
                case(2):
                    printArray(elements);
                    break;
                case(0):
                    close = true;
            }
        } while(!close);
    }
    
    public static void printArray(int[] elements)
    {
        for(int i=0; i<elements.length; i++)
        {
            System.out.print(elements[i] + " ");
        }
    }
}

