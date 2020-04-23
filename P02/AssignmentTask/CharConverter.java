import java.util.*;

public class CharConverter
{
    public static void main(String[] args)
    {
        char uppercaseChar, lowercaseChar;
        int ascii;
        System.out.println("Please enter an uppercase character");

        Scanner sc = new Scanner(System.in);
        uppercaseChar = sc.next().charAt(0);
        System.out.println("Character: " + uppercaseChar);
 
        ascii = (int)(uppercaseChar);
        lowercaseChar = Character.toLowerCase(uppercaseChar);
        System.out.println("ASCII number: " + ascii);
        System.out.println("Lowercase: " + lowercaseChar);
    }
}
