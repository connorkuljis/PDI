import java.util.*;
import java.io.*;

public class FileIOTestHarness
{
    public static void main(String[] args)
    {
        int[][] myArray = null;
        try
        {
            myArray = FileIO.readFile("Images/Image_A.csv");
        }
        catch(IOException e)
        {

        }
        for(int i = 0; i < myArray.length; i++)
        {
            for(int j = 0; j < myArray[0].length; j++)
            {
                System.out.print(myArray[i][j] + " "); 
            }
            System.out.println(" "); 
        }
    }
}
