/*********************************************************
 * FILE: UserInterface.java
 * DATE: 8/5/2020
 * UNIT: PDI
 * AUTHOR: Connor Kuljis 19459138
 * PURPOSE: class of static methods for use when accepting 
 *          user input
 * REFERENCE: https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html#nextInt()
 * *******************************************************/

import java.util.*;

public class UserInterface
{
    /*
    * SUBMODULE: userInput
    * IMPORTS: prompt (String), lower (int), upper (int)
    * EXPORTS: value (int)
    * PURPOSE: returns a valid int
    */
    public static int userInput(String prompt, int lower, int upper)
    {
        int value;
        Scanner sc = new Scanner(System.in);
        String outPrompt;
        outPrompt = prompt;
        do 
        {
            try
            {
                System.out.println(outPrompt); 
                value = sc.nextInt(); // throws : InputMismatch; NoSuchElement and IllegalState exceptions
            }
            catch(InputMismatchException e) 
            {
                displayError(e.getMessage()); // passing the message ti another method, makes the exception message a string
                sc.next();         // clearing the scanner
                value = lower - 1; // forcing while statement to loop
            }
            outPrompt = "ERROR: please enter a valid value between " + lower + " and " + upper + "\n" + prompt;
        } while ((value < lower) || (value > upper));
        return value;
    }

    /*
    * SUBMODULE: userInput
    * IMPORTS: prompt (String), lower (double), upper (double)
    * EXPORTS: value (double)
    * PURPOSE: returns a valid double
    */
    public static double userInput(String prompt, double lower, double upper)
    {
        double value;
        Scanner sc = new Scanner(System.in);
        String outPrompt;
        outPrompt = prompt;
        do 
        {
            try
            {
                System.out.println(outPrompt + " between " + lower + " and " + upper); 
                value = sc.nextDouble();
            }
            catch(InputMismatchException e) 
            {
                displayError(e.getMessage()); 
                sc.next();
                value = lower - 1.0;
            }
            outPrompt = "ERROR: please enter a valid value \n" + prompt;
        } while ((value < lower) || (value > upper));
        return value;
    }

    /*
    * SUBMODULE: userInput
    * IMPORTS: prompt (String), lower (long), upper (long)
    * EXPORTS: value (long)
    * PURPOSE: returns a valid long
    */
    public static long userInput(String prompt, long lower, long upper)
    {
        long value;
        Scanner sc = new Scanner(System.in);
        String outPrompt;
        outPrompt = prompt;
        do 
        {
            try
            {
                System.out.println(outPrompt + " between " + lower + " and " + upper); 
                value = sc.nextLong();
            }
            catch(InputMismatchException e) 
            {
                displayError(e.getMessage()); 
                sc.next();
                value = lower - 1L;
            }
            outPrompt = "ERROR: please enter a valid value \n" + prompt;
        } while ((value < lower) || (value > upper));
        return value;
    }

    /*
    * SUBMODULE: userInput
    * IMPORTS: prompt (String), lower (float), upper (float)
    * EXPORTS: value (float)
    * PURPOSE: returns a valid float
    */
    public static float userInput(String prompt, float lower, float upper)
    {
        float value;
        Scanner sc = new Scanner(System.in);
        String outPrompt;
        outPrompt = prompt;
        do 
        {
            try
            {
                System.out.println(outPrompt + " between " + lower + " and " + upper); 
                value = sc.nextFloat();
            }
            catch(InputMismatchException e) 
            {
                displayError(e.getMessage()); 
                sc.next();
                value = lower - 1.0f;
            }
            outPrompt = "ERROR: please enter a valid value \n" + prompt;
        } while ((value < lower) || (value > upper));
        return value;
    }

    /*
    * SUBMODULE: userInput
    * IMPORTS: prompt (String), lower (Character), upper (Character)
    * EXPORTS: value (Character)
    * PURPOSE: returns a valid character
    */
    public static char userInput(String prompt, char lower, char upper)
    {
        char character;
        int value, min, max;
        String outPrompt;
        Scanner sc = new Scanner(System.in);

        outPrompt = prompt;
        min = (int) lower;
        max = (int) upper;

        do
        {
            try
            {
                System.out.println(outPrompt + " between " + lower + " and " + upper); 
                character = sc.next().charAt(0);
                value = (int) character;
            }
            catch(InputMismatchException e)
            {
                displayError(e.getMessage());
                sc.next();
                value = min - 1;
            }
            outPrompt = "ERROR: please enter a valid value \n" + prompt;
        } while ((value < min) || (value > max));
        character = (char) value;
        return character;
    }

    /*
     * SUBMODULE: userInput
     * IMPORTS: prompt (String)
     * EXPORTS: value (String)
     * PURPOSE: returns a valid string of characters
     */
    public static String userInput(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        String value = "";

        try
        {
            System.out.println(prompt);
            value = sc.nextLine();
        }
        catch(InputMismatchException e)
        {
            displayError(e.getMessage());
            sc.next();
        }
        return value;
    }

    /*
     * SUBMODULE: displayError
     * IMPORTS: error (String)
     * EXPORTS: none
     * PURPOSE: prints the error message of an exception
     */
    public static void displayError(String error)
    {
        System.out.println("Displaying exception error -> " + error); 
    }
}
