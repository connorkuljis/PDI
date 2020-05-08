import java.util.*;
public class UserInterfaceTestHarness
{
    public static void main(String[] args)
    {

        System.out.println("TESTING INPUTS\n"); 
        int a;
        a = UserInterface.userInput("Enter a integer", 1, 20);

        double b;
        b = UserInterface.userInput("Enter a double", 2.0, 19.9);

        long c;
        c = UserInterface.userInput("Enter a long", 5L, 15L);

        float d;
        d = UserInterface.userInput("Enter a float", 0.5f, 16.22f);

        char e;
        e = UserInterface.userInput("Enter a char", 'a', 'z');

        String f;
        f = UserInterface.userInput("Enter a string");

        System.out.println("\nPRINTING RESULTS\n"); 
        System.out.println("integer: " + a); 
        System.out.println("double: " + b); 
        System.out.println("long: " + c); 
        System.out.println("float: " + d); 
        System.out.println("character: " + e); 
        System.out.println("String: " + f); 
    }
}
